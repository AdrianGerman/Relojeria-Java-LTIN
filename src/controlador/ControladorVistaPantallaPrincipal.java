/*

 */
package controlador;

// Autor: Adrian Ernesto Germán Becerra

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import modelo.ModeloArticulos;
import modelo.ModeloClientes;
import modelo.ModeloProveedores;
import modelo.ModeloUsuario;
import vista.VistaArticulos;
import vista.VistaClientes;
import vista.VistaPantallaPrincipal;
import vista.VistaProveedores;
import vista.VistaUsuario;


public class ControladorVistaPantallaPrincipal implements MouseListener{
    private VistaPantallaPrincipal vistaPantallaPrincipal;
    VistaProveedores VistaProveedores;
    ModeloProveedores ModeloProveedores;
    

    ControladorVistaPantallaPrincipal(VistaPantallaPrincipal vistaPantallaPrincipal) {
        this.vistaPantallaPrincipal = vistaPantallaPrincipal;
        this.vistaPantallaPrincipal.setVisible(true);
        oyentes();
    }

    private void oyentes() {
        //System.out.println("oyentes pantalla pricnipal");
        vistaPantallaPrincipal.LblArticulo.addMouseListener(this);
        vistaPantallaPrincipal.LblCliente.addMouseListener(this);
        vistaPantallaPrincipal.LblProveedor.addMouseListener(this);
        vistaPantallaPrincipal.LblUsuario.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==vistaPantallaPrincipal.LblProveedor) {
            ModeloProveedores ModeloProveedores = new ModeloProveedores();
            VistaProveedores VistaProveedores = new VistaProveedores(new JFrame(), true);
            ControladorVistaProveedores ControladorVistaProveedores = new ControladorVistaProveedores(VistaProveedores, ModeloProveedores);
        }
        if (e.getSource()==vistaPantallaPrincipal.LblUsuario) {
            ModeloUsuario ModeloUsuario = new ModeloUsuario();
            VistaUsuario VistaUsuario = new VistaUsuario(new JFrame(), true);
            ControladorVistaUsuario ControladorVistaUsuario = new ControladorVistaUsuario(ModeloUsuario, VistaUsuario);  
        }
        if (e.getSource()==vistaPantallaPrincipal.LblCliente) {
            ModeloClientes ModeloClientes = new ModeloClientes();
            VistaClientes VistaClientes = new VistaClientes(new JFrame(), true);
            ControladorVistaClientes ControladorVistaClientes = new ControladorVistaClientes(VistaClientes, ModeloClientes); 
        }
        if (e.getSource()==vistaPantallaPrincipal.LblArticulo) {
            ModeloArticulos ModeloArticulos = new ModeloArticulos();
            VistaArticulos VistaArticulos = new VistaArticulos(new JFrame(), true);
            ControladorVistaArticulos ControladorVistaArticulos = new ControladorVistaArticulos(ModeloArticulos, VistaArticulos);
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
        if(e.getSource()==vistaPantallaPrincipal.LblArticulo){
            vistaPantallaPrincipal.LblArticulo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            vistaPantallaPrincipal.LblArticulo.setToolTipText("Articulos");
        }
        if(e.getSource()==vistaPantallaPrincipal.LblCliente){
            vistaPantallaPrincipal.LblCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            vistaPantallaPrincipal.LblCliente.setToolTipText("Clientes");
        }
        if(e.getSource()==vistaPantallaPrincipal.LblProveedor){
            vistaPantallaPrincipal.LblProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            vistaPantallaPrincipal.LblProveedor.setToolTipText("Proveedores");
        }
        if(e.getSource()==vistaPantallaPrincipal.LblUsuario){
            vistaPantallaPrincipal.LblUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            vistaPantallaPrincipal.LblUsuario.setToolTipText("Usuarios");
        }
        
        
        

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
