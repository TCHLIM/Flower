package ui;

public interface FlowerInterface {
    public void setFlower(String flowerName);
    public void setPrice(int price);
    public void setAddress(String address);
    public void setTime(String time);
    public String getAddress();
    public String getTime();
    public String getFlower();
    public int getPrice();
    
    public FlowerInterface add(FlowerInterface flower);
    public FlowerInterface subtract(FlowerInterface flower);
    
    
    
}
