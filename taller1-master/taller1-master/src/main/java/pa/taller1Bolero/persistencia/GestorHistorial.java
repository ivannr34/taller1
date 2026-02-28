package pa.taller1Bolero.persistencia;

import pa.taller1Bolero.modelo.Equipo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GestorHistorial {

    private static final String RUTA = "Specs/data/historial.dat";

    public void guardarResultado(Equipo equipoGanador) throws IOException {

        File archivo = new File(RUTA);
        RandomAccessFile raf = new RandomAccessFile(archivo, "rw");

        // Ir al final del archivo
        raf.seek(raf.length());

        int nuevaClave = obtenerSiguienteClave();

        raf.writeInt(nuevaClave);
        raf.writeUTF(equipoGanador.getNombreEquipo());

        for (int i = 0; i < 3; i++) {
            raf.writeUTF(equipoGanador.getJugadores().get(i).getNombre());
        }

        raf.writeInt(equipoGanador.getPuntajeTotal());

        raf.close();
    }

    private int obtenerSiguienteClave() throws IOException {

        File archivo = new File(RUTA);

        if (!archivo.exists() || archivo.length() == 0) {
            return 1;
        }

        RandomAccessFile raf = new RandomAccessFile(archivo, "r");

        int ultimaClave = 0;

        while (raf.getFilePointer() < raf.length()) {
            ultimaClave = raf.readInt();
            raf.readUTF(); 
            raf.readUTF(); 
            raf.readUTF(); 
            raf.readUTF(); 
            raf.readInt(); 
        }

        raf.close();
        return ultimaClave + 1;
    }

    public int contarVictorias(String nombreEquipo) throws IOException {

        File archivo = new File(RUTA);

        if (!archivo.exists()) {
            return 0;
        }

        RandomAccessFile raf = new RandomAccessFile(archivo, "r");

        int contador = 0;

        while (raf.getFilePointer() < raf.length()) {

            raf.readInt();
            String nombre = raf.readUTF();

            raf.readUTF();
            raf.readUTF();
            raf.readUTF();

            raf.readInt();

            if (nombre.equals(nombreEquipo)) {
                contador++;
            }
        }

        raf.close();
        return contador;
    }
}