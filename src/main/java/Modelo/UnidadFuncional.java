package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Modelo.Comunicador.Comunicador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadFuncional {
    private Comunicador contactoInteresado;
    private float porcentaje;
    private List<ExpensaPorUnidadFuncional> expensa;

    UnidadFuncional(Comunicador contactoInteresado) {
        this.contactoInteresado = contactoInteresado;
        this.porcentaje = this.porcentaje;
        this.expensa = new ArrayList<>();
    }

    public void notificarExpensa() {
        this.contactoInteresado.notificar("Nueva expensa");
    }

    public void anadirExpensa(float valorOrdinario, float valorExtraordinario) {
        ExpensaPorUnidadFuncional nuevaExpensa = new ExpensaPorUnidadFuncional(
            new Date() ,
            valorOrdinario,
            valorExtraordinario);

        expensa.add(nuevaExpensa);
    }

}
