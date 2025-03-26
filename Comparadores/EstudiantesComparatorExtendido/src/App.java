
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("Juan", 20, 8.5));
        estudiantes.add(new Estudiante("Ana", 22, 9.0));
        estudiantes.add(new Estudiante("Luis", 21, 7.8));
        estudiantes.add(new Estudiante("Maria", 23, 8.2));
        estudiantes.add(new Estudiante("Pedro", 20, 6.9));
        Iterator<Estudiante> it = estudiantes.iterator();

        System.out.println("SIN ORDENAR");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nORDENADO");
        estudiantes.sort(new Comparador());
        it = estudiantes.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
