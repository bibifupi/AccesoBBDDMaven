package com.softtek.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Empleado {
    private int idEmpleado;
    private String apellidos;
    private String nombre;
    private int jefe;
}
