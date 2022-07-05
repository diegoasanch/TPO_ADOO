package Modelo.DivisionDeGastos;

import Modelo.GastosDelMes;
import Modelo.UnidadFuncional;

import java.util.List;

public interface EstrategiaDeDivision {

    void dividirExpensa(List<UnidadFuncional> unidadesFuncionales, GastosDelMes gastos, float saldo);
}
