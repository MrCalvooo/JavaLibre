
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
Enunciado del ejercicio:
Crea un archivo de texto llamado productos.txt.
El archivo debe contener una lista de productos. 
Cada línea del archivo representa un producto con el siguiente formato: NombreProducto,Precio,Cantidad. 
Por ejemplo: Manzana,0.5,10
Pan,1.2,5
Leche,0.8,8
Escribe un programa que:
Lea el contenido del archivo productos.txt.
Calcule el valor total de cada producto en función de su precio y cantidad (ValorTotal = Precio * Cantidad).
Muestre en la consola el nombre del producto y su valor total.
Agregue una nueva línea al archivo con el nombre del producto más caro, indicando el precio total.
 */
public class App {

    public static void main(String[] args) throws Exception {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Manzana", 0.5, 10));
        productos.add(new Producto("Pan", 1.2, 5));
        productos.add(new Producto("Leche", 0.8, 8));
        productos.add(new Producto("Arroz", 2.0, 3));
        productos.add(new Producto("Huevos", 0.2, 12));
        Path archivo = Paths.get("productos.txt");

        try {
            if (Files.exists(archivo)) {
                // Eliminamos registros existentes
                Files.writeString(archivo, "", StandardOpenOption.TRUNCATE_EXISTING);
            }

            // Creamos el archivo
            Files.writeString(archivo, "", StandardOpenOption.CREATE);

            System.out.println("INSERTANDO PRODUCTOS EN EL ARCHIVO: " + archivo.getFileName());
            insertarProductos(productos, archivo);

            System.out.println("LECTURA PRODUCTOS");
            leerFichero(productos, archivo);

            insertarProductoMasValioso(productos, archivo);

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo: " + e.getMessage());
        } catch (IOException e){
            System.out.println("Error con el tratamiento de datos: " + e.getMessage());
        }
    }

    public static void leerFichero(List<Producto> productos, Path archivo) throws IOException {
        Scanner scanner = new Scanner(archivo);

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }

    public static void insertarProductos(List<Producto> productos, Path archivo) throws IOException, FileNotFoundException {
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Files.writeString(archivo, iterator.next().toString() + System.lineSeparator(), StandardOpenOption.APPEND);
        }
    }

    public static void insertarProductoMasValioso(List<Producto> productos, Path archivo) throws IOException, FileNotFoundException {
        // PRECIOS
        double valorMaximo = 0.;
        int productoMaximo = 0;
        for (int i = 0; i < productos.size(); i++) {
            double valor = productos.get(i).getPrecio() * productos.get(i).getCantidad();
            System.out.println("Valor del producto " + productos.get(i).getNombre() + ": " + valor);

            if (valor > valorMaximo) {
                valorMaximo = valor;
                productoMaximo = i;
            }
        }

        Files.writeString(archivo, "Producto mas caro: " + productos.get(productoMaximo).getNombre() + " valor: " + valorMaximo, StandardOpenOption.APPEND);
    }
}
