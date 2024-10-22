package dominio;
import java.io.*;
import java.util.ArrayList;
public class Pais {
    private String nombre;
    private ArrayList<Provincia> Provincias = new ArrayList<Provincia>();

    public Pais() {}
    public Pais(String nombre) {
        this.nombre = nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
    }
    public Pais(String nombre, ArrayList<Provincia> Provincias) {
        this.nombre = nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
        this.Provincias = Provincias;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Provincia getProvincia(int index) {
        return Provincias.get(index);
    }
    public Pais add(Provincia provincia){
        Provincias.add(provincia);
        return this;
    }
    public int size() {return Provincias.size();}
    public int habitantesPais(){
        int suma=0;
        for(Provincia provincia : Provincias){
            suma+=provincia.habitantesProvincia();
        }
        return suma;
    }
    public void grabar() {
        try {
            ObjectOutputStream fo = new ObjectOutputStream(new FileOutputStream("pais.ser"));
            fo.writeObject(this);
            fo.close();
        } catch (Exception e) {
            System.out.println("Error de escritura");
        }
    }
    public static Pais leer() {
        try {
            ObjectInputStream fi = new ObjectInputStream(new FileInputStream("pais.ser"));
            Pais p = (Pais) fi.readObject(); //El objeto que lea se convierte a País
            fi.close();
            return p;
        } catch (Exception e) {
            return new Pais(); //Se devuelve un país vacío.
        }
    }
    public String toString(){return nombre;}
    //Escribir el info()
}