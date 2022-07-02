package Modelo;

import java.util.Date;

public class CuentaBancaria implements AdapterConexionBancaria{

    private static float saldo;

    @Override
    public float conectarConBanco(String cbu, Date fecha, String token) {
        // TODO: Hacer
        return saldo;
    }
}
