package Modelo.Comunicacion;

import Modelo.Comunicacion.Adapters.IAdapterSMS;
import Modelo.UnidadFuncional.Interesado;

public class Sms implements TipoDeMensaje {
    private IAdapterSMS adapter;

    public Sms(IAdapterSMS adapter) {
        this.adapter = adapter;
    }

    @Override
    public void enviar(String mensaje, Interesado interesado) {
        this.adapter.enviar(mensaje,interesado);
    }
}

