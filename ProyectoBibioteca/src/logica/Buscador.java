package logica;

import java.io.Serializable;
import java.util.LinkedList;
/**
 * @Donaldo
 */
public class Buscador implements Serializable{
    private LinkedList<Ficha> fichasBibliograficas;
    private LinkedList<Ficha> fichasHemerograficas;
    
    public Buscador(){
        fichasBibliograficas = new LinkedList<Ficha>();
        fichasHemerograficas = new LinkedList<Ficha>();
    }
    public Buscador(LinkedList<Ficha> fichasBibliograficas,LinkedList<Ficha> fichasHemerograficas) {
        this.fichasBibliograficas = fichasBibliograficas;
        this.fichasHemerograficas = fichasHemerograficas;
    }
    public Buscador(Buscador buscador){
        fichasBibliograficas = buscador.fichasBibliograficas;
        fichasHemerograficas = buscador.fichasHemerograficas;
    }
    public void destruir(){
        if(fichasBibliograficas!=null){
            fichasBibliograficas.clear();
            fichasBibliograficas = null;
        }
        if(fichasHemerograficas!=null){
            fichasHemerograficas.clear();
            fichasHemerograficas = null;
        }
        System.gc();
    }
    private boolean compararAutores(Autor[] autores1, Autor[] autores2){
        for(int i=0 ; i<autores1.length ; i++){
            for(int j=0; j<autores2.length ; j++){
                if(autores1[i].equals(autores2[j]))
                    return true;
            }
        }
        return false;
    }
    public FichaBibliografica buscarFichaBibliografica(String isbn){
        FichaBibliografica   auxiliar   = null;
        String  isbnAuxiliar            = "";
        
        for(int i=0; i<fichasBibliograficas.size() ; i++){
            auxiliar = (FichaBibliografica)fichasBibliograficas.get(i);
            isbnAuxiliar = auxiliar.getIsbn();
            if(isbnAuxiliar.equals(isbn)){
                return auxiliar;
            }
        }
        return null;
    }
    public String buscarLibro(String titulo,Autor[] autores){
        Ficha   auxiliar            = null;
        Autor[] autoresAuxiliares;
        String  tituloAuxiliar      = "";
        String  libros              = "";
        for(int i=0; i<fichasBibliograficas.size() ; i++){
            auxiliar = fichasBibliograficas.get(i);
            tituloAuxiliar = auxiliar.getTitulo();
            autoresAuxiliares = auxiliar.getAutores();
            if(titulo.equals(tituloAuxiliar) || compararAutores(autoresAuxiliares,autores)){
                libros += fichasBibliograficas.get(i);
            }
        }
        return libros;
    }
    public String buscarPeriodico(String titulo,Autor[] autores){
        Ficha   auxiliar            = null;
        Autor[] autoresAuxiliares;
        String  tituloAuxiliar      = "";
        String  periodicos          = "";
        for(int i=0; i<fichasBibliograficas.size() ; i++){
            auxiliar = fichasBibliograficas.get(i);
            tituloAuxiliar = auxiliar.getTitulo();
            autoresAuxiliares = auxiliar.getAutores();
            if(titulo.equals(tituloAuxiliar) || compararAutores(autoresAuxiliares,autores)){
                periodicos += fichasBibliograficas.get(i);
            }
        }
        return periodicos;
    }
    public String buscarRevista(String titulo,Autor[] autores){
        Ficha   auxiliar            = null;
        Autor[] autoresAuxiliares;
        String  tituloAuxiliar      = "";
        String  revistas            = "";
        for(int i=0; i<fichasHemerograficas.size() ; i++){
            auxiliar = fichasHemerograficas.get(i);
            tituloAuxiliar = auxiliar.getTitulo();
            autoresAuxiliares = auxiliar.getAutores();
            if(titulo.equals(tituloAuxiliar) || compararAutores(autoresAuxiliares,autores)){
                revistas += fichasHemerograficas.get(i);
            }
        }
        return revistas;
    }
    public void agregarFicha(Texto texto,int existencias){
        if(texto instanceof Libro){
            Libro libro = (Libro) texto;
            fichasBibliograficas.add(new FichaBibliografica(libro, libro.getEditorial(), libro.getEdicion(), libro.getIsbn(), libro.getGenero(), libro.getTitulo(), libro.getAutores(), libro.getNumeroDePaginas(), libro.getLugarPublicacion(), existencias));
        }
        if(texto instanceof Revista){
            Revista revista = (Revista) texto;
            fichasHemerograficas.add(new FichaHemerografica(revista, revista.getNumeroPublicacion(), revista.getNombreDeLaCadena(), revista.getTitulo(), revista.getAutores(), revista.getNumeroDePaginas(), revista.getLugarPublicacion(), existencias));
        }
        if(texto instanceof Periodico){
            Periodico periodico = (Periodico)texto;
            fichasHemerograficas.add(new FichaHemerografica(texto, periodico.getNumeroPublicacion(), periodico.getNombreDeLaCadena(), periodico.getTitulo(), periodico.getAutores(), periodico.getNumeroDePaginas(), periodico.getLugarPublicacion(), existencias));
        }
    }
    public void tomarLibro(String isbn){
        for(int i=0 ; i< fichasBibliograficas.size() ; i++){
            if(isbn.equals(((FichaBibliografica)fichasBibliograficas.get(i)).getIsbn()))
                fichasBibliograficas.get(i).tomarTexto();
        }
    }
    @Override
    public String toString() {
        String cadena = " ";
        for(int i=0 ; i<fichasBibliograficas.size() ;i++)
            cadena += fichasBibliograficas.get(i)+"\n";
        for(int i=0 ; i<fichasHemerograficas.size() ;i++)
            cadena += fichasHemerograficas.get(i)+"\n";
        return "Fichas: " + cadena;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Buscador)){return false;}
        Buscador casteo = (Buscador)objeto;
        return super.equals(casteo) &&  fichasBibliograficas.equals(casteo.fichasBibliograficas) && fichasHemerograficas.equals(casteo.fichasHemerograficas);
    }
    public LinkedList<Ficha> getFichasBibliograficas() {
        return fichasBibliograficas;
    }
    public void setFichasBibliograficas(LinkedList<Ficha> fichasBibliograficas) {
        this.fichasBibliograficas = fichasBibliograficas;
    }
    public LinkedList<Ficha> getFichasHemerograficas() {
        return fichasHemerograficas;
    }
    public void setFichasHemerograficas(LinkedList<Ficha> fichasHemerograficas) {
        this.fichasHemerograficas = fichasHemerograficas;
    }
    
}
