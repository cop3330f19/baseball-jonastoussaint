/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.bind.JAXB;

/**
 *
 * @author Jonas
 */
public class baseballController implements Initializable{
    
    @FXML private ListView listViewID;
    @FXML private TableView tableViewID;
    @FXML private TableColumn <String, baseballClass> colPlayer;
    @FXML private TableColumn <String, baseballClass> colBattingAvgID;
    
    //ArrayList of baseball objects
    private final List<baseballClass> ball = new ArrayList<>();
    
    private final List<baseballClass> players = new ArrayList<>();
    
       private final List<baseballClass> playersofteam = new ArrayList<>();
    
    //Gets the directory path of the project
    private final String DIR = System.getProperty("user.dir");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        readFile();
        
        //ChangeListerner for when you click on a ListView Item
        listViewID.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                         
                //REMEMBER the name in the quotation marks should match the case of the get function
                colPlayer.setCellValueFactory(new PropertyValueFactory<>("Name"));
                colBattingAvgID.setCellValueFactory(new PropertyValueFactory<>("BattingAvg"));
                
                //Create an ObservableList object to store the Teams object(s)
                ObservableList<baseballClass> result = FXCollections.observableArrayList();
                
                //Bind the list  to the table
                getPlayers(newValue);
                System.out.println(newValue);
                tableViewID.setItems(FXCollections.observableList(playersofteam));   
                
            }

              /**
                * Sequential search of the Teams by name
                * @param 
                * @return 
                */
                    
        });
        
    }

    private void readFile() {
       
        //ObservableList to add states to the ListView
        ObservableList<String> ballList = FXCollections.observableArrayList();
        
        //Open csv file for input
        try(BufferedReader csvReader = Files.newBufferedReader(Paths.get(DIR + "/src/baseball/data/baseball.xml"))){
            
                baseballRead ball2 = JAXB.unmarshal(csvReader, baseballRead.class);
               
                for(baseballClass baseballRead1 : ball2.getbaseballClass())
                {
                    //add object to ArrayList
                    ball.add(baseballRead1);
                    //add player name to ObservableList
                    if(!ballList.contains(baseballRead1.getTeam()))
                    {
                        ballList.add(baseballRead1.getTeam());                      
                    }
                    
                }
                          
    }catch(IOException e){
        System.err.println("Error opening file");
        e.printStackTrace();   
}
        
        
//Sorts the List of Baseball objects by Team name in ascending order
        Collections.sort(ball, new baseballComparator());
        //sorts the ObservableList
        Collections.sort(ballList);
        
        //Binds the ObservableList to the listView and tableView
        listViewID.setItems(ballList);
        tableViewID.setItems(ballList);
    }
    
        private void getPlayers(String teamname) {
        
            playersofteam.clear();
        for(int i = 0; i < ball.size(); i++){
            if(ball.get(i).getTeam().equals(teamname)){
                playersofteam.add(new baseballClass(ball.get(i).getName(),ball.get(i).getTeam(),ball.get(i).getatBats(),ball.get(i).getHits()));
              
            }
        }   
        }
    
}

