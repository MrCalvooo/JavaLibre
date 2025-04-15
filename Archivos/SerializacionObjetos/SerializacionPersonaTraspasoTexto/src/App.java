
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) throws Exception {
        Path binario = Paths.get("archivo.bin");
        Path texto = Paths.get("texto.txt");

        try (OutputStream fos = Files.newOutputStream(binario); ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))) {
            oos.writeObject(new Persona(50, "Antonio"));

            System.out.println("Serializacion completada");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }

        try (InputStream fis = Files.newInputStream(binario); ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));) {
            Persona temp = (Persona) ois.readObject();
            System.out.println(temp);

            Files.writeString(texto, temp.toString());
            System.out.println("Datos insertados correctamente en archivo txt");

        } catch (FileNotFoundException e) {
            System.out.println("Error: no existe el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el objeto: " + e.getMessage());
        }

    }
}
