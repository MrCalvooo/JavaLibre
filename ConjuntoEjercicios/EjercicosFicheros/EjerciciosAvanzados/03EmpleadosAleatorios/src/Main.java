import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("empleados.dat", "rw");
            raf.setLength(0);

            // Parte 1: insertar datos
            int[] ids = {1, 2, 3, 4};
            String[] apellidos = {
                    String.format("%-20s", "Fernandez"),
                    String.format("%-20s", "García"),
                    String.format("%-20s", "Rodríguez"),
                    String.format("%-20s", "González")
            };
            int[] departamentos = {10, 20, 30, 40};
            double[] salarios = {2500.0, 3000.0, 3500.0, 4000.0};

            for (int i = 0; i < ids.length; i++) {
                raf.writeInt(ids[i]);
                byte[] buffer = new byte[20];
                buffer = apellidos[i].getBytes();
                raf.write(buffer);
                raf.writeInt(departamentos[i]);
                raf.writeDouble(salarios[i]);
            }

            // Parte 2: consultar empleados
            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingrese el ID del empleado a consultar: ");
            int id = 0;
            while (id == 0) {
                try {
                    id = Integer.parseInt(teclado.nextLine());
                    if (id < 1 || id > ids.length) {
                        System.out.println("ID NO REGISTRADO");
                        System.out.println("INGRESE ID: ");
                        id = 0;
                    } else {
                        int pos = encontrarEmpleado(id);
                        raf.seek(pos);
                        int idLeido = raf.readInt();
                        byte[] buffer = new byte[20];
                        raf.readFully(buffer);
                        String apellido = new String(buffer).trim();
                        int departamento = raf.readInt();
                        double salario = raf.readDouble();
                        System.out.println("ID: " + idLeido + " - Apellido: " + apellido + " - Departamento: " +
                                departamento + " - Salario: " + salario);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID NO REGISTRADO");
                    System.out.println("INGRESE ID: ");
                }
            }

            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int encontrarEmpleado(int id) {
        int pos = (id - 1) * 36;
        return pos;
    }
}