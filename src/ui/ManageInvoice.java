/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import domain.*;
import da.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jiachuen
 */
public class ManageInvoice {
    public  ManageInvoice(){
        generateInvoice();
    }
    public void startManage(){
        
    }
    public void generateInvoice(){
        int totalPrice=0;
        System.out.println("####################################################################");
        System.out.println("------------------------Generate Invoice----------------------------");
        System.out.println("###################################################################\n");    
        System.out.println("#####################################################################################");
        System.out.println("Fiore Flower Shop                         INVOICE");
        System.out.println("                                   INVOICE#  |  MONTH");
        System.out.println("                                    V0001    | DEC 2018");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("NO  Item                         QTY       Amount");
        System.out.println("--------------------------------------------------------------------------------");        
        System.out.println("                                  TOTAL RM"+totalPrice);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("#####################################################################################");
    }
    
    
   
}
