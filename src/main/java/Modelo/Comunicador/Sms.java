package Modelo.Comunicador;

import Modelo.TipoDeMensaje;

public class Sms implements TipoDeMensaje {
    @Override
    public void enviar(String mensaje, String direccion) {
        System.out.println("Enviando mensaje SMS a " + direccion + ": " + mensaje);
        // TODO: Adaptar un proveedor (maybe?)
    }
}

