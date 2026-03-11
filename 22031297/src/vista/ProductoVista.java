package vista;

import entidades.Producto;
import java.util.List;
import java.util.Scanner;

public class ProductoVista {
    private Scanner scanner;

    public ProductoVista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
        System.out.println("1. Listar productos");
        System.out.println("2. Buscar producto por ID");
        System.out.println("3. Insertar producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Volver al menú principal");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public void listarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            System.out.println("\nLista de productos:");
            for (Producto p : productos) {
                System.out.println(p.getId() + " - " + p.getNombre() + " - Precio: " + p.getPrecio() + " - Cantidad: " + p.getCantidad() + " - ID Categoría: " + p.getIdCategoria());
            }
        }
    }

    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public Producto pedirDatosProducto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID Categoría: ");
        int idCategoria = scanner.nextInt();
        scanner.nextLine();
        return new Producto(0, nombre, precio, cantidad, idCategoria);
    }

    public int pedirId() {
        System.out.print("ID del producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}