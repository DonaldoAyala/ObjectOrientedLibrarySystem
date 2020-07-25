package logica;

import java.io.Serializable;
/**
 * @Donaldo
 */
public class Revista extends TextoInformativo implements Serializable{
    private String tematica;
    
    public Revista(){
        super();
        tematica = "";
    }
    public Revista(String tematica, int numeroPublicacion, String nombreDeLaCadena, String periodicidad, String titulo, Autor[] autores, String fechaPublicacion, int numeroDePaginas, String lugarPublicacion) {
        super(numeroPublicacion, nombreDeLaCadena, periodicidad, titulo, autores, fechaPublicacion, numeroDePaginas, lugarPublicacion);
        this.tematica = tematica;
    }
    public Revista(Revista revista){
        super(revista);
        tematica = revista.tematica;
    }
    @Override
    public void informar(){
        System.out.println("Informando acerca de: "+tematica);
    }
    @Override 
    public void darInformacion(){
        System.out.println("Dando informacion de: "+tematica);
    }
    @Override
    public void editarTexto(Texto texto){
        
    }
    
    @Override
    public void destruir(){
        if(tematica!=null){tematica=null;}
        System.gc();
    }
    @Override
    public String toString() {
        return   "\n      REVISTA"+"\n"
                +"CADENA:               "+getNombreDeLaCadena()+"\n"
                +"TITULO:               "+getTitulo()+"\n"
                +"TEMATICA              "+tematica+"\n"
                +"FECHA DE PUBLICACION: "+getFechaPublicacion()+"\n"
                +"PERIODICIDAD:         "+getPeriodicidad()+"\n"
                +"NO. DE PAGINAS:       "+getNumeroDePaginas()+"\n"
                +"NO. De PUBLICACION:   "+getNumeroPublicacion()+"\n";
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Revista)){return false;}
        Revista casteo = (Revista)objeto;
        return super.equals(casteo) && tematica == casteo.tematica;
    }
}
