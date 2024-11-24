import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {

        try (Scanner scanner = new Scanner(System.in)) {
            int cantidadNombres;
            String nombres, dudaAmiga;

            try {
                System.out.println("Cuantos nombres vas a introducir?: ");
                cantidadNombres = scanner.nextInt();

                String[] amigas = new String[cantidadNombres];

                for (int i = 0; i < cantidadNombres; i++) {
                    System.out.println("Nombre: ");
                    nombres = scanner.nextLine();

                    System.out.println("Es realmente amiga tuya? (s/n)");
                    dudaAmiga = scanner.nextLine();

                    if (dudaAmiga.equalsIgnoreCase("s")) {
                        amigas[i] = nombres;
                    } else {
                        System.out.println("Que la den a " + nombres);
                    }
                }

                for (String listaAmigas : amigas) {
                    System.out.println(listaAmigas);
                }

            } catch (Exception e) {
                System.out.println("Porfavor introduce numeros enteros");
            }

            TimeUnit.SECONDS.sleep(2);

            scanner.close();
        }
    }
}