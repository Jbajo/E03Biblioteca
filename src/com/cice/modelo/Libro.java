package com.cice.modelo;

import java.util.Date;
import java.util.Hashtable;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Libro extends Recurso {
    private String isbn;
    private String autor;

    @Override
    public void prestarRecurso(String idusuario) {
        this.setPrestado(true);
        this.setIdusuario(idusuario);
    }

    @Override
    public void devuelveRecurso() {
        this.setPrestado(false);
        this.setIdusuario("");
    }

    public Libro(Date fecha, String nombre, String idusuarios, boolean prestado, String isbn, String autor) {
        super(fecha, nombre, idusuarios, prestado);
        this.isbn = isbn;
        this.autor = autor;
    }

    public Libro() {
        super();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", fecha='" + fecha + '\'' +
                ", nombre='" + titulo + '\'' +
                ", idusuario='" + idusuario + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
