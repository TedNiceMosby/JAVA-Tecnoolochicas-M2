package hospital;

// Médico de cuidados intensivos que necesita acceso rápido a la UCI
public class AccesoIntensivista implements Runnable {
    private final AreaHospitalaria area;
    private final String nombre;

    public AccesoIntensivista(AreaHospitalaria area, String nombre) {
        this.area = area;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        area.usar("Intensivista " + nombre);
    }
}
