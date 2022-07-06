package Modelo.Comunicacion.Adapters;

import Modelo.UnidadFuncional.Interesado;

public interface IAdapterWhatsapp {
    void enviar(String mensaje, Interesado interesado);
}
