import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

// Esta clase simula la lógica de una app tipo Uber, usando programación asincrónica
public class SimuladorViaje {

    // Método que simula el cálculo de la ruta entre origen y destino
    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Calculando ruta...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4)); // simula latencia
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular ruta");
            }
        });
    }

    // Método que simula el cálculo del costo (renombrado de estimarTarifa a calcularCostoEstimado)
    public CompletableFuture<Double> calcularCostoEstimado() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Estimando tarifa...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3)); // simula latencia
                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar tarifa");
            }
        });
    }

    // Este método combina ambas tareas y muestra el mensaje final
    public void procesarSolicitudDeViaje() {
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = calcularCostoEstimado();

        rutaFuture
                .thenCombine(tarifaFuture, (ruta, tarifa) -> {
                    return "Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
                })
                .exceptionally(ex -> {
                    return "Error al procesar el viaje: " + ex.getMessage();
                })
                .thenAccept(System.out::println); // finalmente mostramos el mensaje
    }
}
