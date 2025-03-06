
public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException() {
        super("No hay saldo suficiente para realizar la operación");
    }
}
