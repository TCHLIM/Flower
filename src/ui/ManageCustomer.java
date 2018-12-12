/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import control.*;
import domain.*;
import static java.lang.System.exit;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author jiachuen
 */
public class ManageCustomer {
    CustomerControl CC = new CustomerControl();
    Scanner myScanner = new Scanner(System.in);
    Consumer consumer=new Consumer();
    CorCust corCust=new CorCust();
    private String custType;
    private String[] consumerAtt={"ID: ", "Name: ","IC: ","Gender: [1-Male, 2-Female] ","Phone: ","Address: "};
    private String[] corCustAtt={"ID: ","Contract Name: ","Phone: ","Address: ","Credit Limit: "};
    public ManageCustomer(){
       
    }
    public void startManage(){
        
        custTypeMenu();
        functionMenu(); 
    }
    public List<Consumer> getAllConsumer(){
        return CC.getAllConsumer();
    }
    public List<CorCust> getAllCorCust(){
        return CC.getAllCorCust();
    }
    public void refreshConsumer(List<Consumer> c){
        CC.refreshConsumer(c);
    }
    public void refreshCorCust(List<CorCust> cc){
        CC.refreshCorCust(cc);
                
    }
    public void clearAll(){
        consumer = new Consumer();corCust=new CorCust();
    }
    public void custTypeMenu(){
        custType = " ";
        System.out.println("##############################################################");
        System.out.println("Select which customer type u want to maintain.");
        System.out.println("1 - consumer");
        System.out.println("2 - corporate customer");
        System.out.println("5 - exit");
        custType = myScanner.next();
        System.out.println("##############################################################");
        switch(custType){
            case "1": custType = "CONSUMER";functionMenu();break;
            case "2": custType="CORPORATE CUSTOMER";functionMenu();break;
            case "5":exit(0);break;
            default:System.out.println("Only enter '1'-Consumer, '2'-Corporate Customer");
                    custTypeMenu();break;
        }
        
    }
    public void functionMenu(){
        clearAll();
        String userSelection="";
        System.out.println("##############################################################");
        System.out.println("u are now in '" +custType+"' mode");

        System.out.println("##############################################################");
        System.out.println("0 - exit");
        System.out.println("1 - select customer type");
        System.out.println("2 - Add new customer");
        System.out.println("3 - Search customer Info");
        System.out.println("4 - Update customer Info");
        System.out.println("5 - Delete customer Info\n");
        System.out.println("Enter the number to proceed");//menu selection
        userSelection = myScanner.next();
        System.out.println("##############################################################");

        switch(userSelection){
            case "0" : exit(0);break;
            case "1" :custTypeMenu();break;
            case "2" :if("CONSUMER".equals(custType)){addConsumer();
                      }else{
                        addCorCust();
                    }
                break;
            case "3" :if("CONSUMER".equals(custType)){searchConsumer();
                      }else{
                        searchCorCust();
                    }
                break;
            case "4" :if("CONSUMER".equals(custType)){updateConsumer();
                      }else{
                        updateCorCust();
                    };break;
            case "5" : if("CONSUMER".equals(custType)){deleteConsumer();
                      }else{
                        deleteCorCust();
                    };break;
            default : System.out.println("Only enter a number between '0' to '5'");
                    functionMenu();
            break;
        }
    }
    
