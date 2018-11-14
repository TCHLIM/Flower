/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Maintanence {
    
    public Maintanence(){
  
    Scanner userAns = new Scanner(System.in);
    Scanner userAns2 = new Scanner(System.in);
    Scanner userAns3 = new Scanner(System.in);
    
    System.out.println("Welcome To PVZ Flower Shop");
    System.out.println("Please Select An Option To Continue");
    System.out.println("1.Update flower information");
    System.out.println("2.Create monthly promotion");
    
    int option = userAns.nextInt();
        
    if (option == 1){
        
        int counter = 0;
        int orderCounterRed = 30;
        int orderCounterBlue = 30;
        int orderCounterGreen = 30;
        int orderCounterYellow = 30;
        int redquan = 0 ;
        int bluequan = 0 ;
        int greenquan = 0 ;
        int yellowquan = 0 ;
        int total = 0;
        
        String red ="Red Flower";
        String blue = "Blue Flower";
        String green = "Green Flower";
        String yellow = "Yellow Flower";
        
        System.out.println("Catalog:");
        System.out.println("1.Red Flower");
        System.out.println("2.Blue Flower");
        System.out.println("3.Green Flower");
        System.out.println("4.Yellow Flower");
        System.out.println("");
        System.out.println("Please select that which flower u need to update?");
        
        int option2 = userAns2.nextInt();
        
        do{
      
            if(option2 == 1){
                System.out.println("Red Flower:");
                redquan = userAns3.nextInt();
                total = redquan +orderCounterRed;
                System.out.println("Total of red flower :" +total);
                
            }else if(option2 == 2){
                
                System.out.println("Blue Flower:");
                bluequan = userAns3.nextInt();
                total = redquan +orderCounterBlue;
                System.out.println("Total of blue flower :" +total);
           
            }else if(option2 == 3){
                
                System.out.println("Green Flower:");
                greenquan = userAns3.nextInt();
                total = redquan +orderCounterGreen;
                System.out.println("Total of green flower :" +total);

            }else if(option2 == 4){
                
                System.out.println("Yellow Flower:");
                yellowquan = userAns3.nextInt();
                total = redquan +orderCounterYellow;
                System.out.println("Total of yellow flower :" +total);
            }
    
        }while(userAns2.hasNextInt());            
        

        System.out.println(counter);
        } 
   
     }
       
        
    public static void main(String[] args) {
        
        Maintanence main = new Maintanence();
        
    }
    }
    
 

