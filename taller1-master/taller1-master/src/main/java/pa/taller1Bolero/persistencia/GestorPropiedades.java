package pa.taller1Bolero.persistencia;

import pa.taller1Bolero.modelo.Equipo;
import pa.taller1Bolero.modelo.Jugador;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class GestorPropiedades {
    public List<Equipo> cargarEquipos() throws IOException {

        JFileChooser chooser = new JFileChooser();
        int resultado = chooser.showOpenDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            throw new IOException("No se seleccionó archivo.");
        }

        Properties props = new Properties();
        props.load(new FileInputStream(chooser.getSelectedFile()));

        List<Equipo> equipos = new ArrayList<>();

        int cantidadEquipos = Integer.parseInt(props.getProperty("equipos"));

        for (int i = 1; i <= cantidadEquipos; i++) {

            String proyecto = props.getProperty("equipo" + i + ".proyecto");
            String nombreEquipo = props.getProperty("equipo" + i + ".nombre");

            Equipo equipo = new Equipo(proyecto, nombreEquipo, new ArrayList<>());

            for (int j = 1; j <= 3; j++) {

                String codigo = props.getProperty("equipo" + i + ".jugador" + j + ".codigo");
                String nombre = props.getProperty("equipo" + i + ".jugador" + j + ".nombre");

                Jugador jugador = new Jugador(codigo, nombre);
                equipo.AgregarJugador(jugador);
            }

            equipos.add(equipo);
        }

        return equipos;
    }
}
