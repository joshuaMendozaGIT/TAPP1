# Proyecto CRUD Tienda con Java + MySQL (MVC)

Aplicación de consola desarrollada en Java que implementa un CRUD completo para dos tablas relacionadas (`categorias` y `productos`) de una tienda. El proyecto sigue el patrón **Modelo-Vista-Controlador (MVC)**, utiliza **JDBC** para la conexión con MySQL y aplica principios de **Programación Orientada a Objetos**.

## Requisitos previos

- **Java Development Kit (JDK)** 8 o superior.
- **MySQL Server** instalado y en ejecución.
- **Conector MySQL JDBC** (archivo `.jar`). Puedes descargarlo desde [aquí](https://dev.mysql.com/downloads/connector/j/).
- Un IDE (opcional, pero recomendado) como NetBeans, IntelliJ IDEA o Eclipse.

## Configuracion de la base de datos

1. Abre el manejador de base de datos de MySQL.
2. Ejecuta el siguiente script para crear la base de datos y las tablas:

```sql
CREATE DATABASE IF NOT EXISTS tienda;
USE tienda;

CREATE TABLE IF NOT EXISTS categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    cantidad INT NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id) ON DELETE SET NULL
);

INSERT INTO categorias (nombre, descripcion) VALUES
('Electrónica', 'Productos electrónicos y gadgets'),
('Ropa', 'Prendas de vestir para todas las edades'),
('Hogar', 'Artículos para el hogar y decoración');

INSERT INTO productos (nombre, precio, cantidad, id_categoria) VALUES
('Smartphone', 350.00, 15, 1),
('Laptop', 850.00, 7, 1),
('Camiseta', 15.50, 30, 2),
('Sartén', 25.00, 12, 3);

## Ajusta los datos de conexión en el archivo
private static final String URL = "jdbc:mysql://localhost:3306/tienda";
private static final String USER = "*****";      // Tu usuario de MySQL
private static final String PASSWORD = "*****";  // Tu contraseña

## Funcionalidades

La aplicación presenta un menú principal con las siguientes opciones:

    Gestionar Categorías

        Listar todas las categorías.

        Buscar categoría por ID.

        Insertar nueva categoría.

        Actualizar categoría existente.

        Eliminar categoría por ID.

    Gestionar Productos

        Listar todos los productos.

        Buscar producto por ID.

        Insertar nuevo producto (requiere ID de categoría válida).

        Actualizar producto existente.

        Eliminar producto por ID.

    Salir de la aplicación.


# Markdown Cheat Sheet (Example File)

This is a **generic Markdown template** showcasing essential formatting features.

---

## 1. Headers
# H1 (Largest)
## H2
### H3
#### H4
##### H5
###### H6 (Smallest)

---

## 2. Text Formatting
- **Bold** (`**text**` or `__text__`)
- *Italic* (`*text*` or `_text_`)
- ~~Strikethrough~~ (`~~text~~`)
- `Inline Code` (`` `code` ``)
- > Blockquote (prefix with `>`)

---

## 3. Lists
### Unordered List
- Item 1
- Item 2
  - Nested Item (indent with 2 spaces)

### Ordered List
1. First item
2. Second item
   1. Nested item (indent with 3 spaces)

### Task List
- [x] Completed task
- [ ] Pending task (`[ ]`)

---

## 4. Links
- [Hyperlink](https://example.com) (`[text](url)`)

---

## 5. Code Blocks
```java
# Syntax-highlighted block (java)
class HelloWorld {
    public static main(String... args) {
        System.out.println("Hello markdown");
    }
}
