void main() {
    // Preparamos un objeto Socket significando asi que este programa representa a un cliente TCP conectandose a IP y puerto especificados
    try (Socket conexion = new Socket("127.0.0.1", 20001);
         // Preparamos canales de entrada y salida de datos
         BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
         PrintWriter pw = new PrintWriter(conexion.getOutputStream(), true); // autoFlush
         Scanner scanner = new Scanner(System.in)) {

        // Informamos de que se pudo conectar sin errores al servidor
        System.out.println("Conexion con el servidor exitosa");

        String mensajeServidor = br.readLine();
        System.out.println("Servidor: " + mensajeServidor);

        String mensaje = "";
        // Mientras el mensaje escrito por el usuario NO sea adios, el cliente seguira enganchado al servidor
        while (!mensaje.equalsIgnoreCase("adios")) {
            System.out.print("Mensaje a enviar (adios para salir): ");
            mensaje = scanner.nextLine();
            pw.println(mensaje); // autoFlush
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
