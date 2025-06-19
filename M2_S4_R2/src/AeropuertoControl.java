import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;

// Clase principal que gestiona todas las verificaciones asincrónicas
public class AeropuertoControl {
    private final RegistroEventos logger = new RegistroEventos();

    // Verificación de disponibilidad de pista
    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean ok = ProbabilidadServicio.conProbabilidad(0.8);
                logger.registrar(" Pista disponible: " + ok);
                return ok;
            } catch (InterruptedException e) {
                throw new RuntimeException("Fallo en verificación de pista");
            }
        });
    }

    // Verificación de clima
    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean ok = ProbabilidadServicio.conProbabilidad(0.85);
                logger.registrar("Clima favorable: " + ok);
                return ok;
            } catch (InterruptedException e) {
                throw new RuntimeException("Fallo en verificación de clima");
            }
        });
    }

    // Verificación de tráfico aéreo
    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean ok = ProbabilidadServicio.conProbabilidad(0.9);
                logger.registrar(" Tráfico aéreo despejado: " + ok);
                return ok;
            } catch (InterruptedException e) {
                throw new RuntimeException("Fallo en verificación de tráfico aéreo");
            }
        });
    }

    // Verificación de personal en tierra
    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean ok = ProbabilidadServicio.conProbabilidad(0.95);
                logger.registrar(" Personal disponible: " + ok);
                return ok;
            } catch (InterruptedException e) {
                throw new RuntimeException("Fallo en verificación de personal de tierra");
            }
        });
    }

    // Método principal para evaluar todo en paralelo
    public void evaluarCondicionesAterrizaje() {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        // Esperamos a que todas terminen
        CompletableFuture<Void> todas = CompletableFuture.allOf(pista, clima, trafico, personal);

        todas.thenRun(() -> {
            try {
                boolean autorizacion =
                        pista.get() && clima.get() && trafico.get() && personal.get();
                if (autorizacion) {
                    logger.registrar("\n Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    logger.registrar("\n Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (Exception e) {
                logger.registrar("\n Error al evaluar condiciones: " + e.getMessage());
            }
        }).exceptionally(ex -> {
            logger.registrar("\nError crítico en proceso de aterrizaje: " + ex.getMessage());
            return null;
        });
    }
}
