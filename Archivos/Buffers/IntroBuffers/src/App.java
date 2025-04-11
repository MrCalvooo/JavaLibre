import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        // Definir las rutas de los archivos
        Path inputPath = Paths.get("input.txt");
        Path outputPath = Paths.get("output.txt");

        // Crear los archivos si no existen
        try {
            if (!Files.exists(inputPath)) {
                Files.createFile(inputPath);
                Files.writeString(inputPath, "Este es un ejemplo de texto.\nLínea 2 del archivo.");
            }
            if (!Files.exists(outputPath)) {
                Files.createFile(outputPath);
            }
        } catch (IOException e) {
            System.err.println("Error al crear los archivos: " + e.getMessage());
            return;
        }

        // Leer y escribir usando BufferedReader y BufferedWriter
        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Agregar salto de línea
            }

            System.out.println("El contenido se ha copiado correctamente de input.txt a output.txt.");
        } catch (IOException e) {
            System.err.println("Error durante la lectura/escritura: " + e.getMessage());
        }
    }
}