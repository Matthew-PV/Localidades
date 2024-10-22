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
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getNumeroDeHabitantes() {return numeroDeHabitantes;}
    public void setNumeroDeHabitantes(int numeroDeHabitantes) {this.numeroDeHabitantes=numeroDeHabitantes;}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Localidad: ").append(nombre).append("\nHabitantes ").append(nombre).append(": ").append(numeroDeHabitantes);
        return sb.toString();
    }
}