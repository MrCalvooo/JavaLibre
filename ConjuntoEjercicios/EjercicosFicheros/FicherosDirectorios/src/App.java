
import java.io.File;

public class App {

    public static void main(String[] args) throws Exception {
        File file = new File("src"); // Directorio

        System.out.println("Ruta del archivo: " + file.getAbsolutePath());

        System.out.println("Existe el archivo?: " + file.exists());

        String[] archivos = file.list(); // Almacenamos en el array todo lo q hay dentro de la ruta
        for (String archivo : archivos) {
            File f = new File(file.getAbsolutePath(), archivo);
            
            if (f.isDirectory()) {
                String[] archivos2 = f.list();
                for (String string : archivos2) {
                    System.out.println(string);
                }
            } else {
                System.out.println(archivo);
            }
        }
    }
}
