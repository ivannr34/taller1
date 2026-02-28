
package pa.taller1Bolero.modelo;

import java.util.Random;

public class SimuladorEmbocada {

    private final Random random;

    public SimuladorEmbocada() {
        this.random = new Random();
    }

    public ResultadoTurno simular() {

        TipoEmbocada[] tipos = TipoEmbocada.values();

        int indice = random.nextInt(tipos.length);

        TipoEmbocada tipoSeleccionado = tipos[indice];

        return new ResultadoTurno(tipoSeleccionado);
    }
}
