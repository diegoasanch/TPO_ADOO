package Modelo.Comunicacion.Adapters;

import Modelo.Interesado;

public interface IAdapterSMS {
    void enviar(String mensaje, Interesado interesado);
}
