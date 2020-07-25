package logica;
import vista.Teclado;
import persistencia.ArrancadorDeBiblioteca;
import java.io.Serializable;
import java.util.LinkedList;
/**
 * @Donaldo
 */
public class Biblioteca implements Serializable{
    private Buscador                buscador;
    private LinkedList<Usuario>     asociados;
    private LinkedList<Usuario>     bibliotecarios;
    private GestorDePrestamo        gestorDePrestamo;
    private LinkedList<Texto>       libros;
    private LinkedList<Texto>       periodicos;
    private LinkedList<Texto>       revistas;
    private ArrancadorDeBiblioteca  arrancador;
    
    public Biblioteca(){
        buscador = new Buscador();
        asociados = new LinkedList<Usuario>();
        bibliotecarios = new LinkedList<Usuario>();
        gestorDePrestamo = new GestorDePrestamo();
        libros = new LinkedList<Texto>();
        periodicos = new LinkedList<Texto>();
        revistas = new LinkedList<Texto>();
        
    }
    public Biblioteca(Biblioteca biblioteca){
        buscador = biblioteca.buscador;
        bibliotecarios = biblioteca.bibliotecarios;
        asociados = biblioteca.asociados;
        gestorDePrestamo = biblioteca.gestorDePrestamo;
        libros = biblioteca.libros;
        periodicos = biblioteca.periodicos;
        revistas = biblioteca.revistas;
    }
    public void destruir(){
        if(buscador != null){
            buscador.destruir();
            buscador = null;
        }
        if(bibliotecarios != null){
            bibliotecarios.clear();
            bibliotecarios = null;
        }
        if(asociados != null){
            asociados.clear();
            asociados = null;
        }
        if(gestorDePrestamo != null){
            gestorDePrestamo.destruir();
            gestorDePrestamo = null;
        }
        if(libros != null){
            libros.clear();
            libros = null;
        }
        if(revistas != null){
            revistas.clear();
            revistas = null;
        }
        if(arrancador != null){
            arrancador.destuir();
            arrancador = null;
        }
        System.gc();
    }
    public void registrarUsuario(Usuario usuario){
        if(usuario instanceof Bibliotecario)
            bibliotecarios.add(usuario);
        if(usuario instanceof Asociado)
            asociados.add(usuario);
    }
    public void registrarTexto(Texto texto,int existencias){
        buscador.agregarFicha(texto, existencias);
        if(texto instanceof Libro){
            libros.add(texto);
        }
        if(texto instanceof Periodico){
            periodicos.add(texto);
        }
        if(texto instanceof Revista){
            revistas.add(texto);
        }
    }
    public void registrarPrestamo(Asociado asociado,LinkedList<Libro> lista){
        gestorDePrestamo.registrarPrestamo(asociado, lista);
    }
    public int comprobarMulta(String clave){
        return gestorDePrestamo.comprobarMulta(clave);
    }
    public boolean regresarPrestamo(String clave){
        return gestorDePrestamo.regresarPrestamo(clave);
    }
    public void iniciarSistema(){
        ArrancadorDeBiblioteca arrancador = new ArrancadorDeBiblioteca();
        Biblioteca biblioteca = (Biblioteca)arrancador.recuperarSistemaBiblioteca();
        if(biblioteca != null){
            this.buscador = biblioteca.buscador;
            this.asociados = biblioteca.asociados;
            this.bibliotecarios = biblioteca.bibliotecarios;
            this.gestorDePrestamo = biblioteca.gestorDePrestamo;
            this.libros = biblioteca.libros;
            this.revistas = biblioteca.revistas;
            this.periodicos = biblioteca.periodicos;
            gestorDePrestamo.iniciarComprobador();
        }else{
            System.out.println("Imposible Recuperar el Sistema");
        }
    }
    public void guardarSistema(){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.asociados = asociados;
        biblioteca.bibliotecarios = bibliotecarios;
        biblioteca.buscador = buscador;
        gestorDePrestamo.detenerComprobador();
        biblioteca.gestorDePrestamo = gestorDePrestamo;
        biblioteca.libros = libros;
        biblioteca.periodicos = periodicos;
        biblioteca.revistas = revistas;
        ArrancadorDeBiblioteca arrancador = new ArrancadorDeBiblioteca();
        arrancador.guardarSistemaBiblioteca(biblioteca);
    }
    @Override
    public String toString() {
        String usuario = " ";
        String texto = " ";
        
        return "Biblioteca{" + "buscador=" + buscador + ", usuarios=" + usuario + ", gestorDePrestamo=" + gestorDePrestamo + ", textos=" + texto + '}';
    }
    public Buscador getBuscador() {
        return buscador;
    }
    public void setBuscador(Buscador buscador) {
        this.buscador = buscador;
    }
    public LinkedList<Usuario> getAsociados() {
        return asociados;
    }
    public void setAsociados(LinkedList<Usuario> asociados) {
        this.asociados = asociados;
    }
    public LinkedList<Usuario> getBibliotecarios() {
        return bibliotecarios;
    }
    public void setBibliotecarios(LinkedList<Usuario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }
    public GestorDePrestamo getGestorDePrestamo() {
        return gestorDePrestamo;
    }
    public void setGestorDePrestamo(GestorDePrestamo gestorDePrestamo) {
        this.gestorDePrestamo = gestorDePrestamo;
    }
    public LinkedList<Texto> getLibros() {
        return libros;
    }
    public void setLibros(LinkedList<Texto> libros) {
        this.libros = libros;
    }
    public LinkedList<Texto> getPeriodicos() {
        return periodicos;
    }
    public void setPeriodicos(LinkedList<Texto> periodicos) {
        this.periodicos = periodicos;
    }
    public LinkedList<Texto> getRevistas() {
        return revistas;
    }
    public void setRevistas(LinkedList<Texto> revistas) {
        this.revistas = revistas;
    }
    public ArrancadorDeBiblioteca getArrancador() {
        return arrancador;
    }
    public void setArrancador(ArrancadorDeBiblioteca arrancador) {
        this.arrancador = arrancador;
    }
    public LinkedList<Prestamo> getPrestamos(){
        return gestorDePrestamo.getPrestamos();
    }
}