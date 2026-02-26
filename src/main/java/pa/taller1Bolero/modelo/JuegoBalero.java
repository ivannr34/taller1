package pa.taller1Bolero.modelo;

import java.util.List;

public class JuegoBalero {

    private final List<Equipo> equipos;
    private final int tiempoPorEquipo;
    private final SimuladorEmbocada simulador;

    public JuegoBalero(List<Equipo> equipos, int tiempoPorEquipo) {
        this.equipos = equipos;
        this.tiempoPorEquipo = tiempoPorEquipo;
        this.simulador = new SimuladorEmbocada();
    }

    public void iniciarJuego() {
        for (Equipo equipo : equipos) {
            ejecutarTurnoEquipo(equipo);
        }
    }

    private void ejecutarTurnoEquipo(Equipo equipo) {

        int tiempoPorJugador = tiempoPorEquipo / 3;

        for (Jugador jugador : equipo.getJugadores()) {
            ejecutarTurnoJugador(jugador, tiempoPorJugador);
        }
    }

    private void ejecutarTurnoJugador(Jugador jugador, int tiempoJugador) {

        for (int i = 0; i < tiempoJugador; i++) {

            jugador.registrarIntento();

            ResultadoTurno resultado = simulador.simular();

            if (resultado.getTipoEmbocada().esExitosa()) {
                jugador.registrarEmbocada();
                jugador.sumarPuntos(resultado.getTipoEmbocada().getPuntaje());
            }
        }
    }
}
