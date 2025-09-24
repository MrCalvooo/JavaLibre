import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "out", "Hijo");
        int num1 = 5, num2 = 9;
        try {
            Process process = processBuilder.start();

            // Obtenemos el flujo de escritura del hijo
            OutputStreamWriter osw = new OutputStreamWriter(process.getOutputStream());
            BufferedWriter bfw = new BufferedWriter(osw);

            // Flujo de lectura
            InputStreamReader isw = new InputStreamReader(process.getInputStream());
            BufferedReader br = new BufferedReader(isw);

            // Flujo de lectura de errores
            InputStreamReader iswError = new InputStreamReader(process.getErrorStream());
            BufferedReader brError = new BufferedReader(iswError);

            // Pasamos al hijo los numeros
            bfw.write(num1 + "\n");
            bfw.write(num2 + "\n");
            bfw.flush();
            bfw.close();

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            while ((linea = brError.readLine()) != null) {
                System.out.println(linea);
            }

            int codSalida = process.waitFor();
            System.out.println("Codigo de salida: " + codSalida);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}