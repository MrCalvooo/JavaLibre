
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {

    public static void main(String[] args) throws Exception {
        Path binario = Paths.get("pokemon.bin");
        Path texto = Paths.get("pokemon.txt");

        try {
            if (!Files.exists(texto)) {
                Files.createFile(texto);
            }

            if (!Files.exists(binario)) {
                Files.createFile(binario);
            }
        } catch (IOException e) {
            System.out.println("Error al crear los archivos");
        }

        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(binario))) {
            short total;
            for (total = 0; total < 50; total++) {
                short randomNumber = (short) (Math.random() * 1025);
                short hp = randomStats(), ataque = randomStats(), defensa = randomStats(), ataqueEsp = randomStats(), defensaEsp = randomStats();
                short velocidad = randomStats();

                short randomGen = (short) (Math.random() * 2);
                char gen;
                if (randomGen == 0) {
                    gen = 'M';
                } else {
                    gen = 'F';
                }

                // Escribimos los datos en el archivo
                dos.writeUTF("Numero: " + randomNumber);
                dos.writeUTF("Genero: " + gen);
                dos.writeUTF("Estadisticas: ");
                dos.writeUTF("HP (" + hp + "): " + porcentajes(hp));
                dos.writeUTF("Ataque (" + ataque + "): " + porcentajes(ataque));
                dos.writeUTF("Defensa (" + defensa + "): " + porcentajes(defensa));
                dos.writeUTF("Ataque Especial (" + ataqueEsp + "): " + porcentajes(ataqueEsp));
                dos.writeUTF("Defensa Especial (" + defensaEsp + "): " + porcentajes(defensaEsp));
                dos.writeUTF("Velocidad (" + velocidad + "): " + porcentajes(velocidad));
                dos.writeUTF("*************************************");
            }
            dos.writeUTF("En total hay " + total + " pokemons");

            System.out.println("Escritura de los pokemons completada");
        } catch (IOException e) {
            System.out.println("Error al escribir los pokemons: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(Files.newInputStream(binario))) {

            String linea = "";
            while (dis.available() > 0) {
                linea += dis.readUTF() + "\n";
            }

            Files.writeString(texto, linea, StandardOpenOption.WRITE);
            System.out.println("Traspaso de datos binarios a txt completado");

        } catch (IOException e) {
            System.out.println("Error al escribir datos binarios en txt: " + e.getMessage());
        }
    }

    // Estadistica random
    public static short randomStats() {
        return (short) (Math.random() * 241 + 20);
    }

    // Dependiendo del valor de la estadistica se representara un valor a nivel grafico
    public static String porcentajes(short stat) {

        String renglones;

        // Validar que stat esté en el rango permitido
        if (stat < 20 || stat > 260) {
            return "Valor fuera del rango permitido (20-260)";
        }

        // Calcular el número de renglones proporcionalmente
        int numRenglones = 1 + (stat - 20) * 9 / (260 - 20);

        // Construir el gráfico con el número de renglones calculado
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRenglones; i++) {
            sb.append("-"); // Añade un guion seguido de un salto de línea
        }

        renglones = sb.toString();
        return renglones;
    }

}
