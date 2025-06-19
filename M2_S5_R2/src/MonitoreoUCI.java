import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Random;

public class MonitoreoUCI {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        // Generador de eventos por paciente
        Flux<String> paciente1 = generarSignosVitales("Paciente 1", random);
        Flux<String> paciente2 = generarSignosVitales("Paciente 2", random);
        Flux<String> paciente3 = generarSignosVitales("Paciente 3", random);

        // Fusión de todos los pacientes en un solo flujo
        Flux.merge(paciente1, paciente2, paciente3)
                .delayElements(Duration.ofSeconds(1)) // Backpressure simulado
                .subscribe(System.out::println);

        // Mantener la app corriendo para recibir eventos
        Thread.sleep(20000); // 20 segundos de demo
    }

    private static Flux<String> generarSignosVitales(String paciente, Random random) {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> {
                    int fc = 40 + random.nextInt(101);         // 40–140 bpm
                    int sistolica = 80 + random.nextInt(81);   // 80–160 mmHg
                    int diastolica = 50 + random.nextInt(51);  // 50–100 mmHg
                    int spo2 = 85 + random.nextInt(16);        // 85–100 %

                    StringBuilder alerta = new StringBuilder();

                    // Se prioriza FC en los mensajes
                    if (fc < 50 || fc > 120) {
                        alerta.append("⚠️ ").append(paciente).append(" - FC crítica: ").append(fc).append(" bpm");
                    } else if (sistolica < 90 || sistolica > 140 || diastolica < 60 || diastolica > 90) {
                        alerta.append("⚠️ ").append(paciente).append(" - PA crítica: ")
                                .append(sistolica).append("/").append(diastolica).append(" mmHg");
                    } else if (spo2 < 90) {
                        alerta.append("⚠️ ").append(paciente).append(" - SpO2 baja: ").append(spo2).append("%");
                    }

                    return alerta.length() > 0 ? alerta.toString() : null;
                })
                .filter(alerta -> alerta != null); // Solo se emiten eventos críticos
    }
}
