/*

 */
package modelo;

//Autor: Adrian Ernesto Germán Becerra.
public class ModeloArticulos {
    private String Nombre, Descripcion,Stock,Precio,Categoria,Maximos,Minimos;
    private int codigo;

    public ModeloArticulos() {
    }

    public ModeloArticulos(String Nombre, String Descripcion, String Stock, String Precio, String Categoria, String Maximos, String Minimos, int codigo) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Stock = Stock;
        this.Precio = Precio;
        this.Categoria = Categoria;
        this.Maximos = Maximos;
        this.Minimos = Minimos;
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String Stock) {
        this.Stock = Stock;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getMaximos() {
        return Maximos;
    }

    public void setMaximos(String Maximos) {
        this.Maximos = Maximos;
    }

    public String getMinimos() {
        return Minimos;
    }

    public void setMinimos(String Minimos) {
        this.Minimos = Minimos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    
}
