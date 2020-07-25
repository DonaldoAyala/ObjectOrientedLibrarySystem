package logica;

import vista.Teclado;
import java.io.Serializable;
import java.util.LinkedList;
/**
 * @Donaldo
 */
public class Bibliotecario extends Usuario implements Serializable{
    private String  nombre;
    private String turno;
    
    public Bibliotecario(){
        super();
        nombre = "";
        turno = "";
    }
    public Bibliotecario(String nombre, String turno, String identificador, String contraseña) {
        super(identificador, contraseña);
        this.nombre = nombre;
        this.turno = turno;
    }
    public Bibliotecario(Bibliotecario bibliotecario){
        super(bibliotecario);
        nombre = bibliotecario.nombre;
        turno = bibliotecario.turno;
    }
    public void vigilarBiblioteca(){
        System.out.println("Vigilando biblioteca");
    }
    public void vigilarBiblioteca(String hora){
        vigilarBiblioteca();
        System.out.println("A las "+hora+" de "+(turno == "Vespertino"? "Noche":"Dia"));
    }
    @Override
    public boolean identificarse(String contrasenia){
        System.out.println("Identificando Bibliotecario");
        if(getContrasenia().equals(contrasenia))
            return true;
        else
            return false;
    }
    @Override
    public void destruir(){
        if(nombre!=null){nombre=null;}
        System.gc();
    }
    @Override
    public String toString() {
        return "    ---Bibliotecario---"
               +"ID:            "+getIdentificador()+"\n"
               +"NOMBRE:        "+nombre+"\n"
               +"TURNO:         "+turno+"\n";
        
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Bibliotecario)){return false;}
        Bibliotecario casteo = (Bibliotecario)objeto;
        return super.equals(casteo) && nombre == casteo.nombre && turno == casteo.turno;
    }
}
