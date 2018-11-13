package ui;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FlowerCatalog {
    private FlowerInterface order1 = new Flower();
   
        
public FlowerCatalog(){
     
    ArrayList<String> catalog = new ArrayList<String>();
    ArrayList<Integer> price = new ArrayList<Integer>();
    ArrayList<String> orders = new ArrayList<String>();
    ArrayList<String> orderTracker = new ArrayList<String>();
    ArrayList<String> addressList = new ArrayList<String>();
    
    Scanner answer = new Scanner(System.in);
    Scanner answer2 = new Scanner(System.in);
    Scanner answer3 = new Scanner(System.in);
    
    String ans = "";
    String ans2 = "";
    String ans3 = "";
    int number = 0;
    int totalPrice = 0;
    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;
    int counter4 = 0;
    
    catalog.add("Red Flower");
    catalog.add("Blue Flower");
    catalog.add("Green Flower");
    price.add(10);
    price.add(20);
    price.add(30);
    
    System.out.println("Flower Available::");
    
    for(int i=0; i<catalog.size(); i++) {
    System.out.println(  catalog.get(i)+"        "+"RM:"+price.get(i));
    }
    
    
    do{
        
   /*System.out.println("Flower You Ordered: ");
    
    for(int j=0; j<orders.size();j++){
        orders.get(j);
        
        if(orders.get(j).equals("Red Flower")){
            counter1 += 1;
        }else if(orders.get(j).equals("Blue Flower")){
            counter2 += 1;
        }else if(orders.get(j).equals("Green Flower")){
            counter3 += 1;
        }
        
            orderTracker.add(0, counter1);
            orderTracker.add(1, counter2);
            orderTracker.add(2, counter3);
            
        
      for(int p=0; p<orders.size();p++){
          System.out.println(orders.get(p)+"" +orderTracker.remove(p));
      }    
    }*/
    
    System.out.println("\n");
    System.out.println("Total Price: " +totalPrice);
    
    
    System.out.println("\n");
    System.out.println("What Flower Do You Wish To Buy? (Type exit to Exit)");
        ans = answer.nextLine();
    orderTracker.add(ans);
    
    System.out.println("How Many Flower Do You Wish To Order?:");
    ans2 = answer2.nextLine();
    
    for(int l=0; l<orderTracker.size(); l++){
        
        orderTracker.get(l);
        if(orderTracker.get(l).equals("Red Flower")){
            number = Integer.parseInt(ans2);
            totalPrice += 10 * number;
            orders.add(ans);
            orderTracker.remove(l);
        }else if(orderTracker.get(l).equals("Blue Flower")){
            number = Integer.parseInt(ans2);
            totalPrice += 20 * number;
            orders.add(ans);
            orderTracker.remove(l);
        }else if(orderTracker.get(l).equals("Green Flower")){
            number = Integer.parseInt(ans2);
            totalPrice += 30 * number;
            orders.add(ans);
            orderTracker.remove(l);
          }
     }
    
    System.out.println("Where Do You Wish Your Order To Be Deliver?: ");
     ans3 = answer3.nextLine();
     order1.setAddress(ans3);
     String address = order1.getAddress();
     
     for(int m=0; m<addressList.size(); m++){
         
        if(addressList.get(m).equalsIgnoreCase(address)){
            
            System.out.print("One Address Can Only Be Apply For One Order!");
         
     }else{
             addressList.add(address);
        }
     }
     
    }while(!ans.equalsIgnoreCase("exit") || !ans2.equalsIgnoreCase("exit"));
    
 
    
    for(int k=0; k<orders.size();k++){ 
    order1.setFlower(orders.remove(k));
    order1.setPrice(totalPrice);
    
    
    
    }
    
    
    
            
            
}

    
public static void main(String args[]) {
        
    FlowerCatalog flowerCatalog = new FlowerCatalog();


    }

}