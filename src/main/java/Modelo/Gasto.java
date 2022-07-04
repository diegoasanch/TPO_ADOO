package Modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.*;
import java.util.Date;

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
