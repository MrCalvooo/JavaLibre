/*Ejercicio
Descripción: Crea un programa que gestione las calificaciones de los estudiantes en una clase.
El programa debe ser capaz de:
-Registrar las calificaciones de los estudiantes: Guarda las calificaciones en un array.
-Calcular estadísticas: Calcula y muestra la calificación media, la calificación más alta y la más baja.
-Identificar y mostrar los estudiantes con las calificaciones más altas y más bajas.
-Mostrar un listado de estudiantes y sus calificaciones ordenadas de mayor a menor.
-Detalles del ejercicio:
-Declarar y rellenar el array:
Crea un array para almacenar las calificaciones de los estudiantes.
Utiliza un array adicional para almacenar los nombres de los estudiantes.
Rellena estos arrays con datos (puedes usar valores aleatorios para las calificaciones).
Cálculo de estadísticas:
-Calificación media: Calcula la media de todas las calificaciones.
-Calificación más alta y más baja: Encuentra la calificación más alta y la más baja.
-Identificar estudiantes específicos:
-Encuentra los índices de los estudiantes con las calificaciones más alta y más baja.
-Muestra estos estudiantes junto con sus calificaciones.
-Ordenar y mostrar listado:
-Ordena el array de calificaciones de mayor a menor, asegurándote de que
los nombres de los estudiantes se mantengan alineados con sus calificaciones. 
*/

public class App {
    public static void main(String[] args) throws Exception {
        String[] estudiantes = { "Ana", "Antonio", "Jose", "Juan" };
        int[] notas = new int[estudiantes.length];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = (int) (Math.random() * (0 + 10) + 1);
        }

        System.out.println("La media de todas las notas es: " + media(notas));

        System.out.println("La nota mas alta es: " + notaAlta(notas));

        System.out.println("La nota mas baja es: " + notaBaja(notas));

        System.out.println("Orden de notas: ");
        
        ordenNotasAlumnos(notas, estudiantes);

        for (int i = 0; i < notas.length; i++) {
            System.out.println(estudiantes[i] + ": " + notas[i]);
        }

    }

    public static double media(int[] a) {
        double media = 0;

        for (int i = 0; i < a.length; i++) {
            media += a[i];
        }

        media = media / a.length;

        return media;
    }

    public static double notaAlta(int[] a) {
        double alta = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > alta) {
                alta = a[i];
            }
        }
        return alta;
    }

    public static double notaBaja(int[] a) {
        double baja = 10;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < baja) {
                baja = a[i];
            }
        }
        return baja;
    }

    public static void ordenNotasAlumnos(int[] notas, String[] estudiantes) {
        for (int i = 0; i < notas.length - 1; i++) {
            for (int j = 0; j < notas.length - i - 1; j++) {
                if (notas[j] < notas[j + 1]) {
                    int aux = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = aux;
                    String auxS = estudiantes[j];
                    estudiantes[j] = estudiantes[j + 1];
                    estudiantes[j + 1] = auxS;
                }
            }
        }
    }
}
