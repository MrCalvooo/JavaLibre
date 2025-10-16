import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Random;

public class Venta implements Runnable {

    private String nombreFich;
    private int numProceso;

    public Venta(String nombreFich, int numProceso) {
        this.nombreFich = nombreFich;
        this.numProceso = numProceso;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int librosGenerados = random.nextInt(0, 10);
            RandomAccessFile raf = new RandomAccessFile(nombreFich, "rw");

            String linea = raf.readLine();
            int total = 0;

            if (linea != null && !linea.isEmpty()) {
                String[] partes = linea.split(" ");
                total = Integer.parseInt(partes[4]);
            }

            total += librosGenerados;
            raf.seek(raf.length());
            raf.writeBytes("El hilo " + numProceso + " vendio " + librosGenerados + "\n");

            raf.close();

            System.out.println("El hilo " + numProceso + " vendio " + librosGenerados + " se vendieron: " + total);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
