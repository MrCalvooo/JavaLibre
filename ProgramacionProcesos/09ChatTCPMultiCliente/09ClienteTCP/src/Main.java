import java.io.IOException;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            int conexiones = 10;
            while (conexiones > 0) {

                Socket conexion = new Socket("127.0.0.1", 20001);
                HiloManejadorCliente hiloManejadorCliente = new HiloManejadorCliente(conexion);
                hiloManejadorCliente.start();
                conexiones--;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}