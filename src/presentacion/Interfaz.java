package presentacion;
import dominio.*;
import java.util.*;
public class Interfaz {
<<<<<<< HEAD
    private Pais pais = new Pais();
    private final Scanner teclado = new Scanner(System.in);
    public Interfaz() {
        pais = Pais.leer();
        procesarPeticion(leerPeticion());
=======
    private Pais P = new Pais();
    private Scanner teclado = new Scanner(System.in);
    public Interfaz() {
        P = Pais.leer();
        //implementar
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
    }


    //Métodos del interfaz
    public String[] leerPeticion() {
        System.out.print("Introduzca su petición: ");
        String cadena = teclado.nextLine();
        return cadena.split(" ");
    }
    public boolean procesarPeticion(String[] peticion) {
        if (peticion.length==1)
            if (peticion[0].equalsIgnoreCase("addProvincia"))
                annadirProvincia();
            else if (peticion[0].equalsIgnoreCase("addMunicipio"))
                annadirMunicipio();
            else if (peticion[0].equalsIgnoreCase("addLocalidad"))
                annadirLocalidad();
            else if (peticion[0].equalsIgnoreCase("list"))
                System.out.println(P);
            else if (peticion[0].equalsIgnoreCase("read"))
                leer();
            else if (peticion[0].equalsIgnoreCase("exit")) {
                grabar();
                return false;
            }
            else if (peticion[0].equalsIgnoreCase("ayuda"))
                ayuda();
            else {
                System.out.println("Petición errónea.\n");
                ayuda();
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
    public void annadirProvincia() {
        System.out.print("Nombre de la provincia: ");
        String nombre = teclado.nextLine();
<<<<<<< HEAD
        pais.add(new Provincia(nombre));
=======
        P.add(new Provincia(nombre));
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
        grabar();
    }
    public void annadirMunicipio() {
        int numeroP;
        do {
<<<<<<< HEAD
            pais.listadoProvincias();
=======
            P.listadoProvincias();
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
            System.out.print("Número de provincia: ");
            numeroP = teclado.nextInt();
            teclado.nextLine(); //Si no incluímos el nextLine, se guardará una línea vacía.

<<<<<<< HEAD
            if (numeroP <= (pais.size()+1)) {
                System.out.print("Nombre del municipio: ");
                String nombre = teclado.nextLine();
                pais.getProvincia(numeroP).add(new Municipio(nombre));
=======
            if (numeroP <= (P.size()+1)) {
                System.out.print("Nombre del municipio: ");
                String nombre = teclado.nextLine();
                P.getProvincia(numeroP).add(new Municipio(nombre));
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
            } else {
                System.out.println("Número de provincia incorrecta. Inténtalo de nuevo.");
            }

<<<<<<< HEAD
        } while (numeroP > (pais.size()+1));
=======
        } while (numeroP > (P.size()+1));
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
        grabar();
    }
    public void annadirLocalidad() {
        int numeroP,numeroM;
        do {

<<<<<<< HEAD
            pais.listadoProvincias();
=======
            P.listadoProvincias();
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
            System.out.print("Número de provincia: ");
            numeroP = teclado.nextInt();
            teclado.nextLine(); //Si no incluímos el nextLine, se guardará una línea vacía.

<<<<<<< HEAD
            if (numeroP <= (pais.size() + 1)) {
                do {

                    pais.getProvincia(numeroP).listadoMunicipios();
=======
            if (numeroP <= (P.size() + 1)) {
                do {

                    P.getProvincia(numeroP).listadoMunicipios();
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
                    System.out.print("Número de provincia: ");
                    numeroM = teclado.nextInt();
                    teclado.nextLine(); //Si no incluímos el nextLine, se guardará una línea vacía.

<<<<<<< HEAD
                    if (numeroM <= (pais.getProvincia(numeroP).size() + 1)) {
=======
                    if (numeroM <= (P.getProvincia(numeroP).size() + 1)) {
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
                        System.out.print("Nombre de la localidad: ");
                        String nombre = teclado.nextLine();
                        System.out.print("Número de habitantes: ");
                        int habitantes = teclado.nextInt();
                        teclado.nextLine();
                        // Creamos la localidad
<<<<<<< HEAD
                        pais.getProvincia(numeroP).getMunicipio(numeroM).add(new Localidad(nombre, habitantes));
=======
                        P.getProvincia(numeroP).getMunicipio(numeroM).add(new Localidad(nombre, habitantes));
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
                    }
                    else {
                        System.out.println("Número de municipio incorrecto. Inténtalo de nuevo.");
                    }

<<<<<<< HEAD
                } while (numeroM > (pais.getProvincia(numeroP).size() + 1));
=======
                } while (numeroM > (P.getProvincia(numeroP).size() + 1));
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
            } else {
                System.out.println("Número de provincia incorrecta. Inténtalo de nuevo.");
            }

<<<<<<< HEAD
        } while (numeroP > (pais.size()+1));
        grabar();
    }
    public void grabar() {
        pais.grabar();
=======
        } while (numeroP > (P.size()+1));
        grabar();
    }
    public void grabar() {
        P.grabar();
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e
    }
    public void leer() {
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
<<<<<<< HEAD
                pais.add(provincia);
=======
                P.add(provincia);
>>>>>>> a750c7c7e9f6d5043ca2d735dd7a297c83a9cc8e

            }
        }
        while (!nombreP.isEmpty());
    }
}