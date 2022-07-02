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
    private float reserva;
    private List<RegistroGeneracionExpensa> registrosDeGeneracion;

    public void obtenerSaldo(String cbu, String token){
        this.reserva = this.cuentaBancaria.conectarConBanco(cbu, new Date(), token);
    }

    public void agregarRegistroDeGeneracion(Administrador administrador, EstrategiaDeDivision criterio){
        // TODO: Hacer
    }



}
