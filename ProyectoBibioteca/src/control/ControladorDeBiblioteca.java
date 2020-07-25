package control;
import java.util.LinkedList;
import logica.*;
/**
 * @Donaldo
 */
public class ControladorDeBiblioteca {
    private Biblioteca biblioteca;
    
    public ControladorDeBiblioteca(){
        biblioteca = new Biblioteca();
        biblioteca.iniciarSistema();
    }
    public String registrarBibliotecario(String nombre,String contrasenia,String turno){
        String identificador = "B"+biblioteca.getBibliotecarios().size();
        biblioteca.registrarUsuario(new Bibliotecario(nombre, turno, identificador, contrasenia));
        return identificador;
    }
    public String registrarAsociado(String nombre,String entidadEscolar,String contrasenia){
        String identificador = "U"+biblioteca.getAsociados().size();
        biblioteca.registrarUsuario(new Asociado(nombre, entidadEscolar, identificador, contrasenia));
        return identificador;
    }
    public boolean identificarBibliotecario(String clave,String contrasenia){
        LinkedList<Usuario> usuarios;
        usuarios = biblioteca.getBibliotecarios();
        for(int i=0; i<usuarios.size();i++){
            if(usuarios.get(i).getIdentificador().equals(clave)){
                if(usuarios.get(i).identificarse(contrasenia)){
                    System.out.println("Ha ingresado\n");
                    return true;
                }
            }
        }
        System.out.println("Usuario o contrasenia invalidos");
        return false;
    }
    public boolean identificarAsociado(String clave,String contrasenia){
        LinkedList<Usuario> usuarios;
        usuarios = biblioteca.getAsociados();
        for(int i=0; i<usuarios.size();i++){
            if(usuarios.get(i).identificarse(contrasenia)){
                if(usuarios.get(i).getContrasenia().equals(contrasenia)){
                    System.out.println("Ha ingresado\n");
                    return true;
                }
            }
        }
        System.out.println("Usuario o contrasenia invalidos");
        return false;
    }
    public Asociado buscarAsociado(String identificador){
        for(int i=0 ; i<biblioteca.getAsociados().size() ; i++){
            if(biblioteca.getAsociados().get(i).getIdentificador().equals(identificador))
                return (Asociado)biblioteca.getAsociados().get(i);
        }
        return null;
    }
    public Libro buscarLibro(String isbn){
        for(int i=0 ; i<biblioteca.getLibros().size() ; i++){
            if(((Libro)biblioteca.getLibros().get(i)).getIsbn().equals(isbn))
                return (Libro)biblioteca.getLibros().get(i);
        }
        return null;
    }
    public Periodico buscarPeriodico(String titulo){
        for(int i=0 ; i<biblioteca.getPeriodicos().size() ; i++){
            if(((Periodico)biblioteca.getPeriodicos().get(i)).getTitulo().equals(titulo))
                return (Periodico)biblioteca.getPeriodicos().get(i);
        }
        return null;
    }
    public Revista buscarRevista(String titulo){
        for(int i=0 ; i<biblioteca.getRevistas().size() ; i++){
            if(((Revista)biblioteca.getRevistas().get(i)).getTitulo().equals(titulo))
                return (Revista)biblioteca.getRevistas().get(i);
        }
        return null;
    }
    public boolean verificarPrestamo(String clave){
        LinkedList<Prestamo> prestamos = biblioteca.getPrestamos();
        
        for(int i=0 ; i<prestamos.size() ; i++){
            if(prestamos.get(i).getAsociado().getIdentificador().equals(clave) && prestamos.get(i).getFechaDeFin() == null)
                return false;
        }
        return true;
    }
    public String registrarPrestamo(String clave,String[] isbn){
        Asociado prestamista = buscarAsociado(clave);               //Se busca el asociado con dicha clave
        FichaBibliografica fichaAuxiliar= null;
        
        if(prestamista != null){
            if(verificarPrestamo(clave)){
                LinkedList<Libro> listaLibro = new LinkedList<>();
                for(int i=0 ; i<isbn.length ; i++){
                    if(buscarLibro(isbn[i]) != null){
                        listaLibro.add(buscarLibro(isbn[i]));
                        fichaAuxiliar = biblioteca.getBuscador().buscarFichaBibliografica(isbn[i]);
                        if(fichaAuxiliar != null)
                            if(!fichaAuxiliar.tomarTexto())
                                return "Revise las existencias de los libros pedidos";
                    }
                }
                if(listaLibro.size()>0){
                    biblioteca.registrarPrestamo(prestamista,listaLibro);
                    return "Registro exitoso";
                }
                else
                    return "Ningun libro agregado";
            }else{
                return "Devuelva el prestamo pendiente";
            }
        }else{
            return "Asociado no encontrado";
        }
    }
    public String leerLibro(String clave,String identificador){
        Asociado lector = buscarAsociado(clave);
        Texto texto = buscarLibro(identificador);
        if(texto != null && lector != null)
            return lector.leerTexto(texto);
        else
            return "Libro u asociado no encontrado";
    }
    public String leerRevista(String clave,String identificador){
        Asociado lector = buscarAsociado(clave);
        Texto texto = buscarRevista(identificador);
        return lector.leerTexto(texto);
    }
    public String leerPeriodico(String clave,String identificador){
        Asociado lector = buscarAsociado(clave);
        Texto texto = buscarLibro(identificador);
        return lector.leerTexto(texto);
    }
    public int comprobarMulta(String clave){
        int multa = 0;
        multa = biblioteca.comprobarMulta(clave);
        return multa;
    }
    public String regresarPrestamo(String clave){
        return biblioteca.regresarPrestamo(clave) ? "Prestamo devuelto\n":"Error al devolver prestamo";
    }
    public void registrarTexto(String isbn,String titulo,int numeroEdicion,String genero,String lugarPublicacion,String fechaPublicacion,int numeroPaginas,String[][] autor,String[] editor,int existencias){
        Editorial editorial = new Editorial(editor[0],editor[1]);
        Autor[] autores = new Autor[autor.length];
        for(int i=0;i<autor.length;i++){
            autores[i] = new Autor(autor[i][0], autor[i][1]);
        }
        biblioteca.registrarTexto(new Libro(isbn, editorial, numeroEdicion, genero, titulo, autores, fechaPublicacion, numeroPaginas, lugarPublicacion),existencias);
    }
    public void registrarTexto(String[] notas, int numeroPublicacion, String lugarDeEdicion, String nombreDeLaCadena, String periodicidad, String titulo, String[][] autor, String fechaPublicacion, int numeroDePaginas, String lugarPublicacion, int existencias){
        Autor[] autores = new Autor[autor.length];
        for(int i=0;i<autor.length;i++){
            autores[i] = new Autor(autor[i][0], autor[i][1]);
        }
        biblioteca.registrarTexto(new Periodico(notas, numeroPublicacion, lugarDeEdicion, nombreDeLaCadena, periodicidad, titulo, autores, fechaPublicacion, numeroDePaginas, lugarPublicacion),existencias);
    }
    public void registrarTexto(String titulo,String autor[][],String fechaPublicacion,int numeroDePaginas,String lugarPublicacion,String nombreDeLaCadena,String periodicidad,int numeroPublicacion,String tematica,int existencias){
        Autor[] autores = new Autor[autor.length];
        for(int i=0;i<autor.length;i++){
            autores[i] = new Autor(autor[i][0], autor[i][1]);
        }
        biblioteca.registrarTexto(new Revista(tematica, numeroPublicacion, nombreDeLaCadena, periodicidad, titulo, autores, fechaPublicacion, numeroDePaginas, lugarPublicacion),existencias);
    }
    public String buscarLibro(String titulo, String[][] autores){
        Autor[] autor = new Autor[autores.length];
        for(int i=0;i<autores.length ; i++){
            autor[i] = new Autor(autores[i][0], autores[i][1]);
        }
        String resultado = biblioteca.getBuscador().buscarLibro(titulo, autor);
        if(resultado.length() > 0)
            return resultado;
        return "Sin resultados";
    }
    public String buscarRevista(String titulo, String[][] autores){
        Autor[] autor = new Autor[autores.length];
        for(int i=0;i<autores.length ; i++){
            autor[i] = new Autor(autores[i][0], autores[i][1]);
        }
        String resultado = biblioteca.getBuscador().buscarRevista(titulo, autor);
        if(resultado.length() > 0)
            return resultado;
        return "Sin resultados";
    }
    public String buscarPeriodico(String titulo, String[][] autores){
        Autor[] autor = new Autor[autores.length];
        for(int i=0;i<autores.length ; i++){
            autor[i] = new Autor(autores[i][0], autores[i][1]);
        }
        String resultado = biblioteca.getBuscador().buscarPeriodico(titulo, autor);
        if(resultado.length() > 0)
            return resultado;
        return "Sin resultados";
    }
    public String mostrarLibros(){
        LinkedList<Texto> libro= biblioteca.getLibros();
        String libros = "";
        for(int i=0; i<libro.size() ; i++){
            libros += libro.get(i).toString()+"\n-----------------\n";
        }
        return libros;
    }
    public String mostrarRevistas(){
        LinkedList<Texto> revista= biblioteca.getRevistas();
        String revistas = "";
        for(int i=0; i<revista.size() ; i++){
            revistas += revista.get(i).toString()+"\n-----------------\n";
        }
        return revistas;
    }
    public String mostrarPeriodicos(){
        LinkedList<Texto> periodico= biblioteca.getPeriodicos();
        String periodicos = "";
        for(int i=0; i<periodico.size() ; i++){
            periodicos += periodico.get(i).toString()+"\n-----------------\n";
        }
        return periodicos;
    }
    public String mostrarBibliotecarios(){
        LinkedList<Usuario> libro= biblioteca.getBibliotecarios();
        String libros = "";
        for(int i=0; i<libro.size() ; i++){
            libros += libro.get(i).toString()+"\n-----------------\n";
        }
        return libros;
    }
    public String mostrarAsociados(){
        LinkedList<Usuario> libro= biblioteca.getAsociados();
        String libros = "";
        for(int i=0; i<libro.size() ; i++){
            libros += libro.get(i).toString()+"\n-----------------\n";
        }
        return libros;
    }
    public String verPrestamos(){
        String cadena = "   --PRESTAMOS--\n";
        LinkedList<Prestamo> prestamos = biblioteca.getPrestamos();
        for(int i=0 ; i<prestamos.size() ; i++){
            cadena += prestamos.get(i).toString()+"\n";
        }
        return cadena;
    }
    public void guardarSistema(){
        biblioteca.guardarSistema();
    }
    public void destruir(){
        if(biblioteca != null){
            biblioteca.destruir();
            biblioteca = null;
        }
        System.gc();
    }
}
