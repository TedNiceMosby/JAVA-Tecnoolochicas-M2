import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class SistemaCritico {

    private static final Random random = new Random();

    public static Flux<String> sensoresTrafico() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(congestion -> congestion > 70)
                .map(c -> "🚗 Congestión alta: " + c + "%")
                .onBackpressureBuffer()
                .delayElements(Duration.ofMillis(300));
    }

    public static Flux<String> estadoClima() {
        return Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(101))
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ PM2.5 crítico: " + pm + " ug/m3");
    }

    public static Flux<String> accidentes() {
        String[] prioridades = {"Baja", "Media", "Alta"};
        return Flux.interval(Duration.ofMillis(800))
                .map(i -> prioridades[random.nextInt(3)])
                .filter(p -> p.equals("Alta"))
                .map(p -> "🚑 Accidente prioridad Alta");
    }

    public static Flux<String> trenes() {
        return Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11))
                .filter(delay -> delay > 5)
                .map(d -> "🚝 Retraso tren: " + d + " minutos");
    }

    public static Flux<String> semaforos() {
        String[] estados = {"Verde", "Amarillo", "Rojo"};
        int[] contador = {0};

        return Flux.interval(Duration.ofMillis(400))
                .map(i -> estados[random.nextInt(estados.length)])
                .map(estado -> {
                    if (estado.equals("Rojo")) {
                        contador[0]++;
                        if (contador[0] >= 3) {
                            contador[0] = 0;
                            return "🚦 Semáforo rojo repetido 3 veces";
                        }
                    } else {
                        contador[0] = 0;
                    }
                    return null;
                })
                .filter(m -> m != null);
    }
}
