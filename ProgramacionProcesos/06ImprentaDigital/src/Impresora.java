// Consumidor
public class Impresora implements Runnable {

    private Monitor monitor;
    private int idImpresora;

    public Impresora(Monitor monitor, int idImpresora) {
        this.monitor = monitor;
        this.idImpresora = idImpresora;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("IMPRESORA " + idImpresora + " IMPRIMIENDO TRABAJO");
                monitor.imprimirTrabajo();
                Thread.sleep(3000 + (int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("IMPRESORA IMPRIMIO TRABAJO");
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public int getIdImpresora() {
        return idImpresora;
    }
}
