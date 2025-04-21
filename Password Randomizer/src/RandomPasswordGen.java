
import java.util.Scanner;

public class RandomPasswordGen {

    public static void main(String[] args) throws Exception {

        String password = "";
        int leng = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Longitud deseada de la contraseña: ");
            leng = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Error al leer el numero");
        }

        for (int i = 0; i < leng; i++) {
            int random = (int) (Math.random() * 4 + 1);
            password += caracteresRandom(random);
        }

        System.out.println("Tu contraseña es: " + password);
    }

    public static String caracteresRandom(int random) {

        String minus = "abcdefghijklmnñopqrstuvwxyz";
        String mayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String nums = "0123456789";
        String especiales = ".-*/!ªº?¿'¡´ç¨{}_;:@#~";
        String password = "";
        char caracter;

        switch (random) {
            case 1 -> {
                random = (int) (Math.random() * minus.length());
                caracter = minus.charAt(random);
                password += caracter;
            }

            case 2 -> {
                random = (int) (Math.random() * mayus.length());
                caracter = mayus.charAt(random);
                password += caracter;
            }

            case 3 -> {
                random = (int) (Math.random() * nums.length());
                caracter = nums.charAt(random);
                password += caracter;
            }

            case 4 -> {
                random = (int) (Math.random() * especiales.length());
                caracter = especiales.charAt(random);
                password += caracter;
            }

            default ->
                throw new AssertionError();
        }

        return password;
    }
}
