package Modelo.Comunicacion;

import Modelo.Interesado;
import Modelo.TipoDeMensaje;

public class Sms implements TipoDeMensaje {
    @Override
    public void enviar(String mensaje, Interesado interesado) {
        System.out.println("Enviando mensaje SMS a " + interesado.getTelefono() + ": " + mensaje);
        // TODO: Adaptar un proveedor (maybe?)
    }
}

