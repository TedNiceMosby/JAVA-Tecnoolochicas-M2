import hospital.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Simulación iniciada: acceso controlado a recurso médico\n");

        // Creamos el recurso crítico: una sala de cuidados intensivos
        AreaHospitalaria sala = new AreaHospitalaria("Unidad de Cuidados Intensivos");

        // Creamos un grupo de profesionales que intentan acceder al mismo recurso
        Runnable drGomez = new AccesoMedico(sala, "Gómez");
        Runnable enfSanchez = new AccesoEnfermero(sala, "Sánchez");
        Runnable tecnicoLuque = new AccesoTecnicoRx(sala, "Luque");
        Runnable intensivistaMora = new AccesoIntensivista(sala, "Mora");
        Runnable drRodriguez = new AccesoMedico(sala, "Rodríguez");

        // Usamos un pool de 4 hilos para simular concurrencia real
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Enviamos todas las tareas al pool
        executor.execute(drGomez);
        executor.execute(enfSanchez);
        executor.execute(tecnicoLuque);
        executor.execute(intensivistaMora);
        executor.execute(drRodriguez);

        // Cerramos el executor para que el programa termine cuando todas las tareas finalicen
        executor.shutdown();
    }
}
