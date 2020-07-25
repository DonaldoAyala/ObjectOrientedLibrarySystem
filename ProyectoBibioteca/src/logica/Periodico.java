package logica;
import java.io.Serializable;
/**
 * @Donaldo
 */
public class Periodico extends TextoInformativo implements Serializable{
    private String[] notas;
    
    public Periodico(){
        super();
        notas = null;
    }
    public Periodico(String[] notas, int numeroPublicacion, String lugarDeEdicion, String nombreDeLaCadena, String periodicidad, String titulo, Autor[] autores, String fechaPublicacion, int numeroDePaginas, String lugarPublicacion) {
        super(numeroPublicacion, nombreDeLaCadena, periodicidad, titulo, autores, fechaPublicacion, numeroDePaginas, lugarPublicacion);
        this.notas = notas;
    }
    public Periodico(Periodico periodico){
        super(periodico);
        notas = periodico.notas;
    }
    @Override
    public void editarTexto(Texto texto) {
        if(texto instanceof Periodico && texto != null){
            Periodico periodico = (Periodico)texto;
            notas = periodico.notas;
            setAutores(periodico.getAutores());
            setFechaPublicacion(periodico.getFechaPublicacion());
            setLugarPublicacion(periodico.getLugarPublicacion());
            setNombreDeLaCadena(periodico.getNombreDeLaCadena());
            setNumeroDePaginas(periodico.getNumeroDePaginas());
            setNumeroPublicacion(periodico.getNumeroPublicacion());
            setPeriodicidad(periodico.getPeriodicidad());
            setTitulo(periodico.getTitulo());
        }
    }
    @Override
    public void informar(){
        System.out.println("Informando acerca de las notas: ");
        for(int i=0;i<notas.length ; i++){
            System.out.println(notas[i]);
        }
    }
    @Override
    public void darInformacion(){
        System.out.println("Dando informacion acerca de las notas: ");
        for(int i=0;i<notas.length ; i++){
            System.out.println(notas[i]);
        }
    }
    @Override
    public void destruir(){
        if(notas != null){
            notas = null;
        }
        System.gc();
    }
    @Override
    public String toString() {
        String nota = "";
        String autor = "";
        for(int i=0;i<notas.length;i++){
            nota += notas[i]+", ";
        }
        for(int i=0; i< getAutores().length ; i++){
            autor += getAutores()[i]+", ";
        }
        return   "\n    Periodico\n"
                +"CADENA:"+getNombreDeLaCadena()+"\n"
                +"TITULO:"+getTitulo()+"\n"
                +"NOTAS:"+nota+"\n"
                +"FECHA:"+getFechaPublicacion()
                +"AUTO(RES):"+autor+"\n"
                ;
    }
    @Override
    public boolean equals(Object objeto) {
        if(objeto == null){return false;}
        if(!(objeto instanceof Periodico)){return false;}
        Periodico casteo = (Periodico)objeto;
        return super.equals(casteo) && notas.equals(casteo.notas);
    }

}