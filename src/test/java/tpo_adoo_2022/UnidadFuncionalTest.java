package tpo_adoo_2022;

import static org.mockito.Mockito.*;

import Modelo.Comunicacion.Comunicador;
import Modelo.UnidadFuncional.ExpensaPorUnidadFuncional;
import Modelo.UnidadFuncional.Interesado;
import Modelo.UnidadFuncional.UnidadFuncional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UnidadFuncionalTest {
    private Comunicador comunicador;
    private ExpensaPorUnidadFuncional expensa1;
    private ExpensaPorUnidadFuncional expensa2;
    private Interesado interesado;
    private ExpensaPorUnidadFuncional expensa;

    @BeforeEach
    public void init(){
        this.comunicador = mock(Comunicador.class);
        this.expensa1 = mock(ExpensaPorUnidadFuncional.class);
        this.expensa2 = mock(ExpensaPorUnidadFuncional.class);

        this.interesado = new Interesado();
        this.interesado.setNombre("InteresadoA");
        this.interesado.setApellido("Apellido");
        this.interesado.setEmail("nn@gmail.com");
        this.interesado.setTelefono("11234545");

        this.expensa = new ExpensaPorUnidadFuncional(10000f,300f,0);
    }

    @Test
    public void testNotificarExpensa(){
        UnidadFuncional unidadFuncional = new UnidadFuncional(this.comunicador);
        unidadFuncional.setInteresado(this.interesado);
        unidadFuncional.notificarExpensa(this.expensa);

        verify(this.comunicador).notificar(this.expensa.toString(), this.interesado);
    }

    @Test
    public void testAnadirExpensaAgregaUnObjetoYNotifica(){
        UnidadFuncional unidadFuncional = new UnidadFuncional(this.comunicador);
        unidadFuncional.setInteresado(this.interesado);

        int cantidadExpensas = 0;
        Assertions.assertEquals(cantidadExpensas,unidadFuncional.getExpensas().size());

        unidadFuncional.anadirExpensa(this.expensa.getValorOrdinario(),this.expensa.getValorExtraordinario(), 0);

        cantidadExpensas += 1;
        Assertions.assertEquals(cantidadExpensas,unidadFuncional.getExpensas().size());
        
        verify(this.comunicador).notificar(this.expensa.toString(), this.interesado);
    }

    @Test
    public void testAnadirExpensaCreaExpensaPorUnidadFuncional(){
        UnidadFuncional unidadFuncional = new UnidadFuncional(this.comunicador);

        unidadFuncional.anadirExpensa(400,500,0);

        Assertions.assertEquals(ExpensaPorUnidadFuncional.class,unidadFuncional.getExpensas().get(0).getClass());
    }

    @Test
    public void testGetDeuda(){
        UnidadFuncional unidadFuncional = new UnidadFuncional(this.comunicador);
        List<ExpensaPorUnidadFuncional> ArrayExpensas = new ArrayList<>();
        ArrayExpensas.add(this.expensa1);
        ArrayExpensas.add(this.expensa2);
        unidadFuncional.setExpensas(ArrayExpensas);

        when(this.expensa1.isPagado()).thenReturn(true);
        when(this.expensa1.getTotal()).thenReturn(5000f);

        Assertions.assertEquals(0,unidadFuncional.getDeuda());

        when(this.expensa2.isPagado()).thenReturn(false);
        when(this.expensa2.getTotal()).thenReturn(1000f);
        Assertions.assertEquals(1000f,unidadFuncional.getDeuda());

    }

    @Test
    public void testAnadirExpensaYGetDeuda(){
        UnidadFuncional unidadFuncional = new UnidadFuncional(this.comunicador);
        unidadFuncional.anadirExpensa(500,300,0);

        Assertions.assertEquals(800,unidadFuncional.getDeuda());
    }

    @Test
    public void testTrazabilidadDePagoDeExpensas(){
        UnidadFuncional unidadFuncional = new UnidadFuncional(this.comunicador);
        unidadFuncional.anadirExpensa(500,300,0);
        unidadFuncional.anadirExpensa(400,200,0);

        unidadFuncional.getExpensas().get(0).setPagado(true);

        List<ExpensaPorUnidadFuncional> expensasPagadasEsperadas = unidadFuncional.getExpensasPorEstadoPagado(true);
        List<ExpensaPorUnidadFuncional> expensasNoPagadasEsperadas = unidadFuncional.getExpensasPorEstadoPagado(false);

        Assertions.assertEquals(800.00f,expensasPagadasEsperadas.get(0).getTotal());
        Assertions.assertEquals(600.00f,expensasNoPagadasEsperadas.get(0).getTotal());
    }
}
