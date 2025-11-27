import java.util.concurrent.Semaphore;

public class Impresora {
    private Semaphore semaphore = new Semaphore(1, true);

    public Impresora() {
    }

    public void imprimir(String id) throws InterruptedException {
        if (comprobarDisponibilidad()) {
            semaphore.acquire();
            System.out.println("Imprimiendo documento " + id);
        }
    }

    public void finalizar(String id) {
        System.out.println("Documento " + id + " impreso");
        semaphore.release();
    }

    private boolean comprobarDisponibilidad() {
        return semaphore.availablePermits() > 0;
    }
}
