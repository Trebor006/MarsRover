/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert
 */
public class PlateauMainTest {
    
    public PlateauMainTest() {
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
     * Test of ejecutarPrueba method, of class PlateauMain.
     */
    @Test
    public void testEjecutarPrueba() {
        PlateauMain plateauMain = new PlateauMain();                
        String direccion = "EntradaDeDatos.txt";
        plateauMain.ejecutarPrueba(direccion);
    }
        
}
