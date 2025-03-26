
public class Producto implements Comparable<Producto> {

    private String nombre;
    private double precio;
    private String categoria;

    // Constructor
    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Producto{"
                + "nombre='" + nombre + '\''
                + ", precio=" + precio
                + ", categoria='" + categoria + '\''
                + '}';
    }

    // Implementar Comparable
    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }
}
