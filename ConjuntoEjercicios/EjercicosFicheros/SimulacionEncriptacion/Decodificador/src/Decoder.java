import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Decoder {
    // Archivo a decodificar
    private static final String FILE_NAME = "encoded_messages.bin";

    public static void main(String[] args) {
        // Clave
        int seed = 12345;

        try {
            String decodedMessage = decodeMessage(seed);
            System.out.println("Mensaje decodificado: " + decodedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String decodeMessage(int seed) throws IOException {
        Random random = new Random(seed);
        StringBuilder decodedMessage = new StringBuilder();

        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int encodedChar = dis.readInt();
                // Eliminamos el valor codificado retornando el valor del caracter UNICODE
                char decodedChar = (char) (encodedChar - random.nextInt(Short.MAX_VALUE));
                // Lo encadenamos en la cadena desencriptada
                decodedMessage.append(decodedChar);
            }
        }

        return decodedMessage.toString();
    }
}