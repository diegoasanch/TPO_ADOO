package Modelo.Gastos;

import lombok.Getter;
import lombok.Setter;

import java.time.*;

@Getter
@Setter
public class Gasto {

    private TipoDeExpensa expensa;
    private TipoDeGasto tipo;
    private boolean recurrencia;
    private float monto;
    private LocalDate fecha;

    public Gasto() {
        this.fecha = LocalDate.now();
    }

    public boolean esOrdinaria(){
        return expensa == TipoDeExpensa.Ordinaria;
    }
}
