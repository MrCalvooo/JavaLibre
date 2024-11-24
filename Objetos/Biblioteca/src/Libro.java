public class Libro {
    private String titulo;
    private String autor;
    private int numPaginas;

    public Libro(String titulo, String autor, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.numPaginas = 100;
    }

    @Override
    public String toString() {
        return String.format("%2s escrito por: %2s cuenta con un total de %02d paginas\n", titulo, autor, numPaginas);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    // Ponemos un limite al numero de paginas
    public void setNumPaginas(int numPaginas) {
        if (numPaginas < 100) {
            this.numPaginas = 100;
        } else {
            this.numPaginas = numPaginas;
        }
    }

}
