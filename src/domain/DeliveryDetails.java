package domain;


public class DeliveryDetails {
    public String DeliveryDate;
    public String DeliveryTime;
    public String address;
    public String flowerName;
    public int flowerQuantity;
    
    public DeliveryDetails(String DeliveryDate, String DeliveryTime, String address){
        this.DeliveryDate = DeliveryDate;
        this.DeliveryTime = DeliveryTime;
        this.address = address;
        
    }
    
    public DeliveryDetails(String flowerName, int flowerQuantity){
        this.flowerName = flowerName;
        this.flowerQuantity = flowerQuantity;
        
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setFlowerQuantity(int flowerQuantity) {
        this.flowerQuantity = flowerQuantity;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setDeliveryDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    public void setDeliveryTime(String DeliveryTime) {
        this.DeliveryTime = DeliveryTime;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public String getDeliveryTime() {
        return DeliveryTime;
    }

    public int getFlowerQuantity() {
        return flowerQuantity;
    }

    @Override
    public String toString() {
        return "DeliveryDetails{" + "DeliveryDate=" + DeliveryDate + ", DeliveryTime=" + DeliveryTime + ", address=" + address + ", flowerName=" + flowerName + ", flowerQuantity=" + flowerQuantity + '}';
    }

   

    

    public void setAddress(String address) {
        this.address = address;
    }

    

    public String getAddress() {
        return address;
    }
    
    
}
