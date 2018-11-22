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
    private Consumer consumer;
    private CorporateCustomer corporateCustomer;
    private ArrayList<Consumer> consumerList = new ArrayList<>();
    private ArrayList<CorporateCustomer> corCustList = new ArrayList<>();
    
    
    public CustomerMaintenance(){
        consumer = new Consumer();
        corporateCustomer = new CorporateCustomer();
        consumer=null;
        corporateCustomer = null;
    }
    
    //Consumer function
    public void addConsumerDA(Consumer consumer){
        consumerList.add(consumer);
        boolean add = false;
        int i = 0;
        while(add==false||consumerList.size()>=i){
            if(consumerList.get(i).getCustIC().equals(consumer.getCustIC())&&"!DELETED".equals(consumerList.get(i).getCustMode())){
                add = true;
                System.out.println("existing record. Cannot add\n" + "custID = " + consumerList.get(i).getCustID());
            }else{
                add=false;
                i++;
            }//end if
        }
    }
    public Consumer searchConsumerDA(String custID){
        boolean search = false;
        int i = 0;
        while(search==false||consumerList.size()>=i){
            if(consumerList.get(i).getCustID().equals(custID)&&"!DELETED".equals(consumerList.get(i).getCustMode())){
                search = true;
            }else{
                search=false;
                i++;
            }//end if
        }//end while
        if(search==false){
            System.out.println("No such Record!");
        }//end if
        return consumerList.get(i);
    }
    public void deleteConsumerDA(String custID){
        boolean delete = false;
        int i = 0;
        while(delete==false&&consumerList.size()>=i){
            if(consumerList.get(i).getCustID().equals(custID)&&"!DELETED".equals(consumerList.get(i).getCustMode())){
                delete = true;
                consumerList.remove(i);
            }else{
                delete=false;
                i++;
            }//end if
        }//end while
        if(delete==false){
            System.out.println("No such Record!");
        }//end if
    }
    public Consumer updateConsumerDA(Consumer consumer){
        boolean update = false;
        int i = 0;
        while(update==false||consumerList.size()>=i){
            if(consumerList.get(i).getCustID().equals(consumer.getCustID())&&"!DELETED".equals(consumerList.get(i).getCustMode())){
                update = true;
                consumerList.set(i, consumer);
            }else{
                update=false;
                i++;
            }//end if
        }//end while
        if(update==false){
            System.out.println("No such Record!");
        }//end if
        return consumerList.get(i);
    }
    public ArrayList<Consumer> getAllConsumer(){
        int i=0;
        ArrayList<Consumer> copyArray = new ArrayList<>();
        while(consumerList.size()<=i&&"!DELETED".equals(consumerList.get(i).getCustMode())){
            copyArray.add(consumerList.get(i));
        }
        return copyArray;
    }
    
    //Corporate Customer function
    
}
