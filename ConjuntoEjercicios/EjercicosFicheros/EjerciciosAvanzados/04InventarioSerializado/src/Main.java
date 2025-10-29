import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("productos.dat");

        List<Producto> listaProductos = GestorProductos.cargarProductos(file);

        Scanner scanner = new Scanner(System.in);

        // Si la lista está vacía (fichero no existía o estaba vacío), la inicializamos.
        if (listaProductos.isEmpty()) {
            System.out.println("No se encontraron productos, inicializando inventario base.");
            listaProductos.add(new Producto(1, "Laptop", 1200.50, 10));
            listaProductos.add(new Producto(2, "Mouse", 25.00, 50));
            listaProductos.add(new Producto(3, "Teclado", 75.75, 30));
            listaProductos.add(new Producto(4, "Monitor", 300.00, 20));

            // Escribimos la lista inicial completa al fichero
            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Producto p : listaProductos) {
                    oos.writeObject(p);
                }
            } catch (IOException e) {
                System.err.println("Error al inicializar el fichero de productos: " + e.getMessage());
            }
        }

        try {
            String decision;

            do {
                System.out.println("Desea registrar productos nuevos? (y/n): ");
                decision = scanner.nextLine();
                if (!decision.equalsIgnoreCase("y") && !decision.equalsIgnoreCase("n")) {
                    System.out.println("Porfavor introduzca 'y' o 'n'");
                }
            } while (!decision.equalsIgnoreCase("y") && !decision.equalsIgnoreCase("n"));

            if (decision.equalsIgnoreCase("y")) {
                Producto nuevoProducto = GestorProductos.registrarProducto(listaProductos.size());
                listaProductos.add(nuevoProducto);

                // Usamos modo 'append' (true) y nuestra clase MiObjectOutputStream
                try (FileOutputStream fos = new FileOutputStream(file, true);
                     ObjectOutputStream oos = new MiObjectOutputStream(fos)) {
                    oos.writeObject(nuevoProducto);
                    System.out.println("Producto añadido y guardado correctamente.");
                }
            }

            do {
                System.out.println("Desea consultar los productos? (y/n): ");
                decision = scanner.nextLine();
            } while (!decision.equalsIgnoreCase("y") && !decision.equalsIgnoreCase("n"));
            if (decision.equalsIgnoreCase("y")) {
                System.out.println("\n--- Inventario Actual ---");
                GestorProductos.listarProductos(listaProductos);
                System.out.println("-------------------------\n");
            }
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error de E/S: " + e.getMessage());
        }
    }
}