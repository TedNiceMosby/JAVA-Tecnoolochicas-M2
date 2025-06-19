import java.util.Optional;

// Representa una encuesta hecha por un paciente
public class Encuesta {
    private String paciente;
    private String comentario; // puede ser null
    private int calificacion;

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    // Devuelve un Optional para manejar comentarios nulos sin ifs
    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }
}
