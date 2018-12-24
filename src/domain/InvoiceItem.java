/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author jiach
 */
public class InvoiceItem {
    private String itemID;
    private String itemName;
    private String itemType;
    private int itemQty;
    private double itemPrice;
    private DateFormat dateAdded = new SimpleDateFormat("dd/MM/yyyy");
    
    public InvoiceItem(){
    
    }
    
    public InvoiceItem(String itemID,String itemName,String itemType,DateFormat dateAdded,int itemQty,double itemPrice){
        this.itemID=itemID;
        this.itemName=itemName;
        this.itemType=itemType;
            this.dateAdded=dateAdded;
        this.itemPrice=itemQty;
        this.itemPrice=itemPrice;
    }

    public void setDateAdded(DateFormat dateAdded) {
        this.dateAdded = dateAdded;
    }

    public DateFormat getDateAdded() {
        return dateAdded;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemQty() {
        return itemQty;
    }

    public double getItemPrice() {
        return itemPrice;
    }
    
    
}
