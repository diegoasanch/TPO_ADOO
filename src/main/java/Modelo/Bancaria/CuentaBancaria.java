package Modelo.Bancaria;

import java.time.LocalDate;

public class CuentaBancaria implements AdapterConexionBancaria{

    @Override
    public float conectarConBanco(String cbu, LocalDate fecha, String token) {
        return 0f;
    }
}
