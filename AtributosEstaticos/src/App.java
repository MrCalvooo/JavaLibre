
public class App {

    public static void main(String[] args) throws Exception {
        Persona persona1 = new Persona("Pro", "bando", 0);

        System.out.println(persona1.toString());

        Persona persona2 = new Persona("a", "b", 0);

        System.out.println(persona2.toString());

        Persona.setId(5);

        System.out.println(persona1.toString());

        System.out.println(persona2.toString());

    }

}
