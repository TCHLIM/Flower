package domain;

public class Order {

    private int orderId;
    private String orderName;
    private int orderQuantity;
    private double orderPrice;
    private String type;

    public Order(int orderId, String orderName, int orderQuantity, double orderPrice, String type) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.type = type;

    }

    public Order(String orderName, int orderQuantity, double orderPrice) {
        this.orderName = orderName;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
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

    public void setOrderId(int orderId) {
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
    public String toString() {
        return String.format(orderId + "             " + orderName + "            " + orderQuantity + "           " + orderPrice + "          " + type);
    }

}
