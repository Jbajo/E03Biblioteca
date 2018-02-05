package com.cice.modelo.Clases;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Comic extends Recurso {
    private int numero;
    private String coleccion;

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

    public Comic(Date fecha, String nombre, String idusuarios, int prestado, int numero, String coleccion) {
        super(fecha, nombre, idusuarios, prestado);
        this.numero = numero;
        this.coleccion = coleccion;
    }

    public Comic() {
        super();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColeccion() {
        return coleccion;
    }

    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return "Comic{" +
                "numero=" + numero +
                ", coleccion='" + coleccion + '\'' +
                ", fecha='" + formatter.format(this.getFecha()) + '\'' +
                ", nombre='" + this.getTitulo() + '\'' +
                ", idusuario='" + this.getIdusuario() + '\'' +
                ", prestado=" + this.isPrestado() +
                '}';
    }
}
