package com.cice.modelo.Clases;

import com.cice.modelo.Interfaces.IRecurso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public abstract class Recurso implements IRecurso {
    private Date fecha;
    private String titulo;
    private String idusuario;
    private boolean prestado;

    protected Recurso(Date fecha, String nombre, String idusuario, boolean prestado) {
        this.fecha = fecha;
        this.titulo = nombre;
        this.idusuario = idusuario;
        this.prestado = prestado;
    }

    protected Recurso() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        Date date = parser.parse(fecha);
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        return "Recurso{" +
                "fecha='" + formatter.format(fecha) + '\'' +
                ", nombre='" + titulo + '\'' +
                ", idusuario='" + idusuario + '\'' +
                ", prestado=" + prestado +
                '}';
    }
}