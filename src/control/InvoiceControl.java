/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import ADT.ListInterface;
import java.util.*;
import domain.*;
import ui.*;

import da.*;
/**
 *
 * @author jiachuen
 */
public class InvoiceControl {
    Invoice invoice = new Invoice();
    CorCust corCust=new CorCust();
    InvoiceDA invoiceDA = new InvoiceDA();
    //private boolean checkCust;
    public InvoiceControl(){
        
    }
    public ListInterface<Invoice> getAll(){
        return invoiceDA.getAll();
    }
    public void initialized(){
        
    }
    
    public void addInvoice(Invoice inv){
        invoiceDA.add(inv);
    }
    public Invoice searchInvoice(String ID){
        return invoiceDA.search(ID);
    }
    public void updateInvoice(Invoice inv){
        invoiceDA.update(inv);
    }
    
    

    
    public String AutoIDGenerator(){
        String invID="";
        String lastID;
        int IDArray[] = new int[4];        
        lastID=invoiceDA.getLastID();
        if(invoiceDA.getValidation()==false){
            invID="V0001";
        }else{
            invID= "V";
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
                invID+=String.valueOf(IDArray[i]);
            }//end for         
        }//end if
        return invID;
    }
    public String itemIDGenerator(String invID){
        String ID = "I";
        ID = "I"+invID.charAt(1)+invID.charAt(2)+invID.charAt(3)+invID.charAt(4);
        return ID;
    }
    
    
    
    
    
    
    
    
    
}
