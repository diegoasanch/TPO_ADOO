package modelo;

public class Comunicador {
    private TipoDeMensaje tipoDeMensaje;

    Comunicador(TipoDeMensaje tipoDeMensaje) {
        this.tipoDeMensaje = tipoDeMensaje;
    }

    public void notificar(String datosExpensa) {
        this.tipoDeMensaje.enviar(datosExpensa);
    }

    public void cambiarComunicacion(TipoDeMensaje tipoDeMensaje) {
        this.tipoDeMensaje = tipoDeMensaje;
    }
}
