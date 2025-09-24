import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Hijo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList<>();
        String palabra = "";
        String palabraLarga = "";
        String palabraCorta = "";
        do {
            palabra = scanner.nextLine();
            if (palabra.length() > palabraLarga.length()) {
                palabraLarga = palabra;
            }

            if (palabra.length() < palabraCorta.length()) {
                palabraCorta = palabra;
            }
            palabras.add(palabra);
        } while (!palabra.equals("FIN"));

        // Eliminamos la palabra FIN
        palabras.remove(palabras.size() - 1);

        Iterator<String> it = palabras.iterator();

        System.out.println("Total de palabras: " + palabras.size());
        while (it.hasNext()) {
            for (int i = 0; i < palabras.size(); i++) {
                System.out.println("Palabra numero " + i + " : " + it.next());
            }
        }
    }
}
