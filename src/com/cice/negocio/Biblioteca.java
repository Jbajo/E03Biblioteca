package com.cice.negocio;

import com.cice.modelo.Clases.*;
import com.cice.modelo.Enums.EnumPrestable;
import com.cice.modelo.Interfaces.IRecurso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Biblioteca {

    private ArrayList<IRecurso> listaRecursos= new ArrayList <>();  


    /**
     * Método showMenu muestra el menú de la aplicación
     */
    public void showMenu() throws ParseException {
        Scanner sc = new Scanner (System.in);
        int opcion;

        do {
            System.out.println("Bienvenido a tu Biblioteca");
            System.out.println("Esto es lo que puedo hacer por ti:");
            System.out.println("1. Crear Libro");
            System.out.println("2. Crear Revista");
            System.out.println("3. Crear Comic");
            System.out.println("4. Crear DVD");
            System.out.println("5. Listado de publicaciones y discos");
            System.out.println("6. Listado de publicaciones y discos prestados");
            System.out.println("7. Prestar un Recurso");
            System.out.println("8. Devolver un Recurso");
            System.out.println("9. Publicaciones anteriores a una fecha");
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
                // Devolver un Recurso
                devolverRecurso();
                break;
            case 9:
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
    private void crearRecurso(char tipo){


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
     * Método crearComic crea un Comic pidiendo sus datos al Usuario y lo introduce en la listaRecursos
     *
     */
    public void crearComic()  {
        Scanner sc = new Scanner (System.in);
        Comic comic;
        boolean bandera;

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
            if(listaRecursos.size()>0)
                for(IRecurso recurso : listaRecursos)
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
        listaRecursos.add(comic);
    }

    /**
     * Método crearComic crea un Libro pidiendo sus datos al Usuario y lo introduce en la listaRecursos
     *
     */

    public void crearLibro(){
        Scanner sc = new Scanner (System.in);
        Libro libro;
        String autor = "KenFollett";
        String isbn = "ISBN: 1234567891123";
        boolean bandera;


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
            do {
                if(!isbn.matches("\\bISBN[^A-Z0-9]*+(\\d(?:-*+\\d){12})"))
                    System.out.println("ISBN ERRONEO...");
                System.out.println("Introduzca el ISBN-->");
                isbn = sc.nextLine();
            }while (!isbn.matches("\\bISBN[^A-Z0-9]*+(\\d(?:-*+\\d){12})"));
           libro.setIsbn(isbn);
        do {
            if(!autor.matches("^[a-zA-Z ]*$"))
                System.out.println("Opcion erronea");
            System.out.println("Introduzca el autor-->");
            autor = sc.nextLine();
        }while(!autor.matches("^[a-zA-Z ]*$"));
        libro.setAutor(autor);
        if(listaRecursos.size()>0)
            for(IRecurso recurso : listaRecursos)
                if(recurso instanceof Libro)
                   if(((Libro) recurso).getIsbn().equals(libro.getIsbn())){
                        System.out.println("Ya existe este libro en el sistema");
                        bandera= true;
                    }
        }while(bandera);
        listaRecursos.add(libro);
    }

    /**
     * Método crearRevista crea una Revista pidiendo sus datos al Usuario y la introduce en la listaRecursos
     *
     */

    public void crearRevista(){
        Scanner sc = new Scanner (System.in);
        Revista revista;
        boolean bandera;
        revista = new Revista();


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
            if(listaRecursos.size()>0)
                for(IRecurso recurso : listaRecursos)
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
        listaRecursos.add(revista);
    }

    /**
     * Método crearDisco crea un Disco pidiendo sus datos al Usuario y lo introduce en la listaRecursos
     *
     */
    public void crearDisco(){
        Scanner sc = new Scanner (System.in);
        boolean bandera;
        Disco disco = new Disco();

        do {
            bandera = false;
            System.out.println("Introduzca el titulo del Disco->");
            disco.setTitulo(sc.nextLine());
            if(listaRecursos.size()>0)
                for(IRecurso multimedia : listaRecursos)
                    if(multimedia instanceof Disco)
                        if(((Disco)multimedia).getTitulo().equals(disco.getTitulo())){
                            System.out.println("Ya existe este Disco en el sistema");
                            bandera= true;
                        }
        }while (bandera);
        System.out.println("Introduzca la duracion -->");
        disco.setDuracion(sc.nextLine());
        listaRecursos.add(disco);
    }

    /**
     * Método mostrarRecursos muestra los recursos no prestados por pantalla recorriendo la listaRecursos
     * invirtiendo la lista para que aparezcan primero los recursos no prestados
     *
     */

    public void mostrarRecursos(){
        int i = 1;
        int j = 0;
        //Reordenamos las listas para mostrarlas correctamente
        if(listaRecursos.size()>0)
            for (IRecurso recurso : listaRecursos) {
                if (recurso.isPrestado() == 1 && !listaRecursos.get(0).equals(recurso) && j == 0)
                    Collections.reverse(listaRecursos);
                j++;
            }
        if (listaRecursos.size()>0){
            for (IRecurso recurso : listaRecursos){
                if(recurso.isPrestado() == 0) {
                    System.out.println(i + ") " + recurso.toString());
                    i++;
                }
            }
        }
    }

    /**
     * Método mostrarRecursosPrestados muestra los recursos prestados por pantalla
     * invirtiendo la lista para que aparezcan primero los recursos prestados
     *
     */

    public void mostrarRecursosPrestados(){
        int i = 1;
        int j =0;

        //Reordenamos las listas para mostrarlas correctamente
        if(listaRecursos.size()>0)
        for (IRecurso recurso : listaRecursos) {
            if (recurso.isPrestado() == 1 && !listaRecursos.get(0).equals(recurso) && j == listaRecursos.size() - 1)
                Collections.reverse(listaRecursos);
            j++;
        }
        if (listaRecursos.size()>0){
            for (IRecurso recurso : listaRecursos){
                    if(recurso.isPrestado() == 1) {
                        System.out.println(i + ") " + recurso.toString());

                    }
                i++;
            }
        }
       
    }


    /**
     * Método prestarRecurso presta un Recurso a un Usuario de la Biblitoeca
     * y reordena la listaRecursos a partir del campo prestado
     */
    public void prestarRecurso() {
        IRecurso recurso;
        int opcion;
        String id = "";
        boolean bandera = false;

        Scanner sc = new Scanner(System.in);
        if (listaRecursos.size() > 0) {
               do {
                   do {

                       System.out.println("Seleccione un Recurso");
                       this.mostrarRecursos();
                       opcion = Integer.parseInt(sc.nextLine());
                       opcion--;
                   } while (opcion < 0 || opcion > listaRecursos.size());
                   if(listaRecursos.get(opcion).getPrestable().equals(EnumPrestable.NOPRESTABLE))
                       System.out.println("Opcion no valida...");
                   System.out.println(opcion);
               }while (listaRecursos.get(opcion).getPrestable().equals(EnumPrestable.NOPRESTABLE));
                   recurso = listaRecursos.get(opcion);
                   System.out.println("Introduzca el ID de un usuario");
                   recurso.prestarRecurso(sc.nextLine());
                   Collections.sort(listaRecursos);
        }
    }

    /**
     * Método devolverRecurso devuelve un Recurso que tiene un Usuario a la Biblitoeca
     ** y reordena la listaRecursos a partir del campo prestado
     */
    public void devolverRecurso(){
        IRecurso recurso;
        int opcion;
        String id="";
        boolean bandera = false;

        Scanner sc = new Scanner (System.in);
        if(listaRecursos.size()>0) {
            for (IRecurso recursoaux : listaRecursos) {
                if (recursoaux.isPrestado() == 1)
                    bandera = true;
            }            
        }
        else
            bandera= false;
        if(bandera) {
            do {

                System.out.println("Seleccione un Recurso a devolver");
                this.mostrarRecursosPrestados();
                opcion = Integer.parseInt(sc.nextLine());
                opcion--;
            } while (opcion < 0 || opcion > listaRecursos.size());
                recurso = listaRecursos.get(opcion);
                recurso.devuelveRecurso();
                Collections.sort(listaRecursos);
        }

    }


    /**
     * Método mostrarPublicacionesFecha() muestra los Recursos anteriores a una fecha dada
     *
     */

    public void mostrarPublicacionesFecha() throws ParseException{
        Scanner sc = new Scanner (System.in);
        boolean bandera;
        String fecha;
        Date date;

        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        Libro libro = new Libro();

        do {
            try {
                System.out.println("Introduzca la fecha de publicacion (DD/MM/AAAA)-->");
                fecha = sc.nextLine();
                date = parser.parse(fecha);
                bandera = false;
                libro.setFecha(fecha);
            } catch (ParseException pex2) {
                System.out.println("No es una fecha válida");
                bandera = true;
            }
        }while(bandera);
        if(listaRecursos.size()>0){
            for(IRecurso recurso : listaRecursos){
                if(recurso instanceof Libro)
               if(libro.getFecha().after(recurso.getFecha()))
                  System.out.println(recurso.toString());
            }
        }
    }
}
