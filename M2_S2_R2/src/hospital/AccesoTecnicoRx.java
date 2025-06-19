package hospital;

// Técnico de rayos X accediendo al recurso (por ejemplo, sala de imagenología)
public class AccesoTecnicoRx implements Runnable {
    private final AreaHospitalaria area;
    private final String nombre;

    public AccesoTecnicoRx(AreaHospitalaria area, String nombre) {
        this.area = area;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        area.usar(" Téc. RX " + nombre);
    }
}
