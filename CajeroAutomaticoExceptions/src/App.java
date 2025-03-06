
public class App {

    public static void main(String[] args) throws Exception {
        CajeroAutomatico cajeroAutomatico = new CajeroAutomatico();

        System.out.println(cajeroAutomatico);

        System.out.println("--------------------OPERACIONES CON ERROR-------------------");

        // Retirar dinero incorrecto
        System.out.println("Retiramos 0 euros");
        try {
            cajeroAutomatico.retirarDinero(0);
        } catch (CantidadIncorrectaException | SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(cajeroAutomatico);
        }

        // Ingresar dinero incorrecto
        System.out.println("Ingresamos -50 euros");
        try {
            cajeroAutomatico.ingresarDinero(-50);
        } catch (CantidadIncorrectaException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(cajeroAutomatico);
        }

        System.out.println("--------------------OPERACIONES CORRECTAS-------------------");

        // Retirar dinero correcto
        System.out.println("Retiramos 100.80 euros");
        try {
            cajeroAutomatico.retirarDinero(100.80);
        } catch (CantidadIncorrectaException | SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(cajeroAutomatico);
        }

        // Ingresar dinero correcto
        System.out.println("Ingresamos 1000 euros");
        try {
            cajeroAutomatico.ingresarDinero(1000);
        } catch (CantidadIncorrectaException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(cajeroAutomatico);
        }
    }
}
