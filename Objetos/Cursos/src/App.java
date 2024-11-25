
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Curso curso = new Curso(1, "DAM");

        Scanner scanner = new Scanner(System.in);

        int edad = 0, longitud;
        String nombre, matricula;
        boolean edadValida = false;

        System.out.println("Cuantos estudiantes vamos a agregar?: ");
        longitud = scanner.nextInt();
        Estudiante[] estudiantes = new Estudiante[longitud];

        scanner.nextLine();

        for (int i = 0; i < estudiantes.length; i++) {

            System.out.println("Nombre: ");
            nombre = scanner.nextLine();

            do {
                try {

                    System.out.println("Edad: ");
                    edad = scanner.nextInt();

                    if (edad < 18) {
                        edadValida = false;
                        System.out.println("No podemos meter a un menor de edad en la universidad");
                    } else if (edad > 18) {
                        edadValida = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Introduzca una edad");
                    System.out.println(e.getMessage());
                }
            } while (!edadValida);

            scanner.nextLine();

            System.out.println("Numero de matricula: ");
            matricula = scanner.nextLine();

            estudiantes[i] = new Estudiante(curso, edad, matricula, nombre);
        }

        System.out.println("Alumnos del curso " + curso.getNombre() + ": ");

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.mostrarInformacion());
        }

        scanner.close();
    }
}
