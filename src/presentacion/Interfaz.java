package presentacion;
import dominio.*;
import java.util.*;
public class Interfaz {
    private Pais p = new Pais();
    private Scanner teclado = new Scanner(System.in);
    public Interfaz() {
        p = Pais.leer();
        //implementar
    }
    public String[] leerPeticion() {
        System.out.print("?>");
        String cadena = teclado.nextLine();
        return cadena.split(" ");
    }
    public  boolean procesarPeticion(String[] peticion) {
        if (peticion.length==1)
            if (peticion[0].equalsIgnoreCase("addProvincia"))
                annadirProvincia();
            else if (peticion[0].equalsIgnoreCase("addMunicipio"))
                annadirMunicipio();
            else if (peticion[0].equalsIgnoreCase("addLocalidad"))
                annadirLocalidad();
            else if (peticion[0].equalsIgnoreCase("list"))
                System.out.println(peticion);
            else if (peticion[0].equalsIgnoreCase("read"))
                leer();
            else if (peticion[0].equalsIgnoreCase("exit")) {
                grabar();
            }
            else if (peticion[0].equalsIgnoreCase("help"))
                ayuda();
            else {
                System.out.println("Petición errónea.");
                ayuda();
                return false;//No se procesarán más peticiónes
            }
        else {
            System.out.println("Petición erronea");
            ayuda();
        }
        return true; //En todos los casos debe seguir pidiendo y procesando peticiones
    }
    public static void ayuda() {
        System.out.println("""
                Introduzca una de las siguientes peticiones:
                addProvincia: Añadir una provincia.
                addMunicipio: Añadir un municipio.
                addLocalidad: Añadir una localidad.
                list: Listar el contenido.
                read: Lectura inicial.
                exit: Salir.
                """);
    }
    // Métodos "annadir"

    public  void annadirProvincia() {
        //implementar
        System.out.print("Nombre de la provincia: ");
        String nombre = teclado.nextLine();
        p.add(new Provincia(nombre));
        grabar();
    }
    public  void annadirMunicipio() {
        //implementar
        int numeroP;
        do {
            p.listadoProvincias();
            System.out.print("Número de provincia: ");
            numeroP = teclado.nextInt();
            teclado.nextLine(); //Si no incluímos el nextLine, se guardará una línea vacía.

            if (numeroP <= (p.size()+1)) {
                System.out.print("Nombre del municipio: ");
                String nombre = teclado.nextLine();
                p.getProvincia(numeroP).add(new Municipio(nombre));
            } else {
                System.out.println("Número de provincia incorrecta. Inténtalo de nuevo.");
            }

        } while (numeroP > (p.size()+1));
        grabar();
    }
    public  void annadirLocalidad() {
        //implementar
        int numeroP,numeroM;
        do {

            p.listadoProvincias();
            System.out.print("Número de provincia: ");
            numeroP = teclado.nextInt();
            teclado.nextLine(); //Si no incluímos el nextLine, se guardará una línea vacía.

            if (numeroP <= (p.size() + 1)) {
                do {

                    p.getProvincia(numeroP).listadoMunicipios();
                    System.out.print("Número de provincia: ");
                    numeroM = teclado.nextInt();
                    teclado.nextLine(); //Si no incluímos el nextLine, se guardará una línea vacía.

                    if (numeroM <= (p.getProvincia(numeroP).size() + 1)) {
                        System.out.print("Nombre de la localidad: ");
                        String nombre = teclado.nextLine();
                        System.out.print("Número de habitantes: ");
                        int habitantes = teclado.nextInt();
                        teclado.nextLine();
                        // Creamos la localidad
                        p.getProvincia(numeroP).getMunicipio(numeroM).add(new Localidad(nombre, habitantes));
                    }
                    else {
                        System.out.println("Número de municipio incorrecto. Inténtalo de nuevo.");
                    }

                } while (numeroM > (p.getProvincia(numeroP).size() + 1));
            } else {
                System.out.println("Número de provincia incorrecta. Inténtalo de nuevo.");
            }

        } while (numeroP > (p.size()+1));
        grabar();
    }
    public void grabar() {
        p.grabar();
    }
    public  void leer() {
        String nombreP, nombreM, nombreL;
        do {
            System.out.print("Introduce el nombre de la provincia (<enter> para finalizar): ");
            nombreP= teclado.nextLine();
            if (!nombreP.isEmpty()) {
                Provincia provincia = new Provincia(nombreP);

                do {
                    System.out.print("Introduce el nombre del municipio (<enter> para finalizar): ");
                    nombreM = teclado.nextLine();
                    if (!nombreM.isEmpty()) {
                        Municipio municipio = new Municipio(nombreM);

                        do {
                            System.out.print("Introduce el nombre de la localidad (<enter> para finalizar): ");
                            nombreL= teclado.nextLine();

                            if (!nombreL.isEmpty()){
                                System.out.print("Introduce la población de la localidad: ");
                                int poblacion= teclado.nextInt();
                                teclado.nextLine();
                                Localidad localidad=new Localidad(nombreL,poblacion);
                                municipio.add(localidad);
                            }

                        } while (!nombreL.isEmpty());
                        provincia.add(municipio);

                    }
                } while (!nombreM.isEmpty());
                p.add(provincia);

            }
        }
        while (!nombreP.isEmpty());
    }
}