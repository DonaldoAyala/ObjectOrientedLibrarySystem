package logica;

import java.io.Serializable;
/**
 * @Donaldo
 */
public class Libro extends Texto implements Serializable{
    private Editorial   editorial;
    private int         edicion;
    private String      isbn;
    private String      genero;
    
    public Libro(){
        super();
        editorial = null;
        edicion = 0;
        isbn = "";
        genero = "";
    }
    public Libro(String isbn,Editorial editorial, int edicion, String genero, String titulo, Autor[] autores, String fechaPublicacion, int numeroDePaginas, String lugarPublicacion) {
        super(titulo, autores, fechaPublicacion, numeroDePaginas, lugarPublicacion);
        this.editorial = editorial;
        this.edicion = edicion;
        this.isbn = isbn;
        this.genero = genero;
    }
    public Libro(Libro libro){
        super(libro);
        editorial = libro.editorial;
        edicion = libro.edicion;
        isbn = libro.isbn;
        genero = libro.genero;
    }
    @Override
    public void darInformacion(){
        System.out.println("Dando informacion acerca de "+genero);
    }
    
    @Override
    public void editarTexto(Texto texto){
        if(texto instanceof Libro){
            Libro libro = (Libro)texto;
            setLugarPublicacion(libro.getLugarPublicacion());
            setNumeroDePaginas(libro.getNumeroDePaginas());
            setFechaPublicacion(libro.getFechaPublicacion());
            setTitulo(libro.getTitulo());
            setAutores(libro.getAutores());
            editorial = libro.editorial;
            edicion = libro.edicion;
            isbn = libro.isbn;
            genero = libro.genero;
        }
    }
    @Override
    public void destruir(){
        if(editorial!=null){
            editorial.destruir();
            editorial=null;
        }
        if(isbn!=null){isbn=null;}
        if(genero!=null){genero=null;}
        System.gc();
    }

    @Override
    public String toString() {
        String cadena = "";
        String autores = "";
        cadena += "\nISBN:                    "+isbn+"\n";
        cadena += "TITULO:                  "+getTitulo()+"\n";
        cadena += "EDITORIAL:               "+editorial.getNombre()+", "+editorial.getPais()+"\n";
        for(int i=0; i< getAutores().length ; i++){
            autores += getAutores()[i]+",  ";
        }
        cadena += "AUTORES:                 "+autores+"\n";
        cadena += "FECHA DE PUBLICACION:    "+getFechaPublicacion()+"\n";
        cadena += "EDICION:                 "+edicion+"\n";
        cadena += "PAGINAS:                 "+getNumeroDePaginas()+"\n";
        cadena += "GENERO:                  "+genero+"\n\n";
        return  cadena;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Libro)){return false;}
        Libro casteo = (Libro)objeto;
        return super.equals(casteo) && editorial.equals(casteo.editorial) && edicion == casteo.edicion && isbn == isbn  && genero == genero;
    }
    public Editorial getEditorial() {
        return editorial;
    }
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    public int getEdicion() {
        return edicion;
    }
    public void setEdicion(int edicion) {
        this.edicion = edicion;
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
}
