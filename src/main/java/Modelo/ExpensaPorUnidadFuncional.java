package Modelo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ExpensaPorUnidadFuncional {
    private Date fecha;
    private float valorOrdinario;
    private float valorExtraordinario;
    private float total;
    private boolean pagado;

    public ExpensaPorUnidadFuncional(float valorOrdinario, float valorExtraordinario, float extra) {
        this.fecha = new Date();
        this.valorOrdinario = valorOrdinario;
        this.valorExtraordinario = valorExtraordinario;
        this.total = (valorOrdinario + valorExtraordinario) + extra;
        this.pagado = false;
    }

    @Override
    public String toString() {
        return "\n" + "Expensa:" + "\n" +
                "Fecha: " + fecha + "\n" +
                "Valor Ordinario: " + valorOrdinario + "\n" +
                "Valor Extraordinario: " + valorExtraordinario + "\n" +
                "Total: " + total + "\n" +
                "Pagado: " + pagado + "\n";
    }
}
