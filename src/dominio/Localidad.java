package dominio;
public class Localidad {
    private String nombre;
    private int numeroDeHabitantes;

    public Localidad() {}
    public Localidad(String nombre) {
        this.nombre = nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
    }
    public Localidad(String nombre, int numeroDeHabitantes) {
        this.nombre = nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
        //Reescrito de forma que el nombre tenga la primera letra mayúscula :).
        this.numeroDeHabitantes = numeroDeHabitantes;
    }

    public String getNombre() {return nombre;}
    public int getNumeroDeHabitantes() {return numeroDeHabitantes;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setNumeroDeHabitantes(int numeroDeHabitantes) {this.numeroDeHabitantes=numeroDeHabitantes;}

    public String toString() {return nombre;}
    public String info() {
        return "Localidad: "+nombre+"\nHabitantes "+nombre+": "+numeroDeHabitantes;
    }
}