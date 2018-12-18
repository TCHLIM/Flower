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

public class UniversalControl {
    ManageCustomer MC = new ManageCustomer();
    InvoiceControl IC = new InvoiceControl();
    List<VOrder> orderList = new ArrayList<>();
    Scanner s=new Scanner(System.in);
    
    VOrder vorder=new VOrder();
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

            IC.printPdf(MC.corCust,IC.getAll(),orderList,"NOV","2018");
            System.out.println("Continue?Y/N");
            userReply=s.next();
        }while("Y".equals(userReply.toUpperCase())||"YES".equals(userReply.toUpperCase()));
    }
    
    
    
    
    
    public static void main(String[] args){
        new UniversalControl();
    }
}
