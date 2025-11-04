import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Cada persona ocupará 68 bytes
        // 12 * 2 bytes el nombre, 10 * 2 bytes apellido1, 10 * 2 bytes apellido2, 4 bytes edad
        Persona[] personas = {
                new Persona(String.format("%-12s", "Brais"), String.format("%-10s", "Moure"), String.format("%-10s", "Dev"), 30),
                new Persona(String.format("%-12s", "Samuel"), String.format("%-10s", "Blas"), String.format("%-10s", "Garcia"), 20),
                new Persona(String.format("%-12s", "Miriam"), String.format("%-10s", "Moreno"), String.format("%-10s", "Torres"), 22)
        };
        try {
            RandomAccessFile raf = new RandomAccessFile("personas.dat", "rw");

            for (Persona p : personas) {
                //byte[] bufferNombre = p.getNombre().getBytes();
                raf.writeChars(p.getNombre());
                raf.writeChars(p.getApellido1());
                raf.writeChars(p.getApellido2());
                raf.writeInt(p.getEdad());
            }

            System.out.println("Personas insertadas en el fichero correctamente");

            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Activando modo lectura para meter dicha información en un XML");
    }
}