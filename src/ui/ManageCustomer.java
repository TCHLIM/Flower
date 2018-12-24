/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import ADT.ListInterface;
import control.*;
import domain.*;
import static java.lang.System.exit;
import java.util.Scanner;
/**
 *
 * @author jiachuen
 */
public class ManageCustomer {
    private CustomerControl CC = new CustomerControl();
    private Scanner myScanner = new Scanner(System.in);
    private CorCust corCust=new CorCust();
    private String custType;
    private final String[] corCustAtt={"ID: ","Contract Name: ","Phone: ","Address: ","Credit Limit: "};
    public ManageCustomer(){
       CC.initialized();
    }
    public void startManage(){
        
        functionMenu(); 
    }
     
    public void clearAll(){
        corCust=new CorCust();
    }
    public ListInterface<CorCust> getAllCorCust(){
        return CC.getAllCorCust();
    }//get All data
    
    public void functionMenu(){
        
        clearAll();
        String userSelection="";
        System.out.println("##############################################################");
        System.out.println("u are now in 'Manage Corporate customer' mode");
        System.out.println("##############################################################");
        System.out.println("0 - exit");
        System.out.println("1 - Add new customer");
        System.out.println("2 - Search customer Info");
        System.out.println("3 - Update customer Info");
        System.out.println("4 - Delete customer Info\n");
        System.out.println("Enter the number to proceed");//menu selection
        userSelection = myScanner.next();
        System.out.println("##############################################################");

        switch(userSelection){
            case "0" : exit(0);break;
            
            case "1" : addCorCust();
                break;
            case "2" : searchCorCust();
                break;
            case "3" : updateCorCust();
                ;break;
            case "4" :  deleteCorCust();
                ;break;
            default : System.out.println("Only enter a number between '0' to '4'");
                    functionMenu();
            break;
        }
    }
        
    public void addCorCust(){
        int countPlace=0;String ID;
        while(countPlace<corCustAtt.length){
            System.out.println(corCustAtt[countPlace]);
            //System.out.println("");
            switch(countPlace){
                case 0:ID=CC.AutoIDGenerator(); System.out.println(ID);corCust.setCustID(ID);break;
                case 1:corCust.setContractName(myScanner.next());break;
                
                case 2: String phone;
                    do{phone=myScanner.next();}while(CC.checkInputValidation("Phone", phone)==false);
                    corCust.setCustPhone(phone);
                break;
                case 3:corCust.setCustAddress(myScanner.next());
                break;
                case 4:String creditLimit;
                    do{creditLimit=myScanner.next();}while(CC.checkInputValidation("CreditLimit", creditLimit)==false);
                    corCust.setCreditLimit(creditLimit);
                break;
            }
            countPlace++;
        }
        corCust.setCustMode("EXISTING");
        CC.addCorCust(corCust);corCust=new CorCust();
        System.out.println("Enter 'y' to continue add. Anything to function menu");
        String userReply=myScanner.next();
        switch(userReply.toUpperCase()){
            case "Y":
            case "YES":addCorCust();
            break;
            default:functionMenu();
            break;
        }
    }
    public void searchCorCust(){
        String ID;
        System.out.println("Enter the corCust ID : ");
        ID=myScanner.next();
        corCust=CC.searchCorCust(ID);
        if(CC.getCValidation()==true){
            System.out.println(corCustAtt[1]+corCust.getContractName());
            System.out.println(corCustAtt[2]+corCust.getCustPhone());
            System.out.println(corCustAtt[3]+corCust.getCustAddress());
            System.out.println(corCustAtt[4]+corCust.getCreditLimit());
        }corCust=new CorCust();
        System.out.println("Enter 'y' to continue search. Anything to function menu");
        String userReply=myScanner.next();
        switch(userReply.toUpperCase()){
            case "Y":
            case "YES":searchCorCust();
            break;
            default:functionMenu();
            break;
        }
    }
    public void updateCorCust(){
        String ID;CorCust cc1=new CorCust();
        System.out.println("Enter the corCust ID : ");
        ID=myScanner.next();
        cc1=CC.searchCorCust(ID);
        corCust=new CorCust(cc1.getCustID(),cc1.getContractName(),cc1.getCustPhone(),cc1.getCustAddress(),cc1.getCreditLimit()
        ,cc1.getCustMode());
        if(CC.getCValidation()==true){
            System.out.println("0 - cancel update");
            System.out.println("1 - confirm update");
            System.out.println("2 - "+corCustAtt[1]+corCust.getContractName());
            System.out.println("3 - "+corCustAtt[2]+corCust.getCustPhone());
            System.out.println("4 - "+corCustAtt[3]+corCust.getCustAddress());
            System.out.println("5 - "+corCustAtt[4]+corCust.getCreditLimit());
            boolean checkSelection;
            do{
                checkSelection=true;
                System.out.println("Enter the number 0-5 to select function");
                String userSelection = myScanner.next();
                switch(userSelection){
                    case "0":corCust=new CorCust();checkSelection=false;break;
                    case "1":CC.updateCorCust(corCust);checkSelection=false;break;
                    case "2":System.out.println(corCustAtt[1]);corCust.setContractName(myScanner.next());break;
                    case "3": String phone;System.out.println(corCustAtt[2]);
                        do{phone=myScanner.next();}while(CC.checkInputValidation("Phone", phone)==false);
                        corCust.setCustPhone(phone);
                    break;
                    case "4":System.out.println(corCustAtt[3]);corCust.setCustAddress(myScanner.next());
                    break;
                    case "5":String creditLimit;System.out.println(corCustAtt[4]);
                        do{creditLimit=myScanner.next();}while(CC.checkInputValidation("CreditLimit", creditLimit)==false);
                        corCust.setCreditLimit(creditLimit);
                    break;
                    default:checkSelection=false;System.out.println("Only number between 0 to 5 !!");break;
                }
            }while(checkSelection==true);
        }
        corCust=new CorCust();
        System.out.println("Enter 'y' to continue update. Anything to function menu");
        String userReply=myScanner.next();
        switch(userReply.toUpperCase()){
            case "Y":
            case "YES":updateCorCust();
            break;
            default:functionMenu();
            break;
        }
    }
    public void deleteCorCust(){
        String ID;String userReply;
        System.out.println("Enter the corCust ID : ");
        ID=myScanner.next();
        corCust=CC.searchCorCust(ID);
        if(CC.getCValidation()==true){
            System.out.println(corCustAtt[1]+corCust.getContractName());
            System.out.println(corCustAtt[2]+corCust.getCustPhone());
            System.out.println(corCustAtt[3]+corCust.getCustAddress());
            System.out.println(corCustAtt[4]+corCust.getCreditLimit());
            System.out.println("Confirm? Y/N");
            userReply=myScanner.next();
            switch(userReply.toUpperCase()){
                case "Y":
                case "YES":CC.deleteCorCust(ID);
                break;
                default:corCust=new CorCust();System.out.println("Delete cancelled...");
                break;
            }
        }corCust=new CorCust();
        System.out.println("Enter 'y' to continue delete next corCust. Anything to function menu");
        userReply=myScanner.next();
        switch(userReply.toUpperCase()){
            case "Y":
            case "YES":deleteCorCust();
            break;
            default:functionMenu();
            break;
        
        }
    }
    
    
    
    
    
    
    
}
