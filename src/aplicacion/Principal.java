/**
 *
 * Matthew Puente-Villegas Michavila
 *
 */
package aplicacion;
import dominio.*;
import presentacion.Interfaz;

import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        boolean ejecucion = interfaz.procesarPeticion(interfaz.leerPeticion());
    }
}