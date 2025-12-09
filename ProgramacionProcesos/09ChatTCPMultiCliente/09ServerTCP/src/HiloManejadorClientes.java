import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloManejadorClientes extends Thread {
    private Socket cliente;

    public HiloManejadorClientes(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter pw = new PrintWriter(cliente.getOutputStream());
            String mensaje = "";
            while (!mensaje.equalsIgnoreCase("adios")) {
                mensaje = br.readLine();
                System.out.println(cliente.getInetAddress().getHostName() + " dice " + mensaje);
                pw.println(mensaje);
                pw.flush();
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
