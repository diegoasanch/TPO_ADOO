package Modelo.DivisionDeGastos;

import Modelo.GastosDelMes;
import Modelo.UnidadFuncional;

import java.util.List;

public class Completo implements EstrategiaDeDivision{

    @Override
    public void dividirExpensa(List<UnidadFuncional> unidadesFuncionales, GastosDelMes gastos, float saldo) {
        for (UnidadFuncional unidad : unidadesFuncionales){
            float deuda = unidad.getDeuda();
            float ordinariosPorUnidadFuncional = gastos.getGastosOrdinariosTotales() * unidad.getPorcentaje();
            float extraordinariosPorUnidadFuncional = gastos.getGastosExtraordinariosTotales() * unidad.getPorcentaje();
            unidad.anadirExpensa(ordinariosPorUnidadFuncional,extraordinariosPorUnidadFuncional,deuda);
        }


    }
}
