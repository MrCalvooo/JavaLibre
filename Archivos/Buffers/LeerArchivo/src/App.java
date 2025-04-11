
/**
 * Crea un archivo llamado input.txt en el directorio raíz de tu proyecto.
 * Escribe algunas líneas de texto en este archivo.
 * Implementa un programa en Java que:
 * Lea las líneas del archivo input.txt usando BufferedReader.
 * Imprima cada línea en la consola.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) throws Exception {
        Path input = Paths.get("input.txt");

        try {
            if (!Files.exists(input)) {
                Files.createFile(input);
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(input)) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}
