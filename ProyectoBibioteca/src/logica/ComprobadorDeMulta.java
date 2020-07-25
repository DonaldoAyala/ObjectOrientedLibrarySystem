package logica;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author Donaldo
 */
public class ComprobadorDeMulta implements Runnable , Serializable{
    private int segundosEntreRevision;
    private GestorDePrestamo gestor;
    private volatile boolean activo;
    
    public ComprobadorDeMulta(){
        segundosEntreRevision = 10;
        gestor = null;
        activo = true;
    }
    public ComprobadorDeMulta(int segundosEntreRevision,GestorDePrestamo gestor,boolean activo){
       this.segundosEntreRevision = segundosEntreRevision;
       this.gestor = gestor;
       this.activo = activo;
    }
    public ComprobadorDeMulta(ComprobadorDeMulta comprobador){
        segundosEntreRevision = comprobador.segundosEntreRevision;
        gestor = comprobador.gestor;
        activo = comprobador.activo;
    }
    
    public void detener(){
        activo = false;
    }
    public void start(){
        Thread comprobador = new Thread(this);
        comprobador.start();
    }
    @Override
    public void run(){
        while(activo){
            try{
                gestor.actualizarMulta();
                Thread.sleep(segundosEntreRevision*1000);
            }catch(InterruptedException ie){
                System.out.println(ie.getLocalizedMessage());
            }
        }
    }
    public void destruir(){
        detener();
        if(gestor != null)
            gestor = null;
    }
    @Override
    public String toString() {
        return "ComprobadorDeMulta{" + "segundosEntreRevision=" + segundosEntreRevision + ", gestor=" + gestor + ", activo=" + activo + '}';
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof ComprobadorDeMulta)){return false;}
        ComprobadorDeMulta casteo = (ComprobadorDeMulta)objeto;
        return super.equals(casteo) && segundosEntreRevision == casteo.segundosEntreRevision && activo == casteo.activo && gestor.equals(casteo.gestor);
    }
    
}
