/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, c
hoose Tools | Templates
 * and open the template in the editor.
 */
package control;
import da.*;
import domain.*;
/**
 *
 * @author jiachuen
 */
public class CustomerControl {
   
    Consumer consumer = new Consumer();
    CorCust corCust = new CorCust();
    ConsumerDA consumerDA= new ConsumerDA();
    CorCustDA corCustDA = new CorCustDA();
        
    public void initialized(){
        consumerDA.getLastID();
        if(consumerDA.getValidation()==false){
            consumer=new Consumer("C0001","CHUEN","981206145493","MALE","01127011502","16,jln8/17,tmn fadason,kl","EXISTING");
            consumerDA.add(consumer);
        }
        corCustDA.getLastID();
        if(corCustDA.getValidation()==false){
            corCust=new CorCust("B0001","CHUEN","01127011502","16,jln8/17,tmn fadason,kl","2000","EXISTING");
            corCustDA.add(corCust);
        }
            
    }
    
    public boolean checkInputValidation(String type, String userInput){
        int countPlace=0;
        boolean validation=true;
        switch(type){
            case "Name" :  ;break;
            case "IC" :
                if(userInput.length()==12){    
                    while(countPlace<userInput.length()){
                        if(!Character.isDigit(userInput.charAt(countPlace))){
                            validation=false;countPlace=userInput.length();System.out.println("IC Only in digits!!\nPlease try Again! :");
                        }countPlace++;//end if
                    }
                }else{validation=false;System.out.println("IC only 12 digits!!\nPlease Try again!! :");}//end if
                ;break;
            case "Gender" :  
                    if(!"1".equals(userInput)&&!"2".equals(userInput)){
                        validation=false;
                        System.out.println("Only enter '1'-Male, '2'-Female !!");
                    }
                ;break;
            case "Phone" :  
                while(countPlace<userInput.length()){
                    if(!Character.isDigit(userInput.charAt(countPlace))){validation=false;
                        System.out.println("Only digits!!\nPlease enter again : ");
                        countPlace=userInput.length();
                    }countPlace++;//end if
                }
                ;break;
            case "Address" :  ;break;
            case "ContractName" :  ;break;
            case "CreditLimit" :  
                int countDot=0;
                while(countPlace<userInput.length()){
                    if(userInput.charAt(countPlace)=='.'){countDot++;}countPlace++;//end if
                }countPlace=0;//end while
                while(countPlace<userInput.length()){
                    if(!Character.isDigit(userInput.charAt(countPlace))&&countDot>1){
                        validation=false;
                        countPlace=userInput.length();
                        System.out.println("Only digits and 1 '.' !!\nPlease enter again : ");
                    }countPlace++;//end if
                }//end while
                    
                ;break;
            default : validation=false;break;
        }
        return validation;
    }
    
    public String AutoIDGenerator(String type){
        String custID="";
        String lastID;
        int IDArray[] = new int[4];
        switch(type){
            case "consumer" : 
                lastID=consumerDA.getLastID();
                if(consumerDA.getValidation()==false){
                    custID="C0001";
                }else{
                    custID= "C";
                    int j=0;
                    for(int i =1;i<lastID.length();i++){
                        IDArray[j]=lastID.charAt(i)-48;j++;
                    }//end for
                    if(IDArray[3]<9){IDArray[3]+=1;}
                        else{if(IDArray[2]<9){IDArray[2]+=1;IDArray[3]=0;}
                            else{if(IDArray[1]<9){IDArray[1]+=1;IDArray[2]=0;IDArray[3]=0;}
                                else{if(IDArray[0]<9){IDArray[0]+=1;IDArray[1]=0;IDArray[2]=0;IDArray[3]=0;}
                        }}}
                    for(int i=0;i<4;i++){
                        custID+=String.valueOf(IDArray[i]);
                    }
                }
            ;break;
            case "corCust" : 
                lastID=corCustDA.getLastID();
                if(corCustDA.getValidation()==false){
                    custID="B0001";
                }else{
                    custID= "B";
                    int j=0;
                    for(int i =1;i<lastID.length();i++){
                        IDArray[j]=lastID.charAt(i)-48;j++;
                    }//end for
                    if(IDArray[3]<9){IDArray[3]+=1;}
                        else{if(IDArray[2]<9){IDArray[2]+=1;IDArray[3]=0;}
                            else{if(IDArray[1]<9){IDArray[1]+=1;IDArray[2]=0;IDArray[3]=0;}
                                else{if(IDArray[0]<9){IDArray[0]+=1;IDArray[1]=0;IDArray[2]=0;IDArray[3]=0;}
                        }}}
                    for(int i=0;i<4;i++){
                        custID+=String.valueOf(IDArray[i]);
                    }
                }
                ;break;
        }
        return custID;
    }
    
    public boolean addConsumerValidation(String IC){
        consumerDA.addValidation(IC);
        return consumerDA.getValidation();
    }
    public boolean updateConsumerValidation(String IC,String ID){
        consumerDA.updateValidation(IC, ID);
        return consumerDA.getValidation();
    }
    public void addConsumer(Consumer c){
        consumerDA.add(c);
    }
    public Consumer searchConsumer(String ID){
        return consumerDA.search(ID);
    }
    public void updateConsumer(Consumer c){
        consumerDA.update(c);
    }
    public void deleteConsumer(String ID){
        consumerDA.delete(ID);
    }
    public boolean getValidation(){
        return consumerDA.getValidation();
    }
    
    
    public void addCorCust(CorCust c){
        corCustDA.add(c);
    }
    public CorCust searchCorCust(String ID){
        return corCustDA.search(ID);
    }
    public void updateCorCust(CorCust c){
        corCustDA.update(c);
    }
    public void deleteCorCust(String ID){
        corCustDA.delete(ID);
    }
    public boolean getCValidation(){
        return corCustDA.getValidation();
    }
}
