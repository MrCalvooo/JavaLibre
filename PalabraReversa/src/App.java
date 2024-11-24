import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Palabra/frase para leer al reves: ");
        String cadena = scanner.nextLine();

        System.out.println(cadenaReversa(cadena));

        System.out.println("Palabra a comprobar palindromo: ");
        String palindromo = scanner.nextLine();

        System.out.println(palindromo + " es palindroma?: " + esPalindroma(palindromo));

        scanner.close();

    }

    public static String cadenaReversa(String cadena) {
        String reversa = "";

        for (int i = cadena.length() - 1; i >= 0; i--) {
            reversa += cadena.charAt(i);
        }

        return reversa;
    }

    public static boolean esPalindroma(String cadena) {
        int n = cadena.length();
        for (int i = 0; i < n / 2; i++) {
            if (cadena.charAt(i) != cadena.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
