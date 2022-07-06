package Modelo.Comunicacion.Adapters;

import Modelo.UnidadFuncional.Interesado;

public class AdapterWhatsapp implements IAdapterWhatsapp{
    @Override
    public void enviar(String mensaje, Interesado interesado) {
        System.out.println("Enviando mensaje Whatsapp a " + interesado.getTelefono() + ": " + mensaje);

    }
}
