
/**
 * Pedir frase por teclado y visualizarla
 * de manera vertical
 */
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String frase = "";

        System.out.println("Introduzca una frase: ");
        frase = scanner.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            System.out.println(frase.charAt(i));
        }
        scanner.close();
    }
}
