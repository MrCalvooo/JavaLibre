public class Fabricante implements Runnable {

    private Monitor monitor;
    private String nombre;

    public Fabricante(Monitor monitor, String nombre) {
        this.monitor = monitor;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Se va a fabricar la herramienta: " + nombre);
            try {
                monitor.fabricarHerramienta();
                Thread.sleep(3000 + (int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                break;
            }

            System.out.println("Se fabrico la herramienta: " + nombre);
        }
    }
}
