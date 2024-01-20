/*
 */
package vista;

import interfaces.Colores;
import static interfaces.Colores.BTN_COLOR;
import static interfaces.Colores.LBL_COLOR;
import static interfaces.Colores.PANEL_SECUNDARIO;
import interfaces.Fuentes;
import static interfaces.Fuentes.FUENTE_BOTONES;
import static interfaces.Fuentes.FUENTE_LABELS;
import static interfaces.Fuentes.FUENTE_TEXTFIELDS;
import static interfaces.Fuentes.FUENTE_TITULOS;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


//Autor: Adrian Ernesto Germán Becerra.
public class VistaUsuario extends JDialog implements Colores,Fuentes{
    
    JPanel PnlInferior = new JPanel();
    JPanel PnlSuperior = new JPanel();
    
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Iconos
    ImageIcon ImagenEye = new ImageIcon(getClass().getResource("/imagenes/eye.png"));
    ImageIcon ImagenEyex = new ImageIcon(getClass().getResource("/imagenes/eyex.png"));
    
    //Recuadros de texto
    public JTextField TxtUsuario = new JTextField(20);
    public JPasswordField TxtPassword = new JPasswordField(20);
    public JTextField TxtNombre = new JTextField(20);
    public JTextField TxtTipo = new JTextField(20);
    
    //Texto
    public JLabel LblTitulo = new JLabel("Usuarios");
    public JLabel LblUsuario = new JLabel("Usuario");
    public JLabel LblPassword = new JLabel("Password");
    public JLabel LblNombre = new JLabel("Nombre");
    public JLabel LblTipo = new JLabel("Tipo");
   
    //Botonoes
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");

    public VistaUsuario(Frame owner, boolean modal) {
        super(owner, modal);
        configuracion();
        agregarComponentes();
        
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(550,350);
        this.setLocationRelativeTo(null);
        this.setTitle("Usuario");
        getContentPane().setBackground(PANEL_SECUNDARIO);
        this.setLayout(new BorderLayout()); //Diseño Libre
    }

    private void agregarComponentes() {
        getContentPane().add(PnlInferior, new BorderLayout().SOUTH);
        PnlInferior.setLayout(new FlowLayout());
        PnlInferior.setBackground(PANEL_SEC_INF);
        
        getContentPane().add(PnlSuperior, new BorderLayout().CENTER);
        PnlSuperior.setLayout(new GridBagLayout());
        PnlSuperior.setBackground(PANEL_SECUNDARIO);
                
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.insets=new Insets(0,80,30,0);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        PnlSuperior.add(LblTitulo, gbc);
        LblTitulo.setFont(FUENTE_TITULOS);
        LblTitulo.setForeground(LBL_COLOR);
        
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        gbc.insets=new Insets(0,5,10,0);
        PnlSuperior.add(LblUsuario, gbc);
        LblUsuario.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtUsuario, gbc);
        TxtUsuario.setFont(FUENTE_TEXTFIELDS);
        LblUsuario.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblPassword, gbc);
        LblPassword.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtPassword, gbc);
        TxtPassword.setFont(FUENTE_TEXTFIELDS);
        LblPassword.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblNombre, gbc);
        LblNombre.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtNombre, gbc);
        TxtNombre.setFont(FUENTE_TEXTFIELDS);
        LblNombre.setForeground(LBL_COLOR);

        gbc.gridwidth = 1;
        PnlSuperior.add(LblTipo, gbc);
        LblTipo.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtTipo, gbc);
        TxtTipo.setFont(FUENTE_TEXTFIELDS);
        LblTipo.setForeground(LBL_COLOR);
    
        //Botones
        PnlInferior.add(BtnGuardar);
        BtnGuardar.setFont(FUENTE_BOTONES);
        BtnGuardar.setBackground(BTN_COLOR);
        
        PnlInferior.add(BtnBuscar);
        BtnBuscar.setFont(FUENTE_BOTONES);
        BtnBuscar.setBackground(BTN_COLOR);
        
        PnlInferior.add(BtnActualizar);
        BtnActualizar.setFont(FUENTE_BOTONES);
        BtnActualizar.setBackground(BTN_COLOR);
        
        PnlInferior.add(BtnEliminar);
        BtnEliminar.setFont(FUENTE_BOTONES);
        BtnEliminar.setBackground(BTN_COLOR);
        
        PnlInferior.add(BtnSalir);
        BtnSalir.setFont(FUENTE_BOTONES);
        BtnSalir.setBackground(BTN_COLOR);

    }

    
    
    
    
}
