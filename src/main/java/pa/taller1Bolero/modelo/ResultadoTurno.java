
package pa.taller1Bolero.modelo;

public class ResultadoTurno {

    private final TipoEmbocada tipoEmbocada;

    public ResultadoTurno(TipoEmbocada tipoEmbocada) {
        this.tipoEmbocada = tipoEmbocada;
    }

    public TipoEmbocada getTipoEmbocada() {
        return tipoEmbocada;
    }

    public boolean fueExitosa() {
        return tipoEmbocada.esExitosa();
    }
}
