package Modelo;

import java.util.Date;

public interface AdapterConexionBancaria {

    float conectarConBanco(String cbu, Date fecha, String token);
}
