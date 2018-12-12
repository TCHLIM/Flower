/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author jiachuen
 */
public class ConsumerTest {
    
    private Consumer c1,c2;

    public ConsumerTest() {
    }

    /**
     * Test of setCustName method, of class Consumer.
     */
    @Before
    public void setUp(){
        c1= new Consumer("C0001","Chuen","981206145493","MALE","01127011502","fadason","EXISTING");
        c2 = new Consumer("C0001","Chuen","981206145493","MALE","01127011502","fadason","EXISTING");
    }
    
    @Test
    public void testSetCustName() {
        System.out.println("setCustName");
        c1.setCustName("Chuen");
        assertEquals("Chuen",c1.getCustName());
    }

    /**
     * Test of setCustIC method, of class Consumer.
     */
    @Test
    public void testSetCustIC() {
        System.out.println("setCustIC");
        c1.setCustIC("981206145493");
        assertEquals("981206145493",c1.getCustIC());
    }

    /**
     * Test of setCustGender method, of class Consumer.
     */
    @Test
    public void testSetCustGender() {
        System.out.println("setCustGender");
        c1.setCustGender("MALE");
        assertEquals("MALE",c1.getCustGender());
    }

    /**
     * Test of getCustName method, of class Consumer.
     */
    @Test
    public void testGetCustName() {
        System.out.println("getCustName");
        assertEquals("Chuen",c1.getCustName());
        assertEquals("Chuen",c2.getCustName());
    }

    /**
     * Test of getCustIC method, of class Consumer.
     */
    @Test
    public void testGetCustIC() {
        System.out.println("getCustIC");
        assertEquals("981206145493",c1.getCustIC());
        assertEquals("981206145493",c2.getCustIC());
    }

    /**
     * Test of getCustGender method, of class Consumer.
     */
    @Test
    public void testGetCustGender() {
        System.out.println("getCustGender");
        assertEquals("MALE",c1.getCustGender());
        assertEquals("MALE",c2.getCustGender());
    }
    
}
