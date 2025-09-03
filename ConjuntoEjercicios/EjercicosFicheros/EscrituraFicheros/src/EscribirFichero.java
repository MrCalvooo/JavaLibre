
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {

    public void escribir() {
        String frase = "Escribiendo desde un metodo";

        try {
            // Agregamos mas texto al fichero
            FileWriter fileWriter = new FileWriter("mifichero.txt", true);

            for (int i = 0; i < frase.length(); i++) {
                fileWriter.write(frase.charAt(i));
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }

    }
}
