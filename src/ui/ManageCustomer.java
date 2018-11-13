/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import domain.Customer;
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
    Customer customer = new Customer();
    List<Customer> listCust = new ArrayList<>();
    
    public ManageCustomer(){
        int userSelection = 0;
        do{//prompt user to enter the menu number
            
            System.out.println("1 - Add new customer");
            //System.out.println("2 - Search customer Info");
            //System.out.println("3 - Update customer Info");
            //System.out.println("4 - Delete customer Info");
            System.out.println("5 - exit");
            //System.out.println("Enter the number to proceed");//menu selection
            
            try{
                userSelection = 0;
                userSelection = myScanner.nextInt();
            }catch(Exception e){
                userSelection = 0;
            }
            
                switch(userSelection){
                    case 1 : addCustomer();break;
                    case 2 : retrieveCustomer();break;
                    case 3 : updateCustomer();break;
                    case 4 : deleteCustomer();break;
                    case 5 : ;break;
                    default : System.out.println("Only enter a number between '1' to '5'");break;
                }
            
        }while(userSelection!=5);//loop back if user enter y
        
    }
    public void addCustomer(){
        System.out.println("Enter the customer details to add");
        System.out.println("Customer ID: ");customer.setCustID( myScanner.nextLine());
        
        promptUserInput();
        //System.out.println(" ");
        listCust.add(customer);
        
    }
    public void retrieveCustomer(){
        System.out.println("Enter the number to change mode: ");
        System.out.println("");
        System.out.printf("%s", customer.getCustID());
    }
    public void updateCustomer(){
        
    }
    public void deleteCustomer(){
        
    }
    public void promptUserInput(){
        boolean booGender = false;
        boolean booType = false;
        System.out.println("Name: "); customer.setCustName( myScanner.nextLine()) ;
        System.out.println("IC: ");customer.setCustIC(myScanner.nextLine());
        System.out.println("Date Of Birth: ");customer.setCustDOB(myScanner.nextLine());
        System.out.println("H/P: ");customer.setCustPhone(myScanner.nextLine());
        while(booGender == false){
            System.out.println("Gender: '1' for Male & '2' for Female");
            String selectGender = myScanner.nextLine();
            if("1".equals(selectGender)){
                customer.setCustGender("Male");
                booGender = true;
            }else if("2".equals(selectGender)){
                customer.setCustGender("Female");
                booGender = true;
            }else{
                System.out.println("Please enter either '1' or '2'");
                booGender = false;
            }
        }
        System.out.println("Address: ");
        while(booType == false){
            System.out.println("Type: '1' for coporate & '2' for consumer");
            String selectType = myScanner.nextLine();
            if("1".equals(selectType)){
                customer.setCustType("coporate");
                booType = true;
                System.out.println("Status");
                System.out.println("Credit Limit");
                System.out.println("");
            }else if("2".equals(selectType)){
                customer.setCustType("consumer");
                booType = true;
            }else{
                System.out.println("Please enter either '1' or '2'");
                booType = false;
            }
        }
        System.out.println("---------successfull!!!!!!!!!!!");
        
    }
    
}
