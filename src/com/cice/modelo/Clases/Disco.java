package com.cice.modelo.Clases;

import com.cice.modelo.Enums.EnumFormato;

import java.util.Date;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public class Disco extends Multimedia {
    private String idusuario;
    EnumFormato formato;

    public Disco(String titulo, String duracion) {
        super(titulo, duracion);
        this.setPrestado(0);
        this.idusuario = "";
        this.formato = EnumFormato.DVD;

    }

    public Disco() {
        super();
        this.formato = EnumFormato.DVD;
        this.setPrestado(0);
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
        this.setPrestado(1);
        this.setIdusuario(idusuario);
    }

    @Override
    public Date getFecha() {
        return null;
    }

    @Override
    public void devuelveRecurso() {
        this.setPrestado(0);
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
