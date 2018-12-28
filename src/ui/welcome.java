/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.InvoiceItemControl;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author jiach
 */
public class welcome {
    private Scanner myScanner = new Scanner(System.in);
    private boolean validation;
    private ManageCustomer MC ;
    private ManageOrder MO;
    private ManageInvoice MI;
    private InvoiceItemControl IC;
    private Main M;
    
    public welcome(){
        MO = new ManageOrder();M=new Main();
        MC= new ManageCustomer();MI = new ManageInvoice();IC = new InvoiceItemControl();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("***************Welcome to Fiore Flower Shop***************");
        System.out.println("+--------------------------------------------------------+");
        String userReply;
        do{
            System.out.println("Function:\n0 - exit\n1 - Manage Order\n2 - Manage Flower\n3 - Manage Customer\n4 - Generate Invoice ");
            System.out.println("Please Select which function u want to proceed");
            userReply=myScanner.next();
            validation=false;
            switch(userReply){
                case "0": exit(0);break;
                case "1": MO.mainMenu();break;
                case "2": M.giveAccess();break;
                case "3": MC.startManage();break;
                case "4": MI.startInvoice(MC.getAllCorCust(),IC.getAll());break;
                default: System.out.println("Only enter number between '0' to '4");break;
            }
        }while(validation==false);
            
        //System.out.println("WAFFAAGAGAGAGGAGA");
    }
    public static void main(String[] args){
        new welcome();
    }
}
