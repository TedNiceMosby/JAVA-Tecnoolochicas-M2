package hospital;

import java.util.concurrent.locks.ReentrantLock;

// Esta clase representa un recurso hospitalario crítico (como un quirófano).
// Cambié el nombre de RecursoMedico a AreaHospitalaria para que suene más general.
public class AreaHospitalaria {
    private final String nombre;
    private final ReentrantLock lock;

    public AreaHospitalaria(String nombre) {
        this.nombre = nombre;
        this.lock = new ReentrantLock();
    }

    // Este método simula el uso del recurso por un profesional.
    public void usar(String profesional) {
        lock.lock(); // Solicitamos acceso exclusivo
        try {
            System.out.println("🔓 " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000); // Simula el tiempo de uso
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println(profesional + " fue interrumpido durante el uso de " + nombre);
        } finally {
            lock.unlock(); // Liberamos el recurso
        }
    }
}
