/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author User
 */
public class Consumer extends Customer {
    private String custName;
    private String custIC;
    private String custGender;
    
    public Consumer(){
        
    }
    public Consumer(String custID,String custName, String custIC, String custGender, String custPhone, String custAddress,String custMode){
        super();
        this.custName=custName;
        this.custIC=custIC;
        this.custGender=custGender;
        
    }
    
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustIC(String custIC) {
        this.custIC = custIC;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustIC() {
        return custIC;
    }

    public String getCustGender() {
        return custGender;
    }
    
}
