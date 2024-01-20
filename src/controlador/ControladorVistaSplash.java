/*

 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaSplash;


// Autor: Adrian Ernesto Germán Becerra.

public class ControladorVistaSplash implements MouseListener,MouseMotionListener, MouseWheelListener{
    private VistaSplash VistaSplash; //Apunta al objeto original
    int x,y; //Capturar cordenadad a partir de donde se mueve el objeto

    public ControladorVistaSplash(VistaSplash VistaSplash) { //Vista Original
        this.VistaSplash = VistaSplash;
        VistaSplash.setVisible(true);
        oyentes();
        dormirMatarSplash(5);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) {
            x = e.getX();
            y = e.getY();
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) {
            VistaSplash.LblSplash.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void oyentes() {
        //Oyentes para el mouseListened
        VistaSplash.LblSplash.addMouseListener(this);
        
        //Oyentes para el mouseMotionListened
        VistaSplash.LblSplash.addMouseMotionListener(this);
        
        //Oyente para el mouseWhileListened
        VistaSplash.LblSplash.addMouseWheelListener(this);
    }

    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) {
            VistaSplash.setLocation(VistaSplash.getLocation().x + e.getX() - x, 
                                    VistaSplash.getLocation().y + e.getY() - y);
            
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    private void dormirMatarSplash(int i) {
        try {
            Thread.sleep(i*1000);
            VistaSplash.dispose(); //Mata al JFrame
        } catch (InterruptedException ex) {
            System.out.println("Error: "+ex);
        }finally{ //pase o no pase un error finally significa: Ejecutar lo siguiente
            VistaSplash.dispose(); //Quita la ventana o mata la ventana splash
            
            //Dar paso al login creando la vista y el controlador
            ModeloUsuario ModeloUsuario = new ModeloUsuario();
            VistaLogin VistaLogin = new VistaLogin();
            ControladorVistaLogin CcontroladorVistaLogin = new ControladorVistaLogin(VistaLogin,ModeloUsuario);
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        VistaSplash.dispose(); //Quitalo de la memoria o llama al destructor
    }
    
    
    
    
    
    
    
    
}
