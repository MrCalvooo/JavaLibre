/*
Descripción: Crea un programa que gestione las temperaturas de una ciudad durante un mes.
El programa debe ser capaz de:
-Registrar las temperaturas diarias: Guarda la temperatura máxima y mínima de cada día en arrays separados.
-Calcular estadísticas: Calcula y muestra la temperatura media del mes,
-la temperatura máxima más alta y la mínima más baja del mes.
-Encontrar y mostrar días específicos: Identifica y muestra los días en los que
-se registraron la temperatura máxima más alta y la mínima más baja del mes.
Detalles del ejercicio:
-Declarar y rellenar los arrays:
-Crea dos arrays, uno para las temperaturas máximas (tempMax) y otro para las mínimas (tempMin),
-ambos de tamaño 30 (suponiendo un mes de 30 días).
Rellena estos arrays con temperaturas aleatorias entre un rango razonable
(por ejemplo, máximas entre 20°C y 40°C y mínimas entre 0°C y 20°C).
Cálculo de estadísticas:
-Media de temperaturas: Calcula la media de las temperaturas máximas y mínimas.
-Máxima y mínima: Encuentra la temperatura máxima más alta y la mínima más baja.
Identificar días específicos:
-Encuentra los índices (días) donde se registraron la máxima más alta y la mínima más baja.
-Muestra estos días junto con las temperaturas correspondientes.
 */

public class App {
    public static void main(String[] args) throws Exception {

        int[] tempMax = new int[30], tempMin = new int[30];

        // Rellenando con temperaturas minimas entre 0 y 20
        for (int i = 0; i < tempMin.length; i++) {
            int temperatura = (int) (Math.random() * (0 + 20) + 1);
            tempMin[i] = temperatura;
        }

        // Rellenando con temperaturas maximas entre 20 y 40
        for (int i = 0; i < tempMax.length; i++) {
            int temperatura = (int) (Math.random() * (20 + 40) + 1);
            tempMax[i] = temperatura;
        }

        System.out.println("Temperatura maxima media: " + mediaTemperatura(tempMax));

        System.out.println("Temperatura minima media: " + mediaTemperatura(tempMin));

        System.out.println("Temparatura mas alta: " + maximaMasAlta(tempMax));

        System.out.println("Temperatura mas baja: " + minimaMasBaja(tempMin));

    }

    public static int mediaTemperatura(int[] temperatura) {
        int media = 0;
        for (int i = 0; i < temperatura.length; i++) {
            media += temperatura[i];
        }

        media = media / temperatura.length;

        return media;
    }

    public static String maximaMasAlta(int[] temperatura) {
        int max = 0;
        int dia = 0;
        for (int i = 0; i < temperatura.length; i++) {
            if (temperatura[i] > max) {
                max = temperatura[i];
                dia = i;
            }
        }
        return max + "ºC el dia " + dia;
    }

    public static String minimaMasBaja(int[] temperatura) {
        int minima = 20;
        int dia = 0;
        for (int i = 0; i < temperatura.length; i++) {
            if (temperatura[i] < minima) {
                minima = temperatura[i];
                dia = i;
            }
        }
        return minima + "ºC y el dia " + dia;
    }
}
