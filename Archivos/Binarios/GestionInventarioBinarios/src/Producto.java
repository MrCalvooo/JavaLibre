
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Producto {

    private final int id;
    private final String nombre;
    private final int cantidad;
    private final double precio;

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }

    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public static void buscarProducto(Set<Producto> productos, int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                System.out.println("Producto encontrado: " + p.toString());
            }
        }
    }

    public static double calcularTotal(Set<Producto> productos) {
        Iterator<Producto> it = productos.iterator();
        double valor = 0.;

        while (it.hasNext()) {
            Producto pTemp = it.next();
            valor += pTemp.getPrecio() * pTemp.getCantidad();
        }

        return valor;
    }

    public static void agregarProducto(Set<Producto> productos, int i, Path archivo) throws IOException {
        try (Scanner scanner = new Scanner(System.in); DataOutputStream dos = new DataOutputStream(Files.newOutputStream(archivo, StandardOpenOption.WRITE, StandardOpenOption.APPEND))) {

            dos.writeInt(i);

            System.out.println("Nombre: ");
            String nombreP = scanner.nextLine();
            dos.writeUTF(nombreP);

            System.out.println("Precio: ");
            double precioP = Double.parseDouble(scanner.nextLine());
            dos.writeDouble(precioP);

            System.out.println("Cantidad: ");
            int cantidadP = Integer.parseInt(scanner.nextLine());
            dos.writeInt(cantidadP);

            productos.add(new Producto(i, nombreP, cantidadP, precioP));

        } catch (NumberFormatException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
    }

    public static Set<Producto> leerProductos(Set<Producto> productos, Path archivo) {

        try (DataInputStream dis = new DataInputStream(Files.newInputStream(archivo))) {
            while (true) {
                try {
                    // Leer en el mismo orden en que se escribió: id, nombre, precio, cantidad
                    int id = dis.readInt();
                    String nombre = dis.readUTF();
                    double precio = dis.readDouble();
                    int cantidad = dis.readInt();
                    productos.add(new Producto(id, nombre, cantidad, precio));
                } catch (IOException e) {
                    // Fin del archivo alcanzado, salimos del bucle
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return productos;
    }

}
