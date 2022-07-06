package Modelo.Comunicacion;

import Modelo.Comunicacion.Adapters.AdapterEmail;
import Modelo.UnidadFuncional.Interesado;

public class Comunicador {
    private TipoDeMensaje tipoDeMensaje;

    public Comunicador(){
        this.tipoDeMensaje = new Email(new AdapterEmail());
    }

    public void notificar(String datosExpensa, Interesado interesado) {
        this.tipoDeMensaje.enviar(datosExpensa, interesado);
    }

    public void cambiarComunicacion(TipoDeMensaje tipoDeMensaje) {
        this.tipoDeMensaje = tipoDeMensaje;
    }
}
