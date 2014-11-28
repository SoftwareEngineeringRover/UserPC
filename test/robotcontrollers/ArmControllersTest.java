/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcontrollers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author junxin
 */
public class ArmControllersTest {
    
    public ArmControllersTest() {
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

     @Test
    public void testGetMotorData() {
        ArmControllers ac = new ArmControllers(-1);
        if (ac.searchForControllers()) {
            String expectedOutput = "1 shoulder stop stop false";
            String actualOutput = ac.getArmData();
            assertEquals(expectedOutput, actualOutput);
            
            //assertTrue(1==1);
        }
    }
}
