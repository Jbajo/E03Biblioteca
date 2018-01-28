package com.cice.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Revista extends Recurso {
    private int numero;
    private String periocidad;

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

    public Revista(Date fecha, String titulo, String idusuarios, boolean prestado, int numero, String periocidad) {
        super(fecha, titulo, idusuarios, prestado);
        this.numero = numero;
        this.periocidad = periocidad;
    }

    public Revista() {
        super();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        return "Revista{" +
                "numero=" + numero +
                ", periocidad='" + periocidad + '\'' +
                ", fecha='" + formatter.format(fecha) + '\'' +
                ", nombre='" + titulo + '\'' +
                ", idusuario='" + idusuario + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
