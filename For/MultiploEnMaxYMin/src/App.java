import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Buscar multiplos entre un valor minimo y maximo
        int minimo, maximo, multiplo;

        System.out.println("Numero para usar como valor minimo: ");
        minimo = scanner.nextInt();

        System.out.println("Numero para usar como valor maximo: ");
        maximo = scanner.nextInt();

        System.out.println("Unidad para buscar multiplos: ");
        multiplo = scanner.nextInt();

        for (int i = minimo; (minimo <= i) && (i < maximo); i++) {
            if (i % multiplo == 0) {
                System.out.println(multiplo + " * " + i + " = " + multiplo * i);
            }
        }
        scanner.close();
    }
}
