package ui;

import ADT.List;
import domain.DeliveryDetails;
import domain.Order;
import domain.MadePayment;
import ADT.ListInterface;
import Report.CatalogBirthday;
import Report.CatalogAnniversary;
import Report.CatalogCondolence;
import Report.CatalogGraduation;
import Report.CatalogRomance;
import control.CustomerControl;
import da.CorCustDA;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FlowerAssignment {

    private static Scanner in = new Scanner(System.in);
    private ListInterface<MadePayment> MPList = new List<>();
    private ListInterface<Order> orderList = new List<>();
    private ListInterface<DeliveryDetails> DeliveryList = new List<>();
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Date date = new Date();
    private static DateFormat timeFormat = new SimpleDateFormat("hh:mm");
    private static Date time = new Date();
    double creditLimit = 0;
    private static final Main newMain = new Main();
    private static final CustomerControl newCC = new CustomerControl();
    private static CorCustDA newCCD = new CorCustDA();
    private static int i = 0;
    private static String inputName = "";
    private static boolean condition = false;

    public void mainMenu() {

        i = newMain.initComponents(i);
        newCC.initialized();
        String choice = "";

        if (condition == false) {
            System.out.print("Please Enter Your Corporate Name:");
            inputName = in.nextLine();

            for (int h = 0; h < newCC.getAllCorCust().size(); h++) {
                if (inputName.equalsIgnoreCase(newCC.getAllCorCust().getEntry(h).getContractName())) {
                    condition = true;
                }

            }

        }

        if (condition == true) {
            System.out.format("%-11s%-22s%-17s ", "", "PROMOTION AVAILABLE !!!", "");
            System.out.print("\n");
            System.out.format("%-11s%-22s%-13s", "---------", "--------------------", "---------------");
            System.out.print("\n");
            for (int n = 0; n < newMain.promotionList.size(); n++) {

                System.out.format("%-22s",
                        newMain.promotionList.getEntry(n).getDes());
                System.out.print("\n");

            }

            System.out.print("\nWelcome to Fiore Flower Shop\n");
            System.out.print("1.Make Order\n");
            System.out.print("2.Catalog Sales Order Report\n");
            System.out.print("3.Make Payment\n");
            System.out.print("4.Check Order Schdule\n");
            System.out.print("5.Log Out\n");
            System.out.print("Decision: ");
            choice = in.nextLine();

            if (choice.equals("1")) {
                displayFlower();
            } else if (choice.equals("2")) {
                displayCatalogReport();
            } else if (choice.equals("3")) {
                makePayment();
            } else if (choice.equals("4")) {
                displayDeliveryDetails();
            } else if (choice.equals("5")) {

                System.out.print("Log Out Successful !!!\n");
                inputName = "";
                condition = false;
                mainMenu();
            }
        } else {
            mainMenu();
        }

    }

    public void displayFlower() {
        String choice = "";
        int n = 0;

        System.out.print("\nPlease Choose A Category: \n");
        System.out.print("1.Birthday\n");
        System.out.print("2.Anniversary\n");
        System.out.print("3.Condolence\n");
        System.out.print("4.Romance\n");
        System.out.print("5.Graduation\n");
        System.out.print("6.Remove Order\n");
        System.out.print("7.Back To Main Menu\n");
        System.out.print("Decision:");
        choice = in.nextLine();

        if (choice.matches("1")) {

            addFlower(choice);

        } else if (choice.matches("2")) {

            addFlower(choice);
        } else if (choice.matches("3")) {

            addFlower(choice);

        } else if (choice.matches("4")) {
            addFlower(choice);
        } else if (choice.matches("5")) {
            addFlower(choice);
        } else if (choice.matches("6")) {
            deleteFlower();
        } else {
            mainMenu();
        }

    }

    public void displayDeliveryDetails() {

        System.out.format("%-12s%-22s%-18s%-13s", "Date", " Time", "Address", "Corporate");
        System.out.print("\n");
        System.out.format("%-12s%-22s%-18s%-13s ", "----------", "--------------------", "----------------", "------------");
        System.out.print("\n");
        for (int n = 0; n < DeliveryList.size(); n++) {
            String date = DeliveryList.getEntry(n).getDeliveryDate();
            String time = DeliveryList.getEntry(n).getDeliveryTime();

            System.out.format("%-12s%-22s%-18s%-13s ",
                    date, time,
                    DeliveryList.getEntry(n).getAddress(), inputName);
            System.out.print("\n");
        }

    }

    public void displayAnniversaryCatalog() {

        System.out.format("%-11s%-22s%-17s%-13s ", "ID", "Name", "Quantity", "Price");
        System.out.print("\n");
        System.out.format("%-11s%-22s%-17s%-13s ", "---------", "--------------------", "---------------", "------------");
        System.out.print("\n");
        for (int n = 0; n < newMain.flowerList.size(); n++) {
            if (newMain.flowerList.getEntry(n).getType().equalsIgnoreCase("Anniversary")) {
                if (newMain.flowerList.getEntry(n).getQuantity() == 0) {
                    n++;
                }
                System.out.format("%-11s%-22s%-17s%-14s",
                        newMain.flowerList.getEntry(n).getId(), newMain.flowerList.getEntry(n).getName(),
                        newMain.flowerList.getEntry(n).getQuantity(), newMain.flowerList.getEntry(n).getPrice() + "");
                System.out.print("\n");
            }
        }
    }

    public void displayBirthdayCatalog() {
        System.out.format("%-12s%-22s%-18s%-15s ", "ID", " Name", "Quantity", "Price");
        System.out.print("\n");
        System.out.format("%-12s%-22s%-18s%-15s ", "----------", "--------------------", "----------------", "-------------");
        System.out.print("\n");
        for (int n = 0; n < newMain.flowerList.size(); n++) {
            if (newMain.flowerList.getEntry(n).getType().equalsIgnoreCase("Birthday")) {

                System.out.format("%-12s%-22s%-18s%-15s ",
                        newMain.flowerList.getEntry(n).getId(), newMain.flowerList.getEntry(n).getName(),
                        newMain.flowerList.getEntry(n).getQuantity(), newMain.flowerList.getEntry(n).getPrice() + "");
                System.out.print("\n");
            }
        }
    }

    public void displayCondolenceCatalog() {
        System.out.format("%-12s%-22s%-18s%-15s ", "ID", "Name", "Quantity", "Price");
        System.out.print("\n");
        System.out.format("%-12s%-22s%-18s%-15s ", "----------", "--------------------", "----------------", "-------------");
        System.out.print("\n");
        for (int n = 0; n < newMain.flowerList.size(); n++) {
            if (newMain.flowerList.getEntry(n).getType().equalsIgnoreCase("Condolence")) {

                System.out.format("%-12s%-22s%-18s%-15s ",
                        newMain.flowerList.getEntry(n).getId(), newMain.flowerList.getEntry(n).getName(),
                        newMain.flowerList.getEntry(n).getQuantity(), newMain.flowerList.getEntry(n).getPrice() + "");
                System.out.print("\n");
            }
        }
    }

    public void displayRomanceCatalog() {
        System.out.format("%-12s%-22s%-18s%-15s ", "ID", "Name", "Quantity", "Price");
        System.out.print("\n");
        System.out.format("%-12s%-22s%-18s%-15s ", "----------", "--------------------", "----------------", "-------------");
        System.out.print("\n");
        for (int n = 0; n < newMain.flowerList.size(); n++) {
            if (newMain.flowerList.getEntry(n).getType().equalsIgnoreCase("Romance")) {

                System.out.format("%-12s%-22s%-18s%-15s ",
                        newMain.flowerList.getEntry(n).getId(), newMain.flowerList.getEntry(n).getName(),
                        newMain.flowerList.getEntry(n).getQuantity(), newMain.flowerList.getEntry(n).getPrice() + "");
                System.out.print("\n");
            }
        }
    }

    public void displayGraduationCatalog() {
        System.out.format("%-12s%-22s%-18s%-15s ", " ID", "Name", "Quantity", "Price");
        System.out.print("\n");
        System.out.format("%-12s%-22s%-18s%-15s ", "----------", "--------------------", "----------------", "-------------");
        System.out.print("\n");
        for (int n = 0; n < newMain.flowerList.size(); n++) {
            if (newMain.flowerList.getEntry(n).getType().equalsIgnoreCase("Graduation")) {

                System.out.format("%-12s%-22s%-18s%-15s ",
                        newMain.flowerList.getEntry(n).getId(), newMain.flowerList.getEntry(n).getName(),
                        newMain.flowerList.getEntry(n).getQuantity(), newMain.flowerList.getEntry(n).getPrice() + "");
                System.out.print("\n");
            }
        }
    }

    public void deleteFlower() {
        int DeleteEntry = 0;
        double totalPrice = 0;
        String choice = "";

        if (!orderList.isEmpty()) {
            System.out.format("%-20s%-15s%-10s", "Item Name", "Item Quantity", "Item Price");
            System.out.print("\n");
            System.out.format("%-20s%-15s%-10s", "---------", "-------------", "----------");
            System.out.print("\n");

            for (int i = 0; i < orderList.size(); i++) {

                System.out.format("%-20s%-15s%.2f", orderList.getEntry(i).getOrderName(), orderList.getEntry(i).getOrderQuantity(), orderList.getEntry(i).getOrderPrice());
                System.out.print("\n");
                totalPrice += orderList.getEntry(i).getOrderPrice();
            }

            System.out.format("%-20s%-15s%.2f", "Total Price: ", " ", totalPrice);
            System.out.print("\n");

            System.out.println("What Flower Do you Wish To Delete? (Example: 1) :");
            DeleteEntry = Integer.parseInt(in.nextLine());
            orderList.remove(DeleteEntry);
            System.out.print("Delete Successful");
            System.out.println("\n");

            for (int m = 0; m < orderList.size(); m++) {
                totalPrice += orderList.getEntry(m).getOrderPrice();

            }

            System.out.format("%-20s%-15s%-10s", "Item Name", "Item Quantity", "Item Price");
            System.out.print("\n");
            System.out.format("%-20s%-15s%-10s", "---------", "-------------", "----------");
            System.out.print("\n");

            for (int k = 0; k < orderList.size(); k++) {
                System.out.format("%-20s%-15s%.2f", orderList.getEntry(k).getOrderName(), orderList.getEntry(k).getOrderQuantity(), orderList.getEntry(k).getOrderPrice());
                System.out.print("\n");

            }

            System.out.format("%-20s%-15s%.2f", "Total Price: ", " ", totalPrice);
            System.out.print("\n");

            System.out.print("Continue? (Press Yes to continue :");
            choice = in.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                deleteFlower();
            }

        } else {
            System.out.println("You Have No Orders.........");
            mainMenu();
        }

        displayFlower();

    }

    public void addFlower(String input) {
        String choice = "", newItem = "";
        String opt = "";
        double totalPrice = 0, orderPrice = 0;
        int n = 0, q = 0, orderQuantity = 0;

        do {

            if (input.equals("1")) {
                displayBirthdayCatalog();
            } else if (input.equals("2")) {
                displayAnniversaryCatalog();
            } else if (input.equals("3")) {
                displayCondolenceCatalog();
            } else if (input.equals("4")) {
                displayRomanceCatalog();
            } else if (input.equals("5")) {
                displayGraduationCatalog();
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
                    totalPrice += newMain.flowerList.getEntry(n).getPrice() * orderQuantity;
                }

            }

            System.out.format("%-20s%-15s%-10s", "Item Name", "Item Quantity", "Item Price");
            System.out.print("\n");
            System.out.format("%-20s%-15s%-10s", "---------", "-------------", "----------");
            System.out.print("\n");

            for (int i = 0; i < orderList.size(); i++) {

                System.out.format("%-20s%-15s%.2f", orderList.getEntry(i).getOrderName(), orderList.getEntry(i).getOrderQuantity(), orderList.getEntry(i).getOrderPrice());
                System.out.print("\n");

            }
            totalPrice = totalPrice - totalPrice;

            for (int g = 0; g < orderList.size(); g++) {

                totalPrice += orderList.getEntry(g).getOrderPrice();

            }

            System.out.format("%-20s%-15s%.2f", "Total Price: ", " ", totalPrice);
            System.out.print("\n");

            System.out.print("\nDo you wish to continue? (Yes to Continue | Any Characters to exit)");
            System.out.print("\nDecision: ");
            opt = in.nextLine();

        } while (opt.equalsIgnoreCase("yes") && orderQuantity != 0);

        displayFlower();

    }

    public void makePayment() {

        int choice = 0, totalQuantity = 0;
        double total = 0, payment = 0;

        System.out.format("%-20s%-15s%-10s", "Item Name", "Item Quantity", "Item Price");
        System.out.print("\n");
        System.out.format("%-20s%-15s%-10s", "---------", "-------------", "----------");
        System.out.print("\n");

        for (int i = 0; i < orderList.size(); i++) {

            System.out.format("%-20s%-15s%.2f", orderList.getEntry(i).getOrderName(), orderList.getEntry(i).getOrderQuantity(), orderList.getEntry(i).getOrderPrice());
            System.out.print("\n");

        }

        for (int g = 0; g < orderList.size(); g++) {

            total += orderList.getEntry(g).getOrderPrice();

        }

        for (int i = 0; i < orderList.size(); i++) {
            totalQuantity += orderList.getEntry(i).getOrderQuantity();
        }

        if (totalQuantity >= 10) {
            total = total * 0.8;
        }

        System.out.format("%-20s%-15s%.2f", "Total Price: ", " ", total);
        System.out.print("\n");

        if (orderList.isEmpty()) {

            System.out.println("You Have No Orders..............");
            mainMenu();
        }

        for (int l = 0; l < newCC.getAllCorCust().size(); l++) {
            if (newCC.getAllCorCust().getEntry(l).getContractName().equalsIgnoreCase(inputName)) {
                creditLimit = Double.parseDouble(newCC.getAllCorCust().getEntry(l).getCreditLimit());

            }

        }

        System.out.print("Current Credit Limit :" + creditLimit);
        System.out.print("\n");
        System.out.println("Would You Like To Make Payment?(Press 1 to Make Payment, Press other key to cancel)");
        System.out.print("Decision: ");
        choice = Integer.parseInt(in.nextLine());

        if (choice == 1) {
            if (creditLimit >= total) {
                payment = creditLimit - total;
                creditLimit = payment;
                System.out.println("    Payment Successful !    ");

                addDelivery();

            } else if (creditLimit < total) {
                System.out.println("  Sorry! Credit Already Hit Limit!  ");
                mainMenu();
            }

        } else {
            mainMenu();

        }

    }

    public void addDelivery() {
        String Details = "";
        String DeliveryDate = "";
        String DeliveryTime = "";
        int hh = 0;
        int mm = 0;
        String address = " ";
        String deliveryDetails = "";

        System.out.print("What Date Do You Wish To Pick Up Your Order?: ");
        DeliveryDate = in.nextLine();
        System.out.print("What Time Do You Wish To Pick Up Your Order?: ");
        DeliveryTime = in.nextLine();
        System.out.print("Please Enter Your Address:");
        address = in.nextLine();

        try {
            if (timeFormat.parse((DeliveryTime)).before(timeFormat.parse("24:00"))) {
                DeliveryDetails DDetails = new DeliveryDetails(DeliveryTime, DeliveryDate, address);

                DeliveryList.add(DDetails);

                Details = "Your Delivery Time: " + DeliveryTime + " " + "Your Delivery Date: " + DeliveryDate + " " + " Your Address " + address;

                System.out.println(Details);

                for (int k = 0; k < orderList.size(); k++) {
                    MadePayment mp = new MadePayment(orderList.getEntry(k).getOrderId(), orderList.getEntry(k).getOrderName(), orderList.getEntry(k).getOrderQuantity(), orderList.getEntry(k).getOrderPrice(), orderList.getEntry(k).getType());
                    MPList.add(mp);

                }

                orderList.clear();
                mainMenu();

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

        System.out.print("\nPlease Choose The Catalog Report You Wish To Print :");
        System.out.print("\n1. Birthday");
        System.out.print("\n2. Anniversary");
        System.out.print("\n3. Condolence");
        System.out.print("\n4. Romance");
        System.out.print("\n5. Graduation");
        System.out.print("\n6. Back To Menu");
        System.out.print("\nDecision: ");
        choice = in.nextInt();

        if (choice == 1) {
            CatalogAnniversary ca = new CatalogAnniversary();
            ca.main(args, month, year, MPList);

        } else if (choice == 2) {
            CatalogBirthday cb = new CatalogBirthday();
            cb.main(args, month, year, MPList);
        } else if (choice == 3) {
            CatalogCondolence cc = new CatalogCondolence();
            cc.main(args, month, year, MPList);
        } else if (choice == 4) {
            CatalogGraduation cg = new CatalogGraduation();
            cg.main(args, month, year, MPList);
        } else if (choice == 5) {
            CatalogRomance cr = new CatalogRomance();
            cr.main(args, month, year, MPList);
        } else {
            mainMenu();
        }
    }

    public static void main(String[] args) {
        FlowerAssignment assignment = new FlowerAssignment();
        assignment.mainMenu();

    }

}
