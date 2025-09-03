
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Manzanas", 1.20, "Frutas"));
        productos.add(new Producto("Cereal", 3.50, "Desayuno"));
        productos.add(new Producto("Leche", 0.99, "Lácteos"));
        productos.add(new Producto("Pollo", 5.99, "Carnes"));
        productos.add(new Producto("Pasta", 2.50, "Granos"));

        // Ordenar usando Comparable
        System.out.println("Ordenado por precio:");
        productos.sort(null); // COMPLETAR
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Comparator por nombre
        productos.sort(new ComparatorNombre());
        System.out.println("\nOrdenado por nombre:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Comparator por categoría
        productos.sort(new ComparatorCategoria());
        System.out.println("\nOrdenado por categoría:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
