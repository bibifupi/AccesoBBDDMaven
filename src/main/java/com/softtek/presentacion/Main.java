package com.softtek.presentacion;

import com.softtek.modelo.Empleado;
import com.softtek.persistencia.AccesoEmpleados;
import com.softtek.persistencia.Conexion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexion c1 = new Conexion();
        try {
            c1.abrirConexion();
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        AccesoEmpleados aE1 = new AccesoEmpleados();
        Empleado emple = new Empleado(1, "García", "Lola", 5);
        Empleado emple2 = new Empleado(99, "Piris", "Zelda", 2);

        System.out.println("\nObtener todos los empleados: \n");
        try {
            System.out.println(aE1.obtenerTodos());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }


        /*System.out.println("\nModificar un empleado por su id: \n");
        try {
            System.out.println(aE1.modificar(emple));
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }*/

        /*System.out.println("\nEliminar un empleado por su id: \n");
        try {
            System.out.println(aE1.baja(99));
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }*/

        /*System.out.println("\nDar de alta a un empleado: \n");
        try {
            System.out.println(aE1.alta(emple2));
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }*/

        /*System.out.println("\nObtener un empleado por su id: \n");
        try {
            System.out.println(aE1.obtenerId(99));
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }*/


    }
}
