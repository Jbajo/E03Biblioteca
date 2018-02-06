package com.cice.modelo.Clases;

import com.cice.modelo.Enums.EnumPrestable;

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
        this.setPrestado(1);
        this.setIdusuario(idusuario);
    }

    @Override
    public void devuelveRecurso() {
        this.setPrestado(0);
        this.setIdusuario("");
    }

    public Revista(Date fecha, String titulo, String idusuarios, int prestado, int numero, String periocidad) {
        super(fecha, titulo, idusuarios, prestado);
        this.numero = numero;
        this.periocidad = periocidad;
        this.setPrestable(EnumPrestable.NOPRESTABLE);
    }

    public Revista() {
        super();
        this.setPrestable(EnumPrestable.NOPRESTABLE);
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
                ", fecha='" + formatter.format(this.getFecha()) + '\'' +
                ", nombre='" + this.getTitulo() + '\'' +
                ", idusuario='" + this.getIdusuario() + '\'' +
                ", prestado=" + this.isPrestado() +
                '}';
    }
}
