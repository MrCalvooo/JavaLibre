
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App {

    public static void main(String[] args) throws Exception {
        Set<Empleados> empleados = new HashSet<>();

        empleados.add(new Empleados("Sara", "Ventas", 2000));
        empleados.add(new Empleados("Juan", "Contabilidad", 1500));
        empleados.add(new Empleados("Marco", "Ventas", 2300));
        empleados.add(new Empleados("Ana", "RRHH", 2000.80));
        empleados.add(new Empleados("Laura", "Contabilidad", 2100));

        Iterator<Empleados> iterator = empleados.iterator();

        verEmpleados(empleados, iterator);

        iterator = empleados.iterator();

        while (iterator.hasNext()) {

            Empleados e = iterator.next();

            if (e.getDepartamento().equalsIgnoreCase("Ventas")) {
                e.incrementoSalario();
            }

            if (e.getSalario() < 2000) {
                iterator.remove();
            }
        }

        iterator = empleados.iterator();

        System.out.println("-------------------");

        verEmpleados(empleados, iterator);
    }

    public static void verEmpleados(Set<Empleados> empleados, Iterator<Empleados> iterator) {

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
