
import java.util.Comparator;

public class ComparatorNombre implements Comparator<Estudiante> {

    @Override
    public int compare(Estudiante o1, Estudiante o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }

}
