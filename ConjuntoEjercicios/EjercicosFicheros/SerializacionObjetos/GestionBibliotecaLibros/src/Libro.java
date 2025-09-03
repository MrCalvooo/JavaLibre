
import java.io.Serializable;
import java.util.Objects;

public class Libro implements Serializable, Comparable<Libro> {

    private final String titulo;
    private final String autor;
    private final int anyo;

    public Libro(String titulo, String autor, int anyo) {
        this.titulo = titulo;
        this.autor = autor;
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return titulo + ", escito por " + autor + ", en el año " + anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnyo() {
        return anyo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.titulo);
        hash = 83 * hash + Objects.hashCode(this.autor);
        hash = 83 * hash + this.anyo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.anyo != other.anyo) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }

    @Override
    public int compareTo(Libro o) {
        // Comparar primero por título
        int comparacionTitulo = this.titulo.compareTo(o.titulo);
        if (comparacionTitulo != 0) {
            return comparacionTitulo;
        }

        // Si los títulos son iguales, comparar por autor
        int comparacionAutor = this.autor.compareTo(o.autor);
        if (comparacionAutor != 0) {
            return comparacionAutor;
        }

        // Si los autores también son iguales, comparar por año
        return Integer.compare(this.anyo, o.anyo);
    }

}
