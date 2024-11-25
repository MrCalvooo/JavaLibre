public class Estudiante {
    private String nombre;
    private int edad;
    String matricula;
    Curso curso;

    public Estudiante(Curso curso, int edad, String matricula, String nombre) {
        this.curso = curso;
        this.edad = edad;
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public Estudiante(Estudiante e) {
        this.curso = e.getCurso();
        this.edad = e.getEdad();
        this.matricula = e.getMatricula();
        this.nombre = e.getNombre();
    }

    public String mostrarInformacion() {
        return "Nombre: " + getNombre() + " edad: " + getEdad() + " numero matricula: " + getMatricula() + " curso: \n"
                + curso;
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
        if (edad < 18) {
            this.edad = 0;
        } else {
            this.edad = edad;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
