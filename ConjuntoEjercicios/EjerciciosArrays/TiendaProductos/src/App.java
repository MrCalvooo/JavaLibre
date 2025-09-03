/*
 * Descripción: Crea un programa que gestione una lista de productos y
 * sus precios en una tienda. El programa debe ser capaz de:
 *  Registrar productos y precios: Guarda los nombres de los productos y sus precios en arrays separados.
 * Calcular estadísticas: Calcula y muestra el precio medio, el producto más caro y el más barato.
Identificar y mostrar los productos más caros y más baratos.
Mostrar un listado de productos y sus precios ordenados de menor a mayor.
Detalles del ejercicio:
Declarar y rellenar los arrays:
Crea un array para almacenar los nombres de los productos.
Crea un array para almacenar los precios de los productos.
Rellena estos arrays con datos (puedes usar valores aleatorios para los precios).
Cálculo de estadísticas:
Precio medio: Calcula la media de todos los precios.
Producto más caro y más barato: Encuentra el precio más alto y el más bajo.
Identificar productos específicos:
Encuentra los índices de los productos con los precios más altos y más bajos.
Muestra estos productos junto con sus precios.
Ordenar y mostrar listado:
Ordena el array de precios de menor a mayor, asegurándote de que los nombres
de los productos se mantengan alineados con sus precios.
 */

public class App {
    public static void main(String[] args) throws Exception {
        String[] productos = { "Teclado", "Raton", "Monitor", "CPU" };

        double[] precios = new double[productos.length];

        // Asignacion de precios a los productos
        for (int i = 0; i < precios.length; i++) {
            double precio = Math.random() * 100 + 1;
            precios[i] = precio;
        }

        // Desordenado
        for (int i = 0; i < precios.length; i++) {
            System.out.printf("Producto: %s \t Precio: %.2f euros\n", productos[i], precios[i]);
        }

        ordenacionProductos(productos, precios);

        // Ordenado
        for (int i = 0; i < precios.length; i++) {
            System.out.printf("Producto: %s \t Precio: %.2f euros\n", productos[i], precios[i]);
        }

        System.out.printf("\nPrecio medio: %.2f\n", precioMedio(precios));

        System.out.println("\n" + productoCaro(productos, precios));

        System.out.println("\n" + productoBarato(productos, precios));
    }

    public static double precioMedio(double[] a) {
        double media = 0;

        for (int i = 0; i < a.length; i++) {
            media += a[i];
        }

        media = media / a.length;

        return media;
    }

    public static String productoCaro(String[] a, double[] b) {

        double precio = Double.MIN_VALUE;
        String producto = "";

        for (int i = 0; i < b.length; i++) {
            if (b[i] > precio) {
                precio = b[i];
                producto = a[i];
            }
        }
        return String.format("Producto mas caro: %s %.2f euros", producto, precio);
    }

    public static String productoBarato(String[] a, double[] b) {
        double precio = Double.MAX_VALUE;
        String producto = "";
        for (int i = 0; i < b.length; i++) {
            if (b[i] < precio) {
                precio = b[i];
                producto = a[i];
            }
        }
        return String.format("Producto mas barato: %s %.2f euros", producto, precio);
    }

    public static void ordenacionProductos(String[] a, double[] b) {
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b.length - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    double auxD = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = auxD;

                    String auxS = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = auxS;
                }
            }
        }
    }
}
