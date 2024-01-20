/*

 */
package controlador;

//Autor: Adrian Ernesto Germán Becerra.

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProveedores;
import modelo.ModeloProveedores;
import vista.VistaPantallaPrincipal;
import vista.VistaProveedores;


public class ControladorVistaProveedores implements MouseListener{
    private VistaProveedores VistaProveedores;
    private ModeloProveedores ModeloProveedores;
    
    private ConsultasProveedores ConsultasProveedores = new ConsultasProveedores(); //Original

    public ControladorVistaProveedores(VistaProveedores VistaProveedores, ModeloProveedores ModeloProveedores) {
        this.VistaProveedores = VistaProveedores;
        this.ModeloProveedores = ModeloProveedores; 
        oyentes();
        VistaProveedores.setVisible(true);
        
    }

    private void oyentes() {
        VistaProveedores.BtnActualizar.addMouseListener(this);
        VistaProveedores.BtnBuscar.addMouseListener(this);
        VistaProveedores.BtnEliminar.addMouseListener(this);
        VistaProveedores.BtnGuardar.addMouseListener(this);
        VistaProveedores.BtnSalir.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaProveedores.BtnActualizar) {
            actualizar();
        }else if(e.getSource()==VistaProveedores.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaProveedores.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaProveedores.BtnGuardar) {
            guardar();
        }else if (e.getSource()==VistaProveedores.BtnSalir) {
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
        ModeloProveedores.setCodigo(Integer.parseInt(VistaProveedores.TxtCodigo.getText()));
        ModeloProveedores.setNombre(VistaProveedores.TxtNombre.getText());
        ModeloProveedores.setApellido(VistaProveedores.TxtApellido.getText());
        ModeloProveedores.setDireccion(VistaProveedores.TxtDireccion.getText());
        ModeloProveedores.setCiudad(VistaProveedores.TxtCiudad.getText());
        ModeloProveedores.setEmail(VistaProveedores.TxtEmail.getText());
        ModeloProveedores.setWeb(VistaProveedores.TxtWeb.getText());
        ModeloProveedores.setTelefono(VistaProveedores.TxtTelefono.getText());
        ModeloProveedores.setCelular(VistaProveedores.TxtCelular.getText());
    }
    
    private void llenarVistaConModelo(){
        VistaProveedores.TxtCodigo.setText(ModeloProveedores.getCodigo()+"");
        VistaProveedores.TxtNombre.setText(ModeloProveedores.getNombre());
        VistaProveedores.TxtApellido.setText(ModeloProveedores.getApellido());
        VistaProveedores.TxtDireccion.setText(ModeloProveedores.getDireccion());
        VistaProveedores.TxtCiudad.setText(ModeloProveedores.getCiudad());
        VistaProveedores.TxtEmail.setText(ModeloProveedores.getEmail());
        VistaProveedores.TxtWeb.setText(ModeloProveedores.getWeb());
        VistaProveedores.TxtTelefono.setText(ModeloProveedores.getTelefono());
        VistaProveedores.TxtCelular.setText(ModeloProveedores.getCelular());
    }
    
    
    private void limpiarCampos(){
        VistaProveedores.TxtCodigo.setText("");
        VistaProveedores.TxtNombre.setText("");
        VistaProveedores.TxtApellido.setText("");
        VistaProveedores.TxtDireccion.setText("");
        VistaProveedores.TxtCiudad.setText("");
        VistaProveedores.TxtEmail.setText("");
        VistaProveedores.TxtWeb.setText("");
        VistaProveedores.TxtTelefono.setText("");
        VistaProveedores.TxtCelular.setText("");
        VistaProveedores.TxtCodigo.requestFocus();
    }
    
    private boolean validarCampoCodigo(){
        if (VistaProveedores.TxtCodigo.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    
    private boolean validarTodosLosCampos(){
        if (VistaProveedores.TxtCodigo.getText().isEmpty()||
            VistaProveedores.TxtNombre.getText().isEmpty()||
            VistaProveedores.TxtApellido.getText().isEmpty()||   
            VistaProveedores.TxtDireccion.getText().isEmpty()||    
            VistaProveedores.TxtCiudad.getText().isEmpty()||
            VistaProveedores.TxtEmail.getText().isEmpty()||
            VistaProveedores.TxtWeb.getText().isEmpty()||
            VistaProveedores.TxtTelefono.getText().isEmpty()||
            VistaProveedores.TxtCelular.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    

    private void actualizar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            
            //Para buscar el dato en Modelo Temporal y no modifique al modelo original
            ModeloProveedores ModeloTemporal = new ModeloProveedores();
            ModeloTemporal.setCodigo(Integer.parseInt(VistaProveedores.TxtCodigo.getText()));
            
            if (ConsultasProveedores.buscar(ModeloTemporal)== false) { //Buscar con modelo temporal
                JOptionPane.showMessageDialog(VistaProveedores, "Ese producto no existe");
            }else{
                if (ConsultasProveedores.modificar(ModeloProveedores)) {
                    JOptionPane.showMessageDialog(VistaProveedores, "Registro modificado correctamente");
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
            ModeloProveedores.setCodigo(Integer.parseInt(VistaProveedores.TxtCodigo.getText()));
            if (ConsultasProveedores.buscar(ModeloProveedores)==true) {
               llenarVistaConModelo();
                
            }else{
                JOptionPane.showMessageDialog(VistaProveedores, "Registro no existe");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
        }
    }

    private void eliminar() {
        if (validarCampoCodigo()) {
            ModeloProveedores.setCodigo(Integer.parseInt(VistaProveedores.TxtCodigo.getText()));
            if (ConsultasProveedores.buscar(ModeloProveedores)==false) {
                JOptionPane.showMessageDialog(VistaProveedores, "Ese proveedor no existe");  
            }else{
                if (ConsultasProveedores.eliminar(ModeloProveedores)) {
                    JOptionPane.showMessageDialog(VistaProveedores, "Registro eliminado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaProveedores, "Error al eliminar el registro");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "El campo codigo no debe de estar vacio");
        }
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloProveedores.setCodigo(Integer.parseInt(VistaProveedores.TxtCodigo.getText()));
            if (ConsultasProveedores.buscar(ModeloProveedores)==true) {
                JOptionPane.showMessageDialog(VistaProveedores, "Ese proveedor ya existe");   
            }else{
                llenarModeloConVista();  
                if (ConsultasProveedores.insertar(ModeloProveedores)==true) {
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
        int opc = JOptionPane.showConfirmDialog(VistaProveedores, "¿Desea salir de proveedores?","Alerta",0,1);
        if (opc == 0) VistaProveedores.dispose();    
    } 
    
}
