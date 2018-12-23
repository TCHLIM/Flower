
package ui;
import ADT.ListInterface;
import domain.Flower;
import java.util.Scanner;


public class UIDisplay {

    Scanner scanner = new Scanner(System.in);

    public UIDisplay() {
    }

    public int displayMainMenu() {
     
        System.out.println("Hello. Welcome for using our system.");
        System.out.println("===== Main Menu =====");
        System.out.println("1. Update flower \n"
                +"2. Promotion of the Month \n"
                + "0. Exit");
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
            if (selection < 0 || selection > 2) {
                System.out.print("*****selection within 0 to 8.\nPlease enter your selection:");
            }
        } while (selection < 0 || selection > 2);
        return selection;
    }

}
