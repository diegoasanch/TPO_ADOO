package Modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UnidadFuncional {
    private Comunicador comunicador;
    private float porcentaje;
    private List<ExpensaPorUnidadFuncional> expensas;
    private Interesado interesado;

    public UnidadFuncional(Comunicador comunicador) {
        this.comunicador = comunicador;
        this.expensas = new ArrayList<>();
    }

    public void notificarExpensa(ExpensaPorUnidadFuncional expensa) {
        this.comunicador.notificar(expensa.toString(), this.interesado);
    }

    public void anadirExpensa(float valorOrdinario, float valorExtraordinario, float extra) {
        ExpensaPorUnidadFuncional nuevaExpensa = new ExpensaPorUnidadFuncional(
            valorOrdinario,
            valorExtraordinario,
            extra);

        expensas.add(nuevaExpensa);

        this.notificarExpensa(nuevaExpensa);
    }

    public float getDeuda(){
        float deuda = 0f;
        for (ExpensaPorUnidadFuncional expensa : expensas)
            if (!expensa.isPagado())
                deuda += expensa.getTotal();
        return deuda;

    }

    public List<ExpensaPorUnidadFuncional> getExpensasPorEstadoPagado (boolean estado){
        List<ExpensaPorUnidadFuncional> expensasPagadas = new ArrayList<>();
        for (ExpensaPorUnidadFuncional expensa : expensas){
            if (expensa.isPagado() == estado)
                expensasPagadas.add(expensa);
        }

        return expensasPagadas;
    }

}

