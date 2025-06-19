package sistemas;

import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(800); // Simulamos verificación de oxígeno y presión
        return "Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}
