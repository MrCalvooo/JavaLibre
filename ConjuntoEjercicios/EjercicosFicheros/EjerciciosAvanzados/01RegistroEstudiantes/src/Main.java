import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {

            File file = new File("estudiantes.dat");
            if (file.exists()) {
                file.delete();
            }

            RandomAccessFile raf = new RandomAccessFile("estudiantes.dat", "rw");
            Scanner scanner = new Scanner(System.in);

            System.out.println("Cuantos estudiantes se van a registrar?: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            // Insercion de estudiantes
            for (int i = 0; i < cantidad; i++) {

                int id = i + 1;
                raf.writeInt(id);

                System.out.println("INSERCION DE DATOS DEL ESTUDIANTE NUMERO " + id);

                System.out.println("Nombre: ");
                String nombre = scanner.nextLine();

                // Limitamos a 20 caracteres para cumplir con el requisito de 40 bytes
                // 1 caracter = 2 bytes
                if (nombre.length() > 20) {
                    nombre = nombre.substring(0, 20);
                } else {
                    // Si el nombre es menor a 20 caracteres (40 bytes), añadimos los espacios necesarios para que ocupe 40 bytes
                    nombre = String.format("%-20s", nombre);
                }

                raf.writeChars(nombre);

                System.out.println("Edad del estudiante: ");
                int edad = Integer.parseInt(scanner.nextLine());
                raf.writeInt(edad);
            }

            System.out.println("ID del estudiante a leer: ");
            int id = Integer.parseInt(scanner.nextLine());

            String estudiante = mostrarEstudianteBuscado(id, raf);
            System.out.println(estudiante);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int buscarEstudiante(int id, RandomAccessFile raf) throws IOException {
        // Un estudiante ocupa 48 bytes
        // Formula: posicion - 1 * tamaño estudiante
        int pos = (id - 1) * 48;
        return pos;
    }

    public static String mostrarEstudianteBuscado(int id, RandomAccessFile raf) throws IOException {
        int pos = buscarEstudiante(id, raf);
        // Establecemos el puntero del fichero a la posicion calculada donde estara el usuario
        raf.seek(pos);
        int idLeido = raf.readInt();

        // Al haber escrito el nombre con writeChars(), debemos usar un sBuilder para concatenar todos los caracteres
        StringBuilder nombre = new StringBuilder();
        // El 20 es el numero de caracteres a recoger ya que el nombre debe contener 40 bytes
        for (int i = 0; i < 20; i++) {
            nombre.append(raf.readChar());
        }
        int edad = raf.readInt();

        return "ID: " + idLeido + ", nombre: " + nombre.toString().trim() + ", edad: " + edad;
    }

    public static void modificarEstudiante(int id, RandomAccessFile raf, String nombre, int edad) throws IOException {
        int pos = buscarEstudiante(id, raf);

        // Mandamos el puntero del fichero al comienzo de donde se encuentra el nombre
        raf.seek(pos + 4);

        if (nombre.length() > 20) {
            nombre = nombre.substring(0, 20);
        } else {
            // Si el nombre es menor a 20 caracteres (40 bytes), añadimos los espacios necesarios para que ocupe 40 bytes
            nombre = String.format("%-20s", nombre);
        }
        raf.writeChars(nombre);

        raf.writeInt(edad);
    }
}