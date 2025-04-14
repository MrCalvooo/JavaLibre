
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
import java.util.ArrayList;
import java.util.List;

/*
Crear una lista de objetos Persona.
Serializar la lista en un archivo.
Deserializar la lista desde el archivo.
Iterar sobre la lista deserializada y mostrar los datos de cada Persona
 */
public class App {

    public static void main(String[] args) throws Exception {
        List<Persona> personas = new ArrayList<>();
        Path archivo = Paths.get("archivo.dat");

        personas.add(new Persona(20, "Manolo el del Bombo"));
        personas.add(new Persona(30, "Marina"));
        personas.add(new Persona(25, "Julia"));

        try (OutputStream fos = Files.newOutputStream(archivo); ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))) {
            oos.writeObject(personas);
            System.out.println("Lista serializada");
        } catch (IOException e) {
            System.out.println("Error al serializar la lista");
        }

        try (InputStream fis = Files.newInputStream(archivo); ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis))) {
            List<Persona> deserializada = (List<Persona>) ois.readObject();
            System.out.println("Lista deserializada");

            for (Persona persona : deserializada) {
                System.out.println(persona);
            }
        } catch (IOException e) {
            System.out.println("Error al deserializar la lista");
        }

    }
}
