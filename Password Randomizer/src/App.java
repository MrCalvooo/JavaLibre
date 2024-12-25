
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String password = "";
        int leng;

        String minus = "abcdefghijklmnñopqrstuvwxyz";
        String mayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String nums = "0123456789";
        String especiales = ".-*/!ªº?¿'¡´ç¨{}_;:@#~";

        System.out.println("Longitud deseada de la contraseña: ");
        leng = scanner.nextInt();

        for (int i = 0; i < leng; i++) {
            int random = (int) (Math.random() * 4 + 1);
            char caracter;

            switch (random) {
                case 1 -> {
                    random = (int) (Math.random() * minus.length() + 1);
                    caracter = minus.charAt(random);
                    password += caracter;
                }

                case 2 -> {
                    random = (int) (Math.random() * mayus.length() + 1);
                    caracter = mayus.charAt(random);
                    password += caracter;
                }

                case 3 -> {
                    random = (int) (Math.random() * nums.length() + 1);
                    caracter = nums.charAt(random);
                    password += caracter;
                }

                case 4 -> {
                    random = (int) (Math.random() * especiales.length() + 1);
                    caracter = especiales.charAt(random);
                    password += caracter;
                }

                default ->
                    throw new AssertionError();
            }
        }

        System.out.println("Tu contraseña es: " + password);

        scanner.close();
    }
}
