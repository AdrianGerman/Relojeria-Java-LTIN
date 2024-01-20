/*

 */
package modelo;

//Autor: Adrian Ernesto Germám Becerra.

import com.sun.prism.PresentableState;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ConsultasProveedores extends Conexion{
    Connection Con = getConexion(); //Se conecta a la base de datos
    
    public boolean insertar(ModeloProveedores Modelo){
        try{
            PreparedStatement Ps;
            String SQL =
            "insert into proveedores (Codigo,Nombre,Apellido,Direccion,Ciudad,Email,"
                    + "Web,Telefono,Celular) values (?,?,?,?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            Ps.setString(2, Modelo.getNombre());
            Ps.setString(3, Modelo.getApellido());
            Ps.setString(4, Modelo.getDireccion());
            Ps.setString(5, Modelo.getCiudad());
            Ps.setString(6, Modelo.getEmail());
            Ps.setString(7, Modelo.getWeb());
            Ps.setString(8, Modelo.getTelefono());
            Ps.setString(9, Modelo.getCelular());
            Ps.executeUpdate();
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL: insertar()\n "+e);
            return false;
        }
    }
    
    public boolean modificar (ModeloProveedores Modelo){
        try{
            PreparedStatement Ps;
            String SQL=
            "update proveedores set Nombre=?,Apellido=?,Direccion=?,Ciudad=?,Email=?,Web=?,Telefono=?,Celular=? where Codigo=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getNombre());
            Ps.setString(2, Modelo.getApellido());
            Ps.setString(3, Modelo.getDireccion());
            Ps.setString(4, Modelo.getCiudad());
            Ps.setString(5, Modelo.getEmail());
            Ps.setString(6, Modelo.getWeb());
            Ps.setString(7, Modelo.getTelefono());
            Ps.setString(8, Modelo.getCelular());
            Ps.setInt(9, Modelo.getCodigo());
            Ps.executeUpdate();
            return true;

    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: modificar()\n"+e);
        return false;
    }
    
        }
    public boolean eliminar (ModeloProveedores Modelo){
        try{
            PreparedStatement Ps;
            String SQL= "delete from proveedores where Codigo=?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            Ps.executeUpdate();
            return true;

    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: eliminar()\n"+e);
        return false;
    }    
        }
    public boolean buscar (ModeloProveedores Modelo){
        try{
            PreparedStatement Ps;
            String SQL= "SELECT * FROM proveedores where Codigo = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getCodigo());
            ResultSet Rs = Ps.executeQuery();
            
            if (Rs.next()) {
                Modelo.setNombre(Rs.getString("Nombre"));
                Modelo.setApellido(Rs.getString("Apellido"));
                Modelo.setDireccion(Rs.getString("Direccion"));
                Modelo.setCiudad(Rs.getString("Ciudad"));
                Modelo.setEmail(Rs.getString("Email"));
                Modelo.setWeb(Rs.getString("Web"));
                Modelo.setTelefono(Rs.getString("Telefono"));
                Modelo.setCelular(Rs.getString("Celular"));
                Modelo.setCodigo(Rs.getInt("Codigo"));
                return true;
            }
            return false;
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n"+e);
        return false;
    }
  }
    
    
    public String obtenerNombreString(int id_nombre){
        try {
            PreparedStatement Ps;
             String SQL= "select * from Nombre where Nombre = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1,id_nombre);
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                return Rs.getString("apellido");
                
            }
            return null;
        }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n"+e);
        return null;
    }
  }
    
    public Integer obtenerNombreNumerica(String Nombre){
        try{
            PreparedStatement Ps;
            String SQL = "select * from Nombre where Apellido = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1,Nombre);
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                return Rs.getInt("Nombre") ;
            }
            return null;
        }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: obtenerCaracteristicasNumericas()\n"+e);
        return null;
        
    }
  }
    
    public void llenarComboNombre(JComboBox ComboTabla){
        try{
            PreparedStatement Ps;
            String SQL = "select * from Nombre order by Apellido";
            Ps = Con.prepareCall(SQL);
            ResultSet RsResultado = Ps.executeQuery();
            while (RsResultado.next()){
                ComboTabla.addItem(RsResultado.getString("nombre"));
            }
        }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL: llenerComboNombre()\n"+e);
        
    }
        }
}
