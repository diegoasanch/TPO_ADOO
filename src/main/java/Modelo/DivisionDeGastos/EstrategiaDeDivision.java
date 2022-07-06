package Modelo.DivisionDeGastos;

import Modelo.Gastos.GastosDelMes;
import Modelo.UnidadFuncional.UnidadFuncional;

import java.util.List;

public interface EstrategiaDeDivision {

    void dividirExpensa(List<UnidadFuncional> unidadesFuncionales, GastosDelMes gastos, float saldo);
}
