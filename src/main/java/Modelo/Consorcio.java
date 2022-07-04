package Modelo;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    public Consorcio() {
        this.unidadesFuncionales = new ArrayList<>();
        this.registrosDeGeneracion = new ArrayList<>();
        this.gastos = new ArrayList<>();
    }

    public float obtenerSaldo(String token, Date fecha){
        return this.cuentaBancaria.conectarConBanco(this.cbu, fecha, token);
    }

    public void agregarRegistroDeGeneracion(Administrador administrador, EstrategiaDeDivision criterio){
        RegistroGeneracionExpensa registro = new RegistroGeneracionExpensa();
        registro.setAdministrador(administrador);
        registro.setCriterio(criterio);
        this.registrosDeGeneracion.add(registro);
    }


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
