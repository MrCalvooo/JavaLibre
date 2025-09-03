import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // Cambiar a ArrayList para permitir ordenamiento
        List<Libro> libros = new ArrayList<>();

        // Agregar libros a la lista
        libros.add(new Libro(2021, "Autor Uno", "Titulo Uno"));
        libros.add(new Libro(2020, "Autor Dos", "Titulo Dos"));
        libros.add(new Libro(2019, "Autor Tres", "Titulo Tres"));
        libros.add(new Libro(2022, "Autor Cuatro", "Titulo Cuatro"));

        // Ordenar libros por año usando el ComparadorPorAño
        libros.sort(new ComparadorPorAño());
        System.out.println("Ordenados por año:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }

        // Ordenar libros por autor usando el ComparadorPorAutor
        libros.sort(new ComparadorPorAutor());
        System.out.println("\nOrdenados por autor:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}
