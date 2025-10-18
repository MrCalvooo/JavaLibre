import java.io.File;
import java.io.IOException;
import java.util.Timer;

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

        Timer timer = new Timer();

        for (int i = 0; i < 10; i++) {
            Temporizador venta = new Temporizador(file, i);
            timer.schedule(venta, 1000);
        }

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        timer.cancel();
        System.out.println("Ventas registradas");
    }
}