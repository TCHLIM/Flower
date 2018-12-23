/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ADT.ListInterface;
import control.InvoiceControl;
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
    Invoice invoice;
    InvoiceControl invControl = new InvoiceControl();
    LocalDate todayDate;
    Scanner myScanner = new Scanner(System.in);
    CorCust corCust;
    
    public ManageInvoice(){
        
    }
    
    public void startInvoice(ListInterface<CorCust> corCustList,ListInterface<Order> orderList){
        corCust = checkCustomer(corCustList);
        Date date=selectDate();
        Order order=checkOrder(orderList);
        if(corCust!=null&&date!=null){
            DisplayInvoice(corCust,invoice,order,date);
        }
        
    }
    public Invoice checkInvoice(){
        invoice = new Invoice();
        
        return invoice;
    }
    
    public CorCust checkCustomer(ListInterface<CorCust> corCustList){
        String custID;boolean validation=false;corCust=new CorCust();
        while(validation==false){
            System.out.println("Enter the corporate customer id, '0' to cancel");
                custID=myScanner.next();int countPlace=0;
            if(custID!="0"){
                while(countPlace<corCustList.getNumberOfEntries()&&validation==false){
                    corCust=corCustList.getEntry(countPlace);
                    if(corCust.getCustID().equals(custID)){validation=true;}
                }//end nested while
            }else corCust=null;   
        }//end while
        return corCust;
    }
    public Date selectDate(){
        boolean MonthValidation,YearValidation=false,validation;String invMonth,invYear;Date selectedDate = new Date();
        
       
        do{MonthValidation=true;validation=true;
         System.out.println("Enter 1 - 12 to select month of invoice, '0'to cancel");
            invMonth=myScanner.next();
            switch(invMonth){
                case "0":validation=false;selectedDate=null;break;
                default:
                    try{
                        if(Integer.parseInt(invMonth)>12){MonthValidation=false;
                            System.out.println("Please enter the valid month***");
                        }else {selectedDate.setMonth(Integer.parseInt(invMonth)-1);}

                    }catch(Exception ex){
                        MonthValidation=false;System.out.println("please enter the valid month in digit***");
                    }//end try
                //System.out.println("DateMonth"+selectedDate.toLocaleString());
                break;
            }
        }while(MonthValidation==false&&validation==true);//end do
        
        while(validation==true&&YearValidation==false){YearValidation=true;   
            System.out.println("Enter the year of invoice in digit, '0' to exit");
            invYear=myScanner.next();
            switch(invYear){
                case "0":YearValidation=true;selectedDate=null;break;
                default:
                    try{
                        if(Integer.parseInt(invYear)<1900){YearValidation=false;
                            System.out.println("please enter the valid year in digit***");
                        }else{selectedDate.setYear(Integer.parseInt(invYear)-1900);}
                    }catch(Exception ex){
                        YearValidation=false;System.out.println("please enter the valid year in digit***");
                    }//end try                  
                break;
            }//end switch
        }//end while
        return selectedDate;
    }
    public Order checkOrder(ListInterface<Order> orderList){
        Order order;
        return order;
    }
   
    
    public void DisplayInvoice(CorCust corCust,Invoice invoice,Order order,Date date){
        
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
        
    
    }
    public static void main(String[] args){
        new ManageInvoice();
    }
}

