
import java.util.Comparator;

public class ComparatorNotaMedia implements Comparator<Estudiante> {

    @Override
    public int compare(Estudiante o1, Estudiante o2) {
        return Double.compare(o1.getNotaMedia(), o2.getNotaMedia());
    }

}
