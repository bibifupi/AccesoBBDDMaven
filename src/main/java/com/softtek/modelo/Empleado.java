package com.softtek.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Empleado {
    private int idEmpleado;
    private String apellidos;
    private String nombre;
    private int jefe;
    private LocalDate fechaNacimiento;
    private String ciudad;
}
