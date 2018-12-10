/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Promotion;

import ADT.List;
import ADT.ListInterface;
import domain.Flower;
import domain.Promotion;
import java.util.Scanner;



public class PromotionUI {
    
    Scanner scanner = new Scanner(System.in);

public PromotionUI(){

}

public int displayPromotionMenu(){
    
    System.out.println("\n===== Flower Maintenance =====");
    System.out.println("1. View All Promotion \n"
                + "2. Add New Promotion \n"
                + "3. Edit Promotion  \n"
                + "4. Remove Promotion \n"
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
            if (selection < 0 || selection > 4) {
                System.out.print("*****selection within 0 to 5.\nPlease enter your selection:");
            }
        } while (selection < 0 || selection > 4);

        return selection;
    }
    public int displayViewAllPromotion(ListInterface<Promotion> promotionList) {
       
        System.out.println("\n===== All FlowerPackage=====");
        System.out.printf("|%3s|%3s|%20s|%50s|%%-10d|\n", "NO", "ID", "Name", "DES", "Price");
        int count=0;
        for (int i = 0; i < promotionList.getNumberOfEntries() + 1; i++) {
            if (promotionList.getEntry(i).isStatus()) {
                count++;
                System.out.printf("|%3d|%3d|%20s|%50s|%13d|\n", count, promotionList.getEntry(i).getId(),
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
    
}