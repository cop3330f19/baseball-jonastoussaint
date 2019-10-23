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
    
    
    
    //Gets the directory path of the project
    private final String DIR = System.getProperty("user.dir");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        readFile();
        //ChangeListerner for when you click on a ListView Item
        listViewID.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                 //Find the state chosen in the ArrayList
                int idx = findbaseball(newValue);
                
                
                //REMEMBER the name in the quotation marks should match the case of the get function
                colPlayer.setCellValueFactory(new PropertyValueFactory<>("Player"));
                colBattingAvgID.setCellValueFactory(new PropertyValueFactory<>("Batting Average"));
                
                //Create an ObservableList object to store the States object(s)
                ObservableList<baseballClass> result = FXCollections.observableArrayList();
                
                //Add the States object to the list
                result.add(ball.get(idx));
              
                //Bind the list  to the table
                tableViewID.setItems(result);            
            }

              /**
                * Sequential search of the states by name
                * @param value
                * @return 
                */
            private int findbaseball(String newValue) {
               // return 0;
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                for(int i = 0; i < ball.size(); i++)
                    if(ball.get(i).getTeam().equals(newValue))
                    return i;
                return 0;
            }
            
            });
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void readFile() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //ObservableList to add states to the ListView
        ObservableList<String> ballList = FXCollections.observableArrayList();
        
        //Open csv file for input
        try(BufferedReader csvReader = Files.newBufferedReader(Paths.get(DIR + "/src/baseball/data/baseball.xml"))){
            
                baseballRead ball2 = JAXB.unmarshal(csvReader, baseballRead.class);
                //States object
                
                //int atBats = ball.getatBats();
                //int hits = ball.getHits();
               // double battingAvg = hits / atBats;
                for(baseballClass baseballRead1 : ball2.getbaseballClass())
                {
                    //add object to ArrayList
                    ball.add(baseballRead1);
                    //add player name to ObservableList
                    if(!ballList.contains(baseballRead1.getTeam()))
                    {
                        ballList.add(baseballRead1.getTeam());
                       // ballList.add(baseballRead1.battingAvg());
                    }
                    
                   /* if(!ballList.contains(baseballRead1.getName()))
                    {
                        ballList.add(baseballRead1.getName());
                    }*/

                }
                          
    }catch(IOException e){
        System.err.println("Error opening file");
        e.printStackTrace();
    
}
        
//Sorts the List of Baseball objects by Team name in ascending order
        Collections.sort(ball, new baseballComparator());
        //sorts the ObservableList
        Collections.sort(ballList);
        
        //Binds the ObservableList to the ListView
        listViewID.setItems(ballList);
    }
}
