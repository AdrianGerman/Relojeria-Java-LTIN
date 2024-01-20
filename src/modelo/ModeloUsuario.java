/*
Modelo usuario para interactuar entre la vista y el controlador atravez de sus 
metodos getters y setters.
 */
package modelo;


//Autor: Adrian Ernesto Germán Becerra.
public class ModeloUsuario {
    //Atributos
    String Usuario, Password, Nombre, Tipo;

    
    public ModeloUsuario() { //Constructor Vacio
    }

    public ModeloUsuario(String Usuario, String Password, String Nombre, String Tipo) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    } 
}
