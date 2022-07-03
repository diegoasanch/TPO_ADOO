package Modelo;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneradorExpensa {

    private Consorcio consorcio;
    private EstrategiaDeDivision estrategiaDeDivision;

    public void generarExpensas(Administrador administrador, EstrategiaDeDivision estrategiaDeDivision, int mes, int anio, String token){
        float saldo = this.consorcio.obtenerSaldo(token);
        float gastos = this.consorcio.calcularGastosDelMes();
        this.estrategiaDeDivision.dividirExpensa(this.consorcio.getUnidadesFuncionales(), saldo, gastos);
    }

    public void cambiarEstrategia(EstrategiaDeDivision estrategiaDeDivision){
        this.estrategiaDeDivision = estrategiaDeDivision;
    }

}
