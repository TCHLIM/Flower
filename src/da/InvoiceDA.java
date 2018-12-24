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
    private ArrayList<InvoiceItem> invoiceItemList;
    
    public InvoiceDA(){
        invoiceDueDate.setDate(7);
        //data 1
        currentMonth.setMonth(0);invoiceDueDate.setMonth(currentMonth.getMonth()+1);
        invoiceItemList.add(new InvoiceItem("I0001","Blue Rose","",new SimpleDateFormat("2018/1/2"),10,105));
        invoiceItemList.add(new InvoiceItem("I0002","White Rose","",new SimpleDateFormat("2018/1/14"),10,100));
        invoiceItemList.add(new InvoiceItem("I0003","Red Rose","",new SimpleDateFormat("2018/1/26"),5,52.5));
        invoiceList.add(new Invoice("V0001","PAID",currentMonth,invoiceDueDate,"B0001",invoiceItemList));
        //data 2
        currentMonth.setMonth(0);invoiceDueDate.setMonth(currentMonth.getMonth()+1);
        invoiceItemList.add(new InvoiceItem("I0001","Yellow Rose","",new SimpleDateFormat("2018/5/2"),10,100));
        invoiceItemList.add(new InvoiceItem("I0002","Blue Rose","",new SimpleDateFormat("2018/5/14"),10,105));
        invoiceItemList.add(new InvoiceItem("I0003","Blue Rose","",new SimpleDateFormat("2018/5/26"),5,52.5));
        invoiceList.add(new Invoice("V0002","PAID",currentMonth,invoiceDueDate,"B0002",invoiceItemList));
        
    }
    public void add(Invoice inv){
        invoiceList.add(inv);
    }
    public Invoice search(String ID){
        int countPlace=0;
        while(countPlace<invoiceList.getNumberOfEntries()){
            invoice=invoiceList.getEntry(countPlace);
            if(invoice.getInvoiceID().equals(ID)){
                validation=true;
                countPlace=invoiceList.getNumberOfEntries();
            }else{validation = false;}
        }
        return invoice;
    }
    public void update(Invoice inv){
        int countPlace=0;
        while(countPlace<invoiceList.getNumberOfEntries()){
            invoice=invoiceList.getEntry(countPlace);
            if(invoice.getInvoiceID().equals(inv.getInvoiceID())){
                invoiceList.replace(countPlace, inv);
                validation=true;
                countPlace=invoiceList.getNumberOfEntries();
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
           custID= invoiceList.getEntry(invoiceList.getNumberOfEntries()-1).getInvoiceID() ;
        }else{validation=false;}
        
        return custID;
    }
    
}
