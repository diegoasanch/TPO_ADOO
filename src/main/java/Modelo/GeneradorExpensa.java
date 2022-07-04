package Modelo;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GeneradorExpensa {

    private Consorcio consorcio;
    private EstrategiaDeDivision estrategiaDeDivision;

    public void generarExpensas(Administrador administrador, EstrategiaDeDivision estrategiaDeDivision, int mes, int anio, String token){
        float saldo = this.consorcio.obtenerSaldo(token, new Date());
        GastosDelMes gastos = this.consorcio.calcularGastosDelMes();
        this.estrategiaDeDivision.dividirExpensa(this.consorcio.getUnidadesFuncionales(), gastos, saldo);
        consorcio.agregarRegistroDeGeneracion(administrador,estrategiaDeDivision);
    }

    public void cambiarEstrategia(EstrategiaDeDivision estrategiaDeDivision){
        this.estrategiaDeDivision = estrategiaDeDivision;
    }

}
