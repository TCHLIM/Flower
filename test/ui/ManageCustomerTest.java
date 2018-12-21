/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.CustomerControl;
import domain.Consumer;
import domain.CorCust;
import java.util.Scanner;
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
public class ManageCustomerTest {
    CustomerControl CC = new CustomerControl();
    Scanner myScanner = new Scanner(System.in);
    Consumer consumer=new Consumer();
    CorCust corCust=new CorCust();
    private String[] corCustAtt={"ID: ","Contract Name: ","Phone: ","Address: ","Credit Limit: "};
    
    public ManageCustomerTest() {
        
    }
    /*Test add corporate customer*/
     @Test
    public void addCorCust(){
        int countPlace=0;String ID;
        while(countPlace<corCustAtt.length){
            switch(countPlace){
                case 0:ID="B0001";corCust.setCustID(ID);break;
                case 1:corCust.setContractName("Jia Chuen");break;
                
                case 2: String phone="01127011502";
                    corCust.setCustPhone(phone);
                break;
                case 3:corCust.setCustAddress("jffewofbewuifbewiobceofbewoif");
                break;
                case 4:String creditLimit;
                    corCust.setCreditLimit("1000.20");
                break;
            }
            countPlace++;
        }
        corCust.setCustMode("EXISTING");
        CC.addCorCust(corCust);//corCust=new CorCust();
        
        assertEquals(1,CC.corCustDA.corCustList.size());
    }
}
