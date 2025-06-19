package hospital;

// Simula a un enfermero que también requiere acceso exclusivo a la sala
public class AccesoEnfermero implements Runnable {
    private final AreaHospitalaria area;
    private final String nombre;

    public AccesoEnfermero(AreaHospitalaria area, String nombre) {
        this.area = area;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        area.usar("Enfermera " + nombre);
    }
}
