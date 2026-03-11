package vista;

import entidades.Categoria;
import java.util.List;
import java.util.Scanner;

public class CategoriaVista {
    private Scanner scanner;

    public CategoriaVista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE CATEGORÍAS ---");
        System.out.println("1. Listar categorías");
        System.out.println("2. Buscar categoría por ID");
        System.out.println("3. Insertar categoría");
        System.out.println("4. Actualizar categoría");
        System.out.println("5. Eliminar categoría");
        System.out.println("6. Volver al menú principal");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public void listarCategorias(List<Categoria> categorias) {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías para mostrar.");
        } else {
            System.out.println("\nLista de categorías:");
            for (Categoria c : categorias) {
                System.out.println(c.getId() + " - " + c.getNombre() + " - " + c.getDescripcion());
            }
        }
    }

    public void mostrarCategoria(Categoria categoria) {
        if (categoria != null) {
            System.out.println("Categoría encontrada: " + categoria);
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    public Categoria pedirDatosCategoria() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        return new Categoria(0, nombre, descripcion);
    }

    public int pedirId() {
        System.out.print("ID de la categoría: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}