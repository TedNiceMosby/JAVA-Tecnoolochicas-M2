public class Main {
    public static void main(String[] args) throws InterruptedException {
        GestorEventos.monitorear();

        // Esperar para que los eventos fluyan (solo para la demo)
        Thread.sleep(20000);
    }
}
