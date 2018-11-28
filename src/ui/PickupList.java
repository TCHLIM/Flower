/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class PickupList {
    
      ArrayList<String> pickUpList = new ArrayList<String>();
    
    public void PickupList(){
        
           pickUpList.add("P1001            Chun Yi Goh               10:00AM ");
           pickUpList.add("P1002            KING                           3:00PM ");
           pickUpList.add("P1003            KONG                         4:00PM");
           
            for(int i = 0; i < pickUpList.size(); i++){
                
              System.out.println( pickUpList.get(i));
               
            }  
    }
   
}
