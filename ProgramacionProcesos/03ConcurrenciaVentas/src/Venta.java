import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Random;

public class Venta {
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Porfavcr inserte correctamente el comando");
        }
        int numProceso = Integer.parseInt(args[0]);
        String nombreFichero = args[1];

        try {
            RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rwd");
            // Bloqueamos el fichero
            System.out.println("La caja " + numProceso + " esta registrando");
            FileLock fileLock = raf.getChannel().lock();

            // Situamos el puntero al final del fichero para poder escribir
            raf.seek(raf.length());

            Random random = new Random();
            int randomNumber = random.nextInt(0, 100);

            raf.writeBytes("Caja " + numProceso++ + ": " + randomNumber + " euros\n");
            fileLock.release();
            System.out.println("Numero " + randomNumber + " insertado por la caja " + numProceso);
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
