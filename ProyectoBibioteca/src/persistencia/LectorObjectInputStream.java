package persistencia;

/**
 * @author Donaldo
 * 
*/
import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import  java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;
import logica.Biblioteca;

public class LectorObjectInputStream implements Serializable{
    private String              archivo;
    private FileInputStream     fis;
    private ObjectInputStream   ois;
    
    public LectorObjectInputStream(String archivo){
        this.archivo = archivo;
        fis = null;
        ois = null;
    }
    public boolean abrirFlujo(){
        boolean abierto = false;
        try{
            fis = new FileInputStream(archivo);
            System.out.println(fis);
            ois = new ObjectInputStream(fis);
            abierto = true;
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return abierto;
    }
    
    public boolean cerrarFlujo(){
        boolean cerradoOis = false;
        boolean cerradoFis = false;
        if(ois != null){
            try{
                ois.close();
                cerradoOis = true;
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        if(fis != null){
            try{
                fis.close();
                cerradoFis = true;
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return cerradoOis && cerradoFis;
    }
    
    public Object leerObjeto(){
        Object biblioteca = null;
        if(abrirFlujo()){
            try{
                biblioteca = ois.readObject();
            }catch(EOFException eofe){
                eofe.printStackTrace();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }catch(ClassNotFoundException cnfe){
                cnfe.printStackTrace();
            }finally{
                if(cerrarFlujo()){
                }else{
                    System.out.println("Ocurrio un error al cerrar el flujo");
                }
            }
        }
        return biblioteca;
    }
}
