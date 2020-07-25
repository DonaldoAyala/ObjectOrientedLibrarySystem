package logica;

import java.io.Serializable;
/**
 * @Donaldo
 */
public class Editorial implements Serializable{
    private String nombre;
    private String pais;
    
    public Editorial(){
        this(" "," ");
    }
    public Editorial(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    public Editorial(Editorial editorial){
        nombre = editorial.nombre;
        pais = editorial.pais;
    }
    
    public void editarLibro(){
        System.out.println("Editando libro");
    }
    public void editarLibro(String titulo){
        editarLibro();
        System.out.println("Creando nueva version de: "+titulo);
    }
    
    public void setEditorial(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    public void setEditorial(Editorial editorial) {
        nombre = editorial.nombre;
        pais = editorial.pais;
    }
    public Editorial getEditorial(){
        return new Editorial(nombre,pais);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void destruir(){
        if(nombre!=null){nombre = null;}
        if(pais!=null){pais = null;}
        System.gc();
    }
    @Override
    public String toString() {
        return "Editorial{" + "nombre=" + nombre + ", pais=" + pais + '}';
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Editorial)){return false;}
        Editorial casteo = (Editorial)objeto;
        return nombre == casteo.nombre && pais == casteo.pais;
    }
}