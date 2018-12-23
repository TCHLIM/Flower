/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.util.Scanner;
import java.util.ArrayList;

public class ManageDelivery {
    
    Scanner scanner = new Scanner(System.in);
    
    public ManageDelivery(){
        PickupList pickuplist = new PickupList();
        DeliveryList deliverylist = new DeliveryList();
        
        String action = "";
   
        boolean playAgain = true;

        while(playAgain){
            System.out.println("Pickup & Delivery");
            System.out.println("1 Check Pickup List");
            System.out.println("2 Check Delivery List");
            System.out.println("");
            System.out.println("Please enter the number of action :");
            action = scanner.nextLine();
            switch(action){
                case "1" : pickuplist.PickupList();
                playAgain = false;
                break;
                case "2" : deliverylist.DeliveryList();
                playAgain = false;
                break;
                default : System.out.println("Warning !!! Please enter 1 or 2 only."); System.out.println("");break;
            }
        }
    }
    
    public static void main(String args[]) {
        ManageDelivery delivery = new ManageDelivery();
    }
  
}


