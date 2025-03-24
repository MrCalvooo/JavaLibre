
import java.util.Objects;

public class Libro {

    private final String nombre;
    private final int ISBN;
    private final String autor;

    @Override
    public String toString() {
        return "Titulo: " + nombre + " ISBN: " + ISBN + " autor: " + autor;
    }

    public Libro(String nombre, int iSBN, String autor) {
        this.nombre = nombre;
        ISBN = iSBN;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + this.ISBN;
        hash = 23 * hash + Objects.hashCode(this.autor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Libro otro) { // Si el objeto es instancia de Libro
            return this.ISBN == otro.ISBN; // Comprobamos el ISBN
        } else {
            return false; // NO es instancia de la clase Libro
        }
    }
}
