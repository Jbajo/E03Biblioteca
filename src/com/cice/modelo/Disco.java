package com.cice.modelo;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Disco extends Multimedia {
    private String idusuario;
    private String formato;

    public Disco(String titulo, String duracion) {
        super(titulo, duracion);
        this.prestado = false;
        this.idusuario = "";
        this.formato = Multimedia.formato.DVD.toString();

    }

    public Disco() {
        super();
        this.formato = Multimedia.formato.DVD.toString();
        this.prestado = false;
        this.idusuario = "";
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getFormato() {
        return formato;
    }

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

    @Override
    public String toString() {
        return "Disco{" +
                "formato='" + formato + '\'' +
                ", titulo='" + titulo + '\'' +
                ", duracion='" + duracion + '\'' +
                ", idusuario='" + idusuario + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
