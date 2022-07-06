package Modelo.Comunicacion.Adapters;

import Modelo.Interesado;

public interface IAdapterWhatsapp {
    void enviar(String mensaje, Interesado interesado);
}
