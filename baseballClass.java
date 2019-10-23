/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;

/*import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;*/

/**
 *
 * @author Jonas
 */
public class baseballClass{
    
    private String name;
    private String team;
    private int atBats;
    private int hits;
   // private double battingAvg;
    
    public baseballClass(){
        this.name = "";
        this.team = "";
        this.atBats = 0;
        this.hits = 0;
       // this.battingAvg = 0.0;
        
    }
            
   /**
     * Overloaded constructor
     * 
     * @param name
     * @param team
     * @param atBats
     * @param hits
     * @param battingAvg
     * 
     */ 
    
    public baseballClass(String name, String team, int atBats, int hits){
        this.name = name;
        this.team = team;
        this.atBats = atBats;
        this.hits = hits;
       // this.battingAvg = battingAvg;
    }
      
    public String getName(){
        return name;
    }
    
    public String getTeam(){
        return team;
    }
    
     public int getatBats(){
        return atBats;
    }
    
     public int getHits(){
        return hits;
    }
    public void setHits(int hits){
        this.hits = hits;
    }
    
     public void setTeam(String team){
        this.team = team;
    }
     
    public void setname(String name){
        this.name = name;
    }
    
    public void setatBats(int atBats)
    {
        this.atBats = atBats;
    }
    
   /* public double battingAvg()
    {
         this.battingAvg = getHits() / getatBats();      
        return battingAvg;
    }*/
    
}
