/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PaymentTestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ArrayList<FlowerName> flower = Payment.generateFlowerArrangementStyles();
         ArrayList<FlowerName> flower2 = Payment.generateFlowerArrangementStyles2();
         
         

        while (true) {
            int choice = Payment.mainMenu();
            if (choice == 3) {
                choice = Payment.displayFlower(flower2);
              
                            }
            if (choice == 3) {
                choice = Payment.displayFlower(flower);
            }
            
            if(choice == 2){
                Payment.salesOrder(flower, flower2); 
                break;
            }
           
        }
    
    }
    
}
