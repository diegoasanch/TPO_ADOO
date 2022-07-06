package Modelo.Bancaria;

import java.time.LocalDate;

public interface AdapterConexionBancaria {

    float conectarConBanco(String cbu, LocalDate fecha, String token);
}
