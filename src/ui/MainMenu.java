package ui;



import java.util.Scanner;

public class MainMenu {
    private static Scanner in = new Scanner(System.in);
    int choice = 0;
    
    public void MainMenu(){
        
        System.out.println("1.Update Flower");
        System.out.println("2.Purchase Flower");
        choice =in.nextInt();
        
        if(choice == 1){
            
        Main newMain = new Main();
        newMain.initComponents(5);
        newMain.runprogram();
        
        
        }else if(choice ==2){
         FlowerAssignment f = new FlowerAssignment();
         f.mainMenu();
            
        }
        
    }
    
    public static void main(String[] args){
                MainMenu main = new MainMenu();
                main.MainMenu();
                 
        
    }
    
}
