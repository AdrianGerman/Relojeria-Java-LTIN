/*

 */
package vista;

// Autor: Adrian Ernesto Germán Becerra

import interfaces.Colores;
import interfaces.Fuentes;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class VistaLogin extends JFrame implements Fuentes,Colores{
    
    //Imagen de fondo
    ImageIcon ImagenFondo = new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
    PanelImagen Panel = new PanelImagen(ImagenFondo);
    
    
    //Iconos
    ImageIcon ImagenLogin = new ImageIcon(getClass().getResource("/imagenes/login.png"));
    ImageIcon ImagenPassword = new ImageIcon(getClass().getResource("/imagenes/password.png"));
    ImageIcon ImagenEye = new ImageIcon(getClass().getResource("/imagenes/eye.png"));
    ImageIcon ImagenEyex = new ImageIcon(getClass().getResource("/imagenes/eyex.png"));
    ImageIcon ImagenIcono = new ImageIcon(getClass().getResource("/imagenes/icon.png"));
    ImageIcon ImagenBtn = new ImageIcon(getClass().getResource("/imagenes/buton.png"));
    
    //Convertimos las imagenes a iconos
    public JLabel LblUsuario = new JLabel(ImagenIcono);
    public JLabel LblLogin = new JLabel(ImagenLogin);
    public JLabel LblPassword = new JLabel(ImagenPassword);
    public JLabel LblEye = new JLabel(ImagenEye);
    public JLabel LblEyex = new JLabel(ImagenEyex);
    
    
    //Barra de texto LOGIN y PASSWORD
    public JTextField TxtUsuario = new JTextField();
    public JPasswordField TxtPassword = new JPasswordField();
    
    //CheckBox
    JCheckBox ChkRecordar = new JCheckBox();
    
    
    //Textos
    JLabel TextoLogin = new JLabel ("Username");
    JLabel TextoPassword = new JLabel("Password");
    JLabel TextoRemember = new JLabel("Recuerdame");
    
    //Boton
    public JButton BtnLogin = new JButton("Login", ImagenBtn);

    public VistaLogin() { 
        configuracion();
        agregarPanelImagen();
        componentes();
  
    }
    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
        this.setResizable(false);   
    }

    private void agregarPanelImagen() {
        this.add(Panel);
        this.setContentPane(Panel);
        this.setLayout(null);
    }
    
    private void componentes() {
        //TextField y Password
        this.add(TxtUsuario);
        this.add(TxtPassword);
        TxtUsuario.setBounds(400,220,200,25);
        TxtPassword.setBounds(400,270,200,25); 
        
        //Iconos
        this.add(LblUsuario);
        LblUsuario.setBounds(442,10,128,128);
        this.add(LblLogin);
        LblLogin.setBounds(360,215,32,32);
        this.add(LblPassword);
        LblPassword.setBounds(360,265,32,32);
        this.add(LblEyex);
        LblEyex.setBounds(600,270,24,24);
        this.add(LblEye);
        LblEye.setBounds(600,270,24,24);
        LblEye.setVisible(false);
        
        
        //Checkbox
        this.add(ChkRecordar);
        ChkRecordar.setBounds(480,310,19,17);
        ChkRecordar.setBackground(PANEL_FONDO);
        
        //Texto
        //login
        this.add(TextoLogin);
        TextoLogin.setBounds(400,190,300,45);
        TextoLogin.setFont(FUENTES_TEXTLOGIN);
        TextoLogin.setForeground(java.awt.Color.black);
        //password
        this.add(TextoPassword);
        TextoPassword.setBounds(400,240,300,45);
        TextoPassword.setFont(FUENTES_TEXTPASSWORD);
        TextoPassword.setForeground(java.awt.Color.black);
        //remember me
        this.add(TextoRemember);
        TextoRemember.setBounds(407, 309, 100, 20);
        TextoRemember.setFont(FUENTES_TEXTREMEMBER);
        TextoRemember.setForeground(java.awt.Color.black);
        //Boton
        this.add(BtnLogin);
        BtnLogin.setBounds(510,310,90,30);
        
        
        
        
        
    }

    

    

    

   

   
    
}
