package Modelo;

import java.util.Date;

public class CuentaBancaria implements AdapterConexionBancaria{

    private final static float saldo = 5000f;

    @Override
    public float conectarConBanco(String cbu, Date fecha, String token) {
        // TODO: Hacer
        return saldo;
    }
}
