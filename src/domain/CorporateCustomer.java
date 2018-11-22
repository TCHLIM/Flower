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
public class CorporateCustomer extends Customer{
    private String ContractName;

    public void setContractName(String ContractName) {
        this.ContractName = ContractName;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getContractName() {
        return ContractName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
    private double creditLimit;
}
