/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import control.CustomerMaintenance;
import static java.lang.System.exit;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jiach
 */
public class ManageCustomer {
    
    Scanner myScanner = new Scanner(System.in);
    CustomerMaintenance CM = new CustomerMaintenance();
    private String custType;
    public ManageCustomer(){
        custTypeMenu();
        functionMenu();
        
        
    }
    
    public void functionMenu(){
        String userSelection = "6";
        do{//prompt user to enter the menu number
            System.out.println("0 - select customer type");
            System.out.println("1 - Add new customer");
            System.out.println("2 - Search customer Info");
            System.out.println("3 - Update customer Info");
            System.out.println("4 - Delete customer Info");
            System.out.println("5 - exit");
            System.out.println("Enter the number to proceed");//menu selection
            
            userSelection = myScanner.next();
            switch(userSelection){
                case "1" : addCustomer();break;
                case "2" : retrieveCustomer();break;
                case "3" : updateCustomer();break;
                case "4" : deleteCustomer();break;
                case "5" : ;break;
                default : System.out.println("Only enter a number between '1' to '5'");break;
            }
            
        }while(!"5".equals(userSelection));//loop back if user enter y
    }
    
    public void custTypeMenu(){
        
        do{
            custType = "6";
            System.out.println("Select which customer type u want to maintain.");
            System.out.println("1 - consumer");
            System.out.println("2 - corporate customer");
            System.out.println("5 - exit \n");
            custType = myScanner.next();
            
            switch(custType){
                case "1": ;break;
                case "2": ; break;
                case "5": ;break;
                case "": System.out.println("Only enter a number '1'，'2' or '5'\n");break;
                default: System.out.println("Only enter a number '1'，'2' or '5'\n");break;
            }
            
        }while(!"1".equals(custType) || !"2".equals(custType) || !"5".equals(custType));
        
    }
    public void addCustomer(){
        //CM.addConsumerDA(consumer);
        System.out.println("add customer");
    }
    public void retrieveCustomer(){
        
    }
    public void updateCustomer(){
        
    }
    public void deleteCustomer(){
        
    }
    public void promptUserInput(){
        
    }
    
}
