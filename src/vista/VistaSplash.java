/*
Imagen de arranque de bienvenida para el proyecto
 */
package vista;

// Autor: Adrian Ernesto Germán Becerra.

import com.sun.awt.AWTUtilities;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VistaSplash extends JFrame{
    //Convertir la imagen a objeto
    ImageIcon ImgSplash = new ImageIcon(getClass().getResource("/imagenes/reloj.gif"));
    public JLabel LblSplash = new JLabel(ImgSplash); //Se incrusta la imagan en la etiqueta

    public VistaSplash() { //Constructor
        configuracion();
        agregarSplash();
        
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ImgSplash.getIconWidth(), ImgSplash.getIconHeight());
        this.setLocationRelativeTo(null);
        
        //Quitar decorado
        this.setUndecorated(true);
        //Quitar el fondo
        AWTUtilities.setWindowOpaque(this, false);
        
        this.setAlwaysOnTop(true);
        
    }

    private void agregarSplash() {
        this.add(LblSplash);
    }
    
    
    
}
