import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class Proceso {
    public static void main(String[] args) {
        // Esta clase se encarga de la ejecucion del proceso

        // Comprobamos que se hayan pasado como argumentos del comando de ejecucion tanto
        // el numero del proceso como el fichero
        if (args.length < 2){
            System.err.println("Porfavor introduzca correctamente el comando: java Proceso num archivo");
            System.exit(1);
        }

        // Almacenamos los argumentos del comando de ejecucion
        // args[0] se refiere al numero del proceso ejecutado
        int numProceso = Integer.parseInt(args[0]);
        // args[1] se refiere al nombre del fichero con el q se trabaja
        String nombreFichero = args[1];

        File file = new File(nombreFichero);

        // Si no existe el fichero o esta vacio, escribimos sobre este
        if (!file.exists() || file.length() == 0){
            // En caso de no existir el fichero lo creamos
            try {
                RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw");
                raf.writeBytes("0\n");
                raf.close();
                System.out.println("Archivo creado gracias al proceso " + numProceso);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Ejecucion de la logica del proceso
        try {
            // Especificamos el fichero
            RandomAccessFile raf = new RandomAccessFile(nombreFichero, "rw");

            // Bloqueamos el fichero para que ningun otro proceso pueda acceder a él
            FileLock fileLock = raf.getChannel().lock();

            // Nos situamos al inicio del proceso y leemos su valor
            raf.seek(0);
            String linea = raf.readLine();
            int valor = Integer.parseInt(linea);

            // Incrementamos dicho valor
            valor++;

            // Nos reposicionamos al inicio del fichero y escribimos el nuevo valor
            raf.seek(0);
            raf.writeBytes(valor + "\n");

            // Desbloqueamos el fichero para que pueda acceder el siguiente proceso
            fileLock.release();
            System.out.println("El proceso " + numProceso + " escribio en el fichero " + valor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
