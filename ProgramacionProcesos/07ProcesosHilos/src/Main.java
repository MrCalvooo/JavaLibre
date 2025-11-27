import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            String dept = "Departamento " + (i + 1);
            ProcessBuilder builder = new ProcessBuilder("java", "-cp", "out/production/07ProcesosHilos", "Departamento", dept);
            builder.inheritIO();
            try {
                Process process = builder.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}