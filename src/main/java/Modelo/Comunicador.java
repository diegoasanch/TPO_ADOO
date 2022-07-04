package Modelo;

public class Comunicador {
    private TipoDeMensaje tipoDeMensaje;
    private String direccion;

    public Comunicador(String direccion, TipoDeMensaje tipoDeMensaje) {
        this.direccion = direccion;
        this.tipoDeMensaje = tipoDeMensaje;
    }

    public void notificar(String datosExpensa) {
        this.tipoDeMensaje.enviar(datosExpensa, this.direccion);
    }

    public void cambiarComunicacion(TipoDeMensaje tipoDeMensaje) {
        this.tipoDeMensaje = tipoDeMensaje;
    }
}
