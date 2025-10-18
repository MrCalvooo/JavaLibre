import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

public class Temporizador extends TimerTask {

    private File file;
    private int numCaja;

    public Temporizador(File file, int numCaja) {
        this.file = file;
        this.numCaja = numCaja;
    }

    @Override
    public void run() {
        String[] comandos = {"java", "-cp", "out/production/03ConcurrenciaVentas", "Venta", String.valueOf(numCaja),
                file.getName()};
        ProcessBuilder processBuilder = new ProcessBuilder(comandos);
        processBuilder.inheritIO();
        try {
            Process process = processBuilder.start();
            System.out.println("Caja " + numCaja + " esta registrando");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
