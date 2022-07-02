package Modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AdminGastos {

    private List<Gasto> gastosAcumulados;

    public float calcularGastosDelMes(){
        // TODO: Hacer
        return 0.12f;
    }
}
