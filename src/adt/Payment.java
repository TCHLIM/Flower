/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author StarmanW
 */
public class Payment {

    private static Scanner in = new Scanner(System.in);
    private static int verify = 0;
    ArrayList<FlowerName> flower3 = new ArrayList<>();
    ArrayList<FlowerName> flowerPrice = new ArrayList<>();

    public static ArrayList<FlowerName> generateFlowerArrangementStyles() {
        ArrayList<FlowerName> flower = new ArrayList<>();

        int custAmount = 1000;

        flower.add(new FlowerName("FAS001", "Red Rose ", 10.00));
        flower.add(new FlowerName("FAS002", "Alyssum ", 8.00));
        flower.add(new FlowerName("FAS003", "Lilin ", 7.00));
        flower.add(new FlowerName("FAS004", "Astilbe ", 10.00));
        flower.add(new FlowerName("FAS005", "Blue Rose ", 12.00));

        return flower;
    }

    public static ArrayList<FlowerName> generateFlowerArrangementStyles2() {
        ArrayList<FlowerName> flower2 = new ArrayList<>();

        flower2.add(new FlowerName("FAS006", "Venus Slipper ", 10.00));
        flower2.add(new FlowerName("FAS007", "Slipper Orchid ", 10.00));
        flower2.add(new FlowerName("FAS008", "Miltoniopis ", 15.00));
        flower2.add(new FlowerName("FAS009", "Vanilla Orchid ", 20.00));
        flower2.add(new FlowerName("FAS010", "White Flow ", 10.00));

        return flower2;
    }

    public static int mainMenu() {
        String choice = "";
        while (true) {
            System.out.print("Please choose one\n"
                    + "1. Browse Flower\n"
                    + "2. Check Daily Sales\n"
                    + "3. make Payment\n"
                    + "4. Back\n"
                    + "Enter your choice: ");
            choice = in.nextLine();
            if (choice.matches("^[1-5]$")) {
                System.out.println("Please Enter Valid Option! (1-4).\n");
                break;
                
            }
            
        }
        return Integer.parseInt(choice);
    }

    public static int displayFlower(ArrayList<FlowerName> flower2) {
        String choice = "", output = "\n Pease review all your order \n";
        int i = 0;

        for (i = 0; i < flower2.size(); i++) {
            output += String.format("%d. %s = RM%.2f\n", i + 1, flower2.get(i).getFlowerName(), flower2.get(i).getPrice());
        }

        output += String.format("%d. Make Payment\n", i + 1);
        output += String.format("%d. Back\nEnter your choice: ", i + 2);

        while (true) {
            System.out.print(output);
            choice = in.nextLine();
            if (choice.matches("^[1-" + (flower2.size() + 1) + "]$") || choice.matches("7")) {
                if (choice.matches("6")) {
                    double totalPrice = 0;
                    for (int j = 0; j < flower2.size(); j++) {
                        double calcPrice = flower2.get(j).getPrice();
                        totalPrice += calcPrice;
                        verify = 1;

                    }
                    System.out.println("Total " + totalPrice);

                }
                
                break;
            }
            System.out.println("Invalid choice entered, please try again with only choice 1-7.\n");
        }
        return Integer.parseInt(choice);
    }

    public static void salesOrder(ArrayList<FlowerName> flower, ArrayList<FlowerName> flower2) {

        String id = "S001";
        String enterID = "";
        int password = 1111;
        int enterPassword = 0;

        System.out.println("Please Enter Your ID: ");
        enterID = in.nextLine();
        System.out.println("Please Enter Your Password:");
        enterPassword = in.nextInt();

        if (enterID.equals("S001") && enterPassword == enterPassword) {

            String choice = "", name = "",  Id = "", price = "";
            int i = 0;
            double total = 47.00;

            System.out.println("Sales Person: Jason Liew" + "                                                     " + "Date:28 November 2018");
            System.out.println("");
            
            for (i = 0; i < flower.size(); i++) {
               Id += flower.get(i).getFlowerID() + ", ";
                if (verify == 1) {
                    Id += flower2.get(i).getFlowerID() + ", ";

                }
                
            }
            System.out.println("ID:" + Id + "\n");
            
            for (i = 0; i < flower.size(); i++) {
                name += flower.get(i).getFlowerName() + ",";
                
                if (verify == 1) {
                    name += flower2.get(i).getFlowerName() + "," ;
                }
            }
            
            System.out.println("Description: "+name + "\n");
            
            
//            for (i = 0; i < flower.size(); i++) {
//                price += flower.get(i).getPrice() + ",";
//                if(verify == 1){
//                price += flower2.get(i).getPrice() + ",";
//                }
//            }
//            
//            System.out.println("Price :" + price);
            
            if (verify == 1) {
                total += 65;

            }
            
            System.out.println("\nTotal Price: RM " + total + "\n");

        } else {
            System.out.println("Wrong Id Or Password Please Try Again!");

        }

    }

}
