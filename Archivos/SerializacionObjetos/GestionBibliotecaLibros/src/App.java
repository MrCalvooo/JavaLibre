
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Set;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) throws Exception {
        Path binario = Paths.get("binario.dat");
        Path archivo = Paths.get("biblioteca.txt");

        Set<Libro> libros = new TreeSet<>();
        libros.add(new Libro("El Quijote", "Miguel de Cervantes", 1605));
        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));

        try (OutputStream fos = Files.newOutputStream(binario); ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))) {
            oos.writeObject(libros);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        }

        try (InputStream fis = Files.newInputStream(binario); ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis))) {
            Set<Libro> librosLeidos = (Set<Libro>) ois.readObject();

            Files.createFile(archivo);

            // Mostrar los libros leídos
            for (Libro libro : librosLeidos) {
                System.out.println(libro);

                Files.writeString(archivo, libro.toString() + "\n", StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }

    }
}
