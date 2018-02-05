package com.cice.modelo.Clases;

import com.cice.modelo.Enums.EnumFormato;
import com.cice.modelo.Interfaces.IRecurso;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public abstract class Multimedia implements IRecurso, Comparable<Multimedia> {
    private String titulo;
    private EnumFormato formato;
    private String duracion;
    private int prestado;

    protected Multimedia(String titulo, String duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

   protected Multimedia() {
        this.prestado = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

   public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Integer isPrestado() {
        return prestado;
    }

    public void setPrestado(int prestado) {
        this.prestado = prestado;
    }

    @Override
    public int compareTo(Multimedia o) {
        return this.isPrestado().compareTo(o.isPrestado());
    }
}
