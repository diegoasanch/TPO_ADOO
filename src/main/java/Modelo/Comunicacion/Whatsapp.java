package Modelo.Comunicacion;

import Modelo.Comunicacion.Adapters.IAdapterWhatsapp;
import Modelo.Interesado;
import Modelo.TipoDeMensaje;

public class Whatsapp implements TipoDeMensaje{


    private IAdapterWhatsapp adapter;

    public  Whatsapp(IAdapterWhatsapp adapter) {
        this.adapter = adapter;
    }

    @Override
    public void enviar(String mensaje, Interesado interesado) {
        this.adapter.enviar(mensaje,interesado);
    }
}
