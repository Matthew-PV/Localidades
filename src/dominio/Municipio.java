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
    public void setNombre(String nombre) {this.nombre = nombre;}


    //Trabajo con localidades:
    public ArrayList<Localidad> getLocalidades() {return Localidades;}
    public Municipio setLocalidades(ArrayList<Localidad> Localidades) {
        this.Localidades = Localidades;
        return this;
    }
    public Localidad getLocalidad(int index) {return Localidades.get(index);}
    public Municipio add(Localidad localidad){
        Localidades.add(localidad);
        return this;
    }
    public int size() {return Localidades.size();}
    public void listadoLocalidades() {
        System.out.println("Listado de localidades");
        for (int i = 0 ; i < size() ; i++) {
            System.out.println('\t' + (i + 1) + ". " + getLocalidad(i).getNombre());
        }
    }


    //Métodos del Municipio
    public int habitantesMunicipio() {
        int suma = 0;
        for (Localidad localidad : Localidades) {
            suma += localidad.getNumeroDeHabitantes();
        }
        return suma;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Municipio: ").append(nombre).append("\nLocalidades:\n");
        for (Localidad localidad : Localidades) {
            sb.append('\t').append(localidad.getNombre()).append('\n');
        }
        sb.append("Número total de habitantes: ").append(habitantesMunicipio());
        return sb.toString();
    }
}