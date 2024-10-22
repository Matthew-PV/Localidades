package presentacion;
import dominio.*;
import java.util.*;
public class Interfaz {
    private Pais p = new Pais();
    private  Scanner teclado = new Scanner(System.in);
    public Interfaz(){
        p = Pais.leer();
        //implementar
    }

    public void grabar(){
        //implementar
        p.grabar();
    }
    public static void ayuda(){
        System.out.println("introduzca ua de las siguientes peticiones: \n addProvindia: añadir provincia\n addMunicipio: añadir Municipio\n addLocalidad: añadir Localidad\n list: listar el contenido\n read: lectura inicial\n exit: salir\n");

    }
    public  boolean procesarPeticion (String [] p){
        if (p.length==1)
            if 	(p[0].equals("addProvincia"))
                annadirProvincia();
            else if (p[0].equals("addMunicipio"))
                annadirMunicipio();
            else if (p[0].equals("addLocalidad"))
                annadirLocalidad();
            else if (p[0].equals("read"))
                leer();
            else if (p[0].equals("list"))
                System.out.println (p);
            else if (p[0].equals("help"))
                ayuda();
            else if (p[0].equals("exit")){
                grabar();
                return false;//no se procesarán más peticiónes
            }
            else {
                System.out.println("petición erronea");
                ayuda();
            }
        else {
            System.out.println("petición erronea");
            ayuda();
        }
        return true;//en todos los casos debe seguir pidiendo y procesando peticiones
    }
    public  void annadirProvincia(){
        //implementar
        System.out.print("Nombre de la provincia: ");
        String nombre = teclado.nextLine();
        p.add(new Provincia(nombre)); //Crear el add
    }

    public  void annadirMunicipio(){
        //implementar
        System.out.println("Listado de provincias");
        for (int i=0 ; i<p.size() ; i++) {
            System.out.println('\t'+(i+1)+". "+p.getProvincia(i));
        }
        System.out.print("Número de provincia: ");
        int i = teclado.nextInt();
        teclado.nextLine(); //Si no incluímos el nextLine, se guardará una línea vacía.
        System.out.print("Nombre del municipio: ");
        String nombre = teclado.nextLine();
        p.getProvincia(i).add(new Municipio(nombre));
    }

    public  void annadirLocalidad(){
        //implementar
    }
    public String [] leerPeticion(){
        System.out.print("?>");
        String cadena = teclado.nextLine();
        return cadena.split(" ");
    }

    public  void leer(){
        String nombreP, nombreM, nombreL;
        do {
            System.out.print("Introduce el nombre de la provincia (<enter> para finalizar: ");
            nombreP= teclado.nextLine();
            if(!nombreP.equals("")){
                Provincia provincia=new Provincia(nombreP);
                do {
                    System.out.print("Introduce el nombre del municipio (<enter> para finalizar: ");
                    nombreM= teclado.nextLine();
                    if(!nombreM.equals("")){
                        Municipio municipio=new Municipio(nombreM);
                        do {
                            System.out.print("Introduce el nombre de la localidad (<enter> para finalizar: ");
                            nombreL= teclado.nextLine();
                            if(!nombreL.equals("")){
                                System.out.print("Introduce la población de la localidad: ");
                                int poblacion= teclado.nextInt();
                                teclado.nextLine();
                                Localidad localidad=new Localidad(nombreL,poblacion);
                                municipio.add(localidad);
                            }
                        } while (!nombreL.equals(""));
                        provincia.add(municipio);
                    }
                } while (!nombreM.equals(""));
                p.add(provincia);
            }
        }
        while (!nombreP.equals(""));

    }

}
