/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DeliveryList {
    
    ArrayList<String> deliveryList = new ArrayList<String>();
    
    
   public void DeliveryList(){
       
          deliveryList.add("P1001            Chun Yi Goh               Setapak                      10:00AM ");
          deliveryList.add("P1002            KING                          Setapak                      3:00PM ");
          deliveryList.add("P1003            KONG                        Setapak                       4:00PM");
        
            for(int i = 0; i < deliveryList.size(); i++){
                
              System.out.println( deliveryList.get(i));
               
            }   
    }
}
