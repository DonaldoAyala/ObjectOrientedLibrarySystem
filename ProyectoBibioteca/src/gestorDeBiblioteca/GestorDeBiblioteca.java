package gestorDeBiblioteca;
/**
 * @author Donaldo
 */
import vista.MenuDeAccion;
public class GestorDeBiblioteca {
    public static void main(String[] args) {
        MenuDeAccion menu = new MenuDeAccion();
        menu.mostrarMenuDeAcciones();
        menu.destruir();
        menu = null;
        System.gc();
    }
}
