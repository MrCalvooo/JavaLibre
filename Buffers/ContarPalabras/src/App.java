/*
Escribe un programa que:
Lea un archivo de texto llamado texto.txt.
Cuente la cantidad total de palabras que contiene el archivo.
Imprima el número total de palabras y las 5 palabras más frecuentes junto con su frecuencia.
Pistas:
Usa un Map<String, Integer> para llevar un conteo de palabras.
Recuerda limpiar el texto eliminando caracteres especiales y convertir las palabras a minúsculas.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
        Path archivo = Paths.get("texto.txt");

        try {
            if (!Files.exists(archivo)) {
                Files.createFile(archivo);
                Files.writeString(archivo, """
                                           Este es un archivo de texto de ejemplo.\r
                                           Puedes escribir cualquier cosa aqu\u00ed.\r
                                           Este archivo contiene varias l\u00edneas de texto.\r
                                           Cada l\u00ednea puede tener palabras, n\u00fameros o caracteres especiales.\r
                                           \r
                                           \u00a1Divi\u00e9rtete explorando el contenido del archivo!"""
                );
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }

        int totalPalabras = 0;
        Map<String, Integer> mapa = new HashMap<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(archivo)) {
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] palabras = linea.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");

                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        mapa.put(palabra, mapa.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        }

        mapa.forEach((palabra, conteo) -> System.out.println(palabra + ": " + conteo));

    }
}
