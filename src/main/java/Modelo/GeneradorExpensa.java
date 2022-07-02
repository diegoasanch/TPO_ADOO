package Modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneradorExpensa {

    private Consorcio consorcio;
    private AdminGastos adminGastos;
    private EstrategiaDeDivision estrategiaDeDivision;

    public void generarExpensas(Administrador administrador, EstrategiaDeDivision estrategiaDeDivision, int mes, int anio){

    }
}
