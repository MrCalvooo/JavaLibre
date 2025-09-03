public class Empleado {
    private String nombre;
    private String posicion;
    private double salario;

    @Override
    public String toString() {
        return String.format("Empleado: %2s cuya posicion es: %2s con un salario de %.2f", nombre, posicion, salario);
    }

    public Empleado(String nombre, String posicion, double salario) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.salario = salario;
    }

    public Empleado() {
        this.nombre = "";
        this.posicion = "";
        this.salario = 1500.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
