/*
Aplicación principal
 */
package principal;

// Autor: Adrian Ernesto Germán Becerra.

import controlador.ControladorVistaSplash;
import vista.VistaSplash;


public class AppRelojeria {
    public static void main(String[] args) {
        VistaSplash vistaSplash = new VistaSplash(); //Original
        ControladorVistaSplash CVS = new ControladorVistaSplash(vistaSplash);
        
    }
    
}
