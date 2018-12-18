/*
     * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jiachuen
 */
public class Invoice {
    private String invoiceID;
    private String corCustID;
    private String orderID[];
    
    public Invoice(){
        
    }
    public Invoice(String invoiceID,String corCustID,String orderID[]){
        this.invoiceID=invoiceID;
        this.corCustID=corCustID;
        this.orderID=orderID;
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

