/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, c
hoose Tools | Templates
 * and open the template in the editor.
 */
package control;
import ADT.ListInterface;
import da.*;
import domain.*;
/**
 *
 * @author jiachuen
 */
public class CustomerControl {
   
    
    CorCust corCust = new CorCust();
    
    public CorCustDA corCustDA = new CorCustDA();
        
    public void initialized(){
        corCustDA.getLastID();
        if(corCustDA.getValidation()==false){
            
            corCustDA.add(new CorCust("B0001","CHUEN BHD","01127011502","16,jln8/17,tmn fadason,kl","2000","EXISTING"));
            corCustDA.add(new CorCust("B0002","DDDD BHD","01127011502","16,jln8/17,tmn fadason,kl","2000","EXISTING"));
            corCustDA.add(new CorCust("B0003","????? BHD","01127011502","16,jln8/17,tmn fadason,kl","2000","EXISTING"));
        }
            
    }   
    public boolean checkInputValidation(String type, String userInput){
        int countPlace=0;
        boolean validation=true;
        switch(type){
            
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
    public String AutoIDGenerator(){
        String custID="";
        String lastID;
        int IDArray[] = new int[4];        
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
            }//end for         
        }//end if
        return custID;
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
    public ListInterface<CorCust> getAllCorCust(){
        return corCustDA.getAllCorCust();
    }
}
