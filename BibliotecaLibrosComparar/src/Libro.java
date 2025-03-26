
public class Libro implements Comparable<Libro> {

    private String titulo;
    private String autor;
    private int anyo;

    @Override
    public String toString() {
        return titulo + " " + autor + " año publicacion: " + anyo;
    }

    public Libro(int anyo, String autor, String titulo) {
        this.anyo = anyo;
        this.autor = autor;
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + anyo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Libro other = (Libro) obj;
        return titulo.equalsIgnoreCase(other.titulo) && autor.equalsIgnoreCase(other.autor);
    }

    @Override
    public int compareTo(Libro o) {
        return this.titulo.compareTo(o.titulo);
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

}
