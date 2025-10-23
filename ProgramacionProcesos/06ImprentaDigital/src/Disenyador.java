// Productor
public class Disenyador implements Runnable {

    private Monitor monitor;
    private String nombre;

    public Disenyador(Monitor monitor, String nombre) {
        this.monitor = monitor;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("EL DISEÑADOR " + nombre + " AÑADE NUEVO TRABAJO A IMPRIMIR EN LA COLA");
                monitor.añadirTrabajo(new TrabajoImpresion((int) (Math.random() + 3), 200));
                Thread.sleep(3000 + (int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Trabajo de " + nombre + " insertado en la cola");
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public String getNombre() {
        return nombre;
    }
}
