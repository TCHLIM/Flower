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
import static java.lang.System.exit;
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
    LocalDate todayDate;
    Scanner myScanner = new Scanner(System.in);
    CorCust corCust;
    
    public ManageInvoice(){
        
    }
    
    public void startInvoice(ListInterface<CorCust> corCustList,ListInterface<InvoiceItem> itemList){
        corCust = checkCustomer(corCustList);Date date;ListInterface<InvoiceItem> filteredList;
        if(corCust!=null){//if 1
            date=selectDate();
            if(date!=null){//if 2
                filteredList =getItems(itemList,corCust.getCustID(),date);
                if(!filteredList.isEmpty()){//if 3
                    DisplayInvoice(corCust,filteredList,date);
                }else System.out.println("******************\n No such record!!!\n******************");//end if 3
            }//end if 2
        }//end if 1
    }
    public CorCust checkCustomer(ListInterface<CorCust> corCustList){
        String custID;boolean validation=false;corCust=new CorCust();
        while(validation==false){
            System.out.println("Enter the corporate customer id, '0' to cancel");
                custID=myScanner.next();int countPlace=0;
            if(!"0".equals(custID)){
                while(countPlace<corCustList.size()){
                    corCust=corCustList.getEntry(countPlace);
                    if(corCust.getCustID().equals(custID)&&!"DELETED".equals(corCust.getCustMode())){validation=true;countPlace=corCustList.size();}
                    countPlace++;
                }//end nested while
            }else {corCust=null;validation=true;}   
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
                        }else {selectedDate.setMonth(Integer.parseInt(invMonth));}

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
                        }else{selectedDate.setYear(Integer.parseInt(invYear));}
                    }catch(Exception ex){
                        YearValidation=false;System.out.println("please enter the valid year in digit***");
                    }//end try                  
                break;
            }//end switch
        }//end while
        return selectedDate;
    }
    public ListInterface<InvoiceItem> getItems(ListInterface<InvoiceItem> itemList,String custID,Date date){
        int countPlace=0;ListInterface<InvoiceItem>returnList=new List<>();
        while(countPlace<itemList.size()){
            item = itemList.getEntry(countPlace);
            //System.out.println("inout " + custID+"  item custid"+item.getCustID());
            if(custID.equals(item.getCustID())){
                if(item.getDateAdded().getMonth()==date.getMonth()){returnList.add(item);
                    if(item.getDateAdded().getYear()==date.getYear()){}//end if
                }//end if
            }//end if
            countPlace++;
        }
        return returnList;
    }
    public void DisplayInvoice(CorCust corCust,ListInterface<InvoiceItem> itemList,Date date){
        
        System.out.println("#####################################################################################");
        System.out.printf("%-20s%-40s%-10s\n","Fiore Flower Shop","","INVOICE");
        System.out.printf("%55s%-15s\n","","INVOICE# | MONTH");
        System.out.printf("%58s%6s%-1s%-5s%-1s%-5s\n","","V0001","|",date.getMonth(),"/",date.getYear());
        System.out.println("BILL TO\n"+corCust.getContractName()+"\n"+corCust.getCustPhone() );
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-4s%-50s%-10s%-10s\n","NO","Item","QTY","Amount(RM)");
        
        double totalPrice=0;int countPlace=0;
        while(countPlace<itemList.size()){
            item=itemList.getEntry(countPlace);
            totalPrice+=item.getItemPrice();
            System.out.printf("%-4s%-50s%-10s%-10s\n",countPlace+1,item.getItemName(),item.getItemQty(),item.getItemPrice());
            
            countPlace++;
        }//end while
        System.out.println("--------------------------------------------------------------------------------");        
        System.out.println("                                    TOTAL RM"+totalPrice);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("#####################################################################################");
        
    
    }
    
}

