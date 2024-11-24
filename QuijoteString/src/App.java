public class App {
    public static void main(String[] args) throws Exception {
        String cadena = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";

        System.out.println(fraseMayus(cadena));

        System.out.println(vocalesPorGuiones(cadena));

        System.out.println(segundaPalabra(cadena));

        System.out.println(ultimaPalabra(cadena));

    }

    public static String fraseMayus(String cadena) {
        return cadena.toUpperCase();
    }

    public static String vocalesPorGuiones(String cadena) {
        String cambio = cadena;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.toLowerCase().charAt(i) == 'a' || cadena.toLowerCase().charAt(i) == 'e'
                    || cadena.toLowerCase().charAt(i) == 'i' || cadena.toLowerCase().charAt(i) == 'o'
                    || cadena.toLowerCase().charAt(i) == 'u') {
                char caracter = cadena.charAt(i);

                cambio = cambio.replace(caracter, '-');
            }
        }

        return cambio;
    }

    public static String segundaPalabra(String cadena) {

        String segundaPalabra = cadena.substring(3, 5);

        return segundaPalabra;
    }

    public static String ultimaPalabra(String cadena) {
        String ultimaPalabra = "";

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                ultimaPalabra = cadena.substring(i);
            }
        }

        return ultimaPalabra;
    }

}
