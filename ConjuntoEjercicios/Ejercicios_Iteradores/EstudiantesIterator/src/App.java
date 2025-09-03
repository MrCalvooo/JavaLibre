
import java.util.ArrayList;
import java.util.Iterator;

public class App {

    public static void main(String[] args) throws Exception {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("Juan", 19));
        estudiantes.add(new Estudiante("Pedro", 21));
        estudiantes.add(new Estudiante("Maria", 22));
        estudiantes.add(new Estudiante("Ana", 17));
        estudiantes.add(new Estudiante("Carla", 16));

        Iterator<Estudiante> it = estudiantes.iterator();

        System.out.println("------------ESTUDAINTES------------");

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Reiniciamos la cuenta del iterador
        it = estudiantes.iterator();

        // Buscamos y eliminamos a los menores de edad
        while (it.hasNext()) {
            if (it.next().getEdad() < 18) {
                it.remove();
            }
        }

        // Reiniciamos la cuenta del iterador
        it = estudiantes.iterator();

        System.out.println("------------ESTUDAINTES MAYORES DE EDAD------------");

        // Imprimimos por pantalla la lista sin los menores de edad
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
