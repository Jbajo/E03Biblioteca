package com.cice.modelo;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public abstract class Multimedia implements IRecurso {
    protected String titulo;
    public enum formato{
        CINTA,
        DVD,
        VINILO
    };
    protected String duracion;
    boolean prestado;

    public Multimedia(String titulo, String duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public Multimedia() {
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

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}
