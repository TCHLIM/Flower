package ui;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Catalog {
    
    public Catalog(){
     
        ArrayList<String> order = new ArrayList<String>();
        ArrayList<Integer> price = new ArrayList<Integer>();
        
        Scanner answer = new Scanner(System.in);
        String red = new String("Red Flower");
        String blue = new String("Blue Flower");
        String green = new String("Green Flower");
        String yellow = new String("Yellow Flower");
        
        System.out.println("Catalog:");
        System.out.println("1.Red Flower(RM10.00)");
        System.out.println("2.Blue Flower(RM15.00)");
        System.out.println("3.Green Flower(RM20.00)");
        System.out.println("4.Yellow Flower(RM25.00)");
        System.out.println("");
        System.out.println("Please Select An Item That You Wish To Buy");
        
        int option = answer.nextInt();
        
        do{
            if(option == 1){
             
             order.add(red);
             int counter =+ 10;
             price.add(counter);
             
             
            }else if(option == 2){
                
                order.add(blue);
                int counter =+ 15;
                
            }
            
            
        
        }while(answer.hasNextInt());
        
        System.out.println("Thanks For Your Purchase, Please Come Again");
        
    }
   public static void main(String[] args){
       
        


    } 
}

