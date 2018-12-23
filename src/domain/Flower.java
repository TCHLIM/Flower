
package domain;

public class Flower {
    
    private static int nextId = 100;
    private int id;
    private String name;
    private String des;
    private int quantity;
    private boolean status;
    private String type;
    private double price;
    
    public Flower(String name, String des, int quantity, boolean status, String type, double price) {
        this.id = nextId++;
        this.name = name;
        this.des = des;
        this.quantity = quantity;
        this.status = status;
        this.type = type;
        this.price=price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Flower.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
 
    public String toString() {
        return String.format("%-3d|%-10s|%-50s|%-10d|%-10s|%-3.2f", id, name, des, quantity,type,price);
    }
}

