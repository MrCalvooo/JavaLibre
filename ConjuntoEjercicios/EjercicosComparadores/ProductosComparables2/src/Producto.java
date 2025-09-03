
public class Producto implements Comparable<Producto> {

    private String nombre;
    private double precio;
    private String categoria = "";

    // Comparar por nombre
    @Override
    public int compareTo(Producto o) {
        return nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return "Nombre producto: " + nombre + " precio: " + precio + " categoria: " + categoria;
    }

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        if (categoria.equalsIgnoreCase("electronica")) {
            this.categoria = "ELECTRONICA";
            this.precio = precio + 0.5;
        } else if (categoria.equalsIgnoreCase("ropa")) {
            this.categoria = "ROPA";
            this.precio = precio + 0.2;
        } else {
            this.categoria = "inexistente";
            this.precio = 0;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            Producto otro = (Producto) obj;
            return nombre.equalsIgnoreCase(otro.nombre);
        }
    }
}
