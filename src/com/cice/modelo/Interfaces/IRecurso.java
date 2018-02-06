package com.cice.modelo.Interfaces;

import com.cice.modelo.Clases.Recurso;

import java.util.Date;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public interface IRecurso extends Comparable<IRecurso>{
    void prestarRecurso(String idusuario);
    Integer isPrestado();
    Date getFecha();
    void devuelveRecurso();
    @Override
    default int compareTo(IRecurso o) {
        return this.isPrestado().compareTo(o.isPrestado());
    }
}
