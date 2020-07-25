package logica;
/**
 * @Donaldo
 */

import java.io.Serializable;
public abstract class Texto implements Serializable{
    private Autor[] autores;
    private String  titulo;
    private String  lugarPublicacion;
    private String  fechaPublicacion;
    private int     numeroDePaginas;
    
    public Texto(){
        this("",null,"",0,"");
    }
    public Texto(String titulo, Autor[] autores, String fechaPublicacion, int numeroDePaginas, String lugarPublicacion) {
        this.titulo = titulo;
        this.autores = autores;
        this.fechaPublicacion = fechaPublicacion;
        this.numeroDePaginas = numeroDePaginas;
        this.lugarPublicacion = lugarPublicacion;
    }
    public Texto(Texto texto){
        titulo = texto.titulo;
        autores = texto.autores;
        fechaPublicacion = texto.fechaPublicacion;
        numeroDePaginas = texto.numeroDePaginas;
        lugarPublicacion = texto.lugarPublicacion;
    }
    public abstract void editarTexto(Texto texto);
    public abstract void darInformacion();    
    public abstract String toString();
    public void destruir(){
        if(titulo!=null){titulo=null;}
        if(autores!=null){
            for(int i=0 ; i<autores.length;i++)
                autores[i].destruir();
            autores=null;
        }
        if(fechaPublicacion!=null){fechaPublicacion=null;}
        if(lugarPublicacion!=null){lugarPublicacion=null;}
        System.gc();
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Autor[] getAutores() {
        return autores;
    }
    public void setAutores(Autor[] autores) {
        this.autores = autores;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }
    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
    public String getLugarPublicacion() {
        return lugarPublicacion;
    }
    public void setLugarPublicacion(String lugarPublicacion) {
        this.lugarPublicacion = lugarPublicacion;
    }
    
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Texto)){return false;}
        Texto casteo = (Texto)objeto;
        return titulo == casteo.titulo && autores.equals(casteo.autores) && fechaPublicacion == casteo.fechaPublicacion && numeroDePaginas == casteo.numeroDePaginas && lugarPublicacion == casteo.lugarPublicacion;
    }
    
}
