/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import ADT.List;
import domain.*;
import ADT.ListInterface;
import java.util.Date;

/**
 *
 * @author jiach
 */
public class InvoiceItemDA {
    private ListInterface<InvoiceItem> itemList= new List<>();
    private InvoiceItem item = new InvoiceItem();
    private boolean validation=true;Date date = new Date();

    public InvoiceItemDA() {
        if(itemList.isEmpty()){
            //data 1
            
            date.setMonth(4);date.setYear(2016);date.setDate(20);
            itemList.add(new InvoiceItem("I0001","Blue Rose","",date,10,105,"B0001"));
            itemList.add(new InvoiceItem("I0002","White Rose","",date,10,100,"B0001"));
            itemList.add(new InvoiceItem("I0003","Red Rose","",date,5,52.5,"B0001"));
            //data 2
            date.setMonth(4);date.setYear(2016);date.setDate(20);
            itemList.add(new InvoiceItem("I0004","Yellow Rose","",date,10,100,"B0002"));
            itemList.add(new InvoiceItem("I0005","Blue Rose","",date,10,105,"B0002"));
            itemList.add(new InvoiceItem("I0006","Blue Rose","",date,5,52.5,"B0002"));
            
        }
            
    }
    
    
     public void add(InvoiceItem item){
        itemList.add(item);
    }
    public InvoiceItem search(String ID){
        int countPlace=0;
        while(countPlace<itemList.size()){
            item=itemList.getEntry(countPlace);
            if(item.getItemID().equals(ID)){
                validation=true;
                countPlace=itemList.size();
            }else{validation = false;}
        }
        return item;
    }
    public void update(InvoiceItem item){
        int countPlace=0;
        while(countPlace<itemList.size()){
            item=itemList.getEntry(countPlace);
            if(item.getItemID().equals(item.getItemID())){
                itemList.replace(countPlace, item);
                validation=true;
                countPlace=itemList.size();
            }else{validation = false;}
        }
    }
    
    
    public ListInterface<InvoiceItem> getAll(){
        return itemList;
    }
    public boolean getValidation(){
        return validation;
    }
    public String getLastID(){
        String custID="";
        validation=true;
        if(!itemList.isEmpty()){
           custID= itemList.getEntry(itemList.size()-1).getItemID() ;
        }else{validation=false;}
        
        return custID;
    }
}
