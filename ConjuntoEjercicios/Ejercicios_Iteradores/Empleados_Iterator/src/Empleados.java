
public class Empleados {

    private final String nombre;
    private final String departamento;
    private double salario;

    public Empleados(String nombre, String departamento, double salario) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " departamento: " + departamento + " salario: " + salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void incrementoSalario() {
        salario += salario * 0.1;
    }

}
