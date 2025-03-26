
public class Estudiante implements Comparable<Estudiante> {

    private String nombre;
    private int edad;
    private double notaMedia;

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", notaMedia=" + notaMedia + "]";
    }

    public Estudiante(String nombre, int edad, double notaMedia) {
        this.edad = edad;
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    @Override
    public int compareTo(Estudiante o) {
        return Integer.compare(this.edad, o.getEdad());
    }
}
