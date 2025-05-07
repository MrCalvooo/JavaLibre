<%@ page import="java.util.List, java.util.ArrayList, com.formulario.model.Usuario" %>
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Mostrar usuarios</title>
        </head>

        <body>
            <h1>DATOS USUARIOS: </h1>
            
            <%
                List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");

                if (listaUsuarios != null && !listaUsuarios.isEmpty()){%>

                <ul>
                    <%
                    for (Usuario usu : listaUsuarios){%>
                        <li>
                            DNI: <%=usu.getDni()%>, nombre: <%=usu.getNombre()%>, apellidos: <%=usu.getApellido()%>, telefono: <%=usu.getTelefono()%>
                        </li>
                    <%}%>
                </ul>
                <%} else {%>
                    <p>No hay usuarios registrados actualmente</p>
                <%}
            %>
            

            <a href="hello-servlet">Volver a registro usuarios</a>
        </body>

        </html>