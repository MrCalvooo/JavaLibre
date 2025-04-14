
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        int opcion;
        Path archivo = Paths.get("archivo.bin");

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("1.- Cifrar");
                System.out.println("2.- Descrifrar");

                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion < 0 && opcion > 2) {
                    System.out.println("Introduzca una opcion valida");
                } else if (opcion == 1) {
                    System.out.println("Mensaje a cifrar: ");

                    String mensaje = scanner.nextLine();

                    System.out.println(cifrar(archivo, mensaje));
                }
            } while (opcion < 0 || opcion > 2);
        }
    }

    public static String cifrar(Path archivo, String mensaje) throws IOException {
        int seed = 0;
        Random random = new Random((long) (Math.random() * Integer.MAX_VALUE));

        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            seed += caracter + random.nextInt();
        }

        try (BufferedReader reader = Files.newBufferedReader(archivo); BufferedWriter writer = Files.newBufferedWriter(archivo)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
        }

        return "Semilla: " + seed;
    }

}
