/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author jiach
 */
public class welcome {
    private Scanner myScanner = new Scanner(System.in);
    private boolean validation;
    private ManageCustomer MC = new ManageCustomer();
    private FlowerAssignment MO = new FlowerAssignment();
    private ManageInvoice MI = new ManageInvoice();
    
    public welcome(){
        System.out.println("+--------------------------------------------------------+");
        System.out.println("***************Welcome to Fiore Flower Shop***************");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("Please Select which function u want to proceed");
        System.out.println("0 - exit\n1 - Manage Order\n2 - Manage Flower\n3 - Manage Customer\n4 - Generate Invoice ");
        String userReply=myScanner.next();
        do{
            validation=true;
            switch(userReply){
                case "0": exit(0);break;
                case "1": break;
                case "2": break;
                case "3": MC.startManage();break;
                case "4": MI.startInvoice(MC.getAllCorCust(), orderList);break;
                default: System.out.println("Only enter number between '0' to '4");validation=false;break;
            }
        }while(validation==false);
            
        System.out.println("");
    }
    public static void main(String[] args){
        new welcome();
    }
}
