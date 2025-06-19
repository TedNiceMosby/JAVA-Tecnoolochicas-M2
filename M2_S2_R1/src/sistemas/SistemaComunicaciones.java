package sistemas;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(700); // Simulamos establecimiento de enlace con la estación
        return "Comunicaciones: enlace con estación terrestre establecido.";
    }
}
