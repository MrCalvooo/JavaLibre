//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        Disenyador disenyador1 = new Disenyador(monitor, "Disenyador 1");
        Disenyador disenyador2 = new Disenyador(monitor, "Disenyador 2");
        Impresora impresora1 = new Impresora(monitor, 1);
        Impresora impresora2 = new Impresora(monitor, 2);

        Thread hilo1 = new Thread(disenyador1);
        Thread hilo2 = new Thread(disenyador2);
        Thread hilo3 = new Thread(impresora1);
        Thread hilo4 = new Thread(impresora2);

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