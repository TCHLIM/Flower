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
    
    

    
    public String invoiceIDGenerator(String custID){
        String invID="";
        int IDArray[] = new int[4];
                
        invID= "V";
        invID+=custID.charAt(1)+custID.charAt(2)+custID.charAt(3)+custID.charAt(4);

        return invID;
    }
    
    
    
    
    
    
    
    
    
}
