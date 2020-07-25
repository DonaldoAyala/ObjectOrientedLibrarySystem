package logica;
/**
 * @Donaldo
 */
import java.io.Serializable;
public class FichaBibliografica extends Ficha implements Serializable{
    private Editorial   editorial;
    private String      isbn;
    private String      genero;
    private int         edicion;
    
    public FichaBibliografica(){
        super();
        editorial = null;
        edicion = 0;
        isbn = "";
        genero = "";
    }
    public FichaBibliografica(Texto texto,Editorial editorial, int edicion, String isbn, String genero, String titulo, Autor[] autores, int numeroPaginas, String lugarPublicacion, int existencias) {
        super(texto, titulo, autores, numeroPaginas, lugarPublicacion, existencias);
        this.editorial = editorial;
        this.edicion = edicion;
        this.isbn = isbn;
        this.genero = genero;
    }
    public FichaBibliografica(FichaBibliografica ficha){
        super(ficha);
        editorial = ficha.editorial;
        edicion = ficha.edicion;
        isbn = ficha.isbn;
        genero = ficha.genero;
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
    
    public void setFichaBibliografica(Texto texto,Editorial editorial, int edicion, String isbn, int anio, String genero, String titulo, Autor[] autores, int numeroPaginas, String lugarPublicacion, int existencias) {
        setFicha(texto, titulo, autores, numeroPaginas, lugarPublicacion, existencias);
        this.editorial = editorial;
        this.edicion = edicion;
        this.isbn = isbn;
        this.genero = genero;
    }
    public void setFichaBibliografica(FichaBibliografica ficha){
        setFicha(ficha);
        editorial = ficha.editorial;
        edicion = ficha.edicion;
        isbn = ficha.isbn;
        genero = ficha.genero;
    }
    public Editorial getEditorial() {
        return editorial;
    }
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getEdicion() {
        return edicion;
    }
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }
    @Override
    public void destruir(){
        if(editorial!=null){editorial=null;}
        if(isbn!=null){isbn=null;}
        if(genero!=null){genero=null;}
        System.gc();
    }

    @Override
    public String toString() {
        return getTexto().toString()+"\n"
                +"EXISTENCIAS: "+getExistencias()
                ;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof FichaBibliografica)){return false;}
        FichaBibliografica casteo = (FichaBibliografica)objeto;
        return super.equals(casteo) && editorial.equals(casteo.editorial) && edicion == casteo.edicion && isbn == casteo.isbn && genero == casteo.genero;
    }
}
