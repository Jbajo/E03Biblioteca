package com.cice.modelo.Interfaces;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public interface IRecurso {
    void prestarRecurso(String idusuario);

    default void devuelveRecurso(){
        System.out.println("Libro devuelto");
    }
}
