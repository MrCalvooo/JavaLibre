void main() {
    // Establecemos el puerto de conexión a usar
    final int PUERTO = 20001;

    // Usando la clase ServerSocket especificamos que estamos creando un servidor con el protocolo TCP y se le indica el puerto a usar
    try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {

        System.out.println("Esperando conexion de cliente...");
        // Aceptamos la peticion de conexion del cliente
        Socket conexion = serverSocket.accept();
        // Informamos de la IP y de su nombre
        System.out.println("Cliente conectado: " + conexion.getInetAddress().getHostName());

        // Preparamos canales de entrada y salida de datos para comunicarse
        BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        PrintWriter pw = new PrintWriter(conexion.getOutputStream(), true); // autoFlush = true

        pw.println("BIENVENIDO USUARIO");

        String mensaje = "";
        // Mientras el mensaje enviado NO sea adios, el servidor seguira ejecutandose
        while (!mensaje.equalsIgnoreCase("adios")) {
            mensaje = br.readLine();
            System.out.println("Cliente dijo: " + mensaje);

            pw.println("Servidor recibe: " + mensaje);
        }

        System.out.println("Cliente desconectado.");

    } catch (IOException e) {
        e.printStackTrace();
    }
}
