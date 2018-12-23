
package domain;
import domain.Flower;

public class Promotion {
    private static int nextId = 100;
    private int id;
    private String name;
    private String des;
    private double discount;
    private boolean status;
 
    public Promotion(String name, String des, double discount, boolean status) {
        this.id = nextId++;
        this.name = name;
        this.des = des;
        this.discount = discount;
        this.status = status;
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
        Promotion.nextId = nextId;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

 
    public String toString() {
        return String.format("%-13d|%-30s|%-50s|%-3.2f", id, name, des, discount);
    }
}
