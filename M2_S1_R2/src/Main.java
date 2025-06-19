
//import utils.GestorMateriales;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Creamos listas de materiales
        List<Video> videos = Arrays.asList(
                new Video("Introducción a Java", "Mario", 15),
                new Video("POO en Java", "Carlos", 20)
        );

        List<Articulo> articulos = Arrays.asList(
                new Articulo("Historia de Java", "Ana", 1200),
                new Articulo("Tipos de datos", "Luis", 800)
        );

        List<Ejercicio> ejercicios = Arrays.asList(
                new Ejercicio("Variables y tipos", "Luis"),
                new Ejercicio("Condicionales", "Mario")
        );

        // Juntamos todos los materiales en una lista común
        List<MaterialCurso> todos = new ArrayList<>();
        todos.addAll(videos);
        todos.addAll(articulos);
        todos.addAll(ejercicios);

        // Mostrar todos los materiales
        GestorMateriales.mostrarMateriales(todos);

        // Contar duración de los videos
        GestorMateriales.contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        GestorMateriales.marcarEjerciciosRevisados(ejercicios);

        // Filtrar por autor (desafío adicional)
        Predicate<MaterialCurso> esDeMario = material -> material.autor.equals("Mario");
        GestorMateriales.filtrarPorAutor(todos, esDeMario);
    }
}
