package Modelo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpensaPorUnidadFuncional {
    private Date fecha;
    private float valorOrdinario;
    private float valorExtraordinario;
    private float total;

    public ExpensaPorUnidadFuncional(Date fecha, float valorOrdinario, float valorExtraordinario) {
        this.fecha = fecha;
        this.valorOrdinario = valorOrdinario;
        this.valorExtraordinario = valorExtraordinario;
        this.total = valorOrdinario + valorExtraordinario;
    }
}
