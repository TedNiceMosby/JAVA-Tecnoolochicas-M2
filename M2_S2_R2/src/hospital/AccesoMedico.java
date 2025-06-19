package hospital;

// Representa un médico intentando acceder a un recurso hospitalario
public class AccesoMedico implements Runnable {
    private final AreaHospitalaria area;
    private final String nombre;

    public AccesoMedico(AreaHospitalaria area, String nombre) {
        this.area = area;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        area.usar("Dr. " + nombre);
    }
}
