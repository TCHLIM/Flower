/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import java.util.*;
import domain.*;
/**
 *
 * @author jiachuen
 */
public class ConsumerDA {
    Consumer consumer = new Consumer();
    List<Consumer> consumerList = new ArrayList<>();
    private boolean validation = true;
   
    public boolean getValidation(){
        return validation;
    }
    public Consumer search(String custID){
        int countPlace=0;
        while(countPlace< consumerList.size()){
            consumer = consumerList.get(countPlace);
            if(!"DELETED".equals(consumer.getCustMode())&&custID.equals(consumer.getCustID())){
                validation=true;
                countPlace=consumerList.size();
            }else{validation=false;}
            countPlace++;
        }
        if(validation==false){System.out.println("No such record...");}
        return consumer;
    }
    public void addValidation(String custIC){
        validation= true;
        int countPlace=0;
        while(countPlace< consumerList.size()){
            consumer = consumerList.get(countPlace);
            if(consumer.getCustIC().equals(custIC)&&!"DELETED".equals(consumer.getCustMode())){
                validation=false;
                System.out.println("Record Existed!!\nPlease use another IC");
                countPlace=consumerList.size();
            }else{validation=true;}
            countPlace++;
        }
    }
    public void add(Consumer c){
        consumerList.add(c);
        System.out.println("New Consumer Added.");
    }
    public void updateValidation(String custIC, String custID){
        int countPlace=0;
        validation=true;
        while(countPlace<consumerList.size()){
            consumer = consumerList.get(countPlace);
            if(consumer.getCustIC().equals(custIC)&&!"DELETED".equals(consumer.getCustMode())){
                if(!custID.equals(consumer.getCustID())){
                    validation=false;
                    System.out.println("Record Existed!!\nPlease use another IC");
                    countPlace=consumerList.size();
                }//end if
            }//end if
            countPlace++;
        }
    }
    public void update(Consumer c){
        int countPlace=0;
        while(countPlace<consumerList.size()){
            if(consumer.getCustID().equals(c.getCustID())){
                consumerList.set(countPlace, c);
                validation=true;
                countPlace=consumerList.size();
            }else{validation = false;}
        }
    }
    public void delete(String custID){
        int countPlace=0;
        while(countPlace< consumerList.size()){
            consumer = consumerList.get(countPlace);
            if(!"DELETED".equals(consumer.getCustMode())&&custID.equals(consumer.getCustID())){
                consumer.setCustMode("DELETED");
                consumerList.set(countPlace, consumer);
                validation=true;
                System.out.println(custID + " are successfully deleted!!");
                countPlace=consumerList.size();
            }else{validation=false;}
            countPlace++;
        }
    }
    public String getLastID(){
        String custID="";
        validation=true;
        if(!consumerList.isEmpty()){
           custID= consumerList.get(consumerList.size()-1).getCustID() ;
        }else{validation=false;}
        
        return custID;
    }
    
    
    
    
    
    
    
}
