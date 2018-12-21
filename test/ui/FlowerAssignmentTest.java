/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ADT.List;
import ADT.ListInterface;
import domain.Flower;
import domain.Order;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Hiko
 */
public class FlowerAssignmentTest {

    public FlowerAssignmentTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of addDelivery method, of class FlowerAssignment.
     */
    @org.junit.Test
    public void testAddDelivery() {
        System.out.println("addDelivery");
    }

    /**
     * Test of addFlower method, of class FlowerAssignment.
     */
    @Test
    public void testAddFlower() {
        System.out.println("addFlower");

        ListInterface<Flower> flowerList = flowerList = new List<>();
        ListInterface<Order> orderList = new List<>();

        int q = 0, orderQuantity = 5;
        String choice = "Blue bouquets";
        
        flowerList.add(new Flower("Red flower", "red color", 20, true, "flower", 10));
        flowerList.add(new Flower("Blue bouquets", "Blue color", 20, true, "bouquets", 10));
        flowerList.add(new Flower("Yellow floral", "Yellow color", 20, true, "floral", 10));
        flowerList.add(new Flower("Grey flower", "Grey color", 20, true, "flower", 10));
        flowerList.add(new Flower("Black flower", "Grey color", 0, true, "flower", 10));

        for (int n = 0; n < flowerList.size(); n++) {
            if (flowerList.getEntry(n).getName().equalsIgnoreCase(choice)) {
                q = flowerList.getEntry(n).getQuantity() - orderQuantity;

                flowerList.getEntry(n).setQuantity(q);
                Order order = new Order(flowerList.getEntry(n).getId(), choice, orderQuantity, flowerList.getEntry(n).getPrice() * orderQuantity, flowerList.getEntry(n).getType());
                orderList.add(order);
            }
        }
        
        assertEquals(1, orderList.size());
    }

    /**
     * Test of makePayment method, of class FlowerAssignment.
     */
    @Test
    public void testMakePayment() {
        System.out.println("makePayment");
    }
}
