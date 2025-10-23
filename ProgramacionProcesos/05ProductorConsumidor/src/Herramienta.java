public class Herramienta implements Runnable {

    private Monitor monitor;
    private String nombre;

    public Herramienta(Monitor monitor, String nombre) {
        this.monitor = monitor;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Se va a usar la herramienta: " + nombre);

            try {
                monitor.comprarHerramienta();
                Thread.sleep(3000 + (int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Obrero acabó con la herramienta " + nombre);
    }
}
