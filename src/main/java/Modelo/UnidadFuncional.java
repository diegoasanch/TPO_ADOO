package Modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UnidadFuncional {
    private Comunicador contactoInteresado;
    private float porcentaje;
    private List<ExpensaPorUnidadFuncional> expensas;

    public UnidadFuncional(Comunicador contactoInteresado) {
        this.contactoInteresado = contactoInteresado;
        this.expensas = new ArrayList<>();
    }

    public void notificarExpensa() {
        this.contactoInteresado.notificar("Nueva expensa");
    }

    public void anadirExpensa(float valorOrdinario, float valorExtraordinario, float extra) {
        ExpensaPorUnidadFuncional nuevaExpensa = new ExpensaPorUnidadFuncional(
            valorOrdinario,
            valorExtraordinario,
            extra);

        expensas.add(nuevaExpensa);

        this.notificarExpensa();
    }

    public float getDeuda(){
        float deuda = 0f;
        for (ExpensaPorUnidadFuncional expensa : expensas)
            if (!expensa.isPagado())
                deuda += expensa.getTotal();
        return deuda;

        }

    }

