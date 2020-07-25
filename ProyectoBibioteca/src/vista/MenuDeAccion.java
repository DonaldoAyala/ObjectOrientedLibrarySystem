package vista;
/**
 * @Donaldo
 */
import control.ControladorDeBiblioteca;

public class MenuDeAccion {
    private Teclado                 teclado;
    private ControladorDeBiblioteca control;

    public MenuDeAccion(){
        teclado = new Teclado();
        control = new ControladorDeBiblioteca();
    }
    public void mostrarMenuDeAcciones(){
        int opcion = 0;
        do{
            System.out.println("        --SISTEMA GESTOR DE BIBLIOTECA--"+"\n"
                                +"                    --MENU--"+"\n"
                                +"Para Salir ingrese 0"+"\n"
                                +"1)Registrar un Texto"+"\n"
                                +"2)Registrar un Usuario"+"\n"
                                +"3)Consultar textos disponibles"+"\n"
                                +"4)Gestionar prestamos"+"\n"
                                +"5)Leer libro");
            opcion = teclado.leerInt();
            switch(opcion){
                case 0:
                    System.out.println("Saliendo y guardando.");
                break;
                case 1:
                    registrarNuevoTexto();
                break;
                case 2:
                    registrarUsuario();
                break;
                case 3:
                    consultarTextos();
                break;
                case 4:
                    gestionarPrestamos();
                break;
                case 5:
                    ingresarDatosConsulta();
                break;
                case 6:
                    System.out.println(control.verPrestamos());
                break;
                case 7:
                    System.out.println(control.mostrarBibliotecarios());
                break;
                case 8:
                    System.out.println(control.mostrarLibros());
                break;
                default:
                    System.out.println("Opcion invalida");
                break;
            }
        }while(opcion != 0);
        control.guardarSistema();
    }
    public void ingresarDatosConsulta(){
        String clave = "";
        String isbn = "";
        
        System.out.println("Ingrese su clave de usuario");
        clave = teclado.leerCadena();
        System.out.println("Ingrese el isbn del libro");
        isbn = teclado.leerCadena();
        if(ingresarClaveAsociado(clave))
            System.out.println(control.leerLibro(clave,isbn));
    }
    public void gestionarPrestamos(){
        int opcion = 0;
        do{
            System.out.println("    --GESTOR DE PRESTAMOS--"+"\n"
                                + "Ingrese 0 para salir"+"\n"
                                + "1)Registrar prestamo"+"\n"
                                + "2)Devolver prestamo"+"\n");
            opcion = teclado.leerInt();
            switch(opcion){
                case 1:
                    registrarPrestamo();
                break;
                case 2:
                    regresarPrestamo();
                break;
            }
        }while(opcion != 0);
    }
    public void regresarPrestamo(){
        String clave = "";
        int multa = 0;
        System.out.println("Ingrese su clave de asociado.");
        clave = teclado.leerCadena();
        String saldarDeuda = "";
        if(ingresarClaveAsociado(clave)){
            multa = control.comprobarMulta(clave);
            if(multa >= 0){
                System.out.println("Tiene una multa pendiente de :"+multa+" pesos");
                System.out.println("Desea saldar la deuda? si/no");
                saldarDeuda = teclado.leerCadena();
                if(saldarDeuda =="no")
                    return;
            }
            System.out.println(control.regresarPrestamo(clave));
        }else{
            System.out.println("Clave o contrasenia incorrectos\n");
        }
    }
    public void registrarPrestamo(){
        String clave = "";
        String[] isbn;
        int noLibros = 0;
        System.out.println("Ingrese su clave de asociado.");
        clave = teclado.leerCadena();
        if(ingresarClaveAsociado(clave)){
            System.out.println("Cuantos libros desea llevar?");
            isbn =  new String[teclado.leerInt()];
            for(int i=0 ; i<isbn.length ; i++){
                System.out.println("Ingrese el isbn del libro "+(i+1));
                isbn[i] = teclado.leerCadena();
            }
            System.out.println(control.registrarPrestamo(clave, isbn));
        }else{
            System.out.println("Clave o contrasenia incorrectos\n");
        }
    }
    public void consultarTextos(){
        int opcion = 0;
        do{
            System.out.println("    --CONSULTAS--"+"\n"
                                +"Ingrese 0 para salir"+"\n"
                                +"1) Buscar Libro"+"\n"
                                +"2) Buscar Revista"+"\n"
                                +"3) Buscar Periodico"+"\n"
                                );
            opcion = teclado.leerInt();
            switch(opcion){
                case 0:                    
                break;
                case 1:
                    consultarLibro();
                break;
                case 2:
                    consultarRevista();
                break;
                case 3:
                    consultarPeriodico();
                break;
                default:
                    System.out.println("Opcion invalida");
                break;
            }
        }while(opcion != 0);
        
    }
    public void consultarLibro(){
        int opcion = 0;
        do{
            System.out.println("Ingrese 0 para salir"+"\n"
                                +"1) Buscar Libro"+"\n"
                                +"2) Ver todos"+"\n"
                                );
            opcion = teclado.leerInt();
            switch(opcion){
                case 1:
                    String titulo = "";
                    String[][] autores;
                    System.out.println("Ingrese el titulo del libro:");
                    titulo = teclado.leerCadena();
                    autores = ingresarAutores();
                    System.out.println(control.buscarLibro(titulo, autores));
                break;
                case 2:
                    System.out.println(control.mostrarLibros());
                break;
            }
        }while(opcion != 0);
    }
    public void consultarRevista(){
        int opcion = 0;
        do{
            System.out.println("Ingrese 0 para salir"+"\n"
                                +"1) Buscar Revista"+"\n"
                                +"2) Ver todas"+"\n"
                                );
            opcion = teclado.leerInt();
            switch(opcion){
                case 1:
                    String titulo = "";
                    String[][] autores;
                    System.out.println("Ingrese el titulo de la revista:");
                    titulo = teclado.leerCadena();
                    autores = ingresarAutores();
                    System.out.println(control.buscarRevista(titulo, autores));
                break;
                case 2:
                    System.out.println(control.mostrarRevistas());
                break;
            }
        }while(opcion != 0);
    }
    public void consultarPeriodico(){
        int opcion = 0;
        do{
            System.out.println("Ingrese 0 para salir"+"\n"
                                +"1) Buscar Periodico"+"\n"
                                +"2) Ver todos"+"\n"
                                );
            opcion = teclado.leerInt();
            switch(opcion){
                case 1:
                    String titulo = "";
                    String[][] autores;
                    System.out.println("Ingrese el titulo del periodico:");
                    titulo = teclado.leerCadena();
                    autores = ingresarAutores();
                    System.out.println(control.buscarPeriodico(titulo, autores));
                break;
                case 2:
                    System.out.println(control.mostrarPeriodicos());
                break;
            }
        }while(opcion != 0);
    }
    public void registrarUsuario(){
        int opcion = 0;
        do{
            System.out.println("        REGISTRAR USUARIO"+"\n"
                                +"Para Salir ingrese 0"+"\n"
                                +"1)Registrar un Bibliotecario"+"\n"
                                +"2)Registrar un Asociado"+"\n");
            opcion = teclado.leerInt();
            switch(opcion){
                case 1:
                    ingresarDatosBibliotecario();
                break;
                case 2:
                    ingresarDatosAsociado();
                break;    
            }
        }while(opcion != 0);
    }
    private String[][] ingresarAutores(){
        System.out.println("Ingrese el numero de autores del texto");
        String[][] autores = new String[teclado.leerInt()][2];
        for(int i=0;i<autores.length;i++){
            System.out.println("Ingrese el nombre del autor "+i);
            autores[i][0]=teclado.leerCadena();
            System.out.println("Ingrese la nacionalidad del autor "+i);
            autores[i][1] = teclado.leerCadena();
        }
        return autores;
    }
    private String[] ingresarEditorial(){
        String[] datos = new String[2];
        
        System.out.println("Ingrese el nombre de la editorial");
        datos[0]= teclado.leerCadena();
        System.out.println("Ingrese el pais de la editorial");
        datos[1]= teclado.leerCadena();
        return datos;
    }
    private void ingresarDatosLibro(){
        String[][]  autores;
        String[]    editorial;
        String      isbn                = "";
        String      genero              = "";
        String      titulo              = "";
        String      fechaPublicacion    = "";
        String      lugarPublicacion    = "";
        int         edicion             = 0;
        int         numeroDePaginas     = 0;
        int         existencias         = 0;
        
        System.out.println("\n\n        --REGISTRO DE LIBRO--\n");
        while(isbn.length()==0){
            System.out.println("Ingrese  el isbn del libro:");
            isbn = teclado.leerCadena();
        }
        while(titulo == ""){
            System.out.println("Ingrese el titulo del libro");
            titulo = teclado.leerCadena();
        }
        autores = ingresarAutores();
        while(edicion <= 0){
            System.out.println("Ingrese el numero de edicion del libro");
            edicion = teclado.leerInt();
        }
        while(genero == ""){
            System.out.println("Ingrese el genero al que pertenece el libro");
            genero = teclado.leerCadena();
        }
        while(lugarPublicacion == ""){
            System.out.println("Ingrese el lugar de Publicacion del libro");
            lugarPublicacion = teclado.leerCadena();
        }
        editorial = ingresarEditorial();
        while(fechaPublicacion == ""){
            System.out.println("Ingrese la fecha de Publicacion del libro con el formato (dia-mes-año)");
            fechaPublicacion = teclado.leerCadena();
        }
        while(numeroDePaginas <= 0){
            System.out.println("Ingrese el numero de paginas del libro");
            numeroDePaginas = teclado.leerInt();
        }
        while(existencias == 0){
            System.out.println("Ingrese el numero de libros a registrar");
            existencias = teclado.leerInt();
        }
        control.registrarTexto(isbn, titulo, edicion, genero, lugarPublicacion, fechaPublicacion, numeroDePaginas, autores, editorial, existencias);
    }
    public void ingresarDatosAsociado(){
        String nombre           = "";
        String escuela          = "";
        String identificador    = "";
        String contraseña       = "";
        while(nombre == ""){
            System.out.println("Ingrese el nombre del usuario");
            nombre = teclado.leerCadena();
        }
        while(escuela == ""){
            System.out.println("Ingrese su entidad escolar");
            escuela = teclado.leerCadena();
        }
        while(contraseña  == ""){
            System.out.println("Ingrese su contraseña");
            contraseña = teclado.leerCadena();
        }
        identificador = control.registrarAsociado(nombre, escuela, contraseña);
        System.out.println("Registro exitoso\nSu clave de usuario es: "+identificador+"\n"
                            +"Su contraseña es: "+contraseña);
    }
    private String[] ingresarNotas(){
        String[] notas;
        
        System.out.println("Ingrese el numero de notas");
        notas = new String[teclado.leerInt()];
        for(int i=0 ; i<notas.length ; i++){
            System.out.println("Ingrese el titulo de la nota "+(i+1));
            notas [i] = teclado.leerCadena();
        }
        return notas;
    }
    public void ingresarDatosPeriodico(){
        String[][]  autores;
        String[]    notas;
        String      titulo              = "";
        String      lugarDeEdicion      = "";
        String      nombreDeLaCadena    = "";
        String      periodicidad        = "";
        String      fechaPublicacion    = "";
        String      lugarPublicacion    = "";
        int         numeroPaginas       = 0;
        int         numeroPublicacion   = 0;
        int         ejemplares          = 0;
        
        while(titulo == ""){
            System.out.println("Ingrese el titulo del periodico");
            titulo = teclado.leerCadena();
        }
        autores = ingresarAutores();
        while(ejemplares == 0){
            System.out.println("Ingrese cuantos periodicos se registraran");
            ejemplares = teclado.leerInt();
        }
        notas = ingresarNotas();
        while(numeroPublicacion == 0){
            System.out.println("Ingrese el numero de publicacion del periodico");
            numeroPublicacion = teclado.leerInt();
        }
        while(lugarDeEdicion == ""){
            System.out.println("Ingrese el lugar de edicion del periodico");
            lugarDeEdicion = teclado.leerCadena();
        }
        while(nombreDeLaCadena == ""){
            System.out.println("Ingrese el nombre de la cadena publicadora del periodico");
            nombreDeLaCadena = teclado.leerCadena();
        }
        while(periodicidad == ""){
            System.out.println("Ingrese la periodicidad del periodico");
            periodicidad = teclado.leerCadena();
        }
        control.registrarTexto(notas, numeroPublicacion, lugarDeEdicion, nombreDeLaCadena, periodicidad, titulo, autores, fechaPublicacion, numeroPaginas, lugarPublicacion, ejemplares);
    }
    public boolean ingresarClaveBibliotecario(){
        System.out.println("Ingrese su clave");
        String clave = teclado.leerCadena();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = teclado.leerCadena();
        return control.identificarBibliotecario(clave, contrasenia);
    }
    public boolean ingresarClaveAsociado(String clave){ 
        System.out.println("Ingrese su contrasenia");
        String contrasenia = teclado.leerCadena();
        return control.identificarAsociado(clave, contrasenia);
    }
    public void registrarNuevoTexto(){
        int opcion = 0;
        if(ingresarClaveBibliotecario()){
        //if(true){
            System.out.println("        --REGISTRO DE TEXTOS--");
            do{
                System.out.println("Ingrese que tipo de texto desea registrar"+"\n"
                                    +"Ingrese 0 para salir"+"\n"
                                    +"1) Libro"+"\n"
                                    +"2) Revista"+"\n"
                                    +"3) Periodico"+"\n"
                                    +"Ingrese la opcion deseada"+"\n");
                opcion = teclado.leerInt();
                switch(opcion){
                    case 1:
                        ingresarDatosLibro();
                    break;
                    case 2:
                        ingresarDatosRevista();
                    break;  
                    case 3:
                        ingresarDatosPeriodico();
                    break;    
                }
            }while(opcion != 0);
        }
    }
    private void ingresarDatosRevista(){
        String[][]  autores;
        String      nombreDeLaCadena    = "";
        String      titulo              = "";
        String      tematica            = "";
        String      fechaPublicacion    = "";
        String      lugarPublicacion    = "";
        String      periodicidad        = "";
        int         numeroDePaginas     = 0;
        int         numeroPublicacion   = 0;
        int existencias = 0;
        
        while(nombreDeLaCadena == ""){
            System.out.println("Ingrese el nombre de la cadena");
            nombreDeLaCadena = teclado.leerCadena();
        }
        while(titulo == ""){
            System.out.println("Ingrese el titulo de la revista");
            titulo = teclado.leerCadena();        
        }
        autores = ingresarAutores();
        while(fechaPublicacion == ""){
            System.out.println("Ingrese el fecha de publicacion de la revista");
            fechaPublicacion = teclado.leerCadena();        
        }
        while(numeroDePaginas <= 0 ){
            System.out.println("Ingrese el numero de paginas de la revista");
            numeroDePaginas = teclado.leerInt();
        }
        while(lugarPublicacion == ""){
            System.out.println("Ingrese el lugar de publicacion");
            lugarPublicacion = teclado.leerCadena();
        }
        while(periodicidad == ""){
            System.out.println("Ingrese la periodicidad de la revista");
            periodicidad = teclado.leerCadena();
        }
        while(numeroPublicacion <= 0){
            System.out.println("Ingrese el numero de publicacion de la revista");
            numeroPublicacion = teclado.leerInt();
        }
        while(tematica == ""){
            System.out.println("Ingrese la temmatica de la revista");
            tematica = teclado.leerCadena();
        }
        control.registrarTexto(titulo, autores, fechaPublicacion, numeroDePaginas, lugarPublicacion, nombreDeLaCadena, periodicidad, numeroPublicacion, tematica, existencias);
    }
    private void ingresarDatosBibliotecario(){
        //if(ingresarClave()){        
        if(true){
            String  nombre      = "";
            String  contraseña  = "";
            String  turno       = "";
            
            while(nombre == ""){
                System.out.println("Ingrese el nombre del bibliotecario");
                nombre = teclado.leerCadena();
            }
            while(contraseña == ""){
                System.out.println("Ingrese su contraseña");
                contraseña = teclado.leerCadena();
            }
            while(turno == ""){
                System.out.println("Ingrese el turno del bibliotecario");
                turno = teclado.leerCadena();
            }
            String id = control.registrarBibliotecario(nombre, contraseña, turno);
            System.out.println("Registro realizado con exito"+"\n"
                              +"Su clave es         "+id+"\n"
                              +"Y su contraseña:    "+contraseña+"\n");
        }
    }
    public void destruir(){
        if(control != null){
            control.destruir();
            control = null;
        }
        System.gc();
    }
    @Override
    public String toString() {
        return "MenuDeAccion{" + "teclado=" + teclado + ", control=" + control + '}';
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof MenuDeAccion)){return false;}
        MenuDeAccion casteo = (MenuDeAccion)objeto;
        return super.equals(casteo) && control.equals(casteo.control) && teclado.equals(casteo.teclado);
    }
}