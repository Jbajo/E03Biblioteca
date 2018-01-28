package com.cice.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public abstract class Recurso implements IRecurso{
    protected Date fecha;
    protected String titulo;
    protected String idusuario;
    protected boolean prestado;

    public Recurso(Date fecha, String nombre, String idusuario, boolean prestado) {
        this.fecha = fecha;
        this.titulo = nombre;
        this.idusuario = idusuario;
        this.prestado = prestado;
    }

    public Recurso() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(fecha);
        this.fecha = date;
    }

    public String getTitulo() {
        return titulo;
    }

    public void seTitulo(String nombre) {
        this.titulo = nombre;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuarios) {
        this.idusuario = idusuarios;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        return "Recurso{" +
                "fecha='" + fecha + '\'' +
                ", nombre='" + titulo + '\'' +
                ", idusuario='" + idusuario + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}
