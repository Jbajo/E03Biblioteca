package com.cice.modelo.Interfaces;

import java.util.Date;

/**
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 */
public interface IRecurso {
    void prestarRecurso(String idusuario);
    Integer isPrestado();
    Date getFecha();
    void devuelveRecurso();
}
