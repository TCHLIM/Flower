/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.*;
import ADT.*;
/**
 *
 * @author jiachuen
 */
public class CorCustDA {
    private CorCust corCust = new CorCust();
    private ListInterface<CorCust> corCustList = new List<>();

    private boolean validation = true;
   
    public boolean getValidation(){
        return validation;
    }
    public CorCust search(String custID){
        int countPlace=0;
        while(countPlace< corCustList.getNumberOfEntries()){
            corCust = corCustList.getEntry(countPlace);
            if(!"DELETED".equals(corCust.getCustMode())&&custID.equals(corCust.getCustID())){
                validation=true;
                countPlace=corCustList.getNumberOfEntries();
            }else{validation=false;}
            countPlace++;
        }
        if(validation==false){System.out.println("No such record...");}
        return corCust;
    }
    
    public void add(CorCust c){
        corCustList.add(c);
        //System.out.println("New CorCust Added.");
    }
    
    public void update(CorCust c){
        int countPlace=0;
        while(countPlace<corCustList.getNumberOfEntries()){
            if(corCust.getCustID().equals(c.getCustID())){
                corCustList.replace(countPlace, c);
                validation=true;
                System.out.println("record updated...");
                countPlace=corCustList.getNumberOfEntries();
            }else{validation = false;}
        }
    }
    public void delete(String custID){
        int countPlace=0;
        while(countPlace< corCustList.getNumberOfEntries()){
            corCust = corCustList.getEntry(countPlace);
            if(!"DELETED".equals(corCust.getCustMode())&&custID.equals(corCust.getCustID())){
                corCust.setCustMode("DELETED");
                corCustList.replace(countPlace, corCust);
                validation=true;
                System.out.println(custID + " are successfully deleted!!");
                countPlace=corCustList.getNumberOfEntries();
            }else{validation=false;}
            countPlace++;
        }
    }
    public String getLastID(){
        String custID="";
        validation=true;
        if(!corCustList.isEmpty()){
           custID= corCustList.getEntry(corCustList.getNumberOfEntries()-1).getCustID() ;
        }else{validation=false;}
        
        return custID;
    }
    
    public ListInterface<CorCust> getAllCorCust(){
        return corCustList;
    }
}