    public void addConsumer(){
        int countPlace=0;
        while(countPlace<consumerAtt.length){
            System.out.println(consumerAtt[countPlace]);
            //System.out.println("");
            switch(countPlace){
                case 0:String ID=CC.AutoIDGenerator("consumer"); System.out.println(ID);consumer.setCustID(ID);break;
                case 1:consumer.setCustName(myScanner.next());break;
                case 2:String IC;
                        do{IC = myScanner.next();}while(CC.addConsumerValidation(IC)==false||CC.checkInputValidation("IC", IC)==false);
                        consumer.setCustIC(IC);
                break;
                case 3: String gender;
                        do{gender=myScanner.next();}while(CC.checkInputValidation("Gender", gender)==false);
                        if("1".equals(gender)){consumer.setCustGender("MALE");}else{consumer.setCustGender("FEMALE");}
                break;
                case 4: String phone;
                    do{phone=myScanner.next();}while(CC.checkInputValidation("Phone", phone)==false);
                    consumer.setCustPhone(phone);
                break;
                case 5:consumer.setCustAddress(myScanner.next());
                break;
            }
            countPlace++;
        }
        consumer.setCustMode("EXISTING");CC.addConsumer(consumer);consumer=new Consumer();
        System.out.println("Enter 'y' to continue add. Anything to function menu");
        String userReply=myScanner.next();
        switch(userReply.toUpperCase()){
            case "Y":
            case "YES":addConsumer();
            break;
            default:functionMenu();
            break;
        }
    }
    public void searchConsumer(){
        String ID;
        System.out.println("Enter the consumer ID : ");
        ID=myScanner.next();
        consumer=CC.searchConsumer(ID);
        if(CC.getValidation()==true){
            System.out.println(consumerAtt[1]+consumer.getCustName());
            System.out.println(consumerAtt[2]+consumer.getCustIC());
            System.out.println("Gender: "+consumer.getCustGender());
            System.out.println(consumerAtt[4]+consumer.getCustPhone());
            System.out.println(consumerAtt[5]+consumer.getCustAddress());
        }consumer=new Consumer();
        System.out.println("Enter 'y' to continue search. Anything to function menu");
        String userReply=myScanner.next();
        switch(userReply.toUpperCase()){
            case "Y":
            case "YES":searchConsumer();
            break;
            default:functionMenu();
            break;
        }
    }
    public void updateConsumer(){
        String ID;Consumer c1 =new Consumer();
        System.out.println("Enter the consumer ID : ");
        ID=myScanner.next();
        c1=CC.searchConsumer(ID);
        consumer=new Consumer(c1.getCustID(),c1.getCustName(),c1.getCustIC(),c1.getCustGender(),c1.getCustPhone(),
        c1.getCustAddress(),c1.getCustMode());
        if(CC.getValidation()==true){
            System.out.println("0 - cancel update");
            System.out.println("1 - confirm update");
            System.out.println("2 - "+consumerAtt[1]+consumer.getCustName());
            System.out.println("3 - "+consumerAtt[2]+consumer.getCustIC());
            System.out.println("4 - "+"Gender: "+consumer.getCustGender());
            System.out.println("5 - "+consumerAtt[4]+consumer.getCustPhone());
            System.out.println("6 - "+consumerAtt[5]+consumer.getCustAddress());
            boolean checkSelection;
            do{
                checkSelection=true;
                System.out.println("Enter the number 0-6 to select function");
                String userSelection = myScanner.next();
                switch(userSelection){
                    case "0":System.out.println("update cancelled...");checkSelection=false;;break;
                    case "1":CC.updateConsumer(consumer);checkSelection=false;break;
                    case "2":System.out.println(consumerAtt[1]);consumer.setCustName(myScanner.next());break;
                    case "3":String IC;System.out.println(consumerAtt[2]);
                            do{IC = myScanner.next();}while(CC.updateConsumerValidation(IC, ID)==false||CC.checkInputValidation("IC", IC)==false);
                            consumer.setCustIC(IC);
                    break;
                    case "4": String gender;System.out.println(consumerAtt[3]);
                            do{gender=myScanner.next();}while(CC.checkInputValidation("Gender", gender)==false);
                            if("1".equals(gender)){consumer.setCustGender("MALE");}else{consumer.setCustGender("FEMALE");}
                    break;
                    case "5": String phone;System.out.println(consumerAtt[4]);
                        do{phone=myScanner.next();}while(CC.checkInputValidation("Phone", phone)==false);
                        consumer.setCustPhone(phone);
                    break;
                    case "6":System.out.println(consumerAtt[5]);consumer.setCustAddress(myScanner.next());
                    break;
                    default:checkSelection=false;System.out.println("Only number between 0 to 6 !!");break;
                }
            }while(checkSelection==true);
        }
        
        System.out.println("Enter 'y' to continue update. Anything to function menu");
        String userReply=myScanner.next();
        switch(userReply.toUpperCase()){
            case "Y":
            case "YES":updateConsumer();
            break;
            default:functionMenu();
            break;
        }
    }
    public void deleteConsumer(){
        String ID;String userReply;
        System.out.println("Enter the consumer ID : ");
        ID=myScanner.next();
        consumer=CC.searchConsumer(ID);
        if(CC.getValidation()==true){
            System.out.println(consumerAtt[1]+consumer.getCustName());
            System.out.println(consumerAtt[2]+consumer.getCustIC());
            System.out.println("Gender: "+consumer.getCustGender());
            System.out.println(consumerAtt[4]+consumer.getCustPhone());
            System.out.println(consumerAtt[5]+consumer.getCustAddress());
            System.out.println("Confirm? Y/N");
            userReply=myScanner.next();
            switch(userReply.toUpperCase()){
                case "Y":
                case "YES":CC.deleteConsumer(ID);
                break;
                default:consumer=new Consumer();System.out.println("Delete cancelled...");
                break;
            }
        }consumer=new Consumer();
        System.out.println("Enter 'y' to continue delete next consumer. Anything to function menu");
        userReply=myScanner.next();
        switch(userReply.toUpperCase()){
            case "Y":
            case "YES":deleteConsumer();
            break;
            default:functionMenu();
            break;
        
        }
    }
    
    
    
    
    
    
    
    
    public void addCorCust(){
        int countPlace=0;String ID;
        while(countPlace<corCustAtt.length){
            System.out.println(corCustAtt[countPlace]);
            //System.out.println("");
            switch(countPlace){
                case 0:ID=CC.AutoIDGenerator("corCust"); System.out.println(ID);corCust.setCustID(ID);break;
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
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args){
        
        new ManageCustomer();
        
    }
    
    
    
    
    
}
