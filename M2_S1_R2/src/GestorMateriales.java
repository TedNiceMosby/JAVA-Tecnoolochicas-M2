//package utils;
import java.util.List;
import java.util.function.Predicate;

// Clase utilitaria para trabajar con materiales de curso
public class GestorMateriales {

    // Muestra cualquier material, sin importar si es video, artículo o ejercicio
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println(" Materiales del curso:");
        for (MaterialCurso m : lista) {
            m.mostrarDetalle();
        }
        System.out.println();
    }

    // Suma las duraciones de todos los videos en la lista
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println(" Duración total de videos: " + total + " minutos\n");
    }

    // Marca todos los ejercicios como revisados (usando instanceof por si están mezclados)
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                ((Ejercicio) obj).marcarRevisado();
            }
        }
        System.out.println();
    }

    // Desafío adicional: filtrar por autor con Predicate
    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println(" Filtrando materiales por autor:");
        for (MaterialCurso m : lista) {
            if (filtro.test(m)) {
                m.mostrarDetalle();
            }
        }
        System.out.println();
    }
}
