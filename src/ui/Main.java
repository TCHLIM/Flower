
package ui;

import ADT.List;
import ADT.ListInterface;
import domain.Flower;
import UpdateFlower.FlowerMaintenance;
import UpdateFlower.FlowerMaintenanceInterface;
import UpdateFlower.FlowerUI;
import java.util.Scanner;

public class Main {

    private ListInterface<Flower> flowerList;
    private Scanner scanner = new Scanner(System.in);        
    
    public static void main(String[] args) {
        Main newMain = new Main();
        newMain.initComponents();
        newMain.runprogram();
    }
    
    private void initComponents(){
        
    flowerList = new List<>();
    flowerList.add(new Flower("Red flower", "red color", 20, true));
    flowerList.add(new Flower("Blue flower", "Blue color", 20, true));
    flowerList.add(new Flower("Yellow flower", "Yellow color", 20, true));
    flowerList.add(new Flower("Grey flower", "Grey color", 20, true));
    }
    private void runprogram(){
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
                            FlowerMaintenanceInterface FDFun = new FlowerMaintenance();
                            this.flowerList = FDFun.updateQuan(flowerList, flower, quan);
                            System.out.print("########Add successful########");
                            scanner.nextLine();
                            runprogram();
                        }
                    default:
                        runprogram();
                
        }
    
    }
}
