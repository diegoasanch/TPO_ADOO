package Modelo;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Consorcio {

    private AdapterConexionBancaria cuentaBancaria;
    private List<UnidadFuncional> unidadesFuncionales;
    private List<RegistroGeneracionExpensa> registrosDeGeneracion;
    private String cbu;
    private List<Gasto> gastos;

    public Consorcio(AdapterConexionBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public float obtenerSaldo(String token){
        return this.cuentaBancaria.conectarConBanco(this.cbu, new Date(), token);
    }

    public void agregarRegistroDeGeneracion(Administrador administrador, EstrategiaDeDivision criterio){
        // TODO: Hacer
    }

//    public float calcularGastosDelMes(){
//        // TODO: Hacer
//        return 0.12f;
//    }

    public void agregarGastos(Gasto ... gastos){
        Collections.addAll(this.gastos, gastos);
    }

    public GastosDelMes calcularGastosDelMes(){
        GastosDelMes gastosDelMes = new GastosDelMes();
        float gastosOrdinarios = 0f;
        float gastosExtraordinarios = 0f;

        for (Gasto gasto : gastos){
            if (gasto.esOrdinaria())
                gastosOrdinarios += gasto.getMonto();
            else
                gastosExtraordinarios += gasto.getMonto();
        }

        gastosDelMes.setGastosOrdinariosTotales(gastosOrdinarios);
        gastosDelMes.setGastosExtraordinariosTotales(gastosExtraordinarios);

        return gastosDelMes;
    }



}
