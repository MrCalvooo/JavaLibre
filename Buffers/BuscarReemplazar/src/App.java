
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/*
Escribe un programa que:
Lea un archivo de texto llamado documento.txt.
Busque todas las ocurrencias de una palabra específica ingresada por el usuario.
Reemplace las ocurrencias por otra palabra ingresada por el usuario.
Guarde los cambios en un archivo nuevo llamado documento_actualizado.txt.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Path documento = Paths.get("documento.txt");
        Path documentoActualizado = Paths.get("documentoActualizado.txt");

        try {
            if (!Files.exists(documento)) {
                Files.createFile(documento);
            }

            if (!Files.exists(documentoActualizado)) {
                Files.createFile(documentoActualizado);
            } else {
                Files.writeString(documentoActualizado, "", StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }

        String palabra;
        String reemplazo;
        boolean existePalabra = false;
        try (Scanner scanner = new Scanner(System.in); BufferedReader bufferedReader = Files.newBufferedReader(documento); BufferedWriter bufferedWriter = Files.newBufferedWriter(documentoActualizado)) {

            do {
                System.out.println("Palabra a buscar: ");
                palabra = scanner.nextLine();

                System.out.println("Palabra a usar como reemplazo: ");
                reemplazo = scanner.nextLine();

                existePalabra = false; // Reiniciar el estado de la bandera

                try (BufferedReader tempReader = Files.newBufferedReader(documento)) {
                    String line;
                    while ((line = tempReader.readLine()) != null) {
                        if (line.contains(palabra)) {
                            existePalabra = true;
                            break; // Salir del bucle si se encuentra la palabra
                        }
                    }

                    if (!existePalabra) {
                        System.out.println("Palabra " + palabra + " no encontrada. Inténtalo de nuevo.");
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                }
            } while (!existePalabra);

            scanner.close();

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String lineaNueva = linea.replaceAll(palabra, reemplazo);
                bufferedWriter.write(lineaNueva);
                bufferedWriter.newLine();
            
            }
        } catch (IOException e) {
            System.out.println("Error al realizar operaciones " + e.getMessage());
        }
    }
}
