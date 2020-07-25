package logica;
/**
 * @Donaldo
 */
import java.io.Serializable;
public abstract class Usuario implements Serializable{
    private String identificador;
    private String contrasenia;
    
    public Usuario(){
        identificador = "admin";
        contrasenia = "admin";
    }
    public Usuario(String identificador, String contrasenia) {
        this.identificador = identificador;
        this.contrasenia = contrasenia;
    }
    public Usuario(Usuario user){
        identificador = user.identificador;
        contrasenia = user.contrasenia;
    }
    public void crearUsuario(String identificador, String contrasenia) {
        this.identificador = identificador;
        this.contrasenia = contrasenia;
    }
    public void crearUsuario(Usuario user){
        identificador = user.identificador;
        contrasenia = user.contrasenia;
    }
    public void destruir(){
        if(identificador!=null){identificador=null;}
        if(contrasenia!=null){contrasenia=null;}
        System.gc();
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public abstract boolean identificarse(String contrasenia);
    @Override
    public String toString() {
        return "Usuario de Biblioteca";
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Usuario)){return false;}
        Usuario casteo = (Usuario)objeto;
        return super.equals(casteo) && identificador == casteo.identificador && contrasenia == casteo.contrasenia;
    }
    
}
