/*
La clase Tablero crea una matriz bidimensional cuadrada cuyos elementos 
representan las casillas del juego. El constructor recibe como argumento un 
entero "ancho" que representa el número de filas/columnas del puzle. Si el argumento 
recibido es menor que la unidad lanza la excepción "MenorQueUnoException".
En cada elemento se introduce un entero, comenzando en 0. El último elemento es 
el que representa la casilla vacía. Su valor se guarda en la variable
"contenidoCeldaNula". El array "celdaNula" contiene en número de fila y de columna
de la casilla vacía.
 */
package Juego15;

import java.util.Arrays;
import java.util.Random;

public class Tablero {

    private int[][] casillas;
    private int[] celdaNula = new int[2];
    private final int contenidoCeldaNula;

    public Tablero(int ancho)
            throws MenorQueUnoException {
        if (ancho < 1) {
            throw new MenorQueUnoException("ancho debe ser mayor que 1");
        }
        this.casillas = new int[ancho][ancho];
        this.contenidoCeldaNula = ancho * ancho - 1;
        for (int fila = 0; fila < this.casillas.length; fila++) {
            for (int columna = 0; columna < casillas[fila].length; columna++) {
                casillas[fila][columna] = (fila * ancho) + (columna);
            }
        }
        this.celdaNula[0] = ancho - 1;
        this.celdaNula[1] = ancho - 1;
    }

    /*
    El método "mueve" recibe in entero que representa la dirección del movimiento a
    reaizar y devuelve un boolean. Si el movimiento es posible lo realiza llamando 
    al método "intercambiarContenidos" y devuelve true. De lo contrario devuelve 
    false.
     */
    public boolean mueve(int dire) {
        /*
dire: 1=DERECHA  2=ABAJO  3=IZQUIERDA  4=ARRIBA
La celda que se mueve es una de las que están al lado de la celda nula.
Por ejemplo, cuando la celda vacía está junto al borde derecho, el movimiento a 
 la izquierda es imposible.        
         */
        int[] futuraCeldaNula = java.util.Arrays.copyOf(celdaNula, 2);
        switch (dire) {
            case 1:
                futuraCeldaNula[1]--;
                if (futuraCeldaNula[1] == -1) {
                    return false;
                }
                break;
            case 2:
                futuraCeldaNula[0]--;
                if (futuraCeldaNula[0] == -1) {
                    return false;
                }
                break;
            case 3:
                futuraCeldaNula[1]++;
                if (futuraCeldaNula[1] == this.casillas.length) {
                    return false;
                }
                break;
            case 4:
                futuraCeldaNula[0]++;
                if (futuraCeldaNula[0] == this.casillas.length) {
                    return false;
                }
                break;
            default:
                return false;
        }
        this.intercambiarContenidos(this.celdaNula, futuraCeldaNula);
        this.celdaNula = java.util.Arrays.copyOf(futuraCeldaNula, 2);
        return true;
    }

    private void intercambiarContenidos(int[] celda1, int[] celda2) {
        int contenido = this.casillas[celda1[0]][celda1[1]];
        this.casillas[celda1[0]][celda1[1]] = this.casillas[celda2[0]][celda2[1]];
        this.casillas[celda2[0]][celda2[1]] = contenido;
    }

    /*
    El método "desordenar" desordena el tablero realizando un número elevado de 
    movimientos aleatorios. Si se desordenaran las casillas al azar el puzle 
    obtenido podría ser irresoluble (50% de las combinaciones)
     */
    public void desordenar() {
        Random rnd = new Random();
        int ancho = this.casillas.length;
        for (int numMovimientos = 0; numMovimientos < ancho * ancho * ancho * ancho; numMovimientos++) {
            this.mueve(1 + rnd.nextInt(4));
        }
    }

    /*
    getCasillas devuelve la matriz bidimensional.
     */
    public int[][] getCasillas() {
        return this.casillas;
    }

    /*
    El método "estaOrdenado" devuelve true si el puzle está completo y false
    si no lo está.
     */
    public boolean estaOrdenado() {
        int ancho = this.casillas.length;
        int valorSiOrdenado;
        for (int fila = 0; fila < ancho; fila++) {
            for (int columna = 0; columna < ancho; columna++) {
                valorSiOrdenado = ((fila * ancho) + (columna));
                if (valorSiOrdenado != this.casillas[fila][columna]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    Presenta por consola el contenido de la matriz. Para comprobaciones.
     */
    public void presentar() {
        for (int fila = 0; fila < this.casillas.length; fila++) {
            System.out.println(Arrays.toString(this.casillas[fila]));
        }

    }
}
