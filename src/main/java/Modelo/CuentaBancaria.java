package Modelo;

import java.time.LocalDate;
import java.util.Date;

public class CuentaBancaria implements AdapterConexionBancaria{

    @Override
    public float conectarConBanco(String cbu, LocalDate fecha, String token) {
        return 0f;
    }
}
