package tpo_adoo_2022;

import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import Modelo.DivisionDeGastos.GenerarFondo;
import Modelo.Gastos.GastosDelMes;
import Modelo.UnidadFuncional.UnidadFuncional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class GenerarFondoTest {
    private UnidadFuncional unidadA;
    private UnidadFuncional unidadB;
    private GastosDelMes gastos;

    private static final float fondoDeReservaGeneradoPorUnidad = 4000.00f * 0.03f;
    private static final float deudaUnidadA = 2000.00f;
    private static final float porcentajeUnidadA = 0.03f;

    private static final float deudaUnidadB = 0.00f;
    private static final float porcentajeUnidadB = 0.06f;

    private static final float gastosOrdinarios = 1000.00f;
    private static final float gastosExtraordinarios = 3000.00f;
    private static final float saldo = 1000.00f;

    @BeforeEach
    public void init(){
        this.unidadA = mock(UnidadFuncional.class);
        this.unidadB = mock(UnidadFuncional.class);
        this.gastos = mock(GastosDelMes.class);
    }

    @Test
    public void testDividirExpensa() {
        EstrategiaDeDivision criterio = new GenerarFondo();
        List<UnidadFuncional> unidadFuncionales = new ArrayList<>();
        unidadFuncionales.add(this.unidadA);
        unidadFuncionales.add(this.unidadB);

        when(this.unidadA.getDeuda()).thenReturn(deudaUnidadA);
        when(this.gastos.getGastosOrdinariosTotales()).thenReturn(gastosOrdinarios);
        when(this.unidadA.getPorcentaje()).thenReturn(porcentajeUnidadA);
        when(this.gastos.getGastosExtraordinariosTotales()).thenReturn(gastosExtraordinarios);
        when(this.unidadA.getPorcentaje()).thenReturn(porcentajeUnidadA);

        when(this.unidadB.getDeuda()).thenReturn(deudaUnidadB);
        when(this.gastos.getGastosOrdinariosTotales()).thenReturn(gastosOrdinarios);
        when(this.unidadB.getPorcentaje()).thenReturn(porcentajeUnidadB);
        when(this.gastos.getGastosExtraordinariosTotales()).thenReturn(gastosExtraordinarios);
        when(this.unidadB.getPorcentaje()).thenReturn(porcentajeUnidadB);

        criterio.dividirExpensa(unidadFuncionales, gastos, saldo);

        verify(this.unidadA).anadirExpensa(gastosOrdinarios * porcentajeUnidadA, gastosExtraordinarios * porcentajeUnidadA, fondoDeReservaGeneradoPorUnidad + deudaUnidadA);

        verify(this.unidadB).anadirExpensa(gastosOrdinarios * porcentajeUnidadB, gastosExtraordinarios * porcentajeUnidadB, fondoDeReservaGeneradoPorUnidad + deudaUnidadB);
    }
}
