package Modelo.Comunicacion;

import Modelo.TipoDeMensaje;

public class Whatsapp implements TipoDeMensaje{
    @Override
    public void enviar(String mensaje, String direccion) {
        System.out.println("Enviando mensaje Whatsapp a " + direccion + ": " + mensaje);
        // TODO: Adaptar un proveedor (maybe?)
    }
}
