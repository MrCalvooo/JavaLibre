## Ejercicio de Práctica: Fichero de Acceso Aleatorio (Empleados)

Debes crear un programa Java para gestionar un fichero de acceso aleatorio llamado `"empleados.dat"`. Para esto, se utilizará la clase `java.io.RandomAccessFile`, que permite el posicionamiento directo del puntero de lectura/escritura mediante el método `seek()` [1, 2].

### Requisito Fundamental: Estructura de Registro Fijo

Cada registro de empleado debe tener una **longitud fija de 36 bytes** [3], asegurando que los datos ocupen siempre el mismo espacio en disco.

| Dato | Tipo Java | Longitud en Bytes (Fija) |
| :--- | :--- | :--- |
| Identificador (ID) | `int` | 4 bytes (Tipo `int`) |
| Apellido (máx. 10 caracteres) | `char` | 20 bytes (10 caracteres * 2 bytes/char) [3, 4] |
| Departamento (DEP) | `int` | 4 bytes (Tipo `int`) |
| Salario (SALARIO) | `double` | 8 bytes (Tipo `double`) |
| **Longitud total del registro** | | **36 bytes** [3] |

### Parte 1: Inserción de Registros Secuenciales

1.  **Apertura:** Abre el fichero `"empleados.dat"` utilizando `RandomAccessFile` en modo lectura y escritura ("rw") [5].
2.  **Datos:** Define arrays o estructuras con la información de al menos 4 empleados (ID, Apellido, Departamento, Salario), donde los ID comienzan en 1.
3.  **Escritura:** Implementa la lógica para escribir secuencialmente estos datos en el fichero.
    *   Asegúrate de que los apellidos se manejen con `writeChars(String s)` y que la cadena siempre tenga una longitud de 10 caracteres (rellenar con espacios si es más corta, o truncar si es más larga) para mantener la longitud fija de 20 bytes por apellido [6].

### Parte 2: Consulta de Acceso Aleatorio (Usando `seek`)

1.  **Consulta:** Solicita al usuario el **ID del empleado** que desea consultar.
2.  **Posicionamiento:** Implementa la lógica para calcular la posición exacta (en bytes) del inicio del registro solicitado, utilizando la longitud fija de 36 bytes [7].
    *   La posición de inicio del registro N (si los ID empiezan en 1) se calcula como: $pos = (ID - 1) \times 36$ bytes [8].
3.  **Búsqueda:** Utiliza el método `seek(long pos)` de `RandomAccessFile` para desplazar el puntero al inicio de ese registro [2, 8].
4.  **Lectura:** Lee secuencialmente los 4 campos del registro (ID, Apellido, Departamento, Salario) utilizando los métodos `readXxx()` apropiados [6].
5.  **Resultado:** Muestra los datos del empleado por pantalla.
6.  **Manejo de errores:** Considera la gestión de errores si el ID solicitado está fuera del rango de datos existente.
7.  **Cierre:** Cierra el fichero [9].