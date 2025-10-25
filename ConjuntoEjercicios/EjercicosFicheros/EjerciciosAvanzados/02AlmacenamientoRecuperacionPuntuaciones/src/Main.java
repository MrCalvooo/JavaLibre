import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Parte 1: escritura
        String[] jugadores = {"Juan", "Ana", "María", "Pepe"};
        int[] puntos = new int[4];
        for (int i = 0; i < puntos.length; i++) {
            puntos[i] = (int) (Math.random() * 100 + 1);
        }

        File file = new File("puntuaciones.dat");

        try {
            // Eliminamos el contenido del fichero anterior
            FileOutputStream fos = new FileOutputStream(file, false);
            DataOutputStream dos = new DataOutputStream(fos);

            for (int i = 0; i < jugadores.length; i++) {
                dos.writeUTF(jugadores[i]);
                dos.writeInt(puntos[i]);
            }

            dos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Parte 2: lectura
        DataInputStream dis = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            dis = new DataInputStream(fis);

            while (true) {
                String nombre = dis.readUTF();
                int punto = dis.readInt();
                System.out.println(nombre + " - " + punto);
            }

        } catch (EOFException e) {
            System.out.println("----------FIN LECTURA------------");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException ignored) {

                }
            }
        }
    }
}