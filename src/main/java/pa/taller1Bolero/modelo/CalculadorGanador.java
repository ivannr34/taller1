
package pa.taller1Bolero.modelo;

import java.util.List;

public class CalculadorGanador {

    public Equipo determinarGanador(List<Equipo> equipos) {

        if (equipos == null || equipos.isEmpty()) {
            throw new IllegalArgumentException("No hay equipos para evaluar.");
        }

        Equipo ganador = equipos.get(0);

        for (Equipo actual : equipos) {

            if (actual.getPuntajeTotal() > ganador.getPuntajeTotal()) {

                ganador = actual;

            } else if (actual.getPuntajeTotal() == ganador.getPuntajeTotal()) {

                if (actual.getTotalEmbocadas() > ganador.getTotalEmbocadas()) {
                    ganador = actual;
                }
            }
        }

        return ganador;
    }
}
