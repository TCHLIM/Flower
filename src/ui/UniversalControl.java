/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import control.*;
import domain.*;
import java.util.*;
/**
 *
 * @author jiachuen
 */
import da.*;
import domain.*;
import java.util.*;

public class UniversalControl {
    Consumer consumer = new Consumer();ConsumerDA consumerDA= new ConsumerDA();List<Consumer> consumerList=new ArrayList<>();
    CorCust corCust= new CorCust();CorCustDA corCustDA = new CorCustDA();List<CorCust> corCustList=new ArrayList<>();
    VOrder order = new VOrder();List<VOrder> orderList = new ArrayList<>();
    Invoice invoice = new Invoice();InvoiceDA  invoiceDA = new InvoiceDA();List<Invoice> invoiceList=new ArrayList<>();
    
    Scanner s=new Scanner(System.in);
    ManageCustomer MC = new ManageCustomer();
    InvoiceControl IC = new InvoiceControl();
    
    public UniversalControl(){
        orderList.add(new VOrder("O0001","Red Rose",2,30));
        orderList.add(new VOrder("O0002","Hibiscus",2,20));
        orderList.add(new VOrder("O0003","black rose",2,50));
        orderList.add(new VOrder("O0004","begonias",4,87));
        orderList.add(new VOrder("O0005","Hisbiscus",4,40));
        MC.CC.initialized();
        IC.initialized();String userReply;
        do{
            String custID;
            do{
                custID=IC.checkCustomer();
                MC.corCust=MC.CC.searchCorCust(custID);
            }while(MC.CC.getCValidation()==false);

            IC.printPdf(MC.corCust,IC.getAll(),orderList,IC.invMonth(),IC.invYear());
            System.out.println("generate next?Y/N");
            userReply=s.next();
        }while("Y".equals(userReply.toUpperCase())||"YES".equals(userReply.toUpperCase()));
    }
    public List<Consumer> refreshConsumer(){
        return MC.getAllConsumer();
    }
    public List<CorCust> refreshCorCust(){
        return MC.getAllCorCust();
    }
    public List<Invoice> refreshInvoice(){
        return IC.getAll();
    }
    
    
    
    
    
    public static void main(String[] args){
        new UniversalControl();
    }
}
