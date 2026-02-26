
package pa.taller1Bolero.modelo;

public enum TipoEmbocada {

    SIMPLE(2),
    DOBLE(10),
    VERTICAL(3),
    MARIQUITA(4),
    PUNALADA(5),
    PURTINA(6),
    DOMINIO_REVES(8),
    SIN_EMBOCADA(0);

    
    private final int puntaje;

   
    TipoEmbocada(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }


    public boolean esExitosa() {
        return this != SIN_EMBOCADA;
    }
}