package sistemas;

import java.util.concurrent.Callable;

// Cambié el nombre a "ModuloNavegacion" en lugar de "SistemaNavegacion" para variar el diseño original
public class ModuloNavegacion implements Callable<String> {

    @Override
    public String call() throws Exception {
        // Simulamos tiempo de cálculo de trayectoria
        Thread.sleep(1000);
        return "Navegación: trayectoria corregida con éxito.";
    }
}
