import java.time.LocalDateTime;

public class Monitor {
    private final int HERRAMIENTAS = 3;
    private int herramientasFabricadas = 0;

    public synchronized void fabricarHerramienta() throws InterruptedException {
        // Si todas las herramientas se estan usando, hay que esperar
        while (herramientasFabricadas == HERRAMIENTAS) {
            System.out.println("ALMACEN LLENO");
            wait();
        }

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("Se esta fabricando una herramienta a las " + localDateTime);
        herramientasFabricadas++;

        // Informamos de que hay una herramienta en uso
        notifyAll();
    }

    public synchronized void comprarHerramienta() throws InterruptedException {
        while (herramientasFabricadas == 0) {
            wait();
        }

        System.out.println("Se ha comprado una herramienta");
        herramientasFabricadas--;
        notifyAll();
    }
}
