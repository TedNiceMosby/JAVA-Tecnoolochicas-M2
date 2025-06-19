

// Clase base para cualquier tipo de material del curso
public abstract class MaterialCurso {
    protected String titulo;
    protected String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Cada tipo de material define su forma de mostrarse
    public abstract void mostrarDetalle();
}
