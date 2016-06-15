package com.commonapps.animesongs.com.commonapps.animesong.musicview;

/**
 * Created by GiovannyGin on 14/06/2016.
 */
public class MusicaInformacion {

    private String numeroMusica;
    private String tituloMusica;
    private String duracionMusica;

    public MusicaInformacion(String numeroMusica, String tituloMusica, String duracionMusica) {
        this.numeroMusica = numeroMusica;
        this.tituloMusica = tituloMusica;
        this.duracionMusica = duracionMusica;
    }

    public String getNumeroMusica() {
        return numeroMusica;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public String getDuracionMusica() {
        return duracionMusica;
    }
}
