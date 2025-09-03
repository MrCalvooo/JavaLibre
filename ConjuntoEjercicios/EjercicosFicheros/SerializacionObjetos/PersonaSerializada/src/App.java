
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

/*
Crear una clase Persona que implementa Serializable.
Serializar un objeto de tipo Persona en un archivo.
Leer el archivo y deserializar el objeto.
Verificar que los datos del objeto deserializado coinciden con el original.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Path archivo = Paths.get("archivo.bin");
        Persona p = new Persona("Juan", 20);

        // Escritura
        try (OutputStream fos = Files.newOutputStream(archivo); ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))) {
            // Escribimos el objeto
            oos.writeObject(p);
            System.out.println("Objeto insertado correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Lectura
        try (InputStream fis = Files.newInputStream(archivo); ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis))) {
            Persona p1 = (Persona) ois.readObject();
            System.out.println(p1);
            System.out.println(p);

            if (p.equals(p1)) {
                System.out.println("Deserilizacion exitosa");
            } else {
                System.out.println("Deserilizacion mal hecha");
            }

        } catch (IOException e) {
            System.out.println("Error al deserializar");
        }
    }
}
