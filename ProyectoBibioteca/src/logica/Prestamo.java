package logica;
/**
 * @Donaldo
 */
import java.io.Serializable;
import java.util.LinkedList;
import java.time.*;
import java.util.Date;
public class Prestamo implements Serializable{
    private LinkedList<Libro>   libros;
    private Asociado            asociado;
    private LocalDate           fechaDeInicio;
    private LocalDate           fechaDeFin;
    private int                 multa;
    
    public Prestamo(){
        asociado = new Asociado();
        multa = 0;
        libros = new LinkedList<Libro>();
        fechaDeInicio = LocalDate.now();
        fechaDeFin = null;
    }
    public Prestamo(Asociado asociado, int multa, LinkedList<Libro> libros, LocalDate fechaDeInicio, LocalDate fechaDeFin) {
        this.asociado = asociado;
        this.multa = multa;
        this.libros = libros;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFin = fechaDeFin;
    }
    public Prestamo(Prestamo prestamo){
        asociado = prestamo.asociado;
        multa = prestamo.multa;
        libros = prestamo.libros;
        fechaDeInicio = prestamo.fechaDeInicio;
        fechaDeFin = prestamo.fechaDeFin;
    }
    public boolean tieneMulta(){
        if(multa>0)
            return true;
        return false;
    }
    public boolean tieneMulta(String fechaFinal,String fechaActual){
        System.out.println("Verificando fecha");
        boolean resultado=true;
        return resultado;
    }
    public void setPrestamo(Asociado asociado, int multa, LinkedList<Libro> libros, LocalDate fechaDeInicio, LocalDate fechaDeFin) {
        this.asociado = asociado;
        this.multa = multa;
        this.libros = libros;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFin = fechaDeFin;
    }
    public void setPrestamo(Prestamo prestamo){
        asociado = prestamo.asociado;
        multa = prestamo.multa;
        libros = prestamo.libros;
        fechaDeInicio = prestamo.fechaDeInicio;
        fechaDeFin = prestamo.fechaDeFin;
    }
    public void destruir(){
        if(asociado!=null){
            asociado.destruir();
            asociado=null;
        }
        if(libros!=null){
            libros.clear();
            libros = null;
        }
        if(fechaDeInicio!=null){fechaDeInicio=null;}
        if(fechaDeFin!=null){fechaDeFin=null;}
        System.gc();
    }
    @Override
    public String toString() {
        String cadena = "";
        for(int i=1 ;i<libros.size() ;i++)
            cadena += libros.get(i).getTitulo() +",";
        return "ASOCIADO: "+asociado.getNombre()+"\n"
                +"CLAVE: "+((Usuario)asociado).getIdentificador()
                +"LIBROS: "+cadena+"\n"
                +"FECHA DE INICIO: "+fechaDeInicio+"\n"
                +"FECHA DE ENTREGA: "+(fechaDeFin == null ? "Pendiente" : fechaDeFin.toString())+"\n"
                +"MULTA: "+(multa <=0? "Sin multa":multa+" pesos")
                
                ;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Prestamo)){return false;}
        Prestamo casteo = (Prestamo)objeto;
        boolean cond= false;
        return super.equals(casteo) && asociado.equals(casteo.asociado) && libros.equals(casteo.libros) && fechaDeInicio == casteo.fechaDeInicio && fechaDeFin == casteo.fechaDeFin && libros.equals(casteo.libros);
    }
    public Asociado getAsociado() {
        return asociado;
    }
    public void setAsociado(Asociado asociado) {
        this.asociado = asociado;
    }
    public int getMulta() {
        return multa;
    }
    public void setMulta(int multa) {
        this.multa = multa;
    }
    public LinkedList<Libro> getLibros() {
        return libros;
    }
    public void setLibros(LinkedList<Libro> libros) {
        this.libros = libros;
    }
    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }
    public void setFechaDeInicio(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }
    public LocalDate getFechaDeFin() {
        return fechaDeFin;
    }
    public void setFechaDeFin(LocalDate fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }
}
