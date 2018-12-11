
package UpdateFlower;

import ADT.List;
import ADT.ListInterface;
import domain.Flower;
import java.util.Scanner;


public class FlowerUI {
    Scanner scanner = new Scanner(System.in);
    
    public FlowerUI() {
    }
    
    public int displayFlowerMenu() {
        
        System.out.println("\n===== Flower Maintenance =====");
        System.out.println("1. View All Flower \n"
                + "2. Add New Flower \n"
                + "3. Edit Flower  \n"
                + "4. Remove Flower \n"
                + "5. Add Flower Quantity\n"
                + "0. Back");
        int selection;
        do {
            System.out.print("Please enter your selection: ");
            try {
                selection = scanner.nextInt();
            } catch (Exception ex) {
                System.out.print("*****selection must be integer.\nPlease enter your selection:");
                scanner.nextLine();
                selection = 0;
            }
            if (selection < 0 || selection > 5) {
                System.out.print("*****selection within 0 to 5.\nPlease enter your selection:");
            }
        } while (selection < 0 || selection > 5);

        return selection;
    }
    public int displayViewAllFlower(ListInterface<Flower> flowerList) {
       
        System.out.println("\n===== All FlowerPackage=====");
        System.out.printf("|%3s|%3s|%20s|%50s|%13s|\n", "NO", "ID", "Name", "DES", "Quantity");
        int count=0;
        for (int i = 0; i < flowerList.getNumberOfEntries() + 1; i++) {
            if (flowerList.getEntry(i).isStatus()) {
                count++;
                System.out.printf("|%3d|%3d|%20s|%50s|%13d|\n", count, flowerList.getEntry(i).getId(),
                        flowerList.getEntry(i).getName(), flowerList.getEntry(i).getDes(), flowerList.getEntry(i).getQuantity());
            }
        }
        int selection;
        do {
            System.out.print("Please 0 to continue: ");
            try {
                selection = scanner.nextInt();
            } catch (Exception ex) {
                System.out.print("*****selection must be integer.\nPlease enter your selection:");
                scanner.nextLine();
                selection = 0;
            }
            if (selection < 0 || selection > 0) {
                System.out.print("*****selection within 0 to 0.\nPlease enter your selection:");
            }
        } while (selection < 0 || selection > 0);

        return selection;
    }
    public int displayEditFlower(ListInterface<Flower> flowerList) {
       
        System.out.println("\n===== View All FlowerPackage (Edit)=====");
        System.out.printf("|%3s|%3s|%20s|%50s|%13s|\n", "NO", "ID", "Name", "DES", "Quantity");
        ListInterface<Flower> tmp = new List<>();
        for (int i = 0; i < flowerList.getNumberOfEntries() + 1; i++) {
            if (flowerList.getEntry(i).isStatus()) {
                tmp.add(flowerList.getEntry(i));
            }
        }
        for (int i = 0; i < tmp.getNumberOfEntries() + 1; i++) {
            System.out.printf("|%3d|%3d|%20s|%50s|%13d|\n", i + 1, tmp.getEntry(i).getId(),
                    tmp.getEntry(i).getName(), tmp.getEntry(i).getDes(), tmp.getEntry(i).getQuantity());
        }

        System.out.println("\nTotol FlowerPackage = " + (tmp.getNumberOfEntries() + 1));
        int selection;
        do {
            System.out.print("Please enter your selection(press 0 for back):");
            try {
                selection = scanner.nextInt();
            } catch (Exception ex) {
                System.out.print("*****selection must be integer.\nPlease enter your selection(press 0 for back):");
                scanner.nextLine();
                selection = 0;
            }
            if (selection < 0 || selection > tmp.getNumberOfEntries() + 1) {
                System.out.print("*****selection within 0 to " + tmp.getNumberOfEntries() + 1 + ".\nPlease enter your selection(press 0 for back):");
            }
        } while (selection < 0 || selection > tmp.getNumberOfEntries() + 1);

        return selection;
    }

    public ListInterface<Flower> displayEditFlowerMenu(ListInterface<Flower> flowerList, int selected) {
     
        ListInterface<Flower> tmp = new List<>();
        for (int i = 0; i < flowerList.getNumberOfEntries() + 1; i++) {
            if (flowerList.getEntry(i).isStatus()) {
                tmp.add(flowerList.getEntry(i));
            }
        }
        Flower flower = tmp.getEntry(selected - 1);
        System.out.println("\n===== Edit Flower Detail =====");
        System.out.printf("|%3s|%20s|%50s|%13s|\n", "ID", "Name", "DES", "Quantity");
        System.out.printf("|%3d|%20s|%50s|%13d|\n", flower.getId(),
                flower.getName(), flower.getDes(), flower.getQuantity());
        System.out.println("1. Name\n"
                + "2. DES\n"
                + "3. Quantity\n");
        int selection;
        do {
            System.out.print("Please enter your selection:");
            try {
                selection = scanner.nextInt();
            } catch (Exception ex) {
                System.out.print("*****selection must be integer.\nPlease enter your selection:");
                scanner.nextLine();
                selection = 0;
            }
            if (selection < 0 || selection > 3) {
                System.out.print("*****selection within 0 to 3.\nPlease enter your selection:");
            }
        } while (selection < 0 || selection > 3);

        switch (selection) {
            case 1:
                String name;
                System.out.print("Name: ");
                name = scanner.nextLine();
                while (name.trim().length() == 0) {   //if didnot type any things 
                    System.out.print("*****Name is required.\nName: ");
                    name = scanner.nextLine();
                }
                flower.setName(name);
                break;
            case 2:
                String des;
                System.out.print("DES: ");
                des = scanner.nextLine();
                while (des.trim().length() == 0) {   //if didnot type any things 
                    System.out.print("*****DES is required.\nDES: ");
                    des = scanner.nextLine();
                }
                flower.setDes(des);
                break;
            case 3:
                int quan;
                do {
                    System.out.print("Quantity:");
                    try {
                        quan = scanner.nextInt();
                    } catch (Exception ex) {
                        System.out.println("****Quantity must be Integer.");
                        scanner.nextLine();
                        quan = 0;
                    }
                    if (quan <= 0) {
                        System.out.println("****Quantity must gatther then 0.");
                    }
                } while (quan <= -1);
                flower.setQuantity(quan);
                break;
        }

        FlowerMaintenanceInterface STFun = new FlowerMaintenance();
        return STFun.update(flowerList, flower);
    }

