
package ui;

import ADT.List;
import ADT.ListInterface;
import domain.Flower;
import UpdateFlower.FlowerMaintenance;
import UpdateFlower.FlowerMaintenanceInterface;
import UpdateFlower.FlowerUI;
import domain.Promotion;
import Promotion.PromotionMaintenance;
import Promotion.PromotionMaintenanceInterface;
import Promotion.PromotionUI;
import java.util.Scanner;

public class Main {

    private ListInterface<Flower> flowerList;
    private ListInterface<Promotion> promotionList;
    private Scanner scanner = new Scanner(System.in);        
    
    public static void main(String[] args) {
        Main newMain = new Main();
        newMain.initComponents();
        newMain.runprogram();
    }
    
    private void initComponents(){
        
    flowerList = new List<>();
    flowerList.add(new Flower("Red flower", "red color", 20, true,"flower",10));
    flowerList.add(new Flower("Blue bouquets", "Blue color", 20, true, "bouquets",10));
    flowerList.add(new Flower("Yellow floral", "Yellow color", 20, true,"floral",10));
    flowerList.add(new Flower("Grey flower", "Grey color", 20, true,"flower",10));
    flowerList.add(new Flower("Black flower", "Grey color", 0, true,"flower",10));
    
    promotionList = new List<>();
    promotionList.add(new Promotion("Buy 3 ", "Any flower buy equal 3", 20, true));
    promotionList.add(new Promotion("Buy 5 ", "Any flower buy equal 5", 35, true));
    promotionList.add(new Promotion("Buy 10 ", "Any flower buy equal 10", 85, true));
    
    }
    
    private void runprogram(){
       UIDisplay show = new UIDisplay();
        switch (show.displayMainMenu()) {
            case 1:  /////////////register
                FlowerUI showflower = new FlowerUI();
                switch (showflower.displayFlowerMenu()) {
                    case 1:
                        showflower.displayViewAllFlower(flowerList);
                        runprogram();
                    case 2:
                        if (flowerList.add(showflower.registerFlower())) {
                            System.out.print("########Add successful########");
                            scanner.nextLine();
                        }
                        runprogram();
                    case 3:
                        int selectionEdit = showflower.displayEditFlower(flowerList);
                        if (selectionEdit == 0) {
                            runprogram();
                        } else {
                            this.flowerList = showflower.displayEditFlowerMenu(flowerList, selectionEdit);
                            System.out.print("########Edit successful########");
                            scanner.nextLine();
                            runprogram();
                        }
                    case 4:
                        int selectiondelete = showflower.displayDeleteFlower(flowerList);
                        if (selectiondelete == 0) {
                            runprogram();
                        } else {
                            FlowerMaintenanceInterface FDFun = new FlowerMaintenance();
                            this.flowerList = FDFun.delete(flowerList, selectiondelete);
                            System.out.print("########Delete successful########");
                            scanner.nextLine();
                            runprogram();
                        }
                    case 5:
                        int selected = showflower.addFlower(flowerList);
                        if (selected == 0) {
                            runprogram();
                        } else {
                            Flower flower = showflower.getFlower(flowerList, selected);
                            int quan = showflower.getAddFlowerQuan();
                            FlowerMaintenanceInterface FMFun = new FlowerMaintenance();
                            this.flowerList = FMFun.updateQuan(flowerList, flower, quan);
                            System.out.print("########Add successful########");
                            scanner.nextLine();
                            runprogram();
                        }
                    case 6:
                        showflower.displayOutOfStock(flowerList);
                        runprogram();
                   default:
                        runprogram();
                }
            case 2:////////food maintenance 
                PromotionUI showpromotion = new PromotionUI();
                switch (showpromotion.displayPromotionMenu()) {
                    case 1:
                        showpromotion.displayViewAllPromotion(promotionList);
                        runprogram();
                    case 2:
                        if (promotionList.add(showpromotion.registerPromotion())) {
                            System.out.print("########Add successful########");
                            scanner.nextLine();
                        }
                        runprogram();
                    case 3:
                        int selectionEdit = showpromotion.displayEditPromotion(promotionList);
                        if (selectionEdit == 0) {
                            runprogram();
                        } else {
                            this.promotionList = showpromotion.displayEditPromotionMenu(promotionList, selectionEdit);
                            System.out.print("########Edit successful########");
                            scanner.nextLine();
                            runprogram();
                        }
                    case 4:
                        int selectiondelete = showpromotion.displayDeletePromotion(promotionList);
                        if (selectiondelete == 0) {
                            runprogram();
                        } else {
                            PromotionMaintenanceInterface PMFun = new PromotionMaintenance();
                            this.promotionList = PMFun.delete(promotionList, selectiondelete);
                            System.out.print("########Delete successful########");
                            scanner.nextLine();
                            runprogram();
                        }
                    case 5:
                        int selected = showpromotion.addPromotion(promotionList);
                        if (selected == 0) {
                            runprogram();
                        } else {
                            Promotion promotion = showpromotion.getPromotion(promotionList, selected);
                            int disc = showpromotion.getAddPromotionPrice();
                            PromotionMaintenanceInterface PMFun = new PromotionMaintenance();
                            this.promotionList = PMFun.updateQuan(promotionList, promotion, disc);
                            System.out.print("########Add successful########");
                            scanner.nextLine();
                            runprogram();
                        }
                   
                    default:
                        runprogram();
                }
                
        }
        
    
    }
}
