/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasClientes;
import modelo.ModeloClientes;
import modelo.ModeloProveedores;
import vista.VistaClientes;


public class ControladorVistaClientes implements MouseListener{
    private VistaClientes VistaClientes;
    private ModeloClientes ModeloClientes;
    private ConsultasClientes ConsultasClientes = new ConsultasClientes();

    public ControladorVistaClientes(VistaClientes VistaClientes, ModeloClientes ModeloClientes) {
        this.VistaClientes = VistaClientes;
        this.ModeloClientes = ModeloClientes;
        oyentes();
        VistaClientes.setVisible(true);
    }

    private void oyentes() {
        VistaClientes.BtnActualizar.addMouseListener(this);
        VistaClientes.BtnBuscar.addMouseListener(this);
        VistaClientes.BtnEliminar.addMouseListener(this);
        VistaClientes.BtnGuardar.addMouseListener(this);
        VistaClientes.BtnSalir.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaClientes.BtnActualizar) {
            actualizar();
        }else if(e.getSource()==VistaClientes.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaClientes.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaClientes.BtnGuardar) {
            guardar();
        }else if (e.getSource()==VistaClientes.BtnSalir) {
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
        ModeloClientes.setCodigo(Integer.parseInt(VistaClientes.TxtCodigo.getText()));
        ModeloClientes.setNombre(VistaClientes.TxtNombre.getText());
        ModeloClientes.setApellido(VistaClientes.TxtApellido.getText());
        ModeloClientes.setDireccion(VistaClientes.TxtDireccion.getText());
        ModeloClientes.setEmail(VistaClientes.TxtEmail.getText());
        ModeloClientes.setTelefono(VistaClientes.TxtTelefono.getText());
        ModeloClientes.setCURP(VistaClientes.TxtCURP.getText());
        ModeloClientes.setRFC(VistaClientes.TxtRFC.getText());
    }
    
    private void llenarVistaConModelo(){
        VistaClientes.TxtCodigo.setText(ModeloClientes.getCodigo()+"");
        VistaClientes.TxtNombre.setText(ModeloClientes.getNombre());
        VistaClientes.TxtApellido.setText(ModeloClientes.getApellido());
        VistaClientes.TxtDireccion.setText(ModeloClientes.getDireccion());
        VistaClientes.TxtEmail.setText(ModeloClientes.getEmail());
        VistaClientes.TxtTelefono.setText(ModeloClientes.getTelefono());
        VistaClientes.TxtCURP.setText(ModeloClientes.getCURP());
        VistaClientes.TxtRFC.setText(ModeloClientes.getRFC());
        
    }
    
    
    private void limpiarCampos(){
        VistaClientes.TxtCodigo.setText("");
        VistaClientes.TxtNombre.setText("");
        VistaClientes.TxtApellido.setText("");
        VistaClientes.TxtDireccion.setText("");
        VistaClientes.TxtEmail.setText("");
        VistaClientes.TxtTelefono.setText("");
        VistaClientes.TxtCURP.setText("");
        VistaClientes.TxtRFC.setText("");
        VistaClientes.TxtCodigo.requestFocus();
    }
    
    private boolean validarCampoCodigo(){
        if (VistaClientes.TxtCodigo.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    
    private boolean validarTodosLosCampos(){
        if (VistaClientes.TxtCodigo.getText().isEmpty()||
            VistaClientes.TxtNombre.getText().isEmpty()||
            VistaClientes.TxtApellido.getText().isEmpty()||
            VistaClientes.TxtDireccion.getText().isEmpty()||
            VistaClientes.TxtEmail.getText().isEmpty()||
            VistaClientes.TxtTelefono.getText().isEmpty()||
            VistaClientes.TxtCURP.getText().isEmpty()||
            VistaClientes.TxtRFC.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    

    private void actualizar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            
            //Para buscar el dato en Modelo Temporal y no modifique al modelo original
            ModeloClientes ModeloTemporal = new ModeloClientes();
            ModeloTemporal.setCodigo(Integer.parseInt(VistaClientes.TxtCodigo.getText()));
            
            if (ConsultasClientes.buscar(ModeloTemporal)== false) { //Buscar con modelo temporal
                JOptionPane.showMessageDialog(VistaClientes, "Ese producto no existe");
            }else{
                if (ConsultasClientes.modificar(ModeloClientes)) {
                    JOptionPane.showMessageDialog(VistaClientes, "Registro modificado correctamente");
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
            ModeloClientes.setCodigo(Integer.parseInt(VistaClientes.TxtCodigo.getText()));
            if (ConsultasClientes.buscar(ModeloClientes)==true) {
               llenarVistaConModelo();
                
            }else{
                JOptionPane.showMessageDialog(VistaClientes, "Registro no existe");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
        }
    }

    private void eliminar() {
        if (validarCampoCodigo()) {
            ModeloClientes.setCodigo(Integer.parseInt(VistaClientes.TxtCodigo.getText()));
            if (ConsultasClientes.buscar(ModeloClientes)==false) {
                JOptionPane.showMessageDialog(VistaClientes, "Ese proveedor no existe");  
            }else{
                if (ConsultasClientes.eliminar(ModeloClientes)) {
                    JOptionPane.showMessageDialog(VistaClientes, "Registro eliminado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaClientes, "Error al eliminar el registro");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "El campo codigo no debe de estar vacio");
        }
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloClientes.setCodigo(Integer.parseInt(VistaClientes.TxtCodigo.getText()));
            if (ConsultasClientes.buscar(ModeloClientes)==true) {
                JOptionPane.showMessageDialog(VistaClientes, "Ese proveedor ya existe");   
            }else{
                llenarModeloConVista();  
                if (ConsultasClientes.insertar(ModeloClientes)==true) {
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
        int opc = JOptionPane.showConfirmDialog(VistaClientes, "¿Desea salir de proveedores?","Alerta",0,1);
        if (opc == 0) VistaClientes.dispose();    
    } 
    
    
    
    
}
