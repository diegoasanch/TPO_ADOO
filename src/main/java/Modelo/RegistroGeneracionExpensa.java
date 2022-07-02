package Modelo;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;

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
}
