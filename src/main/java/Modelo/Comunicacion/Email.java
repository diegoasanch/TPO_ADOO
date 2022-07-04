package Modelo.Comunicacion;

import Modelo.TipoDeMensaje;

public class Email implements TipoDeMensaje {
    @Override
    public void enviar(String mensaje, String direccion) {
        System.out.println("Enviando mensaje Email a " + direccion + ": " + mensaje);
        // TODO: Adaptar un proveedor (maybe?)
    }
}
