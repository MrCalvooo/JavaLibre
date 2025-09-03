
import java.util.Comparator;

public class ComparatorCategoria implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {
        return o1.getCategoria().compareTo(o2.getCategoria());
    }

}
