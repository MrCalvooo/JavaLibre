import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File file = new File("contador.txt");
        String nombreArchivo = file.getName();

        for (int i = 0; i < 1000; i++) {
            // Ejecutamos el proceso n veces
            String[] comando = {"java", "Proceso", String.valueOf(i), nombreArchivo};
            try {
                ProcessBuilder pb = new ProcessBuilder(comando);
                pb.directory(new File("."));
                Process process = pb.start();
                System.out.println("Se ha creado el proceso " + i);
            } catch (IOException e) {
                System.err.println("Error al lanzar el proceso: " + e.toString());
            }
        }
    }
}