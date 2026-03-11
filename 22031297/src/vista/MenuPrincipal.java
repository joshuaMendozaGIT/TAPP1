package vista;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Gestionar Categorías");
        System.out.println("2. Gestionar Productos");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return opcion;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}
