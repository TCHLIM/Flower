/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ADT.List;
import ADT.ListInterface;
import control.InvoiceControl;
import domain.CorCust;
//import domain.Invoice;
import domain.InvoiceItem;
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
    InvoiceItem item;
    InvoiceControl invControl = new InvoiceControl();
    LocalDate todayDate;
    Scanner myScanner = new Scanner(System.in);
    CorCust corCust;
    
    public ManageInvoice(){
        
    }
    
    public void startInvoice(ListInterface<CorCust> corCustList,ListInterface<InvoiceItem> itemList){
        corCust = checkCustomer(corCustList);
        Date date=selectDate();
        ListInterface<InvoiceItem> filteredList =getItems(itemList,corCust.getCustID(),date);
        if(corCust!=null&&date!=null&&filteredList.isEmpty()){
            DisplayInvoice(corCust,filteredList,date);
        }else System.out.println("No such record!!!");
        
    }
    
    public ListInterface<InvoiceItem> getItems(ListInterface<InvoiceItem> itemList,String custID,Date date){
        boolean validation;int countPlace=0;ListInterface<InvoiceItem>returnList=new List<>();
        while(countPlace<itemList.size()){
            item = itemList.getEntry(countPlace);
            if(custID.equals(item.getItemID())){
                if(item.getDateAdded().getMonth()==date.getMonth()){
                    if(item.getDateAdded().getYear()==date.getYear()){returnList.add(item);}//end if
                }//end if
            }//end if
            countPlace++;
        }
        return returnList;
    }
    
    public CorCust checkCustomer(ListInterface<CorCust> corCustList){
        String custID;boolean validation=false;corCust=new CorCust();
        while(validation==false){
            System.out.println("Enter the corporate customer id, '0' to cancel");
                custID=myScanner.next();int countPlace=0;
            if(custID!="0"){
                while(countPlace<corCustList.size()&&validation==false){
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
   
    
    public void DisplayInvoice(CorCust corCust,ListInterface<InvoiceItem> itemList,Date date){
        
        System.out.println("#####################################################################################");
        System.out.println("Fiore Flower Shop"+"                    INVOICE"+"");
        System.out.println("                                   INVOICE# | MONTH");
        System.out.println("                                   "+"V0001"+"| "+date.getMonth()+"/"+date.getYear());
        System.out.println("BILL TO\n"+ corCust.getContractName()+"\n"+corCust.getCustPhone() );
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("NO  Item                         QTY       Amount");
        
        int totalPrice=0,countPlace=0;
        while(countPlace<itemList.size()){
            item=itemList.getEntry(countPlace);
                    totalPrice+=item.getItemPrice();
                System.out.println(countPlace+1+"  "+item.getItemName()+"                "
                        +item.getItemQty()+"          "+item.getItemPrice());

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

