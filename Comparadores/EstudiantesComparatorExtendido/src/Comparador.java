
import java.util.Comparator;

public class Comparador implements Comparator<Estudiante> {

    @Override
    public int compare(Estudiante o1, Estudiante o2) {
        // Comparamos nota
        int comparacionNota = Double.compare(o1.getNotaMedia(), o2.getNotaMedia());
        if (comparacionNota != 0) {
            return comparacionNota;
        }

        // Si coincide la nota comparamos por edad
        int comparacionEdad = Integer.compare(o1.getEdad(), o2.getEdad());
        if (comparacionEdad != 0) {
            return comparacionEdad;
        }

        // Si coinciden ambos casos, comparamos por nombre
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
