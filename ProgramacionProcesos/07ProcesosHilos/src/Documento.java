public class Documento extends Thread {
    private Impresora impresora;
    private String id;

    public Documento(Impresora impresora, String id) {
        this.impresora = impresora;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            impresora.imprimir(id);
            System.out.println("Imprimiendo documento: " + id);
            Thread.sleep(1000);
            impresora.finalizar(id);
            System.out.println("Documento impreso: " + id);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
