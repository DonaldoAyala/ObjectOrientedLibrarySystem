package logica;
/**
 * @Donaldo
 */
import java.io.Serializable;
public class FichaHemerografica extends Ficha implements Serializable{
    private int     numeroPublicacion;
    private String  nombreDeLaCadena;
    
    public FichaHemerografica(){
        super();
        numeroPublicacion= 0;
        nombreDeLaCadena = "";
    }
    public FichaHemerografica(Texto texto,int numeroPublicacion,  String nombreDeLaCadena, String titulo, Autor[] autores, int numeroPaginas, String lugarPublicacion, int existencias) {
        super(texto,titulo, autores, numeroPaginas, lugarPublicacion, existencias);
        this.numeroPublicacion = numeroPublicacion;
        this.nombreDeLaCadena = nombreDeLaCadena;
    }
    public FichaHemerografica(FichaHemerografica ficha){
        super(ficha);
        numeroPublicacion = ficha.numeroPublicacion;
        nombreDeLaCadena = ficha.nombreDeLaCadena;
    }
    public void setFichaHemerografica(Texto texto,int numeroPublicacion, String lugarDeEdicion, String nombreDeLaCadena, String titulo, Autor[] autores, int numeroPaginas, String lugarPublicacion, int existencias) {
        setFicha(texto,titulo, autores, numeroPaginas, lugarPublicacion, existencias);
        this.numeroPublicacion = numeroPublicacion;
        this.nombreDeLaCadena = nombreDeLaCadena;
    }
    public void setFichaHemerografica(FichaHemerografica ficha){
        setFicha(ficha);
        numeroPublicacion = ficha.numeroPublicacion;
        nombreDeLaCadena = ficha.nombreDeLaCadena;
    }
    
    @Override
    public boolean tomarTexto(){
        if(getExistencias() <= 0)
            return false;
        setExistencias(getExistencias()-1);
        return true;
    }
    
    @Override
    public boolean tomarTexto(int cantidad){
        if(cantidad > getExistencias())
            return false;
        setExistencias(getExistencias()-cantidad);
        return true;
    }
    
    @Override
    public String toString() {
        return getTexto()+"\n"
                +"ESXISTENCIAS: "+getExistencias()
                ;
    }
    @Override
    public void destruir(){
        if(nombreDeLaCadena!=null){nombreDeLaCadena=null;}
        System.gc();
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof FichaHemerografica)){return false;}
        FichaHemerografica casteo = (FichaHemerografica)objeto;
        return super.equals(casteo) && numeroPublicacion == casteo.numeroPublicacion && nombreDeLaCadena == nombreDeLaCadena;
    }
    
}
