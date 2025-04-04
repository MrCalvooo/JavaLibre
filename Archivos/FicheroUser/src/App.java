
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/*Enunciado del ejercicio: Escribe un programa en Java que realice lo siguiente:
Cree un archivo de texto llamado miArchivo.txt en la carpeta donde se ejecuta el programa.
Pida al usuario que introduzca varias líneas de texto desde la consola.
El programa debe permitir que el usuario introduzca tantas líneas como desee, y terminará cuando el usuario introduzca la palabra FIN.
Guarde todas las líneas introducidas por el usuario en el archivo miArchivo.txt.
Lea el contenido del archivo y muestre todas las líneas en la consola,
indicando el número de línea antes de cada línea de texto. */
public class App {

    public static void main(String[] args) throws Exception {
        Path archivo = Paths.get("miarchivo.txt");
        Scanner teclado = new Scanner(System.in);

        try {
            if (!Files.exists(archivo)) {
                Files.createFile(archivo);
            } else {
                Files.writeString(archivo, "", StandardOpenOption.TRUNCATE_EXISTING);
            }

            String texto;

            do {
                System.out.println("Introduzca texto (para salir introduzca FIN): ");
                texto = teclado.nextLine();

                if (!texto.equals("FIN")) {
                    Files.writeString(archivo, texto + System.lineSeparator(), StandardOpenOption.APPEND);
                }

            } while (!texto.equals("FIN"));

            teclado.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo " + e.getMessage());
        }

        Scanner textoFichero = new Scanner(archivo);
        int linea = 1;

        System.out.println("\n------------LECTURA DEL ARCHIVO--------------");
        try {
            while (textoFichero.hasNext()) {
                System.out.println("Linea " + linea + ": " + textoFichero.nextLine());
                linea++;
            }

            textoFichero.close();
        } catch (Exception e) {
            System.out.println("Error al leer fichero");
        }

    }
}
