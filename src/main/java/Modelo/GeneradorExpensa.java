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
        GastosDelMes gastos = this.consorcio.calcularGastosDelMes();
        this.estrategiaDeDivision.dividirExpensa(this.consorcio.getUnidadesFuncionales(), gastos, saldo);
    }

    public void cambiarEstrategia(EstrategiaDeDivision estrategiaDeDivision){
        this.estrategiaDeDivision = estrategiaDeDivision;
    }

}
