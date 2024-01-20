/*

 */
package controlador;

// Autor: Adrian Ernesto Germán Becerra


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaPantallaPrincipal;


public class ControladorVistaLogin implements MouseListener{
    private VistaLogin VistaLogin;
    ModeloUsuario ModeloUsuario;
    ConsultasUsuario ConsultasUsuario = new ConsultasUsuario();
    
    
    public ControladorVistaLogin(VistaLogin VistaLogin, ModeloUsuario ModeloUsuario) {
        this.VistaLogin = VistaLogin;
        this.ModeloUsuario = ModeloUsuario;
        VistaLogin.setVisible(true);
        oyentes();
    }

    private void oyentes() {
        VistaLogin.LblEyex.addMouseListener(this);
        VistaLogin.LblEye.addMouseListener(this);
        VistaLogin.BtnLogin.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==VistaLogin.LblEyex){
            VistaLogin.LblEyex.setVisible(false);
            VistaLogin.LblEye.setVisible(true);
            VistaLogin.TxtPassword.setEchoChar((char)0);
       }
        if(e.getSource()==VistaLogin.LblEye){
            VistaLogin.LblEye.setVisible(false);
            VistaLogin.LblEyex.setVisible(true);
            VistaLogin.TxtPassword.setEchoChar('•'); //☻
        }
        if (e.getSource()==VistaLogin.BtnLogin) {
            buscarUsuarioPassWord();
            
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

    
    //Función que retorna verdadero si los campos de texto usuario y password.
    public boolean camposValidos (){
        //Checa si estan vacios o no los campos de texto usuarios y password.
        if (VistaLogin.TxtUsuario.getText().isEmpty() || VistaLogin.TxtPassword.getPassword().length==0) 
            return false;
        else
            return true;
    }
    
    private void llenarModeloConCampos(){
        ModeloUsuario.setUsuario(VistaLogin.TxtUsuario.getText());
        ModeloUsuario.setPassword(new String (VistaLogin.TxtPassword.getPassword()));
        ModeloUsuario.setNombre(""); //No se conoce
        ModeloUsuario.setTipo(""); //No se conoce
    }
    
    //Método que hace una busqueda del usuario y password en la base de datos
    private void buscarUsuarioPassWord(){
        if (camposValidos()==true) { //Hay texto en los campos
            llenarModeloConCampos(); //Para que lleve la información que necesita la consulta SQL
            if (ConsultasUsuario.buscarLogin(ModeloUsuario)==true) { //Si encontro al usuario
                //El ModeloUsuario ya lleno sus campos faltantes con la busqueda (nombre, tipo)
                //Ya solo desplegarlos y dar la bienvenida
                JOptionPane.showMessageDialog(null, "Bienvenido: "+ ModeloUsuario.getNombre(),
                        "Tipo: "+ModeloUsuario.getTipo(),1);
                
                
                //Liberar la ventana Login
                VistaLogin.dispose();
                
                //Crear el modelo Vista de la pantalla principal
                VistaPantallaPrincipal vistaPantallaPrincipal = new VistaPantallaPrincipal();
                ControladorVistaPantallaPrincipal ControladorControladorVistaPantallaPrincipal = new
                    ControladorVistaPantallaPrincipal(vistaPantallaPrincipal);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o Password Incorrectos");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debes de colocar texto en los campos"
                                                                 +"Usuario y Password");
        }
    }
    
    
    
}
