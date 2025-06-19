package sistemas;

import java.util.concurrent.Callable;

// Clase adicional que representa el monitoreo energético de la nave
public class SistemaEnergia implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(950); // Simula análisis de carga energética
        return "Energía: sistema funcionando con 98% de carga.";
    }
}
