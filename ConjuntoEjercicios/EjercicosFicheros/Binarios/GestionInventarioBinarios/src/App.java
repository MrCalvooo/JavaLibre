
import java.io.DataInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
Implementar una aplicación en Java que permita almacenar y procesar un inventario de productos en un archivo 
binario. 
Cada producto contendrá varios campos y el programa deberá ser capaz de escribir y leer dichos registros.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Set<Producto> inventario = new HashSet<>();
        int op;
        Path archivo = Paths.get("productos.bin");

        if (!Files.exists(archivo)) {
            Files.createFile(archivo);
        }

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("1.- Agregar productos al inventario");
                System.out.println("2.- Mostrar inventario y calcular total");
                System.out.println("3.- Salir");

                System.out.println("Que opcion desea?: ");
                op = Integer.parseInt(scanner.nextLine());

                if (op == 3) {
                    break;
                } else {

                    switch (op) {
                        case 1 -> {
                            System.out.println("Productos a agregar?: ");
                            int cantidad = Integer.parseInt(scanner.nextLine());

                            for (int i = 0; i < cantidad; i++) {
                                Producto.agregarProducto(inventario, i, archivo);
                            }

                            TimeUnit.SECONDS.sleep(1);
                        }

                        case 2 -> {
                            System.out.println("\nINVENTARIO: ");
                            DataInputStream dis = new DataInputStream(Files.newInputStream(archivo));
                            
                            System.out.println("\nPrecio total: ");
                            System.out.println(Producto.calcularTotal(inventario));

                            TimeUnit.SECONDS.sleep(3);
                        }

                        default -> {
                            System.out.println("Elija un numero de los q se le muestran");
                        }
                    }
                }

            } while (op < 1 || op > 3);
        }
    }

    
}
