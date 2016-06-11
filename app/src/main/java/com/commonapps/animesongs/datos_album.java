package com.commonapps.animesongs;

/**
 * Created by kevin on 11/06/16.
 */
public class datos_album {

    private int id;
    private String titulo;
    private String Descripcion;

    public datos_album(){}

    public datos_album(String Titulo,String descripcion){
         this.titulo = Titulo;
        this.Descripcion= descripcion;
    }

    public String getTitulo(){
        return  this.titulo;
    }
    public  void  setTitulo(String Titulo){
        Titulo = this.titulo;
    }

    public String getDescripcion(){
        return  this.Descripcion;
    }
    public  void  setDescripcion(String Descripcion){
        Descripcion = this.Descripcion;
    }


}
