package Modelo.Comunicacion.Adapters;

import Modelo.UnidadFuncional.Interesado;

public interface IAdapterEmail {
    void enviar(String mensaje, Interesado interesado);
}
