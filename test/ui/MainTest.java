/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ADT.List;
import ADT.ListInterface;
import domain.Flower;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jiach
 */
public class MainTest {
         ListInterface<Flower> flowerList = flowerList = new List<>();
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testAddFlower() {
        
   
      
        
    }
    
    public Flower registerFlower() {


       
        Flower flower = new Flower("asdasd", "asdasd", 0, true, "asdasdasd",0);
        flowerList.add(flower);
        return flower;
        //assertEquals("asdasd",flowerList.getEntry(0).getName());
    }

       
  
   
    
}
