import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("ventas.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < 10; i++) {
            String[] comandos = {"java", "-cp", "out/production/03ConcurrenciaVentas", "Venta", String.valueOf(i),
                    file.getName()};
            ProcessBuilder processBuilder = new ProcessBuilder(comandos);
            processBuilder.inheritIO();
            try {
                Process process = processBuilder.start();
                System.out.println("Caja " + i + " esta registrando");
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}