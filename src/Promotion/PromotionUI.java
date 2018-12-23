/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promotion;

import ADT.List;
import ADT.ListInterface;

import domain.Promotion;
import java.util.Scanner;



public class PromotionUI {
    
    Scanner scanner = new Scanner(System.in);

public PromotionUI(){

}

    public int displayPromotionMenu(){
    
    System.out.println("\n===== Promotion Maintenance =====");
    System.out.println("1. View All Promotion \n"
                + "2. Add New Promotion \n"
                + "3. Edit Promotion  \n"
                + "4. Remove Promotion \n"
                + "5. Add Promotion Price\n"
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
                System.out.print("*****selection within 0 to 4.\nPlease enter your selection:");
            }
        } while (selection < 0 || selection > 5);

        return selection;
    }
    public int displayViewAllPromotion(ListInterface<Promotion> promotionList) {
       
        System.out.println("\n===== All Promotion Package=====");
        System.out.printf("|%3s|%-13s|%-30s|%-50s|%-10s|\n", "NO", "ID", "Name", "DES", "Discount Price");
        int count=0;
        for (int i = 0; i < promotionList.getNumberOfEntries() + 1; i++) {
            if (promotionList.getEntry(i).isStatus()) {
                count++;
                System.out.printf("|%3d|%-13d|%-30s|%-50s|%-3.2f|\n", count, promotionList.getEntry(i).getId(),
                        promotionList.getEntry(i).getName(), promotionList.getEntry(i).getDes(), promotionList.getEntry(i).getDiscount());
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
    public int displayEditPromotion(ListInterface<Promotion> promotionList) {
       
        System.out.println("\n===== View All Promotion Package (Edit)=====");
        System.out.printf("|%3s|%-13s|%-30s|%-50s|%-10s|\n", "NO", "ID", "Name", "DES", "Discount Price");
        ListInterface<Promotion> tmp = new List<>();
        for (int i = 0; i < promotionList.getNumberOfEntries() + 1; i++) {
            if (promotionList.getEntry(i).isStatus()) {
                tmp.add(promotionList.getEntry(i));
            }
        }
        for (int i = 0; i < tmp.getNumberOfEntries() + 1; i++) {
            System.out.printf("|%3s|%-13s|%-30s|%-50s|%-10.2f|\n", i + 1, tmp.getEntry(i).getId(),
                    tmp.getEntry(i).getName(), tmp.getEntry(i).getDes(), tmp.getEntry(i).getDiscount());
        }

        System.out.println("\nTotol PromotionPackage = " + (tmp.getNumberOfEntries() + 1));
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

    public ListInterface<Promotion> displayEditPromotionMenu(ListInterface<Promotion> promotionList, int selected) {
     
        ListInterface<Promotion> tmp = new List<>();
        for (int i = 0; i < promotionList.getNumberOfEntries() + 1; i++) {
            if (promotionList.getEntry(i).isStatus()) {
                tmp.add(promotionList.getEntry(i));
            }
        }
        Promotion promotion = tmp.getEntry(selected - 1);
        System.out.println("\n===== Edit Promotion Detail =====");
        System.out.printf("|%-13s|%-30s|%-50s|%-10s|\n", "ID", "Name", "DES", "Discount Price");
        System.out.printf("|%-13s|%-30s|%-50s|%-10.2f|\n", promotion.getId(),
                promotion.getName(), promotion.getDes(), promotion.getDiscount());
        System.out.println("1. Name\n"
                + "2. DES\n"
                + "3. Discount Price\n"
                + "0. Back \n");
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
                promotion.setName(name);
                break;
            case 2:
                String des;
                System.out.print("DES: ");
                des = scanner.nextLine();
                while (des.trim().length() == 0) {   //if didnot type any things 
                    System.out.print("*****DES is required.\nDES: ");
                    des = scanner.nextLine();
                }
                promotion.setDes(des);
                break;
            case 3:
                int disc;
                do {
                    System.out.print("Discount Price:");
                    try {
                        disc = scanner.nextInt();
                    } catch (Exception ex) {
                        System.out.println("****Price must be Integer.");
                        scanner.nextLine();
                        disc = 0;
                    }
                    if (disc <= 0) {
                        System.out.println("****Price must gatther then 0.");
                    }
                } while (disc <= -1);
                promotion.setDiscount(disc);
                break;
        }

        PromotionMaintenanceInterface PMFun = new PromotionMaintenance();
        return PMFun.update(promotionList, promotion);
    }

    public int displayDeletePromotion(ListInterface<Promotion> promotionList) {
       
        System.out.println("\n===== View All Promotion (Delete)=====");
        System.out.printf("|%3s|%-13s|%-30s|%-50s|%-10s|\n", "NO", "ID", "Name", "DES", "Discount Price");
        ListInterface<Promotion> tmp = new List<>();
        for (int i = 0; i < promotionList.getNumberOfEntries() + 1; i++) {
            if (promotionList.getEntry(i).isStatus()) {
                tmp.add(promotionList.getEntry(i));
            }
        }
        for (int i = 0; i < tmp.getNumberOfEntries() + 1; i++) {
            System.out.printf("|%3s|%-13s|%-30s|%-50s|%-10.2f|\n", i + 1, tmp.getEntry(i).getId(),
                    tmp.getEntry(i).getName(), tmp.getEntry(i).getDes(), tmp.getEntry(i).getDiscount());

        }
        System.out.println("\nTotol PromotionPackage = " + (tmp.getNumberOfEntries() + 1));
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

    public Promotion registerPromotion() {
     
        String name;
        String des;
        System.out.println("\n===== Promotion=====");
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
        
        Promotion promotion = new Promotion(name, des, 0, true);
        return promotion;
    }
    public int addPromotion(ListInterface<Promotion> promotionList) {
       
        System.out.println("\n===== All Promotion Package=====");
        System.out.printf("|%3s|%-13s|%-30s|%-50s|%-10s|\n", "NO", "ID", "Name", "DES", "Discount Price");
        int count =0;
        for (int i = 0; i < promotionList.getNumberOfEntries() + 1; i++) {
            if (promotionList.getEntry(i).isStatus()) {
                count++;
                System.out.printf("|%3s|%-13s|%-30s|%-50s|%-3.2f|\n", count, promotionList.getEntry(i).getId(),
                        promotionList.getEntry(i).getName(), promotionList.getEntry(i).getDes(), promotionList.getEntry(i).getDiscount());
            }
        }
        
        int selection;
        do {
            System.out.print("Please choose one : ");
            try {
                selection = (int) scanner.nextDouble();
            } catch (Exception ex) {
                System.out.print("*****selection must be double.\nPlease choose one:");
                scanner.nextLine();
                selection = 0;
            }
            if (selection < 0 || selection > count) {
                System.out.print("*****selection within 0 to " + count + ".\n");
            }
        } while (selection < 0 || selection >count);

        return selection;
    }

    public Promotion getPromotion(ListInterface<Promotion> promotionList,int seletedindex) {
        ListInterface<Promotion> tmp = new List<>();
        for (int i = 0; i < promotionList.getNumberOfEntries() + 1; i++) {
            if (promotionList.getEntry(i).isStatus()) {
                tmp.add(promotionList.getEntry(i));
            }
        }
        return tmp.getEntry(seletedindex-1);
    }
    public int getAddPromotionPrice() {
        int disc;
        do {
            System.out.print("Please enter price: ");
            try {
                disc = (int)scanner.nextDouble();
            } catch (Exception ex) {
                System.out.print("*****Price must be double.\nPlease enter price:");
                scanner.nextLine();
                disc = 0;
            }
            if (disc <= 1) {
                System.out.print("*****Price must gatther then 0\nPlease enter price:");
            }
        } while (disc <= 1);
        return disc;
    }
    
}
    
