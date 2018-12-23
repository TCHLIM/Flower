
package domain;
import domain.Flower;

public class Promotion {
    private static int nextId = 100;
    private int id;
    private String name;
    private String des;
    private int discount;
    private boolean status;
 
    public Promotion(String name, String des, int discount, boolean status) {
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

 
    public String toString() {
        return String.format("%-13d|%-30s|%-50s|%-10d", id, name, des, discount);
    }
}
