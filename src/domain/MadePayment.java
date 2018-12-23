package domain;


public class MadePayment {
    
    private int MPid;
    private String MPorderName;
    private int MPorderQuantity;
    private double MPorderPrice;
    private String MPtype;
    
    public MadePayment(int MPid, String MPorderName, int MPorderQuantity, double MPorderPrice, String MPtype){
        this.MPid = MPid;
        this.MPorderName = MPorderName;
        this.MPorderQuantity = MPorderQuantity;
        this.MPorderPrice = MPorderPrice;
        this.MPtype = MPtype;
        
    }

    @Override
    public String toString() {
        return "MadePayment{" + "MPid=" + MPid + ", MPorderName=" + MPorderName + ", MPorderQuantity=" + MPorderQuantity + ", MPorderPrice=" + MPorderPrice + ", MPtype=" + MPtype + '}';
    }

    public void setMPid(int MPid) {
        this.MPid = MPid;
    }

    public void setMPorderName(String MPorderName) {
        this.MPorderName = MPorderName;
    }

    public void setMPorderQuantity(int MPorderQuantity) {
        this.MPorderQuantity = MPorderQuantity;
    }

    public void setMPorderPrice(double MPorderPrice) {
        this.MPorderPrice = MPorderPrice;
    }

    public void setMPtype(String MPtype) {
        this.MPtype = MPtype;
    }

    public int getMPid() {
        return MPid;
    }

    public String getMPorderName() {
        return MPorderName;
    }

    public int getMPorderQuantity() {
        return MPorderQuantity;
    }

    public double getMPorderPrice() {
        return MPorderPrice;
    }

    public String getMPtype() {
        return MPtype;
    }
    
    
}
