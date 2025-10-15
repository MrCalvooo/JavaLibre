import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String nombreFichero = "contador.txt";

        File file = new File(nombreFichero);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Fichero creado correctamente");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Ejecutamos los 10 procesos
        for (int i = 0; i < 10; i++) {
            String[] comando = {"java", "-cp", "out/production/EjemploConcurrenciaProcesos", "Proceso", String.valueOf(i),
                    nombreFichero};
            ProcessBuilder processBuilder = new ProcessBuilder(comando);
            try {
                // Le damos al processBuilder la entrada/salida del proceso
                processBuilder.inheritIO();
                Process process = processBuilder.start();
                process.waitFor();
                System.out.println("Ejecutando proceso " + i);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}