
# 🛡️ Vulnerabilidad: Path Traversal

## 📌 Descripción
La vulnerabilidad de Path Traversal (Traversal Directory o Directory Climbing) permite a un atacante acceder a archivos fuera del directorio permitido de la aplicación web, navegando por la estructura del sistema de archivos con secuencias como `../`.

---

## 🧠 Conceptos Clave

- **Source**: `request.getParameter("file")`  
  Es donde el usuario introduce la entrada que será utilizada en el path del archivo. Aquí puede inyectar `../`.
  
- **Sink**: `new File(getServletContext().getRealPath("/datos/" + nombreArchivo))`  
  Es donde se consume la entrada sin validación, generando el path final del archivo que se va a leer.

- **Secuencia peligrosa**: `../`  
  Esta secuencia sube un nivel en el sistema de archivos. Por ejemplo:  
  - `../../etc/passwd` → puede acceder al archivo de contraseñas en sistemas Unix si no hay validación.

---

## ⚠️ Código Vulnerable

```java
@WebServlet("/leer-archivo")
public class PathTraversalExample extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
```

---

## 🧪 Ejemplo de explotación

Supón que existe el archivo `/etc/passwd` (en sistemas Unix). La siguiente URL intentará leerlo:

```
http://localhost:8080/java-vulnerable-lab/leer-archivo?file=../../../../../../etc/passwd
```

🧨 Si el servidor no valida la ruta, puede acceder a archivos del sistema fuera del directorio `webapp`.

---

## ✅ Solución Segura

1. **Evitar que el usuario pueda subir de directorio**:
```java
if (nombreArchivo.contains("..") || nombreArchivo.contains("/") || nombreArchivo.contains("\")) {
    response.getWriter().write("Nombre de archivo no válido.");
    return;
}
```

2. **Usar una lista blanca de archivos permitidos**:
```java
List<String> archivosPermitidos = List.of("ejemplo.txt", "lectura.txt");
if (!archivosPermitidos.contains(nombreArchivo)) {
    response.getWriter().write("Archivo no autorizado.");
    return;
}
```

## 🧪 Cómo probarlo

1. Accede a:  
   ```
   http://localhost:8080/java-vulnerable-lab/leer-archivo?file=ejemplo.txt
   ```
2. Luego intenta:  
   ```
   http://localhost:8080/java-vulnerable-lab/leer-archivo?file=../../../../etc/passwd
   ```
3. Verifica si te devuelve el contenido del archivo externo.

---

## 📘 Referencias

- [OWASP Path Traversal](https://owasp.org/www-community/attacks/Path_Traversal)
- [Common Weakness Enumeration - CWE-22](https://cwe.mitre.org/data/definitions/22.html)
