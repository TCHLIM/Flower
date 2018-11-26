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
    private String[] consumerAtt={"ID: ", "Name: ","IC: ","Gender: [1-Male, 2-Female] ","Phone: ","Address: "};
    private String[] corCustAtt={"ID: ","Contract Name: ","Phone: ","Address: ","Credit Limit: "};
    public ManageCustomer(){
        custTypeMenu();
        functionMenu();      
    }    
    public void functionMenu(){
        String userSelection = " ";
        do{//prompt user to enter the menu number
            if("1".equals(custType)){
                System.out.println("u are now in 'consumer' mode");
            }else{
                System.out.println("you are now in 'corporate customer' mode");
            }
            System.out.println("0 - exit");
            System.out.println("1 - select customer type");
            System.out.println("2 - Add new customer");
            System.out.println("3 - Search customer Info");
            System.out.println("4 - Update customer Info");
            System.out.println("5 - Delete customer Info\n");
            
            System.out.println("Enter the number to proceed");//menu selection
            
            userSelection = myScanner.next();
            switch(userSelection){
                case "0" : exit(-1);break;
                case "1" :custTypeMenu();break;
                case "2" :if("1".equals(custType)){addConsumer();
                          }else{
                            addCorCust();
                        }
                    break;
                case "3" :if("1".equals(custType)){retrieveConsumer();
                          }else{
                            retrieveCorCust();
                        }
                    break;
                case "4" : updateCustomer();break;
                case "5" : deleteCustomer();break;
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
    public void addConsumer(){
        //CM.addConsumerDA(consumer);
        String userReply = " ";
        System.out.println("");
        do{
            for(int i=0;i<consumerAtt.length;i++){            
                   System.out.println(consumerAtt[i]);
                   switch(i){
                        case 0:consumer.setCustID(myScanner.next());break;
                        case 1:consumer.setCustName(myScanner.next());break;
                        case 2:String custIC=myScanner.next();boolean x=true;
                            if(CM.checkConsumerAdd(custIC)==true){    
                                do{
                                    int j=0;x=true;
                                    if(custIC.length()==12){
                                        while(j<custIC.length()){
                                            if(!Character.isDigit(custIC.charAt(j))){
                                                x=false;
                                                j=custIC.length();
                                            }//end if
                                            j++;
                                        }//while
                                    }else{x=false;}
                                    if(x==false){
                                        System.out.println("Ic only in 12 digits");
                                        System.out.println(consumerAtt[i]);
                                        custIC=myScanner.next();
                                    }
                                
                                }while(x==false);
                                consumer.setCustIC(custIC);
                            }else{
                                    System.out.println("existing record. Cannot be added");
                                    System.out.println("consumer ID : "+CM.returnCustID());
                                    functionMenu();
                                }
                        break;
                            
                        case 3:
                                String custGender = myScanner.next();
                                while(!"1".equals(custGender)&&!"2".equals(custGender)){
                                    System.out.println("Only enter '1' for male or '2' for female");
                                    System.out.println(consumerAtt[i]);
                                    custGender = myScanner.next();
                                }
                                switch(custGender){
                                    case "1": consumer.setCustGender("MALE");break;
                                    case "2": consumer.setCustGender("FEMALE");break;
                                }
                            ;break;
                        case 4: x = true;
                            String custPhone = myScanner.next();
                            do{
                                int j=0;
                                while(custPhone.length()<=j){
                                    if(!Character.isDigit(custPhone.charAt(j))){
                                        System.out.println("Please enter the valid phone number.");
                                        x=false;
                                        j=custPhone.length();
                                    }
                                    else{
                                        x=true;
                                        j++;
                                    }
                                }
                            }while(x==false);
                            consumer.setCustPhone(custPhone);
                            break;
                        case 5:consumer.setCustAddress(myScanner.next());break;
                    }//end switch
            }//end for
            consumer.setCustMode("EXISTING");
            CM.addConsumerDA(consumer);
            System.out.println("Continue to add consumer?Y/N");
            userReply=myScanner.next();
        }while('Y'==Character.toUpperCase(userReply.charAt(0)));
    }
    public void retrieveConsumer(){
        String userReply = " ";
        System.out.println("");
        do{
            System.out.println("Please enter the consumer ID");
            String custID=myScanner.next();
            consumer=CM.searchConsumerDA(custID);
            System.out.println(" ");
            if(CM.getValidation()==false){
                System.out.println("No such record!");
            }else{
                System.out.println(consumerAtt[0]+" : " + consumer.getCustID());
                System.out.println(consumerAtt[1]+" : " + consumer.getCustName());
                System.out.println(consumerAtt[2]+" : " + consumer.getCustIC());
                System.out.println(consumerAtt[3]+" : " + consumer.getCustGender());
                System.out.println(consumerAtt[4]+" : " + consumer.getCustPhone());
                System.out.println(consumerAtt[5]+" : " + consumer.getCustAddress());
            }
            System.out.println("Continue to search?Y/N");
        }while('Y'==Character.toUpperCase(userReply.charAt(0)));
    }
    public void updateCustomer(){
        String userReply = " ";
        System.out.println("");
        do{
            
        }while('Y'==Character.toUpperCase(userReply.charAt(0)));;
    }
    public void deleteCustomer(){
        String userReply = " ";
        System.out.println("");
        do{
            
        }while('Y'==Character.toUpperCase(userReply.charAt(0)));;
    }
    public void addCorCust(){
        String userReply = " ";
        System.out.println("");
        do{
           for(int i=0;i<corCustAtt.length;i++){            
                   System.out.println(corCustAtt[i]);
                   switch(i){
                       
                        case 0:corCust.setCustID(myScanner.next());break;
                        case 1:corCust.setContractName(myScanner.next());break;
                        case 2: boolean x = true;
                            String corCustPhone = myScanner.next();
                            do{
                                int j=0;
                                while(corCustPhone.length()<=j){
                                    if(!Character.isDigit(corCustPhone.charAt(j))){
                                        System.out.println("Please enter the valid phone number.");
                                        x=false;
                                        j=corCustPhone.length();
                                    }
                                    else{
                                        x=true;
                                        j++;
                                    }
                                }
                            }while(x==false);
                            break;
                        case 3:corCust.setCustAddress(myScanner.next());break;
                        case 4: String creditLimit=" ";
                            creditLimit=myScanner.next();
                            do{
                                int j=0;x =true;
                                while(creditLimit.length()>j){
                                    if(Character.isDigit(creditLimit.charAt(j))||creditLimit.charAt(j)=='.'){
                                        j++;x=true;
                                    }else{
                                        j=creditLimit.length();x=false;
                                        System.out.println("enter Credit limit in digit");
                                        System.out.println(corCustAtt[i]);
                                        creditLimit=myScanner.next();
                                    }

                                }corCust.setCreditLimit(Integer.parseInt(creditLimit));
                            }while(x==false); 
                            
                        break;
                            
                    }//end switch 
            }//end for
           
            System.out.println("Continue to add corporate Customer?Y/N");
            userReply=myScanner.next(); 
        }while('Y'==Character.toUpperCase(userReply.charAt(0)));;
    }
    public void retrieveCorCust(){
        String userReply = " ";
        System.out.println("");
        do{
            
        }while('Y'==Character.toUpperCase(userReply.charAt(0)));;
    }
    public void deleteCorCust(){
        String userReply = " ";
        System.out.println("");
        do{
            
        }while('Y'==Character.toUpperCase(userReply.charAt(0)));;
    }
    public void searchCorCust(){
        String userReply = " ";
        System.out.println("");
        do{
            
        }while('Y'==Character.toUpperCase(userReply.charAt(0)));;
    }
    
    
}
