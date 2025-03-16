
import java.util.ArrayList;

public class Tienda {

    // Atributos
    private final String nombre = "Tienda de informática";
    private final ArrayList<Productos> productos = new ArrayList<>();

    // Añadimos en el constructor ciertos productos al ArrayList de productos
    public Tienda() {
        productos.add(new Productos("Portátil", 500, 10));
        productos.add(new Productos("Ratón", 10, 50));
        productos.add(new Productos("Teclado", 20, 30));
        productos.add(new Productos("Monitor", 100, 20));
        productos.add(new Productos("Impresora", 50, 15));
    }

    @Override
    public String toString() {
        return "Productos disponibles: \n" + productos.toString();
    }

    // Metodo para agregar productos
    public void agregarProducto(String nombre, double precio, int cantidad) throws CantidadInvalidaException {

        if (cantidad < 0) {
            throw new CantidadInvalidaException();
        } else {
            productos.add(new Productos(nombre, precio, cantidad));
        }
    }

    // Metodo para comprar productos
    public void comprarProductos(String nombre, int cantidad) throws CantidadInvalidaException, ProductoNoDisponibleException {
        if (cantidad < 0) {
            throw new CantidadInvalidaException();
        } else {
             for (Productos producto : productos) {
                if (nombre.equalsIgnoreCase(producto.getNombre())) {
                if (producto.getStock() < cantidad) {
                    throw new ProductoNoDisponibleException();
                } else {
                    producto.setStock(producto.getStock() - cantidad);
                }
            }
        }   
        }
    }

    public String getNombre() {
        return nombre;
    }

    // Clase interna Productos
    private class Productos {

        // Atributos
        private static int nextId = 1; // Variable estática para llevar la cuenta del próximo ID
        private final int id;
        private final String nombre;
        private final double precio;
        private int stock;

        // Constructor
        public Productos(String nombre, double precio, int stock) {
            this.id = nextId++;
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }

        @Override
        public String toString() {
            return "\nID: " + id + ", " + nombre + " precio: " + precio + " euros" + ", stock: " + stock;
        }

        public String getNombre() {
            return nombre;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

    }

}
