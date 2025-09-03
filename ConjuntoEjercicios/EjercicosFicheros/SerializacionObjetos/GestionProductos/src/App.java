
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {
        Path listado = Paths.get("productos.txt");
        Set<Producto> productos = new HashSet<>();
        int opcion;

        // Comprobaciones
        if (!Files.exists(listado)) {
            Files.createFile(listado);
        } else {
            // Comprobamos que el fichero NO esta vacio
            if (Files.size(listado) > 0) {
                // Insertamos en memoria todos los productos almacenados en el fichero
                try (InputStream fis = Files.newInputStream(listado); ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis))) {
                    while (true) {
                        try {
                            Producto producto = (Producto) ois.readObject();
                            productos.add(producto);
                        } catch (java.io.EOFException eof) {
                            break; // Fin del archivo
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error al leer el fichero");
                }
            }
        }

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("OPCIONES: ");
                System.out.println("1. Insertar producto");
                System.out.println("2. Eliminar productos");
                System.out.println("3. Listar productos");
                System.out.println("4. Salir");
                System.out.println("Opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> {
                        try {
                            Producto.insertarProducto(productos, scanner);
                            Producto.actualizarProductos(productos, listado);
                        } catch (IOException e) {
                            System.out.println("Error al insertar el producto: " + e.getMessage());
                        }
                        break;
                    }
                    case 2 -> {
                        Producto.eliminarProductos(productos, scanner);
                        Producto.actualizarProductos(productos, listado);
                        break;
                    }
                    case 3 -> {
                        Producto.verProductos(listado);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    }
                    default -> {

                    }
                }
            } while (opcion > 0 && opcion < 4);
        }
    }
}
