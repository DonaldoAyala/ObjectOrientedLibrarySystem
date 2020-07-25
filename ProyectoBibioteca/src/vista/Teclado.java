package vista;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @Donaldo
 */
public class Teclado implements Serializable{
	private Scanner lectorDeCadenas;
        private Scanner lectorDeNumeros;
        private Scanner lectorDeBooleanos;
	public Teclado(){
		lectorDeCadenas = new Scanner(System.in);
                lectorDeNumeros = new Scanner(System.in);
                lectorDeBooleanos = new Scanner(System.in);
	}
	public Teclado(Scanner cadenas,Scanner numeros,Scanner booleans){
		lectorDeCadenas = cadenas;
                lectorDeNumeros = numeros;
                lectorDeBooleanos = booleans;
	}
	public Teclado(Teclado teclado){
		lectorDeCadenas = teclado.lectorDeCadenas;
                lectorDeNumeros = teclado.lectorDeNumeros;
                lectorDeBooleanos = teclado.lectorDeBooleanos;
	}
	public void destruir(){
		if(lectorDeCadenas!=null){
			lectorDeCadenas=null;
		}
                if(lectorDeNumeros!=null){
			lectorDeNumeros=null;
		}
                if(lectorDeBooleanos!=null){
			lectorDeBooleanos=null;
		}
		System.gc();
	}
	public String leerCadena(){
            try{
                return lectorDeCadenas.nextLine();
            }catch(InputMismatchException ime){
                ime.printStackTrace();
                return "";
            }
	}
	public byte leerByte(){
            try{
		return lectorDeNumeros.nextByte();
            }catch(InputMismatchException ime){
                System.out.println(ime.getMessage());
                ime.printStackTrace();
                return 0;
            }
	}
	public short leerShort(){
            try{
		return lectorDeNumeros.nextShort();
            }catch(InputMismatchException ime){
                System.out.println(ime.getMessage());
                ime.printStackTrace();
                return 0;
            }
	}
	public int leerInt(){
            try{
		return lectorDeNumeros.nextInt();
            }catch(InputMismatchException ime){
                System.out.println(ime.getMessage());
                return 0;
            }
	}
	public long leerLong(){
		try{
		return lectorDeNumeros.nextLong();
            }catch(InputMismatchException ime){
                System.out.println(ime.getMessage());
                ime.printStackTrace();
                return 0;
            }
	}
	public float leerFloat(){
            try{
		return lectorDeNumeros.nextFloat();
            }catch(InputMismatchException ime){
                ime.printStackTrace();
                return 0;
            }
	}
	public double leerDouble(){
            try{
		return lectorDeNumeros.nextDouble();
            }catch(InputMismatchException ime){
                ime.printStackTrace();
                return 0;
            }
	}
	public char leerChar(){
            try{
		lectorDeCadenas.nextLine();
		return lectorDeCadenas.nextLine().charAt(0);
            }catch(InputMismatchException ime){
                ime.printStackTrace();
                return ' ';
            }
	}
	public boolean leerBoolean(){
            try{
                return lectorDeBooleanos.nextBoolean();
            }catch(InputMismatchException ime){
                ime.printStackTrace();
                return false;
            }
	}
}