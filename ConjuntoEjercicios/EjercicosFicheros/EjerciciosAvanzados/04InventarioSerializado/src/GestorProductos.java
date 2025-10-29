import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorProductos {
    public static Producto registrarProducto(int productos) {

        int id = productos + 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.println("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.println("Cantidad del producto a registrar: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        return new Producto(id, nombre, precio, cantidad);
    }

    public static List<Producto> cargarProductos(File file) {
        List<Producto> productos = new ArrayList<>();
        if (file.exists() && file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (true) {
                    productos.add((Producto) ois.readObject());
                }
            } catch (EOFException e) {
                // Fin del fichero alcanzado, es normal.
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al leer el fichero de productos: " + e.getMessage());
            }
        }
        return productos;
    }
    public static void listarProductos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Stock: " + producto.getStock());
        }
    }
}
