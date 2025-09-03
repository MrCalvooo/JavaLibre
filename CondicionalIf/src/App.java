
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("------------NOTA EXAMEN V2------------");
        Scanner scanner = new Scanner(System.in);

        int preguntas = 20, aciertos;

        System.out.println(preguntas + " preguntas");
        System.out.println("Numero de aciertos: ");
        aciertos = scanner.nextInt();

        if (aciertos == 20) {
            System.out.println("Sobresaliente");
        } else if (aciertos < 20 && aciertos > 15) {
            System.out.println("Notable");
        } else if (aciertos < 15 && aciertos > 10) {
            System.out.println("Suficiente");
        } else {
            System.out.println("Suspenso");
        }

        scanner.close();
    }
}
