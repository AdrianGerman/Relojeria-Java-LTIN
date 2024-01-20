/*
 */
package vista;

//Autor: Adrian Ernesto Germán Becerra.

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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class VistaArticulos extends JDialog implements Colores,Fuentes{
    JPanel PnlInferior = new JPanel();
    JPanel PnlSuperior = new JPanel();
    
    GridBagConstraints gbc = new GridBagConstraints();
    
    //Recuadros de texto
    public JTextField TxtCodigo = new JTextField(20);
    public JTextField TxtNombre = new JTextField(20);
    public JTextField TxtDescripcion = new JTextField(20);
    public JTextField TxtStock = new JTextField(20);
    public JTextField TxtPrecio = new JTextField(20);
    public JTextField TxtCategoria = new JTextField(20);
    public JTextField TxtMaximos = new JTextField(20);
    public JTextField TxtMinimos = new JTextField(20);
    
    //Texto
    public JLabel LblCodigo = new JLabel("Codigo");
    public JLabel LblNombre = new JLabel("Nombre");
    public JLabel LblDescripcion = new JLabel("Descripcion");
    public JLabel LblStock = new JLabel("Stock");
    public JLabel LblPrecio = new JLabel("Precio");
    public JLabel LblCategoria = new JLabel("Categoria");
    public JLabel LblMaximos = new JLabel("Maximos");
    public JLabel LblMinimios = new JLabel("Minimos");
    public JLabel LblTitulo = new JLabel("Articulos");
    
    //Botonoes
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");

    public VistaArticulos(Frame owner, boolean modal) {
        super(owner, modal);
        configuración();
        agregarCompontentes();
    }

    private void configuración() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Proveedores");
        getContentPane().setBackground(PANEL_SECUNDARIO);
        this.setLayout(new BorderLayout()); //Diseño Libre
    }

    private void agregarCompontentes() {
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
        PnlSuperior.add(LblDescripcion, gbc);
        LblDescripcion.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtDescripcion, gbc);
        TxtDescripcion.setFont(FUENTE_TEXTFIELDS);
        LblDescripcion.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblStock, gbc);
        LblStock.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtStock, gbc);
        TxtStock.setFont(FUENTE_TEXTFIELDS);
        LblStock.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblPrecio, gbc);
        LblPrecio.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtPrecio, gbc);
        TxtPrecio.setFont(FUENTE_TEXTFIELDS);
        LblPrecio.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblCategoria, gbc);
        LblCategoria.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCategoria, gbc);
        TxtCategoria.setFont(FUENTE_TEXTFIELDS);
        LblCategoria.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblCategoria, gbc);
        LblCategoria.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtCategoria, gbc);
        TxtCategoria.setFont(FUENTE_TEXTFIELDS);
        LblCategoria.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblMaximos, gbc);
        LblMaximos.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtMaximos, gbc);
        TxtMaximos.setFont(FUENTE_TEXTFIELDS);
        LblMaximos.setForeground(LBL_COLOR);
        
        gbc.gridwidth = 1;
        PnlSuperior.add(LblMinimios, gbc);
        LblMinimios.setFont(FUENTE_LABELS);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        PnlSuperior.add(TxtMinimos, gbc);
        TxtMinimos.setFont(FUENTE_TEXTFIELDS);
        LblMinimios.setForeground(LBL_COLOR);
        

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
