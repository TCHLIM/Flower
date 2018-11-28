/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import domain.Customer;
import domain.Consumer;
import domain.CorporateCustomer;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class CustomerMaintenance {
    private Consumer consumer= new Consumer();
    private CorporateCustomer corporateCustomer= new CorporateCustomer();
    private ArrayList<Consumer> consumerList = new ArrayList<>();
    private ArrayList<CorporateCustomer> corCustList = new ArrayList<>();
    private boolean validation = true;

    public CustomerMaintenance(){

    }
    public void clearAll(){
        consumer= new Consumer();corporateCustomer= new CorporateCustomer();        
    }
    public boolean getValidation(){
        return validation;
    }
    private String id;
    public String returnCustID(){
        return id;
    }
    public boolean checkConsumerAdd(String custIC){
        clearAll();
        int i = 0;
        while(consumerList.size()>i){
            if(custIC.equals(consumerList.get(i).getCustIC())&&!"DELETED".equals(consumerList.get(i).getCustMode())){
                validation = false;id=consumerList.get(i).getCustID();
                i=consumerList.size();
                
            }else{
                i++;
            }//end if
        }return validation;
        
    }
    
    //Consumer function
    public void addConsumerDA(Consumer consumer){
        consumerList.add(consumer);
    }
    public Consumer searchConsumerDA(String custID){
        clearAll();
        int i = 0;
        while(consumerList.size()>i){
            if(custID.equals(consumerList.get(i).getCustID())&&!"DELETED".equals(consumerList.get(i).getCustMode())){
                consumer=consumerList.get(i);
                i=consumerList.size();
            }//end if
            i++;
        }//end while
        return consumer;
    }
    public void deleteConsumerDA(String custID){
        clearAll();
        int i = 0;
        while(consumerList.size()>i){
            if(consumerList.get(i).getCustID().equals(custID)&&!"DELETED".equals(consumerList.get(i).getCustMode())){
                consumerList.get(i).setCustMode("DELETED");
                i=consumerList.size();
            }i++;
        }//end while
    }
    public void updateConsumerDA(Consumer consumer){
        int i = 0;
        while(consumerList.size()>i){
            if(consumerList.get(i).getCustID().equals(consumer.getCustID())&&!"DELETED".equals(consumerList.get(i).getCustMode())){
                consumerList.set(i, consumer);
                i=consumerList.size();
            }//end if
                i++;
        }//end while
    }
    public ArrayList<Consumer> getAllConsumer(){clearAll();
        int i=0;
        ArrayList<Consumer> copyArray = new ArrayList<>();
        while(consumerList.size()<=i&&!"DELETED".equals(consumerList.get(i).getCustMode())){
            copyArray.add(consumerList.get(i));
        }
        return copyArray;
    }
    
    //Corporate Customer function
    public void addCorCustDA(CorporateCustomer c){
        corCustList.add(c);
    }
    public CorporateCustomer searchCorCustDA(String custID){clearAll();
        int i = 0;
        while(corCustList.size()>i){
            if(custID.equals(corCustList.get(i).getCustID())&&!"DELETED".equals(corCustList.get(i).getCustMode())){
                corporateCustomer=corCustList.get(i);
                i=corCustList.size();
            }//end if
            i++;
        }//end while
        return corporateCustomer;
    
    }
    public void updateCorCustDA(CorporateCustomer corCust){
        int i = 0;
        while(corCustList.size()>i){
            if(corCustList.get(i).getCustID().equals(corCust.getCustID())&&!"DELETED".equals(corCustList.get(i).getCustMode())){
                corCustList.set(i, corCust);
                i=corCustList.size();
            }//end if
                i++;
        }//end while
    }
    public void deleteCorCustDA(String custID){
        clearAll();
        int i = 0;
        while(corCustList.size()>i){
            if(corCustList.get(i).getCustID().equals(custID)&&!"DELETED".equals(corCustList.get(i).getCustMode())){
                corCustList.get(i).setCustMode("DELETED");
                i=corCustList.size();
            }i++;
        }//end while
    }
}
