/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Jonas
 */

//Main File
public class BaseBall extends Application 
{
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
               
        //load the FXML Scene
        Parent root = FXMLLoader.load(getClass().getResource("scenes/baseball.fxml"));
        Scene scene = new Scene(root);
        
       // primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
        
         /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }  
        
}