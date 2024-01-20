/*

 */
package modelo;

//Autor: Adrian Ernesto Germán Becerra.

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConsultasArticulos extends Conexion{
    Connection Con = getConexion(); //Se conecta a la base de datos
    
    public boolean insertar(ModeloArticulos Modelo){
        try{
            PreparedStatement Ps;
            String SQL =
            "INSERT INTO articulos (Codigo,Nombre,Descripcion,Stock,Precio,Categoria,"
                    + "Maximos,Minimos) values (?,?,?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            Ps.setString(2, Modelo.getNombre());
            Ps.setString(3, Modelo.getDescripcion());
            Ps.setString(4, Modelo.getStock());
            Ps.setString(5, Modelo.getPrecio());
            Ps.setString(6, Modelo.getCategoria());
            Ps.setString(7, Modelo.getMaximos());
            Ps.setString(8, Modelo.getMinimos());
            Ps.executeUpdate();
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL: insertar()\n "+e);
            return false;
        }
    }
    
    public boolean modificar (ModeloArticulos Modelo){
        try{
            PreparedStatement Ps;
            String SQL=
            "UPDATE articulos set Nombre=?,Descripcion=?,Stock=?,Precio=?,Categoria=?,Maximos=?,Minimos=? where Codigo=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getNombre());
            Ps.setString(2, Modelo.getDescripcion());
            Ps.setString(3, Modelo.getStock());
            Ps.setString(4, Modelo.getPrecio());
            Ps.setString(5, Modelo.getCategoria());
            Ps.setString(6, Modelo.getMaximos());
            Ps.setString(7, Modelo.getMinimos());
            Ps.setInt(8, Modelo.getCodigo());
            Ps.executeUpdate();
            return true;

    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: modificar()\n"+e);
        return false;
    }
    
        }
    public boolean eliminar (ModeloArticulos Modelo){
        try{
            PreparedStatement Ps;
            String SQL= "DELETE FROM articulos where Codigo=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            Ps.executeUpdate();
            return true;

    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: eliminar()\n"+e);
        return false;
    }    
        }
    public boolean buscar (ModeloArticulos Modelo){
        try{
            PreparedStatement Ps;
            String SQL= "SELECT * FROM articulos where Codigo = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            ResultSet Rs = Ps.executeQuery();
            
            if (Rs.next()) {
                Modelo.setNombre(Rs.getString("Nombre"));
                Modelo.setDescripcion(Rs.getString("Descripcion"));
                Modelo.setStock(Rs.getString("Stock"));
                Modelo.setPrecio(Rs.getString("Precio"));
                Modelo.setCategoria(Rs.getString("Categoria"));
                Modelo.setMaximos(Rs.getString("Maximos"));
                Modelo.setMinimos(Rs.getString("Minimos"));
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
