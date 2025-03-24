
public class App {

    public static void main(String[] args) throws Exception {
        Libro libro1 = new Libro("Quijote", 5, "Cervantes");
        Libro libro2 = new Libro("Quijote", 5, "Cervantes");
        Libro libro3 = new Libro("Quijote", 6, "Cervantes");

        if (libro1.equals(libro2)) {
            System.out.println(libro1 + " es igual que " + libro2);
        } else if (libro1.equals(libro3)) {
            System.out.println(libro1 + " es igual que " + libro3);
        }
    }
}
