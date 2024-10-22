package aplicacion;
import dominio.*;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        //1) Comprobación clase localidad:
        System.out.println("Crearemos una localidad y la mostraremos por pantalla.");
        Localidad GuadalajaraL /*L de Localidad*/ = new Localidad("guadalajara",91000);
        System.out.println(GuadalajaraL.info());


        //2) Comprobación clase municipio:
        System.out.println("\nAhora crearemos un municipio al que añadiremos Guadalajara y otra localidad.");
        ArrayList<Localidad> MunicipioGuadalajara = new ArrayList<>();
        MunicipioGuadalajara.add(GuadalajaraL);

        //2.1) Creamos y añadimos otra localidad
        Localidad Iriepal = new Localidad("Iriepal",1000);
        MunicipioGuadalajara.add(Iriepal);

        //2.2) Ahora creamos el municipio
        Municipio GuadalajaraM /*M de Municipio*/ = new Municipio("Guadalajara",MunicipioGuadalajara);
        System.out.println(GuadalajaraM.info());


        //3) Comprobación clase provincia:
        System.out.println("\nAhora crearemos una provincia a la que añadir municipios.");

        //3.1) Creamos una nueva localidad que añadir al nuevo municipio
        Localidad MarchamaloL = new Localidad("Marchamalo", 8000);
        ArrayList<Localidad> MunicipioMarchamalo = new ArrayList<>();
        MunicipioMarchamalo.add(MarchamaloL);

        //3.2) Creamos y añadimos el nuevo municipio
        Municipio MarchamaloM = new Municipio("marchamalo", MunicipioMarchamalo);
        ArrayList<Municipio> ProvinciaGuadalajara = new ArrayList<>();
        System.out.println("Nuevo "+MarchamaloM.info().toLowerCase().charAt(0)+
                MarchamaloM.info().substring(1)+'\n');
        ProvinciaGuadalajara.add(GuadalajaraM); ProvinciaGuadalajara.add(MarchamaloM);

        //3.3) Ahora creamos la provincia
        Provincia GuadalajaraP /*P de Provincia*/ = new Provincia("Guadalajara",ProvinciaGuadalajara);
        System.out.println(GuadalajaraP.info());
    }
}