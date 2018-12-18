package domain;


public class PickUpDetails {
    public String pickUpDate;
    public String pickUpTime;
    public String address;
    public String flowerName;
    public int flowerQuantity;
    
    public PickUpDetails(String pickUpDate, String pickUpTime, String address){
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.address = address;
        
    }
    
    public PickUpDetails(String flowerName, int flowerQuantity){
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

    public int getFlowerQuantity() {
        return flowerQuantity;
    }

    @Override
    public String toString() {
        return "DeliveryDetails{" + "pickUpDate=" + pickUpDate + ", pickUpTime=" + pickUpTime + ", address=" + address + ", flowerName=" + flowerName + ", flowerQuantity=" + flowerQuantity + '}';
    }

   

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public String getAddress() {
        return address;
    }
    
    
}
