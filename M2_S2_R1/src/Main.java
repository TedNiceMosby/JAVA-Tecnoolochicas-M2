import sistemas.*;

import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Simulación de misión espacial iniciada...\n");

        // Usamos un pool de 5 hilos porque tenemos 5 subsistemas
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Creamos una lista con todas las tareas (cada una representa un subsistema)
        List<Callable<String>> tareas = Arrays.asList(
                new ModuloNavegacion(),        // clase con nombre cambiado
                new SistemaSoporteVital(),
                new SistemaControlTermico(),
                new SistemaComunicaciones(),
                new SistemaEnergia()           // clase adicional
        );

        try {
            // Ejecutamos todas las tareas de forma concurrente y esperamos sus resultados
            List<Future<String>> resultados = executor.invokeAll(tareas);

            // Recorremos los resultados en el orden en que fueron enviadas
            for (Future<String> futuro : resultados) {
                // .get() bloquea hasta que la tarea esté completa
                System.out.println(futuro.get());
            }

            System.out.println("\nTodos los sistemas reportan estado operativo.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Ocurrió un error durante la simulación: " + e.getMessage());
        } finally {
            // Siempre cerramos el pool para liberar los recursos
            executor.shutdown();
        }
    }
}
