package Modelo;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneradorExpensa {

    private Consorcio consorcio;
    private AdminGastos adminGastos;
    private EstrategiaDeDivision estrategiaDeDivision;

    public void generarExpensas(Administrador administrador, EstrategiaDeDivision estrategiaDeDivision, int mes, int anio){
        /** AGREGAR EL ORDEN DE LOS PASOS **/
        this.estrategiaDeDivision.dividirExpensa(this.consorcio.getUnidadesFuncionales(), this.consorcio.getReserva(), this.adminGastos.calcularGastosDelMes());
    }

    public void cambiarEstrategia(EstrategiaDeDivision estrategiaDeDivision){
        this.estrategiaDeDivision = estrategiaDeDivision;
    }

}
