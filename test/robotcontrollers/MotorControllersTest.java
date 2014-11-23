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
import robotcontrollers.MotorControllers;
import robotcontrollers.MotorControllers;
import static org.junit.Assert.*;

/**
 *
 * @author junxin
 */
public class MotorControllersTest {

    public MotorControllersTest() {
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
     * Test of main method, of class MotorControllers.
     */
    @Test
    public void testMain() {
    }

    /**
     * Test of getMotorData method, of class MotorControllers.
     */
    @Test
    public void testGetMotorData() {
        MotorControllers mc = new MotorControllers(-1);
        if (mc.searchForControllers()) {
            String expectedOutput = "0 0 45";
            String actualOutput = mc.getMotorData();
            assertEquals(expectedOutput, actualOutput);
            
            //assertTrue(1==1);
        }
    }

}
