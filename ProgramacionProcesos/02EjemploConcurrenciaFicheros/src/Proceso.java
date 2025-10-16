import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class Proceso {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usar: java Proceso numeroProceso archivo");
            System.exit(1);
        }

        // java Proceso numProceso(args[0]) archivo(args[1])
        int numProceso = Integer.parseInt(args[0]);
        String nombre = args[1];

        File archivo = new File(nombre);

        if (!archivo.exists()) {
            try {
                RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
                raf.writeUTF("0");
                raf.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(archivo, "rw");

            for (int i = 0; i < numProceso; i++) {
                FileLock fileLock = raf.getChannel().lock();

                raf.seek(0);
                int valor = Integer.parseInt(raf.readUTF());
                valor++;
                raf.writeUTF(String.format("%d", valor));

                fileLock.release();

                System.out.println("Proceso " + numProceso + " escribio: " + valor);
            }

            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
