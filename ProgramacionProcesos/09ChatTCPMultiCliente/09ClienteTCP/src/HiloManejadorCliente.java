import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HiloManejadorCliente extends Thread {
    private Socket conexion;

    public HiloManejadorCliente(Socket conexion) {
        this.conexion = conexion;
    }

    @Override
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(conexion.getOutputStream());
            String mensaje = "";
            pw.println("Hola");
            pw.flush();
            Thread.sleep(500);
            pw.println("Adios");
            pw.flush();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
