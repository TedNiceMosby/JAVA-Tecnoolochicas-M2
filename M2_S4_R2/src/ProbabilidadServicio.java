import java.util.Random;

// Clase auxiliar para simular fallos aleatorios en los servicios
public class ProbabilidadServicio {
    private static final Random random = new Random();

    // Devuelve true con la probabilidad indicada (0.0 a 1.0)
    public static boolean conProbabilidad(double probabilidad) {
        return random.nextDouble() < probabilidad;
    }
}
