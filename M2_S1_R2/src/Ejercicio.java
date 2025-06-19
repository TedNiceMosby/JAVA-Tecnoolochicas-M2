// Representa un ejercicio que puede o no estar revisado
public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void marcarRevisado() {
        this.revisado = true;
        System.out.println("Ejercicio '" + titulo + "' marcado como revisado.");
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }
}
