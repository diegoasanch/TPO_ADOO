package Modelo;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import lombok.Getter;
import lombok.Setter;

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

    public float obtenerSaldo(String token){
        return this.cuentaBancaria.conectarConBanco(this.cbu, new Date(), token);
    }

    public void agregarRegistroDeGeneracion(Administrador administrador, EstrategiaDeDivision criterio){
        // TODO: Hacer
    }

    public float calcularGastosDelMes(){
        // TODO: Hacer
        return 0.12f;
    }



}
