package tpo_adoo_2022;

import Modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.mockito.Mockito.*;

public class ConsorcioTest {

//    Gasto gasto;

    @Mock
    private AdapterConexionBancaria cuentaBancaria;


    private static final String token = "028643";

    private Gasto gasto1;
    private Gasto gasto2;

    private UnidadFuncional unidadA;
    private UnidadFuncional unidadB;


    @BeforeEach
    public void init(){
//        this.cuentaBancaria = mock(CuentaBancaria.class);
//        this.gasto = mock(Gasto.class);

        TipoDeGasto servicioLuz = new TipoDeGasto();
        servicioLuz.setTitulo("Servicio de Luz");
        servicioLuz.setDescripcion("Gastos mensuales relacionados a el consumo de electricidad");

        this.gasto1 = new Gasto();
        this.gasto1.setExpensa(TipoDeExpensa.Ordinaria);
        this.gasto1.setMonto(500.00f);
        this.gasto1.setRecurrencia(true);
        this.gasto1.setTipo(servicioLuz);

        TipoDeGasto mantenimientoAscensor = new TipoDeGasto();
        mantenimientoAscensor.setTitulo("Mantenimiento de Ascensor");
        mantenimientoAscensor.setDescripcion("Reparación del Ascensor A");

        this.gasto2 = new Gasto();
        this.gasto2.setExpensa(TipoDeExpensa.Extraordinaria);
        this.gasto2.setMonto(10000.00f);
        this.gasto2.setRecurrencia(false);
        this.gasto2.setTipo(mantenimientoAscensor);

//        Comunicador comunicador = new Comunicador();

//        this.unidadA = new UnidadFuncional();

    }

//    @Test
//    public void test(){
//        Consorcio consorcio = new Consorcio();
////        consorcio1.agregarGastos(gasto1,gasto2);
//
//        when(gasto.getMonto()).thenReturn(500.00f);
//        when(gasto.getMonto()).thenReturn(10000.00f);
//
//        GastosDelMes valorActual = consorcio.calcularGastosDelMes();
//    }

    @Test
    public void testObtenerSaldo(){
        Consorcio consorcio = new Consorcio(cuentaBancaria);
        String cbu = "00002123454545";

        when(this.cuentaBancaria.conectarConBanco(cbu,new Date(),token)).thenReturn(600.00f);

        float valorActual = consorcio.obtenerSaldo(token);

        Assertions.assertEquals(600.00f, valorActual);
    }
}
