public class Departamento {
    public static void main(String[] args) {
        String dept = args[0];
        Impresora impresora = new Impresora();
        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Documento(impresora, dept + " " + i + 1);
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
