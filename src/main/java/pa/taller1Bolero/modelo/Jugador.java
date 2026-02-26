package pa.taller1Bolero.modelo;

public class Jugador {

    private String codigo;
    private String nombre;
    private int puntaje;
    private int intentos;
    private int embocadas;

    public Jugador(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntaje = 0;
        this.intentos = 0;
        this.embocadas = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getEmbocadas() {
        return embocadas;
    }

    public void registrarIntento() {
        this.intentos++;
    }

    public void registrarEmbocada() {
        this.embocadas++;
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }
}
