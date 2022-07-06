package Modelo.DivisionDeGastos;

import Modelo.Gastos.GastosDelMes;
import Modelo.UnidadFuncional.UnidadFuncional;

import java.util.List;

public class GenerarFondo implements EstrategiaDeDivision{
    @Override
    public void dividirExpensa(List<UnidadFuncional> unidadesFuncionales, GastosDelMes gastos, float saldo) {

        float fondoDeReservaGeneradoPorUnidad = (gastos.getGastosExtraordinariosTotales() + gastos.getGastosOrdinariosTotales()) * 0.03f;

        for (UnidadFuncional unidad : unidadesFuncionales){
            float deuda = unidad.getDeuda();
            float ordinariosPorUnidadFuncional = gastos.getGastosOrdinariosTotales() * unidad.getPorcentaje();
            float extraordinariosPorUnidadFuncional = gastos.getGastosExtraordinariosTotales() * unidad.getPorcentaje();
            unidad.anadirExpensa(ordinariosPorUnidadFuncional,extraordinariosPorUnidadFuncional,fondoDeReservaGeneradoPorUnidad + deuda);
        }
    }
}
