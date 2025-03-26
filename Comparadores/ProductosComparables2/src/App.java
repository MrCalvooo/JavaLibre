
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Televisor", 300.0, "electronica"));
        productos.add(new Producto("Camiseta", 20.0, "ropa"));
        productos.add(new Producto("Laptop", 800.0, "electronica"));
        productos.add(new Producto("Pantalones", 40.0, "ropa"));
        productos.add(new Producto("Libro", 15.0, "libros"));

        System.out.println("\nORDENAR POR NOMBRE");
        Collections.sort(productos);
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nORDENAR POR PRECIO");
        productos.sort(new ComparadorPorPrecio());
        // Reiniciar iterador
        it = productos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nORDENAR POR CATEGORIA");
        productos.sort(new ComparadorPorCategoria());
        // Reiniciar iterador
        it = productos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
