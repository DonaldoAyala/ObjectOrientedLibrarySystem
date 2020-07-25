package logica;
/**
 * @Donaldo
 */
import java.io.Serializable;
public class Autor implements Serializable{
    private String nombre;
    private String nacionalidad;
    
    public Autor(){
        this(" "," ");
    }
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    public Autor(Autor autor){
        nombre = autor.nombre;
        nacionalidad = autor.nacionalidad;
    }
    public void setAutor(Autor autor){
        nombre = autor.nombre;
        nacionalidad = autor.nacionalidad;
    }
    public void setAutor(String nombre, String nacionalidad) {
        nombre = nombre;
        nacionalidad = nacionalidad;
    }
    public Autor getAutor(){
        return new Autor(nombre,nacionalidad);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public void destruir(){
        if(nombre!=null){nombre = null;}
        if(nacionalidad != null){nacionalidad = null;}
        System.gc();
    }
    public void escribirLibro(){
        System.out.println("Escribiendo libro...");
    }
    public void escribirLibro(String titulo){
        escribirLibro();
        System.out.println("Nuevo Libro: "+titulo);
    }
    
    @Override
    public String toString() {
        String cadena = "";
        cadena += nombre;
        return cadena;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Autor)){return false;}
        Autor casteo = (Autor)objeto;
        return nombre == casteo.nombre && nacionalidad == casteo.nacionalidad;
    }
}
