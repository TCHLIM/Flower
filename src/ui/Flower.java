package flower;


public class Flower implements FlowerInterface{
    private String flower;
    private int price;
    private String address;
    private String Time;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return Time;
    }
    
    public void setFlowerName(String flowerName){
        
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlower() {
        return flower;
    }

    public int getPrice() {
        return price;
    }
    
    public FlowerInterface add(FlowerInterface flower){
        Flower resultFlower = new Flower();
        
        
        return resultFlower;
    }
    
    public FlowerInterface subtract(FlowerInterface flower){
        Flower resultFlower = new Flower();
        
        return resultFlower;
    }
    public String toString(){
        
        return flower+ "  " +price;
        
    }
    
    
}
