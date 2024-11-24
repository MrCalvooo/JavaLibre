
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int numEmpleados;
        String nombre, posicion;
        double salario;

        System.out.println("Cuantos empleados desea introducir?: ");
        numEmpleados = scanner.nextInt();

        // Limpiamos buffer
        scanner.nextLine();

        Empleado arrayEmpleados[] = new Empleado[numEmpleados];

        for (int i = 0; i < arrayEmpleados.length; i++) {

            arrayEmpleados[i] = new Empleado();

            System.out.println("Nombre del empleado: ");
            nombre = scanner.nextLine();
            arrayEmpleados[i].setNombre(nombre);

            System.out.println("Posicion del empleado en la empresa");
            posicion = scanner.nextLine();
            arrayEmpleados[i].setPosicion(posicion);

            System.out.println("El empleado cobra mas de 1500 euros?(s/n): ");
            String cobro = scanner.nextLine();

            if (cobro.equalsIgnoreCase("s")) {
                boolean validarSalario = false;

                while (!validarSalario) {
                    try {
                        System.out.println("Salario: ");
                        salario = scanner.nextDouble();
                        if (salario > 1500.01) {
                            arrayEmpleados[i].setSalario(salario);
                            validarSalario = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Introduzca un valor numerico correcto");

                        // Limpieza buffer
                        scanner.next();
                    }
                }

            }
        }

        scanner.close();

        for (int i = 0; i < arrayEmpleados.length; i++) {
            System.out.println("Datos del empleado numero " + i + ": ");
            System.out.println(arrayEmpleados[i]);
        }

    }
}
