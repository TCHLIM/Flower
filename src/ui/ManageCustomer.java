/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import control.CustomerMaintenance;
import domain.Consumer;
import domain.CorporateCustomer;
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
    CustomerMaintenance CM = new CustomerMaintenance();
    Consumer consumer = new Consumer();
    CorporateCustomer corCust = new CorporateCustomer();
    private String custType;
    private String[] consumerAtt={"ID: ", "Name: ","IC: ","Gender: ","Phone: ","Address: "};
    private String[] corCustAtt={"ID: ","Contract Name: ","Phone: ","Address: ","Credit Limit: "};
    public ManageCustomer(){
        custTypeMenu();
        functionMenu();
        
        
    }
    
    public void functionMenu(){
        String userSelection = " ";
        do{//prompt user to enter the menu number
            System.out.println("0 - exit");
            System.out.println("1 - select customer type");
            System.out.println("2 - Add new customer");
            System.out.println("3 - Search customer Info");
            System.out.println("4 - Update customer Info");
            System.out.println("5 - Delete customer Info");
            System.out.println("6 - select customer type");
            
            System.out.println("Enter the number to proceed");//menu selection
            
            userSelection = myScanner.next();
            switch(userSelection){
                case "0" : exit(-1);break;
                case "1" : addCustomer();break;
                case "2" : retrieveCustomer();break;
                case "3" : updateCustomer();break;
                case "4" : deleteCustomer();break;
                case "5" : custTypeMenu();break;
                default : System.out.println("Only enter a number between '0' to '5'");break;
            }
            
        }while(!"0".equals(userSelection));
    }
    
    public void custTypeMenu(){
        
        do{
            custType = " ";
            System.out.println("Select which customer type u want to maintain.");
            System.out.println("1 - consumer");
            System.out.println("2 - corporate customer");
            System.out.println("5 - exit");
            custType = myScanner.next();
            
        }while(!"1".equals(custType)&&!"2".equals(custType)&&!"5".equals(custType));
        
    }
    public void addCustomer(){
        //CM.addConsumerDA(consumer);
        String userReply = " ";
        System.out.println("");
        do{
            for(int i=0;i<consumerAtt.length;i++){
                System.out.println(i);
                if("1".equals(custType)){
                   switch(i){
                        case 0:consumer.setCustID(myScanner.next());break;
                        case 1:consumer.setCustName(myScanner.next());break;
                        case 2:String custIC=myScanner.next();
                            int j=0;
                            boolean x=true;
                            while(j<custIC.length()||Character.isDigit(custIC.charAt(j))){j++;x=false;}

                            while(custIC.length()!=12||x==false){
                                while(j<custIC.length()||Character.isDigit(custIC.charAt(j))){j++;x=false;}
                                System.out.println("IC must be 12 digit");
                                System.out.println(consumerAtt[i]);
                                custIC=myScanner.next();
                            }
                            
                            consumer.setCustIC(myScanner.next());break;
                        case 3:String gender=" ";
                                String custGender = myScanner.next();
                                while(!"1".equals(gender)&&!"2".equals(gender)){
                                    System.out.println("Only enter '1' for male or '2' for female");
                                    System.out.println(consumerAtt[i]);
                                    custGender = myScanner.next();
                                }
                                switch(custGender){
                                    case "1": consumer.setCustGender("MALE");break;
                                    case "2": consumer.setCustGender("FEMALE");break;
                                }
                            ;break;
                        case 4:consumer.setCustPhone(myScanner.next());break;
                        case 5:consumer.setCustAddress(myScanner.next());break;
                    } 
                }else{
                        
                }
            }
        }while("Y".equals(Character.toUpperCase(userReply.charAt(0))));
    }
    public void retrieveCustomer(){
        String userReply = " ";
        System.out.println("");
        do{
            
        }while("Y".equals(Character.toUpperCase(userReply.charAt(0))));
    }
    public void updateCustomer(){
        String userReply = " ";
        System.out.println("");
        do{
            
        }while("Y".equals(Character.toUpperCase(userReply.charAt(0))));
    }
    public void deleteCustomer(){
        String userReply = " ";
        System.out.println("");
        do{
            
        }while("Y".equals(Character.toUpperCase(userReply.charAt(0))));
    }
    public void promptUserInput(){
        
    }
    
}
