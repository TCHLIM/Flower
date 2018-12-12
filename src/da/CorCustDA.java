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
public class CorCustDA {
    CorCust corCust = new CorCust();
    List<CorCust> corCustList = new ArrayList<>();
    private boolean validation = true;
   
    public boolean getValidation(){
        return validation;
    }
    public void refreshCorCust(List<CorCust> cc){
        this.corCustList=cc;
    }
    public CorCust search(String custID){
        int countPlace=0;
        while(countPlace< corCustList.size()){
            corCust = corCustList.get(countPlace);
            if(!"DELETED".equals(corCust.getCustMode())&&custID.equals(corCust.getCustID())){
                validation=true;
                countPlace=corCustList.size();
            }else{validation=false;}
            countPlace++;
        }
        if(validation==false){System.out.println("No such record...");}
        return corCust;
    }
    
    public List<CorCust> getAll(){
        return corCustList;
    }
    
    
    public void add(CorCust c){
        corCustList.add(c);
        System.out.println("New CorCust Added.");
    }
    
    public void update(CorCust c){
        int countPlace=0;
        while(countPlace<corCustList.size()){
            if(corCust.getCustID().equals(c.getCustID())){
                corCustList.set(countPlace, c);
                validation=true;
                System.out.println("record updated...");
                countPlace=corCustList.size();
            }else{validation = false;}
        }
    }
    public void delete(String custID){
        int countPlace=0;
        while(countPlace< corCustList.size()){
            corCust = corCustList.get(countPlace);
            if(!"DELETED".equals(corCust.getCustMode())&&custID.equals(corCust.getCustID())){
                corCust.setCustMode("DELETED");
                corCustList.set(countPlace, corCust);
                validation=true;
                System.out.println(custID + " are successfully deleted!!");
                countPlace=corCustList.size();
            }else{validation=false;}
            countPlace++;
        }
    }
    public String getLastID(){
        String custID="";
        validation=true;
        if(!corCustList.isEmpty()){
           custID= corCustList.get(corCustList.size()-1).getCustID() ;
        }else{validation=false;}
        
        return custID;
    }
}
