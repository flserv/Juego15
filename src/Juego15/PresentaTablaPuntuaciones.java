/*
El constructor de la clase PresentaTablaPuntuaciones recibe el ranking en forma 
de array bidimensional de String y lo presenta como una tabla JTable con una 
barra de scroll.
 */
package Juego15;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PresentaTablaPuntuaciones extends JFrame {

    private final String[] titulos;

    public PresentaTablaPuntuaciones(String[][] valores) {
        this.titulos = new String[]{"Tiempo (s)", "Jugador", "Fecha", "Imagen"};
        JTable tablaPuntuaciones = new JTable(valores, titulos);
        add(new JScrollPane(tablaPuntuaciones), BorderLayout.CENTER);
        this.setTitle("Tabla de tiempos");
        
    }
}
