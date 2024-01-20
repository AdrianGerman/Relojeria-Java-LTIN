/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConsultasClientes extends Conexion{
    Connection Con = getConexion(); //Se conecta a la base de datos
    
    public boolean insertar(ModeloClientes Modelo){
        try{
            PreparedStatement Ps;
            String SQL =
            "insert into clientes (Codigo,Nombre,Apellido,Direccion,Email,Telefono,"
                    + "CURP,RFC) values (?,?,?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            Ps.setString(2, Modelo.getNombre());
            Ps.setString(3, Modelo.getApellido());
            Ps.setString(4, Modelo.getDireccion());
            Ps.setString(5, Modelo.getEmail());
            Ps.setString(6, Modelo.getTelefono());
            Ps.setString(7, Modelo.getCURP());
            Ps.setString(8, Modelo.getRFC());
            Ps.executeUpdate();
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL: insertar()\n "+e);
            return false;
        }
    }
    
    public boolean modificar (ModeloClientes Modelo){
        try{
            PreparedStatement Ps;
            String SQL=
            "update clientes set Nombre=?,Apellido=?,Direccion=?,Email=?,Telefono=?,CURP=?,RFC=? where Codigo=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getNombre());
            Ps.setString(2, Modelo.getApellido());
            Ps.setString(3, Modelo.getDireccion());
            Ps.setString(4, Modelo.getEmail());
            Ps.setString(5, Modelo.getTelefono());
            Ps.setString(6, Modelo.getCURP());
            Ps.setString(7, Modelo.getRFC());
            Ps.setInt(8, Modelo.getCodigo());
            Ps.executeUpdate();
            return true;

    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: modificar()\n"+e);
        return false;
    }
    
        }
    public boolean eliminar (ModeloClientes Modelo){
        try{
            PreparedStatement Ps;
            String SQL= "delete from clientes where Codigo=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            Ps.executeUpdate();
            return true;

    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: eliminar()\n"+e);
        return false;
    }    
        }
    public boolean buscar (ModeloClientes Modelo){
        try{
            PreparedStatement Ps;
            String SQL= "SELECT * FROM clientes where Codigo = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            ResultSet Rs = Ps.executeQuery();
            
            if (Rs.next()) {
                Modelo.setNombre(Rs.getString("Nombre"));
                Modelo.setApellido(Rs.getString("Apellido"));
                Modelo.setDireccion(Rs.getString("Direccion"));
                Modelo.setEmail(Rs.getString("Email"));
                Modelo.setTelefono(Rs.getString("Telefono"));
                Modelo.setCURP(Rs.getString("CURP"));
                Modelo.setRFC(Rs.getString("RFC"));
                Modelo.setCodigo(Rs.getInt("Codigo"));
                return true;
            }
            return false;
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n"+e);
        return false;
    }
  }

    
    
}
