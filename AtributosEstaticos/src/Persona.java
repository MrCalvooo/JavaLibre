
public class Persona {

    private static int id;
    private String nombre;
    private int edad;
    private String apellidos;

    public static int actualizarID(int id) {
        return id++;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " apellidos: " + getApellidos() + " edad: " + getEdad() + " id: " + getId();
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Persona.id = id;
    }

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
