package Modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Gasto {

    private TipoDeExpensa expensa;
    private TipoDeGasto tipo;
    private boolean recurrencia;
    private float monto;
    private Date fecha;

    public Gasto() {
        this.fecha = new Date();
    }
}
