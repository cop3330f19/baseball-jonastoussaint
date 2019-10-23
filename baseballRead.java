/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseball;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;



/**
 *
 * @author Jonas
 */
public class baseballRead {
    @XmlElement(name="player")
    
    private final List<baseballClass> ball1 = new ArrayList<>();
    
    
    public List<baseballClass> getbaseballClass() {return ball1;} 
    
    
}
