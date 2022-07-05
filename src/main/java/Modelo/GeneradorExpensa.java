package Modelo;

import Modelo.DivisionDeGastos.Completo;
import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GeneradorExpensa {

    private Consorcio consorcio;
    private EstrategiaDeDivision estrategiaDeDivision;

    public GeneradorExpensa(){
        this.estrategiaDeDivision = new Completo();
    }

    public void generarExpensas(Administrador administrador, int mes, int anio, String token){
        float saldo = this.consorcio.obtenerSaldo(token, LocalDate.of(anio,mes,LocalDate.now().getDayOfMonth()));
        GastosDelMes gastos = this.consorcio.calcularGastosDelMes(anio,mes);
        this.estrategiaDeDivision.dividirExpensa(this.consorcio.getUnidadesFuncionales(), gastos, saldo);
        consorcio.agregarRegistroDeGeneracion(administrador,this.estrategiaDeDivision);
    }

    public void cambiarEstrategia(EstrategiaDeDivision estrategiaDeDivision){
        this.estrategiaDeDivision = estrategiaDeDivision;
    }

}
