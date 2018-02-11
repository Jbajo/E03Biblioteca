package com.cice.modelo.Enums;

public enum EnumPrestable {
    LIBRO (1),
    DISCO (1),
    COMIC (0),
    REVISTA (0);

    private int prestado;

    EnumPrestable(int prestado) {
        this.prestado = prestado;
    }

    public int getPrestado(){
        return this.prestado;
    }
}
