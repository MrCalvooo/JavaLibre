<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>JSP - Hello World</title>
    </head>

    <body>
        <h1>DATOS USUARIO: </h1>
        <form action="hello-servlet" method="POST">
            <p>
                <label>DNI: <input type="text" name="dni"></label>
            </p>
            <p>
                <label>Nombre: <input type="text" name="nombre"></label>
            </p>
            <p>
                <label>Apellido: <input type="text" name="apellido"></label>
            </p>
            <p>
                <label>Telefono: <input type="text" name="telefono"></label>
            </p>

            <button type="submit">Enviar</button>
        </form>
    </body>

    </html>