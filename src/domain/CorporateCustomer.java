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
    private String contractName;
    private double creditLimit;

    public CorporateCustomer(){
        
    }
    public CorporateCustomer(String custID,String custPhone, String custAddress,String custMode,String contractName, double creditLimit){
        super();
        this.contractName = contractName;
        this.creditLimit=creditLimit;
    }
    
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getContractName() {
        return contractName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
