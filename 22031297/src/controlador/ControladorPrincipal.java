package controlador;

import vista.MenuPrincipal;
import java.sql.SQLException;

public class ControladorPrincipal {
    private MenuPrincipal vista;
    private CategoriaController categoriaController;
    private ProductoController productoController;

    public ControladorPrincipal() {
        this.vista = new MenuPrincipal();
        this.categoriaController = new CategoriaController();
        this.productoController = new ProductoController();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    categoriaController.iniciar();
                    break;
                case 2:
                    productoController.iniciar();
                    break;
                case 3:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
        vista.cerrar();
    }
}