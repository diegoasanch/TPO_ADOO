package tpo_adoo_2022;

import Modelo.*;
import Modelo.DivisionDeGastos.Completo;
import Modelo.DivisionDeGastos.ConFondo;
import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import Modelo.DivisionDeGastos.GenerarFondo;
import Modelo.Gastos.GastosDelMes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class GeneradorExpensaTest {

    private Consorcio consorcio;
    private EstrategiaDeDivision completo;
    private EstrategiaDeDivision conFondo;
    private EstrategiaDeDivision generarFondo;
    private static final String token = "028643";

    private GastosDelMes gastos;
    private Administrador admin;

    @BeforeEach
    public void init(){
        this.consorcio = mock(Consorcio.class);
        this.completo = mock(Completo.class);
        this.conFondo = mock(ConFondo.class);
        this.generarFondo = mock(GenerarFondo.class);

        this.gastos = new GastosDelMes();
        this.gastos.setGastosOrdinariosTotales(5000.00f);
        this.gastos.setGastosExtraordinariosTotales(10000.00f);

        this.admin = new Administrador();
        this.admin.setNombre("Admin_A");
    }

    @Test
    public void testGenerarExpensasConCriterioCompleto(){
        GeneradorExpensa generadorExpensa = new GeneradorExpensa();
        generadorExpensa.setConsorcio(this.consorcio);
        generadorExpensa.setEstrategiaDeDivision(this.completo);

        LocalDate diaDeHoy = LocalDate.of(2022,6,LocalDate.now().getDayOfMonth());

        when(this.consorcio.obtenerSaldo(token,diaDeHoy)).thenReturn(500.00f);
        when(this.consorcio.calcularGastosDelMes(2022,6)).thenReturn(this.gastos);

        generadorExpensa.generarExpensas(admin,6,2022,token);

        verify(this.completo).dividirExpensa(this.consorcio.getUnidadesFuncionales(), gastos,500.00f);
        verify(this.consorcio).agregarRegistroDeGeneracion(admin,this.completo);
    }

    @Test
    public void testGenerarExpensasConCriterioConFondo(){
        GeneradorExpensa generadorExpensa = new GeneradorExpensa();
        generadorExpensa.setConsorcio(this.consorcio);
        generadorExpensa.setEstrategiaDeDivision(this.conFondo);

        LocalDate diaDeHoy = LocalDate.of(2022,6,LocalDate.now().getDayOfMonth());

        when(this.consorcio.obtenerSaldo(token,diaDeHoy)).thenReturn(500.00f);
        when(this.consorcio.calcularGastosDelMes(2022,6)).thenReturn(this.gastos);

        generadorExpensa.generarExpensas(admin,6,2022,token);

        verify(this.conFondo).dividirExpensa(this.consorcio.getUnidadesFuncionales(), gastos,500.00f);
        verify(this.consorcio).agregarRegistroDeGeneracion(admin,this.conFondo);
    }

    @Test
    public void testGenerarExpensasConCriterioGenerarFondo(){
        GeneradorExpensa generadorExpensa = new GeneradorExpensa();
        generadorExpensa.setConsorcio(this.consorcio);
        generadorExpensa.setEstrategiaDeDivision(this.generarFondo);

        LocalDate diaDeHoy = LocalDate.of(2022,6,LocalDate.now().getDayOfMonth());

        when(this.consorcio.obtenerSaldo(token,diaDeHoy)).thenReturn(500.00f);
        when(this.consorcio.calcularGastosDelMes(2022,6)).thenReturn(this.gastos);

        generadorExpensa.generarExpensas(admin,6,2022,token);

        verify(this.generarFondo).dividirExpensa(this.consorcio.getUnidadesFuncionales(), gastos,500.00f);
        verify(this.consorcio).agregarRegistroDeGeneracion(admin,this.generarFondo);
    }
}
