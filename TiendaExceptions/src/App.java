
public class App {

    public static void main(String[] args) throws Exception {
        Tienda tienda = new Tienda();
        System.out.println(tienda);

        System.out.println("Agregamos 10 RTX 3060");
        try {
            tienda.agregarProducto("RTX 3060", 305.80, 10);
        } catch (CantidadInvalidaException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(tienda);
        }

        System.out.println("Compramos -1 portatil");
        try {
            tienda.comprarProductos("Portatil", -1);
        } catch (CantidadInvalidaException | ProductoNoDisponibleException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(tienda);
        }

    }
}
