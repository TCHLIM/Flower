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

/**
 *
 * @author jiachuen
 */
public class InvoiceDA {
    Invoice invoice = new Invoice();
    ListInterface<Invoice> invoiceList = new List<>();
    private boolean validation=true;
    

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
}
