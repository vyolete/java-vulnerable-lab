package com.example.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/leer-archivo")
public class PathTraversalExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String nombreArchivo = request.getParameter("file");
        File archivo = new File(getServletContext().getRealPath("/datos/" + nombreArchivo));

        if (!archivo.exists()) {
            response.getWriter().write("Archivo no encontrado.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea = reader.readLine();
        response.getWriter().write("Contenido: " + linea);
        reader.close();
    }
}
