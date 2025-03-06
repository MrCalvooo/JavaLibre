
public class CajeroAutomatico {

    private double saldo;

    public CajeroAutomatico() {
        this.saldo = 500;
    }

    @Override
    public String toString() {
        return "Saldo disponible: " + saldo;
    }

    public double retirarDinero(double cantidad) throws SaldoInsuficienteException, CantidadIncorrectaException {

        if (comprobarCantidad(cantidad) == false) {
            throw new CantidadIncorrectaException();
        }

        if (cantidad > saldo) {
            throw new SaldoInsuficienteException();
        } else {
            saldo -= cantidad;
        }
        return cantidad;
    }

    public double ingresarDinero(double cantidad) throws CantidadIncorrectaException {
        if (comprobarCantidad(cantidad) == false) {
            throw new CantidadIncorrectaException();
        } else {
            saldo += cantidad;
        }

        return saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean comprobarCantidad(double cantidad) {

        return cantidad > 0;
    }

}
