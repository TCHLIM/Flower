package domain;

public class VOrder {
    private String orderId;
    private String orderName;
    private int orderQuantity;
    private double orderPrice;
    
    public VOrder(){
        
    }
    public VOrder(String orderId, String orderName, int orderQuantity, double orderPrice){
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        
    }
    
    public VOrder(String orderName, int orderQuantity, double orderPrice){
        this.orderName = orderName;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
    
    @Override
    public String toString(){
        return String.format(orderId+ "             " + orderName +"            "+orderQuantity+"           "+orderPrice);
    }
    
    
    
}

