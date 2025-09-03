
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String nombre;
    private final double precio;
    private final int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + "]";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 97 * hash + this.cantidad;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }

        return Objects.equals(this.nombre, other.nombre);
    }

    public static void insertarProducto(Set<Producto> set, Scanner scanner) {
        try {
            System.out.println("Introduce el nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.println("Introduce el precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.println("Introduce la cantidad del producto: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            Producto producto = new Producto(nombre, precio, cantidad);

            if (!set.contains(producto)) {
                set.add(producto);
                System.out.println("Producto insertado correctamente");
            } else {
                System.out.println("El producto esta registrado");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato de número incorrecto. Asegúrate de introducir un número válido.");
        }
    }

    public static void eliminarProductos(Set<Producto> prods, Scanner scanner) {
        System.out.println("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        Iterator<Producto> it = prods.iterator();

        while (it.hasNext()) {
            Producto temp = it.next();

            if (nombre.equalsIgnoreCase(temp.getNombre())) {
                it.remove();
                System.out.println("Producto eliminado correctamente");
            }
        }
    }

    public static void verProductos(Path fichero) {
        try (InputStream fis = Files.newInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis))) {
            int precioTotal = 0, cantidadTotal = 0;
            while (true) {
                try {
                    Producto producto = (Producto) ois.readObject();
                    cantidadTotal += producto.getCantidad();
                    precioTotal += producto.getPrecio() * cantidadTotal;
                    System.out.println(producto);
                    System.out.println("Precio total del producto " + producto.getNombre() + ": " + precioTotal);
                } catch (java.io.EOFException eof) {
                    break; // Fin del archivo
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void actualizarProductos(Set<Producto> prods, Path fich) throws IOException {
        try (OutputStream fos = Files.newOutputStream(fich); ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))) {
            // Actualizamos el fichero con los nuevos productos
            for (Producto temp : prods) {
                oos.writeObject(temp);
            }
        }
    }

}
