# 🛡️ Java Vulnerable Lab

Este proyecto es un laboratorio de **vulnerabilidades web** en aplicaciones Java con servlets, creado con fines educativos y prácticos. Aquí aprenderás a detectar, explotar y mitigar fallos de seguridad comunes como **Path Traversal, XSS, SQL Injection, CSRF**, entre otros.

---

## 🎯 Objetivo

Desarrollar un entorno seguro donde puedas:

- Comprender cómo funcionan ciertas vulnerabilidades.
- Explorar su impacto real.
- Practicar técnicas de detección y explotación.
- Aplicar soluciones seguras para mitigarlas.

---

## 🧪 Requisitos del entorno

- Java 17 o superior
- Apache Maven
- Apache Tomcat 10.1.x
- IDE recomendado: IntelliJ IDEA
- Navegador Web

---

## 🚀 Cómo ejecutar

1. **Compilar el proyecto:**

   ```bash
   mvn clean package
   ```

2. **Copiar el **``** generado al directorio **``** de Tomcat:**

   ```bash
   cp target/java-vulnerable-lab.war /ruta/a/apache-tomcat/webapps/
   ```

3. **Iniciar Tomcat:**

   ```bash
   cd /ruta/a/apache-tomcat/bin
   ./catalina.sh run
   ```

4. **Abrir en el navegador:**

   ```
   http://localhost:8080/java-vulnerable-lab
   ```

---

## 📚 Guías disponibles

Cada vulnerabilidad tiene su propia guía detallada en la carpeta `docs/`.

| Vulnerabilidad   | Estado     | Guía                                   |
| ---------------- | ---------- | -------------------------------------- |
| ✅ Path Traversal | Completada | [Guía →](docs/README_PathTraversal.md) |
| ⏳ XSS            | En proceso | *Próximamente*                         |
| ⏳ SQL Injection  | En proceso | *Próximamente*                         |
| ⏳ CSRF           | En proceso | *Próximamente*                         |

---

## 🧠 Estructura del proyecto

```
java-vulnerable-lab/
├── src/
│   └── main/java/com/example/servlets/
│       └── PathTraversalExample.java
├── docs/
│   └── README_PathTraversal.md
├── target/
├── pom.xml
└── README.md
```

---

## 🧰 ¿Cómo contribuir al laboratorio?

1. Crea un nuevo archivo `.java` con la vulnerabilidad en `src/main/java`.
2. Agrega la documentación correspondiente en `docs/README_NombreVulnerabilidad.md`.
3. Actualiza la tabla de guías en este README.
4. Haz commit y push con un mensaje claro.

---

## 📝 Notas

- Este laboratorio **NO debe desplegarse en entornos productivos**.
- Todas las vulnerabilidades están creadas intencionadamente para propósitos educativos.
- Asegúrete de usar una máquina local o virtual controlada.

---

## 👩‍💻 Autora

**Johana Yepes**\
Estudiante de Maestría en Ingeniería del Software y Sistemas Informáticos\


---

> “Un espacio seguro para explorar, fallar, aprender... y fortalecer habilidades en desarrollo seguro.” 🧠🔐

