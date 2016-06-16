package com.commonapps.animesongs;

/**
 * Created by kevin on 11/06/16.
 */
public class datos_album {

    private int id;
    private String titulo;
    private String Descripcion;
    private String urlAlbum;

    public datos_album(){}

    public datos_album(String Titulo,String descripcion,String urlAlbum){
         this.titulo = Titulo;
        this.Descripcion= descripcion;
        this.urlAlbum = urlAlbum;
    }

    public String getTitulo(){
        return  this.titulo;
    }
    public  void  setTitulo(String Titulo){
        this.titulo = Titulo;
    }

    public String getDescripcion(){
        return  this.Descripcion;
    }
    public  void  setDescripcion(String Descripcion){
        this.Descripcion = Descripcion;
    }

    public String geturlAlbum(){
        return  this.urlAlbum;
    }
    public  void  seurlAlbum(String urlAlbum){
         this.urlAlbum = urlAlbum;
    }

}
