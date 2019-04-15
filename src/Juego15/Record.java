/*
La clase "Record" contiene información de una partida que ha sido completada.
El método "toStringArray" devuelve un array de String con la información :
duración del juego en segundos, nombre del jugador, fecha y hora de finalización
del juego, nombre de la imagen con la que se jugó.
 */
package Juego15;

import java.io.Serializable;

public class Record implements Serializable {

    private final long tiempo;// tiempo en segundos que ha durado el juego
    private String nombre;//nombre del jugador
    private final String fecha;//fecha y hora cuando se completó el juego
    private final String imagen;//nombre de la imagen del puzle con el que se jugó.

    public Record(long tiempo, String nombre, String fecha, String imagen) {
        this.fecha = fecha;
        this.imagen = imagen;
        this.nombre = String.format("%.20s", nombre.trim());//Se limita a 20 caracteres
        this.tiempo = tiempo;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public long getTiempo() {
        return this.tiempo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getImagen() {
        return this.imagen;
    }

    public String[] toStringArray() {
        String strTiempo = String.format("%02d", this.tiempo / 3600) + ":" + String.format("%02d", (this.tiempo % 3600) / 60) + ":" + String.format("%02d", this.tiempo % 60);
        String[] stringArrayRecord = {strTiempo, String.format("%-20s", this.nombre), String.format("%-20s", this.fecha), String.format("%-15s", this.imagen)};
        return stringArrayRecord;
    }

    @Override
    public String toString() {
        String strRecord = String.format("%8s ", Long.toString(this.tiempo)) + String.format("  %10s", this.nombre) + String.format("%30s", this.fecha) + String.format("%15s", this.imagen);
        return strRecord;
    }
}
