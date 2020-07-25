package logica;

import java.io.Serializable;
/**
 * @Donaldo
 */
public abstract class TextoInformativo extends Texto implements Serializable{    
    private String  nombreDeLaCadena;
    private String  periodicidad;
    private int     numeroPublicacion;
    
    public TextoInformativo(){
        super();
        numeroPublicacion = 0;
        nombreDeLaCadena = "";
        periodicidad = "";
    }

    public TextoInformativo(int numeroPublicacion, String nombreDeLaCadena, String periodicidad, String titulo, Autor[] autores, String fechaPublicacion, int numeroDePaginas, String lugarPublicacion) {
        super(titulo, autores, fechaPublicacion, numeroDePaginas, lugarPublicacion);
        this.numeroPublicacion = numeroPublicacion;
        this.nombreDeLaCadena = nombreDeLaCadena;
        this.periodicidad = periodicidad;
    }
    public TextoInformativo(TextoInformativo texto){
        super(texto);
        numeroPublicacion = texto.numeroPublicacion;
        nombreDeLaCadena = texto.nombreDeLaCadena;
        periodicidad = texto.periodicidad;
    }
    
    public abstract void informar();
    
    
    @Override
    public void destruir(){
        if(nombreDeLaCadena!=null){nombreDeLaCadena=null;}
        if(periodicidad!=null){periodicidad=null;}
        System.gc();
    }    
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof TextoInformativo)){return false;}
        TextoInformativo casteo = (TextoInformativo)objeto;
        return super.equals(casteo) && numeroPublicacion == casteo.numeroPublicacion && nombreDeLaCadena == casteo.nombreDeLaCadena && periodicidad == casteo.periodicidad;
    }
    public String getNombreDeLaCadena() {
        return nombreDeLaCadena;
    }
    public void setNombreDeLaCadena(String nombreDeLaCadena) {
        this.nombreDeLaCadena = nombreDeLaCadena;
    }
    public String getPeriodicidad() {
        return periodicidad;
    }
    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }
    public int getNumeroPublicacion() {
        return numeroPublicacion;
    }
    public void setNumeroPublicacion(int numeroPublicacion) {
        this.numeroPublicacion = numeroPublicacion;
    }
}
