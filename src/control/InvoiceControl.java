/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
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
    Scanner myScanner = new Scanner(System.in);
    //private boolean checkCust;
    public InvoiceControl(){
        
    }
    public List<Invoice> getAll(){
        return invoiceDA.getAll();
    }
    public void initialized(){
        String orderID[]={"O0001","O0002"};
        invoiceDA.add(new Invoice("V0001","B0001",orderID));
        String orderID1[]={"O0003","O0004"};
        invoiceDA.add(new Invoice("V0001","B0002",orderID1));
        String orderID2[]={"O0005"};
        invoiceDA.add(new Invoice("V0001","B0003",orderID2));
        invoiceDA.add(invoice);
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
    public void deleteInvoice(String ID){
        invoiceDA.delete(ID);
    }
    

    
    public String invoiceIDGenerator(String custID){
        String invID="";
        int IDArray[] = new int[4];
                
        invID= "V";
        invID+=custID.charAt(1)+custID.charAt(2)+custID.charAt(3)+custID.charAt(4);

        return invID;
    }
    
    public String checkCustomer(){
        String custID;
        System.out.println("Enter the corporate customer id");
        custID=myScanner.next();
        return custID;
    }
    public String invMonth(){
        boolean validation=true;String invMonth;
        
        System.out.println("Enter 1 - 12 to select month of invoice");
        do{validation=true;invMonth=myScanner.next();
            switch(invMonth){
                case "1":invMonth="JAN";break;
                case "2":invMonth="FEB";break;
                case "3":invMonth="MAR";break;
                case "4":invMonth="APR";break;
                case "5":invMonth="MAY";break;
                case "6":invMonth="JUN";break;
                case "7":invMonth="JUL";break;
                case "8":invMonth="AUG";break;
                case "9":invMonth="SEP";break;
                case "10":invMonth="OCT";break;
                case "11":invMonth="NOV";break;
                case "12":invMonth="DEC";break;
                default:System.out.println("Only enter 1 - 12");validation=false;break;
            }//end switch
        }while(validation==false);//end do
    
        return invMonth;
    }
    public String invYear(){
        String invYear;boolean validation;
        do{validation=true;    
            System.out.println("Enter the year of invoice in digit");
            invYear=myScanner.next();int countPlace=0;
            while(countPlace<invYear.length()){
                if(!Character.isDigit(invYear.charAt(countPlace))){validation=false;
                System.out.println("please enter the valid year in digit");countPlace=invYear.length();}//end if
                countPlace++;
            }//end while
        }while(validation==false);
        return invYear;
    }
   
    
    public void printPdf(CorCust corCust,List<Invoice> invoiceList,List<Order> orderList,String month,String year){
        int countPlace=0;
        while(countPlace<invoiceList.size()){
            invoice=invoiceList.get(countPlace);
            if(invoice.getCorCustID().equals(corCust.getCustID())){countPlace=invoiceList.size();}//end if
            countPlace++;
        }//end while
        System.out.println("#####################################################################################");
        System.out.println("Fiore Flower Shop"+"                    INVOICE"+"");
        System.out.println("                                   INVOICE# | MONTH");
        System.out.println("                                    "+invoice.getInvoiceID()+"|"+month+" "+year);
        System.out.println("BILL TO\n"+ corCust.getContractName()+"\n"+corCust.getCustPhone() );
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("NO  Item                         QTY       Amount");
        countPlace=0;
        int totalPrice=0;
        while(countPlace<orderList.size()){
            order=orderList.get(countPlace);
            for (String orderID : invoice.getOrderID()) {
                if (order.getOrderId().equals(orderID)) {
                    totalPrice+=order.getOrderPrice();
                System.out.println(countPlace+1+"  "+order.getOrderId()+" "+order.getOrderName()+"                "
                        +order.getOrderQuantity()+"          "+order.getOrderPrice());
                }//end if
            }//end for
            countPlace++;
        }//end while
        System.out.println("--------------------------------------------------------------------------------");        
        System.out.println("                                    TOTAL RM"+totalPrice);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("#####################################################################################");
        
    
    }
    
    
    
    
    
    
    
}
