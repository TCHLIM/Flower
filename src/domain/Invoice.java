/*
     * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jiachuen
 */
public class Invoice {
    private String invoiceID;
    private String invoiceStatus;
    private Date currentMonth;
    private Date invoiceDueDate;
    private String corCustID;
    private String orderID[];
    private ArrayList<InvoiceItem> itemID = new ArrayList<>();
    
    public Invoice(){
        
    }
    public Invoice(String invoiceID, String invoiceStatus,Date currentMonth,Date invoiceDueDate,String corCustID,ArrayList<InvoiceItem> itemID){
        this.invoiceID=invoiceID;
        this.invoiceStatus=invoiceStatus;
        this.invoiceDueDate=invoiceDueDate;
        this.corCustID=corCustID;
        this.orderID=orderID;
        this.currentMonth = currentMonth;
        this.itemID=itemID;
    }

    public ArrayList<InvoiceItem> getItemID() {
        return itemID;
    }

    public void setItemID(ArrayList<InvoiceItem> itemID) {
        this.itemID = itemID;
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

    public String getOrderID()[] {
        return orderID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setCorCustID(String corCustID) {
        this.corCustID = corCustID;
    }

    public void setOrderID(String orderID[]) {
        this.orderID = orderID;
    }
    
    

























}

