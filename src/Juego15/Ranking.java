/*
La clase Ranking contiene un ArrayList de Record para almacenar las puntuaciones
obtenidas y los métodos necesarios para serializarlo/deserializarlo , añadir un
registro y convertirlo en un array de String. 
 */
package Juego15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ranking {

    private ArrayList<Record> ranking;

    public Ranking() {
        this.ranking = new ArrayList<Record>();
    }

    public void put(Long tiempo, Record record) {
        if (this.ranking.isEmpty()) {
            this.ranking.add(0, record);
        } else {//Se añaden los records por orden. Los mejores tiempos arriba.
            int indice = 0;
            while ((indice < this.ranking.size()) && (tiempo > this.ranking.get(indice).getTiempo())) {
                indice++;
            }
            this.ranking.add(indice, record);
        }
    }

    public void recuperarDeArchivo(String nombreArchivoRanking) {
        FileInputStream fileIn = null;
        File archivoRanking = new File(nombreArchivoRanking);
        if (archivoRanking.exists()) {
            try {
                fileIn = new FileInputStream(archivoRanking);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                this.ranking = (ArrayList) in.readObject();
                in.close();
                fileIn.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void grabarAArchivo(String nombreArchivoRanking) {
        try {
            FileOutputStream fileOut = null;
            fileOut = new FileOutputStream(nombreArchivoRanking);
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(this.ranking);
            outStream.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[][] toStringArray() {
        String[][] stringArrayRanking;
        stringArrayRanking = new String[this.ranking.size()][4];
        for (int indice = 0; indice < stringArrayRanking.length; indice++) {
            stringArrayRanking[indice] = this.ranking.get(indice).toStringArray();
        }
        return stringArrayRanking;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String line = "";
        for (int index = 0; index < 80; index++) {
            line += "-";
        }
        line += "\n";
        sb.append(line);
        sb.append("Tiempo (s)   Jugador           Fecha                    Imagen  \n");
        sb.append(line);
        for (Record cadaRecord : this.ranking) {
            sb.append(cadaRecord.toString()).append("\n");
        }
        return sb.toString();
    }
}
