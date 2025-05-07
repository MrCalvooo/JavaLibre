/*
 * Copyright 2020 Diego Silva <diego.silva at apuntesdejava.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.formulario.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.formulario.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private String message;
    List<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    public void init() {
        message = "Hello World from Servlet!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Generamos la lista

        // Almacenamos en variables los datos introducidos en cada campo del formulario
        String dni = req.getParameter("dni");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String telefono = req.getParameter("telefono");

        // Añadimos el usuario a la lista
        listaUsuarios.add(new Usuario(dni, nombre, apellido, telefono));

        req.setAttribute("listaUsuarios", listaUsuarios);

        // Mandamos los datos a la nueva pagina
        req.getRequestDispatcher("/WEB-INF/view/MostrarUsuarios.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
    }
}
