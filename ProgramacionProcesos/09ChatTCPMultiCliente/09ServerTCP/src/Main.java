import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        final int puerto = 20001;
        int clientes = 0;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto);

            // Bucle infinito para aceptar clientes
            while (true) {
                System.out.println("Esperando cliente...");
                Socket conexion = serverSocket.accept();   // BLOQUEA hasta que llega un cliente

                clientes++;
                System.out.println("Cliente conectado desde: " +
                        conexion.getInetAddress().getHostName() +
                        " | Total: " + clientes);

                // Crear un hilo por cada cliente
                Thread t = new HiloManejadorClientes(conexion);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
