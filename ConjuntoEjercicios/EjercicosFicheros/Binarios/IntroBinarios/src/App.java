
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {

    public static void main(String[] args) throws Exception {
        Path archivo = Paths.get("archivo.bin");

        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(archivo, StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {
            dos.writeInt(55);
            dos.writeBoolean(false);
            dos.writeDouble(0.5);
        } catch (IOException e) {
            System.out.println("Error al crear el archivo binario: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(Files.newInputStream(archivo))) {
            System.out.println("Numero: " + dis.readInt());
            System.out.println("Booleano: " + dis.readBoolean());
            System.out.println("Decimal: " + dis.readDouble());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo binario: " + e.getMessage());
        }
    }
}
