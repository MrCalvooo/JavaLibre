import java.util.LinkedList;
import java.util.Queue;

public class Monitor {
    private Queue<TrabajoImpresion> trabajos = new LinkedList<>();
    private final int TRABAJAJOS_MAX = 3;

    // Producir
    public synchronized void añadirTrabajo(TrabajoImpresion trabajoImpresion) throws InterruptedException {
        while (trabajos.size() == TRABAJAJOS_MAX) {
            System.out.println("COLA LLENA");
            wait();
        }
        System.out.println("AÑADIENDO NUEVO TRABAJO");
        trabajos.add(trabajoImpresion);
        System.out.println("TRABAJO AÑADIDO. QUEDAN " + trabajos.size() + "/3 TRABAJOS EN COLA");
        notifyAll();
    }

    // Consumir
    public synchronized void imprimirTrabajo() throws InterruptedException {
        while (trabajos.isEmpty()) {
            System.out.println("NO HAY TRABAJOS PARA IMPRIMIR");
            wait();
        }

        System.out.println("IMPRIMIENDO TRABAJO");
        TrabajoImpresion t = trabajos.poll();
        System.out.println("COLA: IMPRIMIENDO TRABAJO " + t.getId() + ". QUEDAN " + trabajos.size() + "/3 TRABAJOS EN COLA");

        notifyAll();
    }
}
