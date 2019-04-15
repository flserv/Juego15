//Pruebas de la clase Tablero.
package Juego15;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TableroNGTest {

    public TableroNGTest() {
    }

    //Para comprobar que si el argumento es <0 el constructor lanza una excepción
    @Test
    public void testSomeMethod() {
        try {
            Tablero tabletoPrueba = new Tablero(-1);
            fail();
        } catch (MenorQueUnoException ex) {
        }
    }

    /*
    Para probar que los movimientos posibles se realizan y devuelven true
    y los imposibles devuelven false.
     */
    @Test
    public void testMueve()
            throws MenorQueUnoException {
        Tablero tablero4 = new Tablero(2);

        boolean obtenido = false;

        assertEquals(tablero4.mueve(3), false);
        assertEquals(tablero4.mueve(4), false);
        assertEquals(tablero4.mueve(1), true);

        assertEquals(tablero4.mueve(1), false);
        assertEquals(tablero4.mueve(4), false);
        assertEquals(tablero4.mueve(2), true);

        assertEquals(tablero4.mueve(1), false);
        assertEquals(tablero4.mueve(2), false);
        assertEquals(tablero4.mueve(3), true);

        assertEquals(tablero4.mueve(2), false);
        assertEquals(tablero4.mueve(3), false);
        assertEquals(tablero4.mueve(4), true);

        assertEquals(tablero4.mueve(2), true);

    }

    /* 
    Para probar que el método "estaOrdenado" devuelve true o false según el 
    tablero esté ordenado o desordenado.
     */
    @Test
    public void testEstaOrdenado()
            throws MenorQueUnoException {
        Tablero tableroTest = new Tablero(6);
        assertEquals(tableroTest.estaOrdenado(), true);
        tableroTest.desordenar();
        assertEquals(tableroTest.estaOrdenado(), false);
    }
}
