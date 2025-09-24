import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "out", "Hijo");
        try {
            Process process = processBuilder.start();
            Scanner scanner = new Scanner(System.in);

            // Establecemos los flujos de entrada, salida y error de datos

            OutputStreamWriter osw = new OutputStreamWriter(process.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);

            InputStreamReader isr = new InputStreamReader(process.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            InputStreamReader isrError = new InputStreamReader(process.getErrorStream());
            BufferedReader brError = new BufferedReader(isrError);

            // Pasamos los datos
            String linea = "";
            do {
                System.out.println("Palabra: ");
                linea = scanner.nextLine();

                bw.write(linea + "\n");
                bw.flush();
            } while (!linea.equals("FIN"));

            // Cerramos flujo de entrada de datos
            bw.close();

            // Salida de datos
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

            while ((linea = brError.readLine()) != null) {
                System.out.println(linea);
            }
            brError.close();

            int codSalida = process.waitFor();
            System.out.println("Codigo de salida: " + codSalida);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}