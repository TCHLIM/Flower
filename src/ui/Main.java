
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
                   default:
                        runprogram();
                }
                
        }
    
    }
}
