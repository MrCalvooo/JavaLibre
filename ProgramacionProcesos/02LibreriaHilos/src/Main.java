import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("ventas.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < 10; i++) {
            Venta v = new Venta(file.getName(), i);
        }
    }
}