import java.util.Scanner;

public class Hijo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int suma = num1 + num2;
        int resta = num1 - num2;
        double producto = num1 * num2;

        System.out.printf("Suma de %d+%d = %d\n", num1, num2, suma);
        System.out.printf("Resta de %d-%d = %d\n", num1, num2, resta);
        System.out.printf("Producto de %d*%d = %.2f\n", num1, num2, producto);
    }
}
