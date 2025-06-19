import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear listas de órdenes
        List<OrdenMasa> ordenesMasa = Arrays.asList(
                new OrdenMasa("A123", 500),
                new OrdenMasa("A124", 750)
        );

        List<OrdenPersonalizada> ordenesPersonalizadas = Arrays.asList(
                new OrdenPersonalizada("P456", 100, "ClienteX"),
                new OrdenPersonalizada("P789", 150, "ClienteY")
        );

        List<OrdenPrototipo> ordenesPrototipo = Arrays.asList(
                new OrdenPrototipo("T789", 10, "Diseño"),
                new OrdenPrototipo("T790", 5, "Pruebas")
        );

        // Mostrar órdenes de cada tipo
        GestorOrdenes.mostrarOrdenes(ordenesMasa);
        GestorOrdenes.mostrarOrdenes(ordenesPersonalizadas);
        GestorOrdenes.mostrarOrdenes(ordenesPrototipo);

        // Procesar las órdenes personalizadas
        GestorOrdenes.procesarPersonalizadas(new ArrayList<>(ordenesPersonalizadas), 200);

        // Desafío adicional: resumen total
        System.out.println("Resumen total de órdenes:");
        System.out.println("Producción en masa: " + ordenesMasa.size());
        System.out.println("Personalizadas: " + ordenesPersonalizadas.size());
        System.out.println("Prototipos: " + ordenesPrototipo.size());
    }
}
