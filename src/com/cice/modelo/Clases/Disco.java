package com.cice.modelo.Clases;

import com.cice.modelo.Enums.EnumFormato;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Disco extends Multimedia {
    private String idusuario;
    EnumFormato formato;

    public Disco(String titulo, String duracion) {
        super(titulo, duracion);
        this.setPrestado(false);
        this.idusuario = "";
        this.formato = EnumFormato.DVD;

    }

    public Disco() {
        super();
        this.formato = EnumFormato.DVD;
        this.setPrestado(false);
        this.idusuario = "";
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public EnumFormato getFormato() {
        return this.formato;
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
                ", titulo='" + this.getTitulo() + '\'' +
                ", duracion='" + this.getDuracion() + '\'' +
                ", idusuario='" + idusuario + '\'' +
                ", prestado=" + this.isPrestado() +
                '}';
    }
}
