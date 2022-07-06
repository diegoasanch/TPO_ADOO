package Modelo.Comunicacion;

import Modelo.Comunicacion.Adapters.IAdapterWhatsapp;
import Modelo.UnidadFuncional.Interesado;

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
