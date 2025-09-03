import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Encoder {
    // Archivo codificado a crear
    private static final String FILE_NAME = "encoded_messages.bin";

    public static void main(String[] args) {
        String mensaje;
        // Mensaje a codificar
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Mensaje a encriptar: ");
            mensaje = scanner.nextLine();
        }

        // Clave
        int seed = 12345;

        try {
            encodeMessage(mensaje, seed);
            System.out.println("Mensaje codificado y guardado en " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encodeMessage(String message, int seed) throws IOException {
        // Instancia de Random dependiendo de la semilla
        Random random = new Random(seed);
        // Creamos el Stream de escritura para el archivo
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {

            // Recorremos cada caracter del mensaje
            for (char c : message.toCharArray()) {
                // Mezclamos el codigo UNICODE del caracter junto con un valor aleatorio
                // contenedor en la clave
                int encodedChar = c + random.nextInt(Short.MAX_VALUE);
                // Escribimos en el archivo
                dos.writeInt(encodedChar);
            }
        }
    }
}