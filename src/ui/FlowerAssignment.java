package ui;

import ADT.List;
import domain.PickUpDetails;
import domain.Order;
import ui.Main;
import domain.Flower;
import ADT.ListInterface;
import Report.CatalogBouquet;
import Report.CatalogFlower;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FlowerAssignment {

    private static Scanner in = new Scanner(System.in);
    private ListInterface<Order> orderList = new List<>();
    private ListInterface<PickUpDetails> pickUpList = new List<>();
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Date date = new Date();
    private static DateFormat timeFormat = new SimpleDateFormat("hh:mm");
    private static Date time = new Date();
    double creditLimit = 1000.00;
    private static final Main newMain = new Main();
    private static int i = 0;

    public void mainMenu() {

        i = newMain.initComponents(i);

        String choice = "";

        System.out.print("\nWelcome to Fiore Flower Shop\n");
        System.out.print("1.Make Order\n");
        System.out.print("2.Catalog Sales Order Report\n");
        System.out.print("3.Make Payment\n");
        System.out.print("4.Check Order Schdule\n");
        System.out.print("Decision: ");
        choice = in.nextLine();

        if (choice.equals("1")) {
            displayFlower();
        } else if (choice.equals("2")) {
            displayCatalogReport();
        } else if (choice.equals("3")) {
            makePayment();
        }
    }

    public void displayFlower() {
        String choice = "";
        int n = 0;

        System.out.print("\nPlease Choose A Category: \n");
        System.out.print("1.Flower\n");
        System.out.print("2.Bouquets\n");
        System.out.print("3.Floral\n");
        System.out.print("4.Back\n");
        System.out.print("Decision: ");
        choice = in.nextLine();

        if (choice.matches("1")) {

            addFlower(choice);

        } else if (choice.matches("2")) {

            addFlower(choice);
        } else if (choice.matches("3")) {
            if (newMain.flowerList.getEntry(n).getType().equalsIgnoreCase("floral")) {
//                System.out.println("Flower ID: " + newMain.flowerList.getEntry(n).getId() + "\n" + "Flower Name: " + newMain.flowerList.getEntry(n).getName() + "\n" + "Flower Quantity: " + newMain.flowerList.getEntry(n).getQuantity() + "\n" + "Flower Price:" + newMain.flowerList.getEntry(n).getPrice() + "\n");
//                addFlower();
                System.out.println("BOIII");

            } else if (choice.matches("4")) {
                mainMenu();
            }

        }
        mainMenu();
    }

    public void displayFlowerCatalog() {
        System.out.format("%-11s%-22s%-17s%-13s ", "Flower ID", "Flower Name", "Flower Quantity", "Flower Price");
        System.out.print("\n");
        System.out.format("%-11s%-22s%-17s%-13s ", "---------", "--------------------", "---------------", "------------");
        System.out.print("\n");
        for (int n = 0; n < newMain.flowerList.size(); n++) {
            if (newMain.flowerList.getEntry(n).getType().equalsIgnoreCase("flower")) {

                System.out.format("%-11s%-22s%-17s%-14s",
                        newMain.flowerList.getEntry(n).getId(), newMain.flowerList.getEntry(n).getName(),
                        newMain.flowerList.getEntry(n).getQuantity(), newMain.flowerList.getEntry(n).getPrice() + ".00");
                System.out.print("\n");
            }
        }
    }

    public void displayBouquetCatalog() {
        System.out.format("%-12s%-22s%-18s%-15s ", "Bouquet ID", "Bouquet Name", "Bouquet Quantity", "Bouquet Price");
        System.out.print("\n");
        System.out.format("%-12s%-22s%-18s%-15s ", "----------", "--------------------", "----------------", "-------------");
        System.out.print("\n");
        for (int n = 0; n < newMain.flowerList.size(); n++) {
            if (newMain.flowerList.getEntry(n).getType().equalsIgnoreCase("bouquets")) {

                System.out.format("%-12s%-22s%-18s%-15s ",
                        newMain.flowerList.getEntry(n).getId(), newMain.flowerList.getEntry(n).getName(),
                        newMain.flowerList.getEntry(n).getQuantity(), newMain.flowerList.getEntry(n).getPrice() + ".00");
                System.out.print("\n");
            }
        }
    }

    public void addFlower(String input) {
        String choice = "", newItem = "";
        String opt = "";
        double totalprice = 0;
        int n = 0, q = 0, orderQuantity = 0;

        do {

            if (input.equals("1")) {
                displayFlowerCatalog();
            } else if (input.equals("2")) {
                displayBouquetCatalog();
            }

            System.out.print("\nPlease Enter The Flower Name You Wish To Purchase: ");
            choice = in.nextLine();
            System.out.print("\nHow Many Flower Would You Like To Purchase? :  ");
            orderQuantity = Integer.parseInt(in.nextLine());

            for (n = 0; n < newMain.flowerList.size(); n++) {
                if (newMain.flowerList.getEntry(n).getName().equalsIgnoreCase(choice)) {
                    q = newMain.flowerList.getEntry(n).getQuantity() - orderQuantity;
                    if (q < 0) {
                        System.out.println("\nNo More Stock");
                        displayFlower();
                    }

                    newMain.flowerList.getEntry(n).setQuantity(q);
                    Order order = new Order(newMain.flowerList.getEntry(n).getId(), choice, orderQuantity, newMain.flowerList.getEntry(n).getPrice() * orderQuantity, newMain.flowerList.getEntry(n).getType());
                    orderList.add(order);
                    System.out.format("%-20s%-15s%-10s", "Item Name", "Item Quantity", "Item Price");
                    System.out.print("\n");
                    System.out.format("%-20s%-15s%-10s", "---------", "-------------", "----------");
                    System.out.print("\n");
                    for (int i = 0; i < orderList.size(); i++) {
                        totalprice += orderList.getEntry(i).getOrderPrice();
                        System.out.format("%-20s%-15s%.2f", orderList.getEntry(i).getOrderName(), orderList.getEntry(i).getOrderQuantity(), orderList.getEntry(i).getOrderPrice());
                        System.out.print("\n");

                    }
                    System.out.format("%-20s%-15s%.2f", " ", " ", totalprice);
                    System.out.print("\n");

                }

            }

            System.out.print("\nDo you wish to continue? (Yes to Continue | Any Characters to exit)");
            System.out.print("\nDecision: ");
            opt = in.nextLine();

        } while (opt.equalsIgnoreCase("yes") && orderQuantity != 0);

    }

    public void makePayment() {

        String choice;
        double total = 0, payment = 0;
        System.out.println("Item You Ordered:");
//
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(String.format("Order ID: %s \n Order Name: %s Order Quantity: %d Order Price: %.2f \n", orderList.getEntry(i).getOrderId(), orderList.getEntry(i).getOrderName(), orderList.getEntry(i).getOrderQuantity(), orderList.getEntry(i).getOrderPrice()));
            total += orderList.getEntry(i).getOrderPrice();
        }
        System.out.println("Total Price: " + total);
        System.out.println("Would You Like To Make Payment?");
        System.out.println("Current Credit Limit :" + creditLimit);
        choice = in.nextLine();
        if (choice.equalsIgnoreCase("Yes")) {
            if (creditLimit >= total) {
                payment = creditLimit - total;
                creditLimit = payment;
                System.out.println("    Payment Successful !    ");
                System.out.println(creditLimit);

                addDelivery();

            } else if (creditLimit < total) {
                System.out.println("  Sorry! Credit Already Hit Limit!  ");
                mainMenu();
            }

        } else if (choice.equalsIgnoreCase("No")) {
            mainMenu();

        }

    }

    public void addDelivery() {
        String Details = "";
        String pickUpDate = "";
        String pickUpTime = "";
        String HH = "";
        String MM = "";
        int hh = 0;
        int mm = 0;
        String address = "Setapak Business Park 53300 Jalan Wangsa Maju";
        String deliveryDetails = "";

        System.out.print("What Date Do You Wish To Pick Up Your Order?: ");
        pickUpDate = in.nextLine();
        System.out.print("What Time Do You Wish To Pick Up Your Order?: ");
        pickUpTime = in.nextLine();
        try {
            if (timeFormat.parse((pickUpTime)).before(timeFormat.parse("24:00"))) {
                PickUpDetails pickUpDetails = new PickUpDetails(pickUpTime, pickUpDate, address);

                pickUpList.add(pickUpDetails);

                Details = pickUpTime + " " + pickUpDate + " " + address;

                System.out.println(Details);

                for (int i = 0;
                        i < orderList.size();
                        i++) {
                    System.out.format("%s           %d", orderList.getEntry(i).getOrderName(), orderList.getEntry(i).getOrderQuantity());

                }
            } else {
                System.out.println("Invalid Time");
            }
        } catch (Exception ex) {
            System.out.println("Error Message: " + ex);
        }
    }

    public void displayCatalogReport() {
        int choice = 0;
        String[] args = {""};

        String month = String.valueOf(date.getMonth());
        String year = String.valueOf(date.getYear() + 1900);

        System.out.print("\nPlease Choose The Catalog Report You Wanna Print");
        System.out.print("\n1. Flower");
        System.out.print("\n2. Bouquet");
        System.out.print("\nDecision: ");
        choice = in.nextInt();

        if (choice == 1) {
            CatalogFlower cf = new CatalogFlower();
            cf.main(args, month, year, orderList);

        } else if (choice == 2) {
            CatalogBouquet cb = new CatalogBouquet();
            cb.main(args, month, year, orderList);
        }
    }

    public static void main(String[] args) {
        FlowerAssignment assignment = new FlowerAssignment();
        assignment.mainMenu();

    }

}
