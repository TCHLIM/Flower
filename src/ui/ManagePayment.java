/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ManagePayment {
    
    Scanner scanner = new Scanner(System.in);
    
    public ManagePayment(){
        double totalPrice = 30.00;
        boolean playAgain = true;
        double charge = 0;
        
        while(playAgain){
            System.out.println("Payment");
            System.out.println("TOTAL PRICE : RM " + totalPrice);
            System.out.println("");
            System.out.println("Please enter the amount of paid : ");

            double paid = scanner.nextDouble();
         
            if(paid > totalPrice){
               charge  = CountPayment(totalPrice, paid);
               playAgain = false;
               System.out.println("The total charge is RM " + charge);
               System.out.println("Thank You !!!");
            }
            else
            {
                System.out.println("");
                System.out.println("The paid amount must equal or more than total price !!!");
                System.out.println("");
            }
        }     
    }
    
    public static double CountPayment(double totalPrice,double paid){
        return paid - totalPrice;
    }
    
    public static void main(String args[]) {
        ManagePayment payment = new ManagePayment();
    }
}
