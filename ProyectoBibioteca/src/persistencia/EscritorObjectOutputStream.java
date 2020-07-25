package persistencia;

/**
 * @author Donaldo
 * 
*/

import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import  java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
public class EscritorObjectOutputStream implements Serializable{
    private String              archivo;
    private FileOutputStream    fos;
    private ObjectOutputStream  oos;
    
    public EscritorObjectOutputStream(String archivo){
        this.archivo = archivo;
        fos = null;
        oos = null;
    }
    public boolean abrirFlujo(){
        boolean abierto = false;
        try{
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            abierto = true;
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return abierto;
    }
    
    public boolean cerrarFlujo(){
        boolean cerradoOos = false;
        boolean cerradoFos = false;
        if(oos != null){
            try{
                oos.close();
                cerradoOos = true;
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        if(fos != null){
            try{
                fos.close();
                cerradoFos = true;
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        return cerradoOos && cerradoFos;
    }
    
    public boolean escribirObjetos(Object biblioteca){
        if(abrirFlujo()){
            try{
                oos.writeObject(biblioteca);
                return true;
            }catch(IOException ioe){
                ioe.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
