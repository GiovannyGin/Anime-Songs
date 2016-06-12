package com.commonapps.animesongs;

/**
 * Created by GiovannyGin on 11/06/2016.
 */
public class adaptadorMusica {
    private int id;
    private String numeroCancion;
    private String tituloCancion;
    private String duracionCancion;

    public adaptadorMusica(String numeroCancion, String tituloCancion, String duracionCancion) {
        this.numeroCancion = numeroCancion;
        this.tituloCancion = tituloCancion;
        this.duracionCancion = duracionCancion;
    }

    public String getNumeroCancion() {
        return numeroCancion;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }
}
