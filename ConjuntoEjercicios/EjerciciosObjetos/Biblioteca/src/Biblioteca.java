
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int cantidadLibros;
        String tituloLibro, autor;
        int numPaginas;

        System.out.println("Cuantos libros deseas agregar a tu biblioteca?: ");
        cantidadLibros = scanner.nextInt();

        Libro biblioteca[] = new Libro[cantidadLibros];

        for (int i = 0; i < biblioteca.length; i++) {

            // Limpiamos buffer
            scanner.nextLine();

            biblioteca[i] = new Libro();

            System.out.println("Titulo: ");
            tituloLibro = scanner.nextLine();

            biblioteca[i].setTitulo(tituloLibro);

            System.out.println("Nombre del autor: ");
            autor = scanner.nextLine();
            biblioteca[i].setAutor(autor);

            System.out.println("Paginas?: ");
            numPaginas = scanner.nextInt();
            biblioteca[i].setNumPaginas(numPaginas);

        }

        for (Libro libro : biblioteca) {
            System.out.printf("Autor: %2s titulo: %2s \tpaginas: %d\n", libro.getAutor(), libro.getTitulo(),
                    libro.getNumPaginas());
        }

        scanner.close();
    }
}
