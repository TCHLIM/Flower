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
    private String custIC;
    private String custGender;
}
