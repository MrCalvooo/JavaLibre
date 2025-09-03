
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

    public void lee() {
        try {
            try (FileReader entrada = new FileReader("mifichero.txt")) {
                int c = entrada.read();
                
                while (c != -1) {
                    c = entrada.read();
                    char letra = (char) c;
                    System.out.print(letra);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el fichero: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada: " + e.getMessage());
        }
    }
}
