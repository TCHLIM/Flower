/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import ADT.List;
import ADT.ListInterface;
import domain.*;
import da.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jiachuen
 */
public class InvoiceDA {
    private Invoice invoice = new Invoice();
    private ListInterface<Invoice> invoiceList = new List<>();
    private boolean validation=true;
    private Date currentMonth,invoiceDueDate;
    private ListInterface<InvoiceItem> invoiceItemList;
    
    public InvoiceDA(){
        
    }
    public void add(Invoice inv){
        invoiceList.add(inv);
    }
    public Invoice search(String ID){
        int countPlace=0;
        while(countPlace<invoiceList.size()){
            invoice=invoiceList.getEntry(countPlace);
            if(invoice.getInvoiceID().equals(ID)){
                validation=true;
                countPlace=invoiceList.size();
            }else{validation = false;}
        }
        return invoice;
    }
    public void update(Invoice inv){
        int countPlace=0;
        while(countPlace<invoiceList.size()){
            invoice=invoiceList.getEntry(countPlace);
            if(invoice.getInvoiceID().equals(inv.getInvoiceID())){
                invoiceList.replace(countPlace, inv);
                validation=true;
                countPlace=invoiceList.size();
            }else{validation = false;}
        }
    }
    
    
    public ListInterface<Invoice> getAll(){
        return invoiceList;
    }
    public boolean getValidation(){
        return validation;
    }
    public String getLastID(){
        String custID="";
        validation=true;
        if(!invoiceList.isEmpty()){
           custID= invoiceList.getEntry(invoiceList.size()-1).getInvoiceID() ;
        }else{validation=false;}
        
        return custID;
    }
    
}
