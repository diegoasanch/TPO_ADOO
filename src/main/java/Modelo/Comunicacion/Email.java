package Modelo.Comunicacion;

import Modelo.Interesado;
import Modelo.TipoDeMensaje;

public class Email implements TipoDeMensaje {
    @Override
    public void enviar(String mensaje, Interesado interesado) {
        System.out.println("Enviando mensaje Email a " + interesado.getEmail() + ": " + mensaje);
        // TODO: Adaptar un proveedor (maybe?)
    }
}
