public class Main {
    public static void main(String[] args) throws InterruptedException {
        SimuladorViaje app = new SimuladorViaje();

        // Procesamos una solicitud de viaje
        app.procesarSolicitudDeViaje();

        // Esperamos unos segundos para permitir que las tareas asíncronas terminen (solo para esta demo)
        Thread.sleep(5000);
    }
}
