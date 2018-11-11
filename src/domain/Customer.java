/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jiach
 */
public class Customer {
    private String custID;
    private String custName;
    private String custIC;
    private String custDOB;
    private String custPhone;
    private String custGender;
    private String custAddress;
    private String custType;
    private String custStatus;
    private String custCreditLimit;
    
    public Customer(String custID,String custName,String custIC,String custDOB,String custPhone,String custGender,String custAddress,String custType,String custStatus,String custCreditLimit){
        this.custID=custID;
        this.custName= custName;
        this.custIC=custIC;
        this.custDOB=custDOB;
        this.custPhone=custPhone;
        this.custGender=custGender;
        this.custAddress=custAddress;
        this.custType=custType;
        this.custStatus=custStatus;
        this.custCreditLimit=custCreditLimit;
    }
    public Customer(){
        
    }

    public String getCustID() {
        return custID;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustIC() {
        return custIC;
    }

    public String getCustDOB() {
        return custDOB;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public String getCustGender() {
        return custGender;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public String getCustType() {
        return custType;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public String getCustCreditLimit() {
        return custCreditLimit;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustIC(String custIC) {
        this.custIC = custIC;
    }

    public void setCustDOB(String custDOB) {
        this.custDOB = custDOB;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    public void setCustCreditLimit(String custCreditLimit) {
        this.custCreditLimit = custCreditLimit;
    }
    
}
