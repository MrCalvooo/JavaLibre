
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Ana", 20, 8.5));
        estudiantes.add(new Estudiante("Luis", 22, 9.0));
        estudiantes.add(new Estudiante("Pedro", 19, 7.8));
        estudiantes.add(new Estudiante("Marta", 21, 8.9));

        // Ordenar usando Comparable
        System.out.println("Ordenado por edad:");
        estudiantes.sort(null);

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

        System.out.println("Ordenado por nombre:");
        estudiantes.sort(new ComparatorNombre());

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }

        System.out.println("Ordenador por nota media");
        estudiantes.sort(new ComparatorNotaMedia());

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
}
