package Modelo.Comunicacion;

import Modelo.UnidadFuncional.Interesado;

public interface TipoDeMensaje {
    void enviar(String mensaje, Interesado interesado);
}
