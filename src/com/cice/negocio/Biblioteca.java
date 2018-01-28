package com.cice.negocio;

import com.cice.modelo.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Biblioteca {

    private ArrayList<Recurso> listaLibros= new ArrayList <>();
    private ArrayList<Multimedia>listaDiscos = new ArrayList<>();

    /**
     * Método showMenu muestra el menú de la aplicación
     */
    public void showMenu() throws ParseException {
        Scanner sc = new Scanner (System.in);
        int opcion = 0;

        do {
            System.out.println("Bienvenido a tu gestion de Poligonos");
            System.out.println("Esto es lo que puedo hacer por ti:");
            System.out.println("1. Crear Libro");
            System.out.println("2. Crear Revista");
            System.out.println("3. Crear Comic");
            System.out.println("4. Crear DVD");
            System.out.println("5. Listado de publicaciones y discos");
            System.out.println("6. Listado de publicaciones y discos prestados");
            System.out.println("7. Prestar un Recurso");
            System.out.println("8. Publicaciones anteriores a una fecha");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            controles (opcion);
        }while (opcion!=0);
        sc.close();
    }

    /**
     * Método controles llama a los distintos métodos de la aplicación
     * @param opcion seleccionada
     */
    private void controles (int opcion) throws ParseException {
        switch (opcion){
            case 0:
                break;
            case 1:
                //crear un Libro
                crearRecurso('l');
                break;
            case 2:
                //crear una Revista
                crearRecurso('r');
                break;
            case 3:
                //crear un Comic
                crearRecurso('c');
                break;
            case 4:
                //crear un Disco
                crearRecurso('d');
                break;
            case 5:
                //mostrar Recursos no Prestados
                mostrarRecursos();
                break;
            case 6:
                //mostrar Recursos Prestados
                mostrarRecursosPrestados();
                break;
            case 7:
                // Prestar un Recurso
                prestarRecurso();
                break;
            case 8:
                //mostrar Publicaciones anteriores a una fecha
                mostrarPublicacionesFecha();
                break;
            default:
                System.out.println("la opcion seleccionada no es valida");
                break;
        }
    }

    /**
     * Método crearRecurso crea un Recurso ya sea Comic, Libro, Revista o Disco
     *
     */
    private void crearRecurso(char tipo) throws ParseException {


        switch (tipo){
            case 'c'://Comic
                this.crearComic();
                break;
            case 'l'://Libro
                this.crearLibro();
                break;
            case 'r'://Revista
                this.crearRevista();
                break;
            case 'd'://Disco
                this.crearDisco();
                break;
            default:
                System.out.println("Opcion erronea...");
                break;

        }
    }

    /**
     * Método crearComic crea un Comic pidiendo sus datos al Usuario
     *
     */
    public void crearComic() throws ParseException {
        Scanner sc = new Scanner (System.in);
        Comic comic;
        boolean bandera = false;
        String fecha;

        comic = new Comic();
        do {
            try {
                System.out.println("Introduzca la fecha de publicacion (DD/MM/AAAA)-->");
                comic.setFecha(sc.nextLine());
                bandera = false;
            } catch (ParseException pex) {
                System.out.println("No es una fecha válida");
                bandera = true;

            }
        }while(bandera);

        do {
            bandera=false;
            System.out.println("Introduzca el titulo del comic-->");
            comic.seTitulo(sc.nextLine());
            if(listaLibros.size()>0)
                for(Recurso recurso : listaLibros)
                    if(recurso instanceof Comic)
                        if(((Comic) recurso).getTitulo().equals(comic.getTitulo())){
                            System.out.println("Ya existe este Comic en el sistema");
                            bandera= true;
                        }

        }while (bandera);
        System.out.println("Introduzca el numero-->");
        comic.setNumero(Integer.parseInt(sc.nextLine()));
        System.out.println("Introduzca la coleccion-->");
        comic.setColeccion(sc.nextLine());
        listaLibros.add(comic);
    }

    /**
     * Método crearComic crea un Libro pidiendo sus datos al Usuario
     *
     */

    public void crearLibro(){
        Scanner sc = new Scanner (System.in);
        Libro libro;
        String autor, isbn, fecha;
        boolean bandera = false;


        libro = new Libro();

        do {
            try {
                System.out.println("Introduzca la fecha de publicacion (DD/MM/AAAA)-->");
                libro.setFecha(sc.nextLine());
                bandera = false;
            } catch (ParseException pex) {
                System.out.println("No es una fecha válida");
                bandera = true;

            }
        }while(bandera);
        System.out.println("Introduzca el titulo del libro-->");
        libro.seTitulo(sc.nextLine());
        do{
            bandera= false;
        System.out.println("Introduzca el ISBN-->");
        libro.setIsbn(sc.nextLine());
        System.out.println("Introduzca el autor-->");
        libro.setAutor(sc.nextLine());
        if(listaLibros.size()>0)
            for(Recurso recurso : listaLibros)
                if(recurso instanceof Libro)
                   if(((Libro) recurso).getIsbn().equals(libro.getIsbn())){
                        System.out.println("Ya existe este libro en el sistema");
                        bandera= true;
                    }
        }while(bandera);
        listaLibros.add(libro);
    }

    /**
     * Método crearRevista crea una Revista pidiendo sus datos al Usuario
     *
     */

    public void crearRevista(){
        Scanner sc = new Scanner (System.in);
        Revista revista;
        boolean bandera = false;
        revista = new Revista();
        String fecha;

        do {
            try {
                System.out.println("Introduzca la fecha de publicacion (DD/MM/AAAA)-->");
                revista.setFecha(sc.nextLine());
                bandera = false;
            } catch (ParseException pex) {
                System.out.println("No es una fecha válida");
                bandera = true;

            }
        }while(bandera);
        do {
            bandera = false;
            System.out.println("Introduzca el titulo de la revista-->");
            revista.seTitulo(sc.nextLine());
            if(listaLibros.size()>0)
                for(Recurso recurso : listaLibros)
                    if(recurso instanceof Revista)
                        if(((Revista) recurso).getTitulo().equals(revista.getTitulo())){
                            System.out.println("Ya existe esta Revista en el sistema");
                            bandera= true;
                        }
        }while (bandera);
        System.out.println("Introduzca el numero-->");
        revista.setNumero(Integer.parseInt(sc.nextLine()));
        System.out.println("Introduzca la periocidad-->");
        revista.setPeriocidad(sc.nextLine());
        listaLibros.add(revista);
    }

    /**
     * Método crearDisco crea un Disco pidiendo sus datos al Usuario
     *
     */
    public void crearDisco(){
        Scanner sc = new Scanner (System.in);
        boolean bandera = false;
        Disco disco = new Disco();

        do {
            bandera = false;
            System.out.println("Introduzca el titulo del Disco->");
            disco.setTitulo(sc.nextLine());
            if(listaDiscos.size()>0)
                for(Multimedia multimedia : listaDiscos)
                    if(multimedia instanceof Disco)
                        if(((Disco)multimedia).getTitulo().equals(disco.getTitulo())){
                            System.out.println("Ya existe este Disco en el sistema");
                            bandera= true;
                        }
        }while (bandera);
        System.out.println("Introduzca la duracion -->");
        disco.setDuracion(sc.nextLine());
        listaDiscos.add(disco);
    }

    /**
     * Método mostrarRecursos muestra los recursos no prestados por pantalla
     *
     */

    public void mostrarRecursos(){
        int i = 1;
        if (listaLibros.size()>0){
            for (Recurso recurso : listaLibros){
                if (recurso.isPrestado() == false)
                System.out.println(i + ") " +recurso.toString());
                i++;
            }
        }
        if (listaDiscos.size()>0){
            for (Multimedia multimedia : listaDiscos){
                if (multimedia.isPrestado() == false)
                System.out.println(i + ") " +multimedia.toString());
                i++;
            }
        }
    }

    /**
     * Método mostrarRecursosPrestados muestra los recursos prestados por pantalla
     *
     */

    public void mostrarRecursosPrestados(){
        int i = 1;
        if (listaLibros.size()>0){
            for (Recurso recurso : listaLibros){
                if (recurso.isPrestado() == true)
                    System.out.println(i + ") " +recurso.toString());
                i++;
            }
        }
        if (listaDiscos.size()>0){
            for (Multimedia multimedia : listaDiscos){
                if (multimedia.isPrestado() == true)
                    System.out.println(i + ") " +multimedia.toString());
                i++;
            }
        }
    }


    /**
     * Método prestarRecurso presta un Recurso a un Usuario de la Biblitoeca
     *
     */


    public void prestarRecurso(){
        IRecurso recurso;
        int opcion;
        Scanner sc = new Scanner (System.in);
        do {
        System.out.println("Seleccione un Recurso");
        this.mostrarRecursos();
        opcion = Integer.parseInt(sc.nextLine());
        opcion--;
        } while (opcion < 0 || opcion > listaLibros.size()+listaDiscos.size());
        if(opcion>listaLibros.size()-1) {
            System.out.println(opcion-listaLibros.size() );
            recurso = listaDiscos.get(opcion-listaLibros.size() );
            System.out.println("Introduzca el ID de un usuario");
            recurso.prestarRecurso(sc.nextLine());
        }
        else
            recurso = listaLibros.get(opcion);
            System.out.println("Introduzca el ID de un usuario");
            recurso.prestarRecurso(sc.nextLine());
    }


    /**
     * Método mostrarPublicacionesFecha() muestra los Recursos anteriores a una fecha dada
     *
     */

    public void mostrarPublicacionesFecha() throws ParseException {
        Scanner sc = new Scanner (System.in);
        boolean bandera = false;
        String fecha;
        Date date;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Libro libro = new Libro();

        do {
            try {
                System.out.println("Introduzca la fecha de publicacion (DD/MM/AAAA)-->");
                fecha = sc.nextLine();
                date = formatter.parse(fecha);
                bandera = false;
                libro.setFecha(fecha);
            } catch (ParseException pex2) {
                System.out.println("No es una fecha válida");
                bandera = true;
            }
        }while(bandera);

        if(listaLibros.size()>0){
            for(Recurso recurso : listaLibros){
               if(libro.getFecha().after(recurso.getFecha()))
                  System.out.println(recurso.toString());
            }
        }





    }
}
