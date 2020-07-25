package persistencia;
/**
 * @author Donaldo
 * 
*/
import java.io.Serializable;
public class ArrancadorDeBiblioteca implements Serializable{
    private EscritorObjectOutputStream  escritor;
    private LectorObjectInputStream     lector;
    
    public ArrancadorDeBiblioteca(){
        lector = new LectorObjectInputStream("I:\\ESCOM\\Tercer Semestre\\P.O.O\\Ayala_Segoviano_Donaldo_Horacio_2CV3_GestorDeBiblioteca\\ProyectoBibioteca\\src\\persistencia\\biblioteca.txt");
        escritor = new EscritorObjectOutputStream("I:\\ESCOM\\Tercer Semestre\\P.O.O\\Ayala_Segoviano_Donaldo_Horacio_2CV3_GestorDeBiblioteca\\ProyectoBibioteca\\src\\persistencia\\biblioteca.txt");
    }
    public Object recuperarSistemaBiblioteca(){
        return lector.leerObjeto();
    }
    public void guardarSistemaBiblioteca(Object biblioteca){
        escritor.escribirObjetos(biblioteca);
    }
    public void destuir(){
        if(escritor != null){
            escritor = null;
        }
        if(lector != null){
            lector = null;
        }
        System.gc();
                
    }
}
