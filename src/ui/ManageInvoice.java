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
import java.util.List;
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
        
    }
    
    public void startInvoice(ListInterface<CorCust> corCustList){
        corCust = checkCustomer(corCustList);
        
    }
    public CorCust checkCustomer(ListInterface<CorCust> corCustList){
        String custID;boolean validation=false;corCust=new CorCust();
        while(validation==false){
            System.out.println("Enter the corporate customer id");
            custID=myScanner.next();int countPlace=0;
            while(countPlace<corCustList.size()&&validation==false){
                corCust=corCustList.getEntry(countPlace);
                if(corCust.getCustID().equals(custID)){validation=true;}
            }//end nested while
        }//end while
        return corCust;
    }
    public Date selectDate(){
        boolean validation=true;String invMonth,invYear;Date selectedDate = null;
        
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
        
        
        do{validation=true;    
            System.out.println("Enter the year of invoice in digit");
            invYear=myScanner.next();int countPlace=0;
            try{
                selectedDate.setYear((int) Date.parse(invYear));
                if(selectedDate.getYear()>=todayDate.getYear()){
                    validation=false;
                    System.out.println("please enter the valid year in digit");
                }
            }catch(Exception ex){validation=false;
                System.out.println("please enter the valid year in digit");
            }//end try
            
            
            /*while(countPlace<invYear.length()){
                if(!Character.isDigit(invYear.charAt(countPlace))){validation=false;
                System.out.println("please enter the valid year in digit");countPlace=invYear.length();}//end if
                countPlace++;
            }//end while*/
        }while(validation==false);
        return selectedDate;
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
