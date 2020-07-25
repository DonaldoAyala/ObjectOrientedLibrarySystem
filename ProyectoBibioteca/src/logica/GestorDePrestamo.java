package logica;
/**
 * @Donaldo
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class GestorDePrestamo implements Serializable{
    private LinkedList<Prestamo>    prestamos;
    private ComprobadorDeMulta      comprobadorDeMulta;
    
    public GestorDePrestamo(){
        prestamos = new LinkedList<>();
        comprobadorDeMulta = new ComprobadorDeMulta(5, this, true);
    }
    public GestorDePrestamo(LinkedList<Prestamo> prestamos, ComprobadorDeMulta comprobador) {
        this.prestamos = prestamos;
        comprobadorDeMulta = comprobador;
    }
    public GestorDePrestamo(GestorDePrestamo gestor){
        prestamos = gestor.prestamos;
        comprobadorDeMulta = gestor.comprobadorDeMulta;
    }
    public void iniciarComprobador(){
        comprobadorDeMulta.start();
    }
    public void detenerComprobador(){
        comprobadorDeMulta.detener();
    }
    
    public void destruir(){
        if(prestamos != null){
            prestamos.clear();
            prestamos = null;
        }
        if(comprobadorDeMulta != null){
            comprobadorDeMulta.destruir();
            comprobadorDeMulta = null;
        }
        System.gc();
    }
    public void actualizarMulta(){
        int diasRetraso;
        for(int i=0 ; i<prestamos.size() ; i++){
            diasRetraso = (int)ChronoUnit.DAYS.between(LocalDate.now(),prestamos.get(i).getFechaDeInicio()) ;
            if(diasRetraso > 7 && prestamos.get(i).getFechaDeFin() == null){
                prestamos.get(i).setMulta(diasRetraso * 10);
            }
        }
    }
    public void buscarMultas(){
        System.out.println("Prestamo con multa");
        for(int i=0 ; i<prestamos.size();i++)
            prestamos.get(i).tieneMulta();
    }
    public void buscarMultas(Prestamo[] prestamo){
        System.out.println("Prestamo con multa");
        boolean verificar;
        for(int i=0 ; i<prestamo.length;i++){
            verificar=prestamo[i].tieneMulta();
            if(verificar)
                System.out.println(prestamo[i].toString());
            
        }   
    }
    public void registrarPrestamo(Asociado asociado,LinkedList<Libro> libros){
        Prestamo prestamonuevo = new Prestamo(asociado, 0, libros, LocalDate.now(), null);
        prestamos.add(prestamonuevo);
    }
    public int comprobarMulta(String clave){
        int multa = 0;
        for(int i=0;i<prestamos.size() ; i++){
            multa = prestamos.get(i).getMulta();
            if(multa > 0){
                return multa;
            }
        }
        return 0;
    }
    public boolean regresarPrestamo(String clave){
        for(int i=0;i<prestamos.size() ; i++){
            if(prestamos.get(i).getAsociado().getIdentificador().equals(clave) && prestamos.get(i).getFechaDeFin() == null){
                prestamos.get(i).setFechaDeFin(LocalDate.now());
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String cadena = "";
        for(int i=0;i<prestamos.size();i++)
            cadena += prestamos.get(i)+"\n";
        return cadena;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof GestorDePrestamo)){return false;}
        GestorDePrestamo casteo = (GestorDePrestamo)objeto;
        return super.equals(casteo) && prestamos.equals(casteo.prestamos);
    }
    public LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(LinkedList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
