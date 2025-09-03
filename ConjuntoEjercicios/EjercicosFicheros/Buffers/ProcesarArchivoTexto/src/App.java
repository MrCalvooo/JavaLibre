
/*
Leer un archivo .txt línea por línea utilizando BufferedReader.
Escribir el contenido en mayúsculas en un nuevo archivo utilizando BufferedWriter.
Utilizar las clases Path y Files para gestionar las rutas de los archivos.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {

    public static void main(String[] args) throws Exception {
        Path input = Paths.get("input.txt");
        Path output = Paths.get("output.txt");

        try {
            if (!Files.exists(output)) {
                Files.createFile(output);
            }

            if (!Files.exists(input)) {
                Files.createFile(input);
                Files.writeString(input, "Hola buenas\ntardes", StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear/buscar los archivos");
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(input); BufferedWriter bufferedWriter = Files.newBufferedWriter(output)) {
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al procesar los archivos: " + e.getMessage());
        }

    }
}
