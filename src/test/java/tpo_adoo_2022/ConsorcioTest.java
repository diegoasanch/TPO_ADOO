package tpo_adoo_2022;

import Modelo.*;
import Modelo.DivisionDeGastos.Completo;
import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


import static org.mockito.Mockito.*;

public class ConsorcioTest {


    private AdapterConexionBancaria cuentaBancaria;

    private static final String token = "028643";

    private Gasto gasto1;
    private Gasto gasto2;


    @BeforeEach
    public void init(){
        this.cuentaBancaria = mock(CuentaBancaria.class);
        this.gasto1 = mock(Gasto.class);
        this.gasto2 = mock(Gasto.class);


    }

    @Test
    public void testCalcularGastosDelMes(){
        Consorcio consorcio = new Consorcio();
        consorcio.agregarGastos(gasto1,gasto2);

        when(this.gasto1.getFecha()).thenReturn(LocalDate.of(2022,6,12));
        when(this.gasto2.getFecha()).thenReturn(LocalDate.of(2022,6,12));
        when(this.gasto1.esOrdinaria()).thenReturn(true);
        when(this.gasto1.getMonto()).thenReturn(500.00f);
        when(this.gasto2.esOrdinaria()).thenReturn(false);
        when(this.gasto2.getMonto()).thenReturn(10000.00f);

        GastosDelMes valorActual = consorcio.calcularGastosDelMes(2022,6);

        Assertions.assertEquals(10000.00f, valorActual.getGastosExtraordinariosTotales());
        Assertions.assertEquals(500.00f, valorActual.getGastosOrdinariosTotales());
    }

    @Test
    public void testObtenerSaldo(){
        Consorcio consorcio = new Consorcio();
        String cbu = "00002123454545";
        consorcio.setCbu(cbu);
        consorcio.setCuentaBancaria(cuentaBancaria);

        LocalDate diaDeHoy = LocalDate.now();

        when(this.cuentaBancaria.conectarConBanco(cbu, diaDeHoy, token)).thenReturn(600.00f);

        float valorActual = consorcio.obtenerSaldo(token, diaDeHoy);

        Assertions.assertEquals(600.00f, valorActual);
    }

    @Test
    public void testAgregarRegistroDeGeneracion(){
        Consorcio consorcio = new Consorcio();
        Administrador admin = new Administrador();
        EstrategiaDeDivision criterio = new Completo();

        int cantidadDeRegistros = 0;

        Assertions.assertEquals(cantidadDeRegistros,consorcio.getRegistrosDeGeneracion().size());

        consorcio.agregarRegistroDeGeneracion(admin,criterio);

        cantidadDeRegistros += 1;

        Assertions.assertEquals(cantidadDeRegistros,consorcio.getRegistrosDeGeneracion().size());
    }
}
