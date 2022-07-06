package Modelo.Comunicacion.Adapters;

import Modelo.UnidadFuncional.Interesado;

public class AdapterSMS implements IAdapterSMS{
    @Override
    public void enviar(String mensaje, Interesado interesado) {
        System.out.println("Enviando mensaje SMS a " + interesado.getTelefono() + ": " + mensaje);
    }
}
