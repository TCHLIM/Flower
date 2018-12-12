/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.util.*;
import domain.*;
import da.*;

/**
 *
 * @author jiachuen
 */
public class InvoiceDA {
    Invoice invoice = new Invoice();
    List<Invoice> invoiceList = new ArrayList();
    
    public List<Invoice> getAll(){
        return invoiceList;
    }
    public void add(Invoice inv){
        invoiceList.add(inv);
    }
    public Invoice search(String ID){
        return invoice;
    }
    public void update(Invoice inv){
        
    }
    public void delete(String ID){
        
    }
    public void refreshInvoice(List<Invoice> inv){
        this.invoiceList=inv;
    }
}
