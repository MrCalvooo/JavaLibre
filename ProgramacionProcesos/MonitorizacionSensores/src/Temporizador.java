import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.TimerTask;

public class Temporizador extends TimerTask {

    private int sensorID;
    private File file;

    public Temporizador(int sensorID, File file) {
        this.sensorID = sensorID;
        this.file = file;
    }

    @Override
    public void run() {
        Random random = new Random();
        double temp = random.nextDouble(0, 50);

        try {
            FileWriter fw = new FileWriter(file.getName(), true);
            fw.write(String.format("Sensor %d registro una temperatura de %.2fºC\n", sensorID, temp));
            fw.close();
            System.out.println("El sensor " + sensorID + " registro una nueva temperatura");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
