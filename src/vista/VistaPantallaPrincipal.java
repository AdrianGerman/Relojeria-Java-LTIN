package vista;

import interfaces.Colores;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Autor: Adrian Ernesto Germán Becerra

public class VistaPantallaPrincipal extends JFrame implements Colores{
    JPanel PnlBar = new JPanel();
    JPanel PnlSup = new JPanel();
    
    //Convertimos imagenes a objetos
    ImageIcon ImagenProveedor = new ImageIcon(getClass().getResource("/imagenes/proveedor.png"));
    ImageIcon ImagenCliente = new ImageIcon(getClass().getResource("/imagenes/cliente.png"));
    ImageIcon ImagenArticulo = new ImageIcon(getClass().getResource("/imagenes/articulo.png"));
    ImageIcon ImagenUsuario = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
    
    //Convertimos Imagenes a Iconos
    public JLabel LblProveedor = new JLabel(ImagenProveedor);
    public JLabel LblCliente = new JLabel(ImagenCliente);
    public JLabel LblArticulo = new JLabel(ImagenArticulo);
    public JLabel LblUsuario = new JLabel(ImagenUsuario);
    
    public VistaPantallaPrincipal(){
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Relojeria");
        //this.getContentPane().setBackground(new Color(43,43,43));
        this.setLayout(new BorderLayout()); //Diseño Libre
        //this.setExtendedState(MAXIMIZED_BOTH);
        //this.setUndecorated(true);
    }

    private void agregarComponentes() {
        PnlBar.add(LblUsuario);
        
        getContentPane().setBackground(PANEL_PRINCIPAL);
        PnlBar.setLayout(new GridLayout(1,3));
        
        getContentPane().add(PnlBar, BorderLayout.SOUTH);
        PnlBar.setBackground(PANEL_BAR);
        
        PnlBar.add(LblArticulo);
        PnlBar.add(LblProveedor);
        PnlBar.add(LblCliente);
        
        getContentPane().add(PnlSup, BorderLayout.NORTH);
        PnlSup.setBackground(PANEL_BAR);
        PnlSup.setLayout(new GridLayout(1,1));
        
        
    }
}
