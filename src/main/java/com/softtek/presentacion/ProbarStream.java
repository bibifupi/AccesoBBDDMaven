package com.softtek.presentacion;

import com.softtek.modelo.Empleado;
import com.softtek.persistencia.AccesoEmpleados;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProbarStream {
    public static void main(String[] args) {

            empleadosJubiladosMayores();
            ciudadesEmpleadosDistintas();

        }
    //6. Obtener los empleados jubilados > 68
        public static void empleadosJubiladosMayores () {
            AccesoEmpleados aP1 = new AccesoEmpleados();

            try {
                List<Empleado> listaEmpleados = aP1.obtenerTodos();

                List<Empleado> jubiladosMayores = listaEmpleados.stream().filter(e -> Period.between(e.getFechaNacimiento(), LocalDate.now()).getYears() > 68).collect(Collectors.toList());


                jubiladosMayores.forEach(System.out::println);

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
    //8. Obtener las distintas ciudades de los empleados
        public static void ciudadesEmpleadosDistintas () {

            AccesoEmpleados aP1 = new AccesoEmpleados();

            try {
                List<Empleado> listaEmpleados = aP1.obtenerTodos();

                Set<String> listaCiudades = listaEmpleados.stream().map(Empleado::getCiudad).collect(Collectors.toSet());

                listaCiudades.forEach(System.out::println);


            } catch (ClassNotFoundException |
                    SQLException e) {
                System.out.println(e);
            }

        }

    }