    public int displayDeleteFlower(ListInterface<Flower> flowerList) {
       
        System.out.println("\n===== View All Flower (Delete)=====");
        System.out.printf("|%3s|%3s|%20s|%50s|%13s|\n", "NO", "ID", "Name", "DES", "Quantity");
        ListInterface<Flower> tmp = new List<>();
        for (int i = 0; i < flowerList.getNumberOfEntries() + 1; i++) {
            if (flowerList.getEntry(i).isStatus()) {
                tmp.add(flowerList.getEntry(i));
            }
        }
        for (int i = 0; i < tmp.getNumberOfEntries() + 1; i++) {
            System.out.printf("|%3d|%3d|%20s|%50s|%13d|\n", i + 1, tmp.getEntry(i).getId(),
                    tmp.getEntry(i).getName(), tmp.getEntry(i).getDes(), tmp.getEntry(i).getQuantity());

        }
        System.out.println("\nTotol FoodPackage = " + (tmp.getNumberOfEntries() + 1));
        int selection;
        do {
            System.out.print("Please enter your selection(press 0 for back):");
            try {
                selection = scanner.nextInt();
            } catch (Exception ex) {
                System.out.print("*****selection must be integer.\nPlease enter your selection(press 0 for back):");
                scanner.nextLine();
                selection = 0;
            }
            if (selection < 0 || selection > tmp.getNumberOfEntries() + 1) {
                System.out.print("*****selection within 0 to " + (tmp.getNumberOfEntries() + 1) + ".\nPlease enter your selection(press 0 for back):");
            }
        } while (selection < 0 || selection > tmp.getNumberOfEntries() + 1);

        return selection;
    }

    public Flower registerFlower() {
     
        String name;
        String des;
        System.out.println("\n===== Flower=====");
        System.out.println("Please fill in all the information.");
        System.out.print("Name: ");
        name = scanner.nextLine();
        while (name.trim().length() == 0) {   //if didnot type any things 
            System.out.print("*****Name is required.\nName: ");
            name = scanner.nextLine();
        }
        System.out.print("DES: ");
        des = scanner.nextLine();
        while (des.trim().length() == 0) {   //if didnot type any things 
            System.out.print("*****DES is required.\nDES: ");
            des = scanner.nextLine();
        }
        Flower flower = new Flower(name, des, 0, true);
        return flower;
    }

    public int addFlower(ListInterface<Flower> flowerList) {
       
        System.out.println("\n===== All FlowerPackage=====");
        System.out.printf("|%3s|%3s|%20s|%50s|%13s|\n", "NO", "ID", "Name", "DES", "Quantity");
        int count =0;
        for (int i = 0; i < flowerList.getNumberOfEntries() + 1; i++) {
            if (flowerList.getEntry(i).isStatus()) {
                count++;
                System.out.printf("|%3d|%3d|%20s|%50s|%13d|\n", count, flowerList.getEntry(i).getId(),
                        flowerList.getEntry(i).getName(), flowerList.getEntry(i).getDes(), flowerList.getEntry(i).getQuantity());
            }
        }
        System.out.println("0.  Back");
        int selection;
        do {
            System.out.print("Please choose one : ");
            try {
                selection = scanner.nextInt();
            } catch (Exception ex) {
                System.out.print("*****selection must be integer.\nPlease choose one:");
                scanner.nextLine();
                selection = 0;
            }
            if (selection < 0 || selection > count) {
                System.out.print("*****selection within 0 to " + count + ".\n");
            }
        } while (selection < 0 || selection >count);

        return selection;
    }

    public Flower getFlower(ListInterface<Flower> flowerList,int seletedindex) {
        ListInterface<Flower> tmp = new List<>();
        for (int i = 0; i < flowerList.getNumberOfEntries() + 1; i++) {
            if (flowerList.getEntry(i).isStatus()) {
                tmp.add(flowerList.getEntry(i));
            }
        }
        return tmp.getEntry(seletedindex-1);
    }

    public int getAddFlowerQuan() {
        int quan;
        do {
            System.out.print("Please enter quantity: ");
            try {
                quan = scanner.nextInt();
            } catch (Exception ex) {
                System.out.print("*****Quantity must be integer.\nPlease enter quantity:");
                scanner.nextLine();
                quan = 0;
            }
            if (quan <= 1) {
                System.out.print("*****Quantity must gatther then 0\nPlease enter quantity:");
            }
        } while (quan <= 1);
        return quan;
    }
    
}

