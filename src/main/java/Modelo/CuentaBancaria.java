package Modelo;

import java.util.Date;

public class CuentaBancaria implements AdapterConexionBancaria{

    @Override
    public float conectarConBanco(String cbu, Date fecha, String token) {
        return 0f;
    }
}
