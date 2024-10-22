package dominio;
import java.util.ArrayList;
public class Provincia {
    private String nombre;
    private ArrayList<Municipio> Municipios = new ArrayList<Municipio>();

    public Provincia() {}
    public Provincia(String nombre) {
        this.nombre = nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
    }
    public Provincia(String nombre, ArrayList<Municipio> Municipios) {
        this.nombre = nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
        this.Municipios = Municipios;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Provincia add(Municipio municipio){
        Municipios.add(municipio);
        return this;
    }
    public int habitantesProvincia() {
        int suma = 0;
        for (Municipio municipio : Municipios) {
            suma += municipio.habitantesMunicipio();
        }
        return suma;
    }
    public String toString() {return nombre;}
    public String info() {
        StringBuilder info = new StringBuilder("Provincia: " + nombre + "\nMunicipios:\n");
        for (Municipio municipio : Municipios) {
            info.append("\t").append(municipio.getNombre()).append('\n');
        }
        info.append("Número total de habitantes: ").append(habitantesProvincia());
        return info.toString();
    }
}