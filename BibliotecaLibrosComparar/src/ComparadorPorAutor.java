
import java.util.Comparator;

public class ComparadorPorAutor implements Comparator<Libro> {

    @Override
    public int compare(Libro o1, Libro o2) {
        return o1.getAutor().compareTo(o2.getAutor());
    }
}
