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
    public void setNombre(String nombre) {this.nombre = nombre;}


    //Trabajo con municipios
    public ArrayList<Municipio> getMunicipios() {return Municipios;}
    public Provincia setMunicipios(ArrayList<Municipio> Municipios) {
        this.Municipios = Municipios;
        return this;
    }
    public Municipio getMunicipio(int index) {
        return Municipios.get(index);
    }
    public Provincia add(Municipio municipio){
        Municipios.add(municipio);
        return this;
    }
    public int size() {return Municipios.size();}
    public void listadoMunicipios() {
        System.out.println("Listado de municipios");
        for (int i = 0 ; i < size() ; i++) {
            System.out.println('\t' + (i + 1) + ". " + getMunicipio(i).getNombre());
        }
    }


    //Métodos de la Provincia
    public int habitantesProvincia() {
        int suma = 0;
        for (Municipio municipio : Municipios) {
            suma += municipio.habitantesMunicipio();
        }
        return suma;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Provincia: ").append(nombre).append("\nMunicipios:\n");
        for (Municipio municipio : Municipios) {
            sb.append('\t').append(municipio.getNombre()).append('\n');
        }
        sb.append("Número total de habitantes: ").append(habitantesProvincia());
        return sb.toString();
    }
}