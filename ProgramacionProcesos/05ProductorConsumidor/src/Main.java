//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        Fabricante fabricante1 = new Fabricante(monitor, "fabricante 1");
        Fabricante fabricante2 = new Fabricante(monitor, "fabricante 2");
        Herramienta herramienta1 = new Herramienta(monitor, "Llave inglesa");
        Herramienta herramienta2 = new Herramienta(monitor, "Mordaza");

        Thread hilo1 = new Thread(fabricante1);
        Thread hilo2 = new Thread(fabricante2);
        Thread hilo3 = new Thread(herramienta1);
        Thread hilo4 = new Thread(herramienta2);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hilo1.interrupt();
        hilo2.interrupt();
        hilo3.interrupt();
        hilo4.interrupt();
    }
}