/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ADT.ListInterface;
import da.InvoiceItemDA;
import domain.Invoice;
import domain.InvoiceItem;

/**
 *
 * @author jiach
 */
public class InvoiceItemControl {
    InvoiceItemDA itemDA = new InvoiceItemDA();
    InvoiceItem item = new InvoiceItem();
    
    public InvoiceItemControl(){
        itemDA = new InvoiceItemDA();
    }
    
    public ListInterface<InvoiceItem> getAll(){
        return itemDA.getAll();
    }
    
    
    public void addInvoice(Invoice inv){
        itemDA.add(item);
    }
    public InvoiceItem searchInvoice(String ID){
        return itemDA.search(ID);
    }
    public void updateInvoice(Invoice inv){
        itemDA.update(item);
    }
    
    public String AutoIDGenerator(){
        String itemID="";
        String lastID;
        int IDArray[] = new int[4];        
        lastID=itemDA.getLastID();
        if(itemDA.getValidation()==false){
            itemID="I0001";
        }else{
            itemID= "I";
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
                itemID+=String.valueOf(IDArray[i]);
            }//end for         
        }//end if
        return itemID;
    }
}
