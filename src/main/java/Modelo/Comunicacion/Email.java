package Modelo.Comunicacion;

import Modelo.Comunicacion.Adapters.IAdapterEmail;
import Modelo.UnidadFuncional.Interesado;

public class Email implements TipoDeMensaje {

    private IAdapterEmail adapter;

    public Email(IAdapterEmail adapter) {
        this.adapter = adapter;
    }

    @Override
    public void enviar(String mensaje, Interesado interesado) {
        this.adapter.enviar(mensaje,interesado);
    }
}
