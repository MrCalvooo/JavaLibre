
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Crea un programa que: Pida al usuario ingresar tres líneas de texto por
 * consola. Escriba esas líneas en un archivo llamado output.txt utilizando
 * BufferedWriter.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Path input = Paths.get("output.txt");

        try {
            if (!Files.exists(input)) {
                Files.createFile(input);
            }
        } catch (IOException e) {
            System.out.println("Error al comprobar la existencia del archivo");
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(input); Scanner scanner = new Scanner(System.in)) {

            String linea;

            for (int i = 0; i < 3; i++) {
                System.out.println("Introduzca texto: ");
                linea = scanner.nextLine();
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }
        }
    }
}
