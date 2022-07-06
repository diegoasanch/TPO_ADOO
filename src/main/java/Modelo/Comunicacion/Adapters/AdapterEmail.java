package Modelo.Comunicacion.Adapters;

import Modelo.UnidadFuncional.Interesado;

public class AdapterEmail implements IAdapterEmail {
    @Override
    public void enviar(String mensaje, Interesado interesado) {
        System.out.println("Enviando mensaje Email a " + interesado.getEmail() + ": " + mensaje);
    }
}
