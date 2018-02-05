package com.cice.modelo.Clases;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Libro extends Recurso {
    private String isbn;
    private String autor;

    @Override
    public void prestarRecurso(String idusuario) {
        this.setPrestado(1);
        this.setIdusuario(idusuario);
    }

    @Override
    public void devuelveRecurso() {
        this.setPrestado(0);
        this.setIdusuario("");
    }

    public Libro(Date fecha, String nombre, String idusuarios, int prestado, String isbn, String autor) {
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", fecha='" + formatter.format(this.getFecha()) + '\'' +
                ", nombre='" + this.getTitulo() + '\'' +
                ", idusuario='" + this.getIdusuario() + '\'' +
                ", prestado=" + this.isPrestado() +
                '}';
    }
}
