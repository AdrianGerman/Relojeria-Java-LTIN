/*

 */
package modelo;

//Autor: Adrian Ernesto Germán Becerra.

public class ModeloProveedores {
    private String Nombre,Apellido,Direccion,Ciudad,Email,Web,Telefono,Celular;
    private int codigo;

    public ModeloProveedores() {
    }

    public ModeloProveedores(String Nombre, String Apellido, String Direccion, String Ciudad, String Email, String Web, int codigo, int telefono, int celular) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Ciudad = Ciudad;
        this.Email = Email;
        this.Web = Web;
        this.codigo = codigo;
        this.Telefono = Telefono;
        this.Celular = Celular;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String Web) {
        this.Web = Web;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    

    
    
    
    
}
