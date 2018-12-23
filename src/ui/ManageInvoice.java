/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ADT.ListInterface;
import domain.CorCust;
import domain.Invoice;
import domain.Order;
import java.time.LocalDate;
import java.util.Date;
//import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jiach
 */
public class ManageInvoice {
    LocalDate todayDate;
    Scanner myScanner = new Scanner(System.in);
    CorCust corCust;
    
    public ManageInvoice(){
        startInvoice();
    }
    
    public void startInvoice(){//ListInterface<CorCust> corCustList
        //corCust = checkCustomer(corCustList);
        selectDate();
        
        
    }
    public CorCust checkCustomer(ListInterface<CorCust> corCustList){
        String custID;boolean validation=false;corCust=new CorCust();
        while(validation==false){
            System.out.println("Enter the corporate customer id");
            custID=myScanner.next();int countPlace=0;
            while(countPlace<corCustList.getNumberOfEntries()&&validation==false){
                corCust=corCustList.getEntry(countPlace);
                if(corCust.getCustID().equals(custID)){validation=true;}
            }//end nested while
        }//end while
        return corCust;
    }
    public Date selectDate(){
        boolean MonthValidation,YearValidation=false,validation;String invMonth,invYear;Date selectedDate = null;
        
        System.out.println("Enter 1 - 12 to select month of invoice");
        do{MonthValidation=true;validation=true;
            invMonth=myScanner.next();
            switch(invMonth){
                case "0":validation=false;break;
                default:
                    try{
                        selectedDate.setMonth((int) Date.parse(invMonth));
                        if(selectedDate.getMonth()>=todayDate.getMonth().getValue()){
                            MonthValidation=false;
                            System.out.println("please enter the valid month in digit");
                        }
                    }catch(Exception ex){
                        MonthValidation=false;
                    }
                break;
            }
        }while(MonthValidation==false&&validation==true);//end do
        
        while(MonthValidation==true||YearValidation==false)YearValidation=true;    
            System.out.println("Enter the year of invoice in digit");
            invYear=myScanner.next();
            switch(invYear){
                case "0":YearValidation=true;break;
                default:
                    try{
                        selectedDate.setYear((int) Date.parse(invYear));
                        if(selectedDate.getYear()>todayDate.getYear()){
                            YearValidation=false;
                            System.out.println("please enter the valid year in digit");
                        }
                    }catch(Exception ex){YearValidation=false;
                        System.out.println("please enter the valid year in digit");
                    }//end try
                break;
            }
        return selectedDate;
    }
    
   
    
   /* public void printPdf(CorCust corCust,Invoice invoice,Order order,String month,String year){
        
        System.out.println("#####################################################################################");
        System.out.println("Fiore Flower Shop"+"                    INVOICE"+"");
        System.out.println("                                   INVOICE# | MONTH");
        System.out.println("                                    "+invoice.getInvoiceID()+"|"+month+" "+year);
        System.out.println("BILL TO\n"+ corCust.getContractName()+"\n"+corCust.getCustPhone() );
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("NO  Item                         QTY       Amount");
        
        int totalPrice=0;
        while(countPlace<orderList.getNumberOfEntries()){
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
        
    
    }*/
    public static void main(String[] args){
        new ManageInvoice();
    }
}

