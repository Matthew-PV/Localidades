package dominio;
import java.util.ArrayList;
public class Municipio {
    private String nombre;
    private ArrayList<Localidad> Localidades = new ArrayList<Localidad>();

    public Municipio() {}
    public Municipio(String nombre) {
        this.nombre = nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
    }
    public Municipio(String nombre, ArrayList<Localidad> Localidades) {
        this.nombre = nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
        this.Localidades = Localidades;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Municipio add(Localidad localidad){
        Localidades.add(localidad);
        return this;
    }
    public int habitantesMunicipio() {
        int suma = 0;
        for (Localidad localidad : Localidades) {
            suma += localidad.getNumeroDeHabitantes();
        }
        return suma;
    }
    public String toString() {return nombre;}
    public String info() {
        StringBuilder info = new StringBuilder("Municipio: " + nombre + "\nLocalidades:\n");
        for (Localidad localidad : Localidades) {
            info.append("\t").append(localidad.getNombre()).append('\n');
        }
        info.append("Número total de habitantes: ").append(habitantesMunicipio());
        return info.toString();
    }
}