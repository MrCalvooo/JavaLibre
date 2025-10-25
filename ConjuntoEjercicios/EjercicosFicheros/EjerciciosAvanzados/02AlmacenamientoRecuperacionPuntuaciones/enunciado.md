## Ejercicio de Práctica: Almacenamiento y Recuperación de Puntuaciones (Ficheros Binarios Primitivos)

Este ejercicio requiere que implementes un programa Java para gestionar el almacenamiento y la recuperación de datos primitivos (`String` e `int`) en un **fichero binario** llamado `"puntuaciones.dat"`.

Los datos primitivos se almacenan en un fichero utilizando las clases `FileOutputStream` y `DataOutputStream` [1]. Para la lectura se utilizan `FileInputStream` y `DataInputStream` [2].

### Parte 1: Escritura de datos primitivos

El objetivo es escribir la información de varios jugadores (nombre y puntuación) de forma secuencial en el fichero `"puntuaciones.dat"`.

1. **Definición de datos:**
    *   Crea un array de cadenas (`String`) con los nombres de al menos 4 jugadores.
    *   Crea un array de enteros (`int`) con las puntuaciones correspondientes a cada jugador.
2. **Configuración de flujos:**
    *   Utiliza `FileOutputStream` y `DataOutputStream` para abrir el flujo de salida de bytes [3].
    *   Asegúrate de que el contenido anterior del fichero, si existe, **sea sobrescrito** (esto se logra omitiendo o estableciendo a `false` el parámetro `append` en el constructor de `FileOutputStream` [3, 4]).
3. **Escritura secuencial:**
    *   Recorre los arrays y, por cada jugador, escribe primero el nombre (utilizando el método apropiado para cadenas en `DataOutputStream` [5]) y luego su puntuación (utilizando `writeInt()` [6]) en el fichero.
4. **Cierre:**
    *   Cierra el flujo de salida (`DataOutputStream`).

### Parte 2: Lectura y Recuperación de datos primitivos

El objetivo es leer todo el contenido del fichero binario creado en la Parte 1.

1. **Configuración de flujos:**
    *   Utiliza `FileInputStream` y `DataInputStream` para abrir el flujo de entrada de bytes [2, 7].
2. **Lectura secuencial y manejo del fin de fichero (EOF):**
    *   Debes leer los datos en el mismo orden en que fueron escritos: Nombre (`String`), Puntuación (`int`).
    *   Implementa un **bucle infinito** (`for (;;)` o `while(true)`) para intentar leer todos los registros.
    *   Para detectar el final del fichero y salir del bucle, debes capturar la excepción `EOFException` que se lanza al intentar leer más allá del último dato [8, 9].
    *   Dentro del bucle, lee el nombre y la puntuación de cada jugador y muéstralos por pantalla.
3. **Cierre:**
    *   Asegúrate de que el flujo de entrada se cierre cuando se capture la `EOFException` [8].