package pa.taller1Bolero.persistencia;

import pa.taller1Bolero.modelo.Equipo;

import java.io.*;
import java.util.List;


public class GestorSerializacion {

    private static final String RUTA = "Specs/data/equipos.ser";

    public void guardarEquipos(List<Equipo> equipos) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(RUTA)
        );

        oos.writeObject(equipos);
        oos.close();
    }

   
    @SuppressWarnings("unchecked")
    public List<Equipo> cargarEquipos() throws IOException, ClassNotFoundException {

        File archivo = new File(RUTA);

        if (!archivo.exists()) {
            throw new FileNotFoundException("No existe archivo de precarga.");
        }

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivo)
        );

        List<Equipo> equipos = (List<Equipo>) ois.readObject();
        ois.close();

        return equipos;
    }
}