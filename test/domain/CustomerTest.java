/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jiach
 */
public class CustomerTest {
    
    private Customer instance;
    
    public CustomerTest() {
    }
    
    @Before
    public void setUp() {
        this.instance= new Customer();
    }

    /**
     * Test of setCustMode method, of class Customer.
     */
    @Test
    public void testSetCustMode() {
        System.out.println("setCustMode");
        String custMode = "DEELETED";
        instance.setCustMode(custMode);
    }

    /**
     * Test of getCustMode method, of class Customer.
     */
    @Test
    public void testGetCustMode() {
        System.out.println("getCustMode");
        Customer instance = new CustomerImpl();
        String expResult = "";
        String result = instance.getCustMode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustID method, of class Customer.
     */
    @Test
    public void testGetCustID() {
        System.out.println("getCustID");
        Customer instance = new CustomerImpl();
        String expResult = "";
        String result = instance.getCustID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustPhone method, of class Customer.
     */
    @Test
    public void testGetCustPhone() {
        System.out.println("getCustPhone");
        Customer instance = new CustomerImpl();
        String expResult = "";
        String result = instance.getCustPhone();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getCustAddress method, of class Customer.
     */
    @Test
    public void testGetCustAddress() {
        System.out.println("getCustAddress");
        Customer instance = new CustomerImpl();
        String expResult = "";
        String result = instance.getCustAddress();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setCustID method, of class Customer.
     */
    @Test
    public void testSetCustID() {
        System.out.println("setCustID");
        String custID = "";
        Customer instance = new CustomerImpl();
        instance.setCustID(custID);
        
        
    }

    /**
     * Test of setCustPhone method, of class Customer.
     */
    @Test
    public void testSetCustPhone() {
        System.out.println("setCustPhone");
        String custPhone = "";
        Customer instance = new CustomerImpl();
        instance.setCustPhone(custPhone);
        
        
    }

    /**
     * Test of setCustAddress method, of class Customer.
     */
    @Test
    public void testSetCustAddress() {
        System.out.println("setCustAddress");
        String custAddress = "";
        Customer instance = new CustomerImpl();
        instance.setCustAddress(custAddress);
        
        
    }

    public class CustomerImpl extends Customer {
    }
    
}
