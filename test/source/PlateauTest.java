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
public class PlateauTest {

//    Plateau instance;
    public PlateauTest() {
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
     * Test of obtenerDireccionFinal method, of class Plateau.
     */
    @Test
    public void testObtenerDireccionFinal1() {
        int x = 5, y = 5, x1 = 1, y1 = 2;
        char dir = 'N';
        String expResult = "1 3 N";
        String movimientos = "LMLMLMLMM";
        Plateau px = new Plateau(x, y);
        px.establecerPosicionRoverInicial(x1, y1, dir);
        px.establecerMovimientosRover(movimientos);
        String result = px.obtenerDireccionFinal();
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerDireccionFinal2() {
        int x = 5, y = 5, x1 = 3, y1 = 3;
        char dir = 'E';
        String expResult = "5 1 E";
        String movimientos = "MMRMMRMRRM";
        
        Plateau px = new Plateau(x, y);
        px.establecerPosicionRoverInicial(x1, y1, dir);
        px.establecerMovimientosRover(movimientos);
        String result = px.obtenerDireccionFinal();
        assertEquals(expResult, result);
    }

    @Test
    public void testObtenerDireccionFinal3() {
        int x = 5, y = 5, x1 = 2, y1 = 3;
        char dir = 'W';
        String expResult = "3 2 S";
        String movimientos = "MRMRMRMMLMR";
        Plateau px = new Plateau(x, y);
        px.establecerPosicionRoverInicial(x1, y1, dir);
        px.establecerMovimientosRover(movimientos);
        String result = px.obtenerDireccionFinal();
        assertEquals(expResult, result);
    }

}
