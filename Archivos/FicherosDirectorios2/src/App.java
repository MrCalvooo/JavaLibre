
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) throws Exception {
        Path carpeta = Paths.get("micarpeta");
        Path fichero = Paths.get("fichero.txt");
        Path directorioActual = Paths.get(".");

        try {
            if (!Files.exists(carpeta)) {
                Files.createDirectory(carpeta); // Crear la carpeta si no existe
            }

            if (Files.exists(fichero)) {
                Path destino = carpeta.resolve(fichero.getFileName()); // Ruta destino dentro de la carpeta
                Files.move(fichero, destino); // Mover el fichero a la carpeta
                System.out.println("Fichero movido a: " + destino.toAbsolutePath());
            } else {
                Path nuevoFichero = directorioActual.resolve("fichero.txt");
                Files.createFile(nuevoFichero);
                System.out.println("Se ha creado el fichero.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo" + e.getMessage()); // Mostrar el error en caso de excepción
        }
    }
}
