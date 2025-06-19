import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Creamos las encuestas manualmente para este ejemplo
        List<Encuesta> centro = Arrays.asList(
                new Encuesta("Luis", "El tiempo de espera fue largo", 2),
                new Encuesta("Ana", null, 4),
                new Encuesta("Carlos", "Falta ventilación en la sala", 3)
        );

        List<Encuesta> norte = Arrays.asList(
                new Encuesta("María", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("Pedro", null, 5)
        );

        // Creamos las sucursales
        List<Sucursal> sucursales = Arrays.asList(
                new Sucursal("Centro", centro),
                new Sucursal("Norte", norte)
        );

        // Creamos el receptor de calidad que mostrará los mensajes
        ResponsableCalidad calidad = new ResponsableCalidad();

        // Procesamos las encuestas con Stream API
        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3) // encuestas insatisfechas
                                .map(e -> e.getComentario()
                                        .map(c -> "Sucursal " + sucursal.getNombre() +
                                                ": Seguimiento a paciente con comentario: \"" + c + "\""))
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                )
                .forEach(calidad::recibirMensaje); // Enviamos el mensaje al receptor
    }
}
