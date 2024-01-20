/*

 */
package vista;

//Autor: Adrian Ernesto Germán Becerra.

import interfaces.Colores;
import static interfaces.Colores.PANEL_PRINCIPAL;
import interfaces.Fuentes;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;

import javax.swing.JDialog;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VistaProveedores extends JDialog implements Colores,Fuentes{
    
    JPanel PnlInferior = new JPanel();
    JPanel PnlSuperior = new JPanel();
    
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Recuadros de texto
    public JTextField TxtCodigo = new JTextField(20);
    public JTextField TxtNombre = new JTextField(20);
    public JTextField TxtApellido = new JTextField(20);
    public JTextField TxtDireccion = new JTextField(20);
    public JTextField TxtCiudad = new JTextField(20);
    public JTextField TxtEmail = new JTextField(20);
    public JTextField TxtWeb = new JTextField(20);
    public JTextField TxtTelefono = new JTextField(20);
    public JTextField TxtCelular = new JTextField(20);
    
    //Texto
    public JLabel LblCodigo = new JLabel("Codigo");
    public JLabel LblNombre = new JLabel("Nombre");
    public JLabel LblApellido = new JLabel("Apellido");
    public JLabel LblDireccion = new JLabel("Dirección");
    public JLabel LblCiudad = new JLabel("Ciudad");
    public JLabel LblEmail = new JLabel("E-Mail");
    public JLabel LblWeb = new JLabel("Web");
    public JLabel LblTelefono = new JLabel("Telefono");
    public JLabel LblCelular = new JLabel("Celular");
    public JLabel LblTitulo = new JLabel("Proveedores");
    
    //Botonoes
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");
    

    public VistaProveedores(Frame owner, boolean modal) {
        super(owner, modal);
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Proveedores");
        getContentPane().setBackground(PANEL_SECUNDARIO);
        this.setLayout(new BorderLayout()); //Diseño Libre
        //this.setUndecorated(true);
        //this.setVisible(true);
    }

    private void agregarComponentes() {
        
        //PnlProveedores.setLayout(new GridLayout(1,9));
        
        //getContentPane().add(PnlProveedores, BorderLayout.CENTER);
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
        PnlSuperior.add(LblCodigo, gbc);
        LblCodigo.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCodigo, gbc);
        TxtCodigo.setFont(FUENTE_TEXTFIELDS);
        LblCodigo.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblNombre, gbc);
        LblNombre.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtNombre, gbc);
        TxtNombre.setFont(FUENTE_TEXTFIELDS);
        LblNombre.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblApellido, gbc);
        LblApellido.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtApellido, gbc);
        TxtApellido.setFont(FUENTE_TEXTFIELDS);
        LblApellido.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblDireccion, gbc);
        LblDireccion.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtDireccion, gbc);
        TxtDireccion.setFont(FUENTE_TEXTFIELDS);
        LblDireccion.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblCiudad, gbc);
        LblCiudad.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCiudad, gbc);
        TxtCiudad.setFont(FUENTE_TEXTFIELDS);
        LblCiudad.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblEmail, gbc);
        LblEmail.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtEmail, gbc);
        TxtEmail.setFont(FUENTE_TEXTFIELDS);
        LblEmail.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblWeb, gbc);
        LblWeb.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtWeb, gbc);
        TxtWeb.setFont(FUENTE_TEXTFIELDS);
        LblWeb.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblTelefono, gbc);
        LblTelefono.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtTelefono, gbc);
        TxtTelefono.setFont(FUENTE_TEXTFIELDS);
        LblTelefono.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblCelular, gbc);
        LblCelular.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCelular, gbc);
        TxtCelular.setFont(FUENTE_TEXTFIELDS);
        LblCelular.setForeground(LBL_COLOR);
        
    
        
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
