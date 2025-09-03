/*
Escribe un programa que:
Tome dos archivos de texto (archivo1.txt y archivo2.txt).
Combine su contenido en un archivo nuevo llamado combinado.txt.
Asegúrate de agregar un encabezado indicando a qué archivo pertenece cada sección.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) throws Exception {
        Path archivo1 = Paths.get("archivo1.txt");
        Path archivo2 = Paths.get("archivo2.txt");
        Path combinacion = Paths.get("combinado.txt");
        
        try {
            if (!Files.exists(archivo1)) {
                Files.createFile(archivo1);
                Files.writeString(archivo1, """
                                            Este es el contenido del archivo1.txt.\r
                                            Puedes agregar m\u00e1s l\u00edneas de texto aqu\u00ed.\r
                                            Este archivo es parte de la combinaci\u00f3n de archivos.""" //
                //
                );
            }

            if (!Files.exists(archivo2)) {
                Files.createFile(archivo2);
                Files.writeString(archivo2, """
                                            Este es el contenido del archivo2.txt.\r
                                            Puedes agregar m\u00e1s l\u00edneas de texto aqu\u00ed.\r
                                            Este archivo es parte de la combinaci\u00f3n de archivos.""" //
                //
                );
            }
        } catch (IOException e) {
            System.out.println("Error al realizar operaciones con el archivo");
        }

        try (BufferedReader bufferedReader1 = Files.newBufferedReader(archivo1); BufferedReader bufferedReader2 = Files.newBufferedReader(archivo2); BufferedWriter bufferedWriter = Files.newBufferedWriter(combinacion)) {
            String linea;

            bufferedWriter.write("DATOS DEL ARCHIVO 1:\n");

            while ((linea = bufferedReader1.readLine()) != null) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }

            bufferedWriter.write("DATOS DEL ARCHIVO 2:\n");

            while ((linea = bufferedReader2.readLine()) != null) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir datos en el fichero");
        }

    }
}
