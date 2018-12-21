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
   
    Scanner s=new Scanner(System.in);
   
    public UniversalControl(){
        String userReply;
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
