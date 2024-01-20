/*
 */
package controlador;

//Autor: Adrian Ernesto Germán Becerra.

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasArticulos;
import modelo.ModeloArticulos;
import modelo.ModeloProveedores;
import vista.VistaArticulos;


public class ControladorVistaArticulos implements MouseListener{
    private ModeloArticulos ModeloArticulos;
    private VistaArticulos VistaArticulos;
    
    private ConsultasArticulos ConsultasArticulos = new ConsultasArticulos(); //Original

    public ControladorVistaArticulos(ModeloArticulos ModeloArticulos, VistaArticulos VistaArticulos) {
        this.ModeloArticulos = ModeloArticulos;
        this.VistaArticulos = VistaArticulos;
        oyentes();
        VistaArticulos.setVisible(true);
    }

    private void oyentes() {
        VistaArticulos.BtnActualizar.addMouseListener(this);
        VistaArticulos.BtnBuscar.addMouseListener(this);
        VistaArticulos.BtnEliminar.addMouseListener(this);
        VistaArticulos.BtnGuardar.addMouseListener(this);
        VistaArticulos.BtnSalir.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaArticulos.BtnActualizar) {
            actualizar();
        }else if(e.getSource()==VistaArticulos.BtnBuscar) {
            buscar();
        }else if (e.getSource()==VistaArticulos.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==VistaArticulos.BtnGuardar) {
            guardar();
        }else if (e.getSource()==VistaArticulos.BtnSalir) {
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
        ModeloArticulos.setCodigo(Integer.parseInt(VistaArticulos.TxtCodigo.getText()));
        ModeloArticulos.setNombre(VistaArticulos.TxtNombre.getText());
        ModeloArticulos.setDescripcion(VistaArticulos.TxtDescripcion.getText());
        ModeloArticulos.setStock(VistaArticulos.TxtStock.getText());
        ModeloArticulos.setPrecio(VistaArticulos.TxtPrecio.getText());
        ModeloArticulos.setCategoria(VistaArticulos.TxtCategoria.getText());
        ModeloArticulos.setMaximos(VistaArticulos.TxtMaximos.getText());
        ModeloArticulos.setMinimos(VistaArticulos.TxtMinimos.getText());
     
    }
    
    private void llenarVistaConModelo(){
        VistaArticulos.TxtCodigo.setText(ModeloArticulos.getCodigo()+"");
        VistaArticulos.TxtNombre.setText(ModeloArticulos.getNombre());
        VistaArticulos.TxtDescripcion.setText(ModeloArticulos.getDescripcion());
        VistaArticulos.TxtStock.setText(ModeloArticulos.getStock());
        VistaArticulos.TxtPrecio.setText(ModeloArticulos.getPrecio());
        VistaArticulos.TxtCategoria.setText(ModeloArticulos.getCategoria());
        VistaArticulos.TxtMaximos.setText(ModeloArticulos.getMaximos());
        VistaArticulos.TxtMinimos.setText(ModeloArticulos.getMinimos());
    }
    
    
    private void limpiarCampos(){
        VistaArticulos.TxtCodigo.setText("");
        VistaArticulos.TxtNombre.setText("");
        VistaArticulos.TxtDescripcion.setText("");
        VistaArticulos.TxtStock.setText("");
        VistaArticulos.TxtPrecio.setText("");
        VistaArticulos.TxtCategoria.setText("");
        VistaArticulos.TxtMaximos.setText("");
        VistaArticulos.TxtMinimos.setText("");
        VistaArticulos.TxtCodigo.requestFocus();
    }
    
    private boolean validarCampoCodigo(){
        if (VistaArticulos.TxtCodigo.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    
    private boolean validarTodosLosCampos(){
        if (VistaArticulos.TxtCodigo.getText().isEmpty()||
            VistaArticulos.TxtNombre.getText().isEmpty()||
            VistaArticulos.TxtDescripcion.getText().isEmpty()||   
            VistaArticulos.TxtStock.getText().isEmpty()||    
            VistaArticulos.TxtPrecio.getText().isEmpty()||
            VistaArticulos.TxtCategoria.getText().isEmpty()||
            VistaArticulos.TxtMaximos.getText().isEmpty()||
            VistaArticulos.TxtMinimos.getText().isEmpty())
            return false;
        else
            return true;
    }
    

    private void actualizar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            
            //Para buscar el dato en Modelo Temporal y no modifique al modelo original
            ModeloArticulos ModeloTemporal = new ModeloArticulos();
            ModeloTemporal.setCodigo(Integer.parseInt(VistaArticulos.TxtCodigo.getText()));
            
            if (ConsultasArticulos.buscar(ModeloTemporal)== false) { //Buscar con modelo temporal
                JOptionPane.showMessageDialog(VistaArticulos, "Ese producto no existe");
            }else{
                if (ConsultasArticulos.modificar(ModeloArticulos)) {
                    JOptionPane.showMessageDialog(VistaArticulos, "Registro modificado correctamente");
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
            ModeloArticulos.setCodigo(Integer.parseInt(VistaArticulos.TxtCodigo.getText()));
            if (ConsultasArticulos.buscar(ModeloArticulos)==true) {
               llenarVistaConModelo();
                
            }else{
                JOptionPane.showMessageDialog(VistaArticulos, "Registro no existe");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
        }
    }

    private void eliminar() {
        if (validarCampoCodigo()) {
            ModeloArticulos.setCodigo(Integer.parseInt(VistaArticulos.TxtCodigo.getText()));
            if (ConsultasArticulos.buscar(ModeloArticulos)==false) {
                JOptionPane.showMessageDialog(VistaArticulos, "Ese proveedor no existe");  
            }else{
                if (ConsultasArticulos.eliminar(ModeloArticulos)) {
                    JOptionPane.showMessageDialog(VistaArticulos, "Registro eliminado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaArticulos, "Error al eliminar el registro");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "El campo codigo no debe de estar vacio");
        }
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloArticulos.setCodigo(Integer.parseInt(VistaArticulos.TxtCodigo.getText()));
            if (ConsultasArticulos.buscar(ModeloArticulos)==true) {
                JOptionPane.showMessageDialog(VistaArticulos, "Ese proveedor ya existe");   
            }else{
                llenarModeloConVista();  
                if (ConsultasArticulos.insertar(ModeloArticulos)==true) {
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
        int opc = JOptionPane.showConfirmDialog(VistaArticulos, "¿Desea salir de proveedores?","Alerta",0,1);
        if (opc == 0) VistaArticulos.dispose();    
    } 
    
    
    
    
    
    
}
