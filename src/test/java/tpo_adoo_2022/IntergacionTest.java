package tpo_adoo_2022;

import Modelo.*;
import Modelo.Comunicacion.Email;
import Modelo.Comunicacion.Sms;
import Modelo.Comunicacion.Whatsapp;
import Modelo.DivisionDeGastos.Completo;
import Modelo.DivisionDeGastos.ConFondo;
import Modelo.DivisionDeGastos.EstrategiaDeDivision;
import Modelo.DivisionDeGastos.GenerarFondo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntergacionTest {

    private UnidadFuncional unidadA;
    private UnidadFuncional unidadB;

    private Interesado interesadoA;
    private Interesado interesadoB;

    private Gasto gastoFuera;

    private EstrategiaDeDivision completo;
    private EstrategiaDeDivision conFondo;
    private EstrategiaDeDivision generarFondo;

    private Comunicador comunicadorA;
    private Comunicador comunicadorB;

    private TipoDeMensaje whatsapp;
    private TipoDeMensaje sms;
    private TipoDeMensaje email;

    private AdapterConexionBancaria cuentaBancaria;

    private static final String token = "028643";
    private static final String cbu = "0004136456214";


    @BeforeEach
    public void init(){
        //MOCK
        this.cuentaBancaria = mock(CuentaBancaria.class);

        //INSTANCIAS
        this.whatsapp = new Whatsapp();
        this.sms = new Sms();
        this.email = new Email();

        this.completo = new Completo();
        this.conFondo = new ConFondo();
        this.generarFondo = new GenerarFondo();

        //GASTO DE OTRO MES
        TipoDeGasto servicioPintura = new TipoDeGasto();
        servicioPintura.setTitulo("Servicio de Pinturas");
        servicioPintura.setDescripcion("Gastos relacionado al revestimiento de pintura de las paredes");

        this.gastoFuera = new Gasto();
        this.gastoFuera.setFecha(LocalDate.of(2022,5,19));
        this.gastoFuera.setExpensa(TipoDeExpensa.Extraordinaria);
        this.gastoFuera.setMonto(20000.00f);
        this.gastoFuera.setRecurrencia(false);
        this.gastoFuera.setTipo(servicioPintura);

        //UNIDAD A
        this.comunicadorA = new Comunicador();

        this.interesadoA = new Interesado();
        this.interesadoA.setNombre("Ramiro");
        this.interesadoA.setApellido("Ramirez");
        this.interesadoA.setEmail("rama.ramirez@gmail.com");
        this.interesadoA.setTelefono("+541145768822");

        this.unidadA = new UnidadFuncional(this.comunicadorA);
        this.unidadA.setInteresado(interesadoA);
        this.unidadA.setPorcentaje(0.5f);

        //UNIDAD B
        this.comunicadorB = new Comunicador();

        this.interesadoB = new Interesado();
        this.interesadoB.setNombre("Martin");
        this.interesadoB.setApellido("Martinez");
        this.interesadoB.setEmail("marta.martinez@gmail.com");
        this.interesadoB.setTelefono("+541176120081");

        this.unidadB = new UnidadFuncional(this.comunicadorB);
        this.unidadB.setInteresado(interesadoB);
        this.unidadB.setPorcentaje(0.5f);

    }

    @Test
    public void testIntegracionConsorcio(){
        //Creamos un consorcio
        Consorcio consorcioInfinity = new Consorcio();
        consorcioInfinity.setCbu(cbu);
        consorcioInfinity.setCuentaBancaria(this.cuentaBancaria);

        //Creamos un Administrador
        Administrador admin = new Administrador();
        admin.setNombre("Eze");

        //Le definimos método de comunicación a las Unidades Funcionales
        this.comunicadorA.cambiarComunicacion(this.whatsapp);
        this.comunicadorB.cambiarComunicacion(this.email);

        //Le agregamos las unidades funcionales
        consorcioInfinity.setUnidadesFuncionales(Arrays.asList(unidadA,unidadB));

        //Creamos gastos
        TipoDeGasto servicioLuz = new TipoDeGasto();
        servicioLuz.setTitulo("Servicio de Luz");
        servicioLuz.setDescripcion("Gastos mensuales relacionados a el consumo de electricidad");

        Gasto gasto1 = new Gasto();
        gasto1.setFecha(LocalDate.of(2022,6,12));
        gasto1.setExpensa(TipoDeExpensa.Ordinaria);
        gasto1.setMonto(5000.00f);
        gasto1.setRecurrencia(true);
        gasto1.setTipo(servicioLuz);

        TipoDeGasto mantenimientoAscensor = new TipoDeGasto();
        mantenimientoAscensor.setTitulo("Mantenimiento de Ascensor");
        mantenimientoAscensor.setDescripcion("Reparación del Ascensor A");

        Gasto gasto2 = new Gasto();
        gasto2.setFecha(LocalDate.of(2022,6,21));
        gasto2.setExpensa(TipoDeExpensa.Extraordinaria);
        gasto2.setMonto(10000.00f);
        gasto2.setRecurrencia(false);
        gasto2.setTipo(mantenimientoAscensor);

        //Le agregamos los gastos al consorcio
        consorcioInfinity.agregarGastos(gasto1,gasto2);

        //Le agrego un gasto de Otro Mes
        consorcioInfinity.agregarGastos(gastoFuera);

        //Instanciamos el Generador y le Asociamos el Consorcio
        GeneradorExpensa generadorExpensa = new GeneradorExpensa();
        generadorExpensa.setConsorcio(consorcioInfinity);

        //Definimos un Criterio
        generadorExpensa.cambiarEstrategia(this.completo);

        //Generamos Expensas
        generadorExpensa.generarExpensas(admin,6,2022,token);

        //Se asume que se tienen $10000 de saldo en la cuenta
        LocalDate diaDeHoy = LocalDate.of(2022,6,LocalDate.now().getDayOfMonth());
        when(consorcioInfinity.obtenerSaldo(token,diaDeHoy)).thenReturn(10000.00f);

        //Paso 1 -> Obtener Saldo
        float saldoEsperado = 10000.00f;
        Assertions.assertEquals(saldoEsperado, consorcioInfinity.obtenerSaldo(token,diaDeHoy));

        //Paso 2 -> Calcular Gastos de un Mes Específico
        float gastosOrdinariosEsperados = 5000.00f;
        float gastosExtraordinariosEsperados = 10000.00f;

        Assertions.assertEquals(gastosOrdinariosEsperados, consorcioInfinity.calcularGastosDelMes(2022,6).getGastosOrdinariosTotales());
        Assertions.assertEquals(gastosExtraordinariosEsperados, consorcioInfinity.calcularGastosDelMes(2022,6).getGastosExtraordinariosTotales());

        //Paso 3 -> Division De Expensas Mediante un Criterio
        Assertions.assertEquals(1,unidadA.getExpensas().size());
        Assertions.assertEquals(1,unidadB.getExpensas().size());

        float valorOrdinarioExpensaA = 2500.00f;
        Assertions.assertEquals(valorOrdinarioExpensaA,unidadA.getExpensas().get(unidadA.getExpensas().size() - 1).getValorOrdinario());

        float valorExtraordinarioExpensaA = 5000.00f;
        Assertions.assertEquals(valorExtraordinarioExpensaA,unidadA.getExpensas().get(unidadA.getExpensas().size() - 1).getValorExtraordinario());

        float valorTotalExpensaA = 7500.00f;
        Assertions.assertEquals(valorTotalExpensaA,unidadA.getExpensas().get(unidadA.getExpensas().size() - 1).getTotal());

        //Se genera el Registro de Generación
        Assertions.assertEquals(1,consorcioInfinity.getRegistrosDeGeneracion().size());
        Assertions.assertEquals(admin,consorcioInfinity.getRegistrosDeGeneracion().get(consorcioInfinity.getRegistrosDeGeneracion().size() - 1).getAdministrador());

        //Si Se cambia de Criterio y De Medio De Notificación
        unidadA.getExpensas().get(0).setPagado(true);

        comunicadorA.cambiarComunicacion(this.email);
        comunicadorB.cambiarComunicacion(this.sms);

        generadorExpensa.cambiarEstrategia(this.generarFondo);
        generadorExpensa.generarExpensas(admin,6,2022,token);

        //Registro de Generación de Expensa
        System.out.println("\n" + "------Registro de Generación------");
        System.out.println(consorcioInfinity.getRegistrosDeGeneracion().toString());

        //Trazabilidad De Expensas
        System.out.println("\n" + "------Expensas Pagadas de Unidad A------");
        System.out.println(unidadA.getExpensasPorEstadoPagado(true).toString());

        System.out.println("\n" + "------Expensas No Pagadas de Unidad B-------");
        System.out.println(unidadB.getExpensasPorEstadoPagado(false).toString());



    }
}
