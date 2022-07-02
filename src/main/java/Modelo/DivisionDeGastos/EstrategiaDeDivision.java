package Modelo.DivisionDeGastos;

import Modelo.UnidadFuncional;

import java.util.List;

public interface EstrategiaDeDivision {

    void dividirExpensa(List<UnidadFuncional> unidadesFuncionales, float gasto, float saldo);
}
