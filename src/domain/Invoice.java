
     * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package domain;

import ADT.List;
import ADT.ListInterface;
import java.util.Date;

public class Invoice {
    private String invoiceID;
    private String invoiceStatus;
    private Date currentMonth;
    private Date invoiceDueDate;
    private String corCustID;
    private ListInterface<InvoiceItem> itemList = new List<>();
    
    public Invoice(){
        
    }
    public Invoice(String invoiceID, String invoiceStatus,Date currentMonth,Date invoiceDueDate,String corCustID,ListInterface<InvoiceItem> itemList){
        this.invoiceID=invoiceID;
        this.invoiceStatus=invoiceStatus;
        this.invoiceDueDate=invoiceDueDate;
        this.corCustID=corCustID;
        this.currentMonth = currentMonth;
        this.itemList=itemList;
    }

    public ListInterface<InvoiceItem> getItemID() {
        return itemList;
    }

    public void setItemID(ListInterface<InvoiceItem> itemID) {
        this.itemList = itemID;
    }

  
    public void setCurrentMonth(Date currentMonth) {
        this.currentMonth = currentMonth;
    }

    public Date getCurrentMonth() {
        return currentMonth;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public void setInvoiceDueDate(Date invoiceDueDate) {
        this.invoiceDueDate = invoiceDueDate;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public Date getInvoiceDueDate() {
        return invoiceDueDate;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public String getCorCustID() {
        return corCustID;
    }


    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setCorCustID(String corCustID) {
        this.corCustID = corCustID;
    }























}

