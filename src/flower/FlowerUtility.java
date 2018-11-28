package flower;


import java.util.Scanner;

public class FlowerUtility {

    private static Scanner myScanner = new Scanner(System.in);

    public static ArrayList<Flower> generateFlowerList(){
        ArrayList<Flower> flower = new ArrayList<>();
        
        
        
        
    }
    
    
    
    public static int menu() {

        int choice = 0;

        do {
            System.out.println("Welcome To FioreFlowerShop");
            System.out.println("1. Order Flower");
            System.out.println("2.View Sales Order");
            System.out.println("3.Back");

            String option = myScanner.nextLine();
            choice = Integer.parseInt(option);
            if (choice > 3) {

                System.out.println("Invalid Option, Please Try Again");
                
            }

        } while (choice != 3);

        return choice;
    }

    public static void orderFlower(ArrayList<Flower> flower){
        int choice = 0;
        
        
        
        
    }

    public static void main(String[] args) {

    }

}
