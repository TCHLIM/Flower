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
    private Customer consumer;
    private Customer corporateCustomer;
    private ArrayList<Consumer> consumerList = new ArrayList<>();
    private ArrayList<CorporateCustomer> corCustList = new ArrayList<>();
    
    
    public CustomerMaintenance(){
        consumer = new Consumer();
        corporateCustomer = new CorporateCustomer();
    }
    
    //Consumer function
    public void addConsumerDA(Consumer consumer){
        consumerList.add(consumer);
    }
    public Consumer searchConsumerDA(String custID){
        boolean search = false;
        int i = 0;
        while(search==false&&consumerList.size()>=i){
            if(consumerList.get(i).getCustID().equals(custID)){
                search = true;
            }else{
                search=false;
                i++;
            }//end if
        }//end while
        return consumerList.get(i);
    }
    public void deleteConsumerDA(String custID){
        boolean delete = false;
        int i = 0;
        while(delete==false&&consumerList.size()>=i){
            if(consumerList.get(i).getCustID().equals(custID)){
                delete = true;
                consumerList.remove(i);
            }else{
                delete=false;
                i++;
            }//end if
        }//end while
    }
    public ArrayList<Consumer> getAllConsumer(){
        return consumerList;
    }
    
    //Corporate Customer function
    public void addCorCustDA(CorporateCustomer corCust){
        corCustList.add(corCust);
    }
    public Consumer searchCorCustDA(String custID){
        boolean search = false;
        int i = 0;
        while(search==false&&corCustList.size()>=i){
            if(corCustList.get(i).getCustID().equals(custID)){
                search = true;
            }else{
                search=false;
                i++;
            }//end if
        }//end while
        return consumerList.get(i);
    }
    public void deleteCorCustDA(String custID){
        boolean delete = false;
        int i = 0;
        while(delete==false&&corCustList.size()>=i){
            if(corCustList.get(i).getCustID().equals(custID)){
                delete = true;
                corCustList.remove(i);
            }else{
                delete=false;
                i++;
            }//end if
        }//end while
    }
    public ArrayList<CorporateCustomer> getAllCorCust(){
        return corCustList;
    }
}
