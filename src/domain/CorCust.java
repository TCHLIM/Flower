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
public class CorCust extends Customer{
    private String contractName;
    private String creditLimit;

    public CorCust(){

    }
    public CorCust(String custID,String contractName, String custPhone, String custAddress,String creditLimit,String custMode){
        super(custID,custPhone,custAddress,custMode);
        this.contractName = contractName;
        this.creditLimit=creditLimit;
    }
    
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getContractName() {
        return contractName;
    }

    public String getCreditLimit() {
        return creditLimit;
    }
}
