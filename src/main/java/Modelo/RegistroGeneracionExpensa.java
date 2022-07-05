package Modelo;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
public class RegistroGeneracionExpensa {

    private Administrador administrador;
    private Date fecha;
    private EstrategiaDeDivision criterio;

    public RegistroGeneracionExpensa() {
        this.fecha = new Date();
    }

    @Override
    public String toString() {
        return "\n" + "RegistroGeneracionExpensa" + "\n" +
                "Administrador: " + administrador.getNombre() + "\n" +
                "Fecha: " + fecha + "\n" +
                "Criterio: " + criterio.getClass().getSimpleName() + "\n";
    }
}
