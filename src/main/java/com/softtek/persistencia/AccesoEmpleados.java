package com.softtek.persistencia;

import com.softtek.modelo.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccesoEmpleados extends Conexion {
    public List<Empleado> obtenerTodos() throws SQLException, ClassNotFoundException {
        PreparedStatement sentencia;
        ResultSet resu;
        String sql = "Select employee_id, last_name, first_name, reports_to from employees";
        List<Empleado> empleados = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.prepareStatement(sql);
        resu = sentencia.executeQuery();
        while (resu.next()) {
            empleados.add(new Empleado(resu.getInt("employee_id"), resu.getString("last_name"), resu.getString("first_name"), resu.getInt("reports_to")));
        }
        return empleados;
    }

    public Empleado obtenerId(int idEmpleado) throws ClassNotFoundException, SQLException {
        PreparedStatement sentencia;
        ResultSet resultado;
        String sql = "Select employee_id, last_name, first_name, reports_to from employees where employee_id=?";
        Empleado emple = null;
        abrirConexion();
        sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1, idEmpleado);
        resultado = sentencia.executeQuery();

        if (resultado.next()) {
            emple = new Empleado(resultado.getInt("employee_id"),
                    resultado.getString("last_name"),
                    resultado.getString("first_name"),
                    resultado.getInt("reports_to"));
        }
        return emple;
    }

    public boolean modificar(Empleado e) throws SQLException, ClassNotFoundException {
        //1. Declarar variables
        PreparedStatement sentencia;
        int resu = 0;
        String sql = "Update employees set last_name=?, first_name=?, reports_to=? where employee_id= ?";
        //2. Abrir conexion
        abrirConexion();
        //3. Crear el statement
        sentencia = miConexion.prepareStatement(sql);
//3a. Dar valor a los parámetros
        sentencia.setString(1, e.getApellidos());
        sentencia.setString(2, e.getNombre());
        sentencia.setInt(3, e.getJefe());
        sentencia.setInt(4, e.getIdEmpleado());
        //4. Actualizar
        resu=sentencia.executeUpdate();
        //5. Devolver resultado
        return resu > 0;
    }


    public boolean alta(Empleado e) throws SQLException, ClassNotFoundException {
        //1. Declarar variables
        PreparedStatement sentencia;
        int resu = 0;
        String sql = "insert into employees (employee_id, last_name, first_name, reports_to ) values (?,?,?,?);";
        //2. Abrir conexion
        abrirConexion();
        //3. Crear el statement
        sentencia = miConexion.prepareStatement(sql);
        //3a. Dar valor a los parámetros
        sentencia.setInt(1, e.getIdEmpleado());
        sentencia.setString(2, e.getApellidos());
        sentencia.setString(3, e.getNombre());
        sentencia.setInt(4, e.getJefe());
        //4. Actualizar
        resu = sentencia.executeUpdate();
        //5. Devolver resultado
        return resu > 0;
    }
    public boolean baja(int idEmpleado) throws SQLException, ClassNotFoundException {
        //1. Declarar variables
        PreparedStatement sentencia;
        int resu = 0;
        String sql = "delete from employees where employee_id = ?;";
        //2. Abrir conexion
        abrirConexion();
        //3. Crear el statement
        sentencia = miConexion.prepareStatement(sql);
        //3a. Dar valor a los parámetros
        sentencia.setInt(1, idEmpleado);
        //4. Actualizar
        resu = sentencia.executeUpdate();
        //5. Devolver resultado
        return resu > 0;
    }

}
