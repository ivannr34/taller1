package pa.taller1Bolero.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private final String nombreProyectoCurricular;
    private final String nombreEquipo;
    private final List<Jugador> jugadores;

    public Equipo(String nombreProyectoCurricular, String nombreEquipo, List<Jugador> jugadores) {
        this.nombreProyectoCurricular = nombreProyectoCurricular;
        this.nombreEquipo = nombreEquipo;
        this.jugadores = new ArrayList<>();
    }

    public void AgregarJugador(Jugador jugador) {
        if (jugadores.size() < 3) {
            jugadores.add(jugador);
        } else {
            throw new IllegalStateException("El equipo ya esta lleno.");
        }
    }

    public int getPuntajeTotal() {
        int total = 0;
        for (Jugador j : jugadores) {
            total += j.getPuntaje();
        }
        return total;
    }

    public int getTotalIntentos() {
        int total = 0;
        for (Jugador j : jugadores) {
            total += j.getIntentos();
        }
        return total;
    }
    
    public int getTotalEmbocadas(){
        int total = 0;
        for (Jugador j: jugadores){
            total += j.getEmbocadas();
        }
        return total;
    }
    
    public String getNombreProyectoCurricular() {
        return nombreProyectoCurricular;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

}
