package modelo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnidadFuncional {
    private Comunicador contactoInteresado
    private float porcentaje
    private List<ExpensaPorUnidadFuncional> expensa

    public void notificarExpensa() {
        // TODO: implementar
    }

    public void anadirExpensa(float valorOrdinario, float valorExtraordinario) {
        // TODO: implementar
    }

}
