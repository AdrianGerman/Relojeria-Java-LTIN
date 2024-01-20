/*
 */
package controlador;

//Autor: Adrian Ernesto Germán Becerra.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaUsuario;

public class ControladorVistaUsuario implements MouseListener, ActionListener{
    private ModeloUsuario ModeloUsuario;
    private VistaUsuario VistaUsuario;
    
    
    private ConsultasUsuario ConsultasUsuario = new ConsultasUsuario();

    public ControladorVistaUsuario(ModeloUsuario ModeloUsuario, VistaUsuario VistaUsuario) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaUsuario = VistaUsuario;
        oyentes();
        VistaUsuario.setVisible(true);
    }
    
    
    private void oyentes() {
        VistaUsuario.BtnActualizar.addMouseListener(this);
        VistaUsuario.BtnBuscar.addMouseListener(this);
        VistaUsuario.BtnEliminar.addMouseListener(this);
        VistaUsuario.BtnGuardar.addMouseListener(this);
        VistaUsuario.BtnSalir.addMouseListener(this);
        VistaUsuario.TxtUsuario.addActionListener(this);
        VistaUsuario.TxtPassword.addActionListener(this);
        VistaUsuario.TxtNombre.addActionListener(this);
        VistaUsuario.TxtTipo.addActionListener(this);
    }

    
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaUsuario.BtnActualizar) {
            actualizar();
        }else if(e.getSource()==VistaUsuario.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaUsuario.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaUsuario.BtnGuardar) {
            guardar();
        }else if (e.getSource()==VistaUsuario.BtnSalir) {
            salir();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
    private void llenarModeloConVista(){
        ModeloUsuario.setUsuario(VistaUsuario.TxtUsuario.getText());
        ModeloUsuario.setPassword(VistaUsuario.TxtPassword.getText());
        ModeloUsuario.setNombre(VistaUsuario.TxtNombre.getText());
        ModeloUsuario.setTipo(VistaUsuario.TxtTipo.getText());
        
    }
    
    private void llenarVistaConModelo(){
        VistaUsuario.TxtUsuario.setText(ModeloUsuario.getUsuario());
        VistaUsuario.TxtPassword.setText(ModeloUsuario.getPassword());
        VistaUsuario.TxtNombre.setText(ModeloUsuario.getNombre());
        VistaUsuario.TxtTipo.setText(ModeloUsuario.getTipo());  
    }
    
    
    private void limpiarCampos(){
        VistaUsuario.TxtUsuario.setText("");
        VistaUsuario.TxtPassword.setText("");
        VistaUsuario.TxtNombre.setText("");
        VistaUsuario.TxtTipo.setText("");

        VistaUsuario.TxtUsuario.requestFocus();
    }
    
    private boolean validarCampoCodigo(){
        if (VistaUsuario.TxtUsuario.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    
    private boolean validarTodosLosCampos(){
        if (VistaUsuario.TxtUsuario.getText().isEmpty()||
            VistaUsuario.TxtPassword.getText().isEmpty()||
            VistaUsuario.TxtNombre.getText().isEmpty()||
            VistaUsuario.TxtTipo.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    

    private void actualizar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            
            //Para buscar el dato en Modelo Temporal y no modifique al modelo original
            ModeloUsuario ModeloTemporal = new ModeloUsuario();
            ModeloTemporal.setUsuario(VistaUsuario.TxtUsuario.getText());
            
            if (ConsultasUsuario.buscar(ModeloTemporal)== false) { //Buscar con modelo temporal
                JOptionPane.showMessageDialog(VistaUsuario, "Ese producto no existe");
            }else{
                if (ConsultasUsuario.modificar(ModeloUsuario)) {
                    JOptionPane.showMessageDialog(VistaUsuario, "Registro modificado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Los campos no deben de estar vacios");
        }
        
    }

    private void buscar() {
        if (validarCampoCodigo()) {
            ModeloUsuario.setUsuario(VistaUsuario.TxtUsuario.getText());
            if (ConsultasUsuario.buscar(ModeloUsuario)==true) {
               llenarVistaConModelo();
                
            }else{
                JOptionPane.showMessageDialog(VistaUsuario, "Registro no existe");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
        }
    }

    private void eliminar() {
        if (validarCampoCodigo()) {
            ModeloUsuario.setUsuario(VistaUsuario.TxtUsuario.getText());
            if (ConsultasUsuario.buscar(ModeloUsuario)==false) {
                JOptionPane.showMessageDialog(VistaUsuario, "Ese proveedor no existe");  
            }else{
                if (ConsultasUsuario.eliminar(ModeloUsuario)) {
                    JOptionPane.showMessageDialog(VistaUsuario, "Registro eliminado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaUsuario, "Error al eliminar el registro");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "El campo codigo no debe de estar vacio");
        }
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloUsuario.setUsuario(VistaUsuario.TxtUsuario.getText());
            if (ConsultasUsuario.buscar(ModeloUsuario)==true) {
                JOptionPane.showMessageDialog(VistaUsuario, "Ese proveedor ya existe");   
            }else{
                llenarModeloConVista();  
                if (ConsultasUsuario.insertar(ModeloUsuario)==true) {
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                    limpiarCampos();   
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
            }
        }
        }else{
            JOptionPane.showMessageDialog(null, "El campo codigo no debe de estar vacio");
    }
}

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaUsuario, "¿Desea salir de proveedores?","Alerta",0,1);
        if (opc == 0) VistaUsuario.dispose();    
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
