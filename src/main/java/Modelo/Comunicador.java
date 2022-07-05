package Modelo;

import Modelo.Comunicacion.Email;

public class Comunicador {
    private TipoDeMensaje tipoDeMensaje;

    public Comunicador(){
        this.tipoDeMensaje = new Email();
    }

    public void notificar(String datosExpensa, Interesado interesado) {
        this.tipoDeMensaje.enviar(datosExpensa, interesado);
    }

    public void cambiarComunicacion(TipoDeMensaje tipoDeMensaje) {
        this.tipoDeMensaje = tipoDeMensaje;
    }
}
