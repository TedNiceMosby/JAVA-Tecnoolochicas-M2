public class Main {
    public static void main(String[] args) throws InterruptedException {
        AeropuertoControl control = new AeropuertoControl();

        // Iniciamos el proceso
        control.evaluarCondicionesAterrizaje();

        // Permitimos que el proceso asincrónico tenga tiempo para completarse
        Thread.sleep(5000);
    }
}
