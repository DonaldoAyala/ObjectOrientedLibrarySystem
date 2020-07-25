package logica;

import java.io.Serializable;
/**
 * @Donaldo
 */
public abstract class Ficha implements Serializable{
    private Texto   texto;
    private Autor[] autores;
    private String  lugarPublicacion;
    private String  titulo;
    private int     numeroPaginas;
    private int     existencias;
    
    public Ficha(){
        this(null,"",null,0,"",0);
    }
    public Ficha(Texto texto,String titulo, Autor[] autores, int numeroPaginas, String lugarPublicacion, int existencias) {
        this.texto = texto;
        this.titulo = titulo;
        this.autores = autores;
        this.numeroPaginas = numeroPaginas;
        this.lugarPublicacion = lugarPublicacion;
        this.existencias = existencias;
    }
    
    public abstract boolean tomarTexto();
    public abstract boolean tomarTexto(int cantidad);
    
    
    public Texto getTexto() {
        return texto;
    }
    public void setTexto(Texto texto) {
        this.texto = texto;
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
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    public String getLugarPublicacion() {
        return lugarPublicacion;
    }
    public void setLugarPublicacion(String lugarPublicacion) {
        this.lugarPublicacion = lugarPublicacion;
    }
    public int getExistencias() {
        return existencias;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    public Ficha(Ficha ficha){
        texto = ficha.texto;
        titulo = ficha.titulo;
        autores = ficha.autores;
        numeroPaginas = ficha.numeroPaginas;
        lugarPublicacion = ficha.lugarPublicacion;
        existencias = ficha.existencias;
    }
    public void setFicha(Texto texto,String titulo, Autor[] autores, int numeroPaginas, String lugarPublicacion, int existencias) {
        this.texto = texto;
        this.titulo = titulo;
        this.autores = autores;
        this.numeroPaginas = numeroPaginas;
        this.lugarPublicacion = lugarPublicacion;
        this.existencias = existencias;
    }
    public void setFicha(Ficha ficha){
        texto = ficha.texto;
        titulo = ficha.titulo;
        autores = ficha.autores;
        numeroPaginas = ficha.numeroPaginas;
        lugarPublicacion = ficha.lugarPublicacion;
        existencias = ficha.existencias;
    }
    public void destruir(){
        if(titulo!=null){titulo=null;}
        if(autores!=null){
            for(int i=0;i<autores.length ; i++)
                autores[i].destruir();
            autores=null;
        }
        if(lugarPublicacion!=null){lugarPublicacion=null;}
        System.gc();
    }
    @Override
    public String toString() {
        return texto.toString()
                +"EXISTENCIAS:  "+existencias+"\n";
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Ficha)){return false;}
        Ficha casteo = (Ficha)objeto;
        return titulo == casteo.titulo && autores.equals(casteo.autores) && numeroPaginas==casteo.numeroPaginas && lugarPublicacion == casteo.lugarPublicacion;
    }
}
