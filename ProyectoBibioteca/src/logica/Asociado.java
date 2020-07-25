package logica;
/**
 * @Donaldo
 */
import java.io.Serializable;
public class Asociado extends Usuario implements Lector ,Serializable{
    private String nombre;
    private String entidadEscolar;
    
    public Asociado(){
        super();
        nombre = "";
        entidadEscolar = "";
    }

    public Asociado(String nombre, String entidadEscolar, String identificador, String contraseña) {
        super(identificador, contraseña);
        this.nombre = nombre;
        this.entidadEscolar = entidadEscolar;
    }
    public Asociado(Asociado asociado){
        super(asociado);
        nombre = asociado.nombre;
        entidadEscolar = asociado.entidadEscolar;
    }
    public void leerTexto(){
        System.out.println("Leyendo textos...");
    }
    public String leerTexto(Texto texto){
        return "Usuario: "+nombre
                +"Leyendo: "
                +texto;
    }
    
    @Override
    public boolean identificarse(String contrasenia){
        System.out.println("Identificando asociado");
        if(getContrasenia().equals(contrasenia))
            return true;
        else
            return false;
    }
    public void crearAsociado(String nombre, String entidadEscolar, String identificador, String contraseña) {
        crearUsuario(identificador, contraseña);
        this.nombre = nombre;
        this.entidadEscolar = entidadEscolar;
    }
    public void crearAsociado(Asociado asociado){
        crearUsuario(asociado);
        nombre = asociado.nombre;
        entidadEscolar = asociado.entidadEscolar;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEntidadEscolar() {
        return entidadEscolar;
    }
    public void setEntidadEscolar(String entidadEscolar) {
        this.entidadEscolar = entidadEscolar;
    }
    @Override
    public void destruir(){
        if(nombre!=null){nombre=null;}
        if(entidadEscolar!=null){entidadEscolar=null;}
        System.gc();
    }
    @Override
    public String toString() {
        return "    --ASOCIADO--"+"\n"
                +"NOMBRE:   "+nombre+"\n"
                +"ESCUELA:  "+entidadEscolar+"\n"
                ;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Asociado)){return false;}
        Asociado casteo = (Asociado)objeto;
        return super.equals(casteo) && nombre == casteo.nombre && entidadEscolar == casteo.entidadEscolar;
    }
    public void consultar(){
        System.out.println("Consultando");
    }
}
