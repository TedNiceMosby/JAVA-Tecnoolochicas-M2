import java.util.*;
import java.util.stream.*;

public class ConfirmadorPedidos {
    public static void main(String[] args) {
        // Lista de órdenes simulada con algunos teléfonos null
        List<OrdenPizza> ordenes = Arrays.asList(
                new OrdenPizza("Luis", "domicilio", "555-1234"),
                new OrdenPizza("Ana", "local", null),
                new OrdenPizza("Carlos", "domicilio", null),
                new OrdenPizza("María", "domicilio", "555-5678")
        );

        // Aquí filtramos solo las órdenes para entrega a domicilio
        // y luego usamos Stream + flatMap para procesar solo las que tienen teléfono válido
        List<String> mensajesConfirmacion = ordenes.stream()
                .filter(o -> o.getTipoEntrega().equalsIgnoreCase("domicilio")) // solo domicilio
                .map(OrdenPizza::obtenerContacto)                               // Optional<String>
                .flatMap(Optional::stream)                                     // convierte a Stream<String> solo si está presente
                .map(tel -> "Confirmación enviada al número: " + tel)       // mensaje personalizado
                .collect(Collectors.toList());                                 // recolectamos a lista final

        // Mostramos los mensajes
        mensajesConfirmacion.forEach(System.out::println);

        // NOTA: usar Optional nos evitó tener que verificar nulls explícitamente
    }
}
