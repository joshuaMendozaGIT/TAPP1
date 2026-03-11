package controlador;

import dao.ProductoDAO;
import entidades.Producto;
import vista.ProductoVista;
import java.sql.SQLException;
import java.util.List;

public class ProductoController {
    private ProductoVista vista;
    private ProductoDAO modelo;

    public ProductoController() {
        this.vista = new ProductoVista();
        this.modelo = new ProductoDAO();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    insertarProducto();
                    break;
                case 4:
                    actualizarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    vista.mostrarMensaje("Volviendo al menú principal...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void listarProductos() {
        try {
            List<Producto> productos = modelo.listarTodos();
            vista.listarProductos(productos);
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al listar productos: " + e.getMessage());
        }
    }

    private void buscarProducto() {
        int id = vista.pedirId();
        try {
            Producto producto = modelo.buscarPorId(id);
            vista.mostrarProducto(producto);
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al buscar producto: " + e.getMessage());
        }
    }

    private void insertarProducto() {
        Producto nuevo = vista.pedirDatosProducto();
        try {
            modelo.insertar(nuevo);
            vista.mostrarMensaje("Producto insertado con ID: " + nuevo.getId());
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al insertar producto: " + e.getMessage());
        }
    }

    private void actualizarProducto() {
        int id = vista.pedirId();
        try {
            Producto producto = modelo.buscarPorId(id);
            if (producto != null) {
                vista.mostrarProducto(producto);
                Producto datosNuevos = vista.pedirDatosProducto();
                producto.setNombre(datosNuevos.getNombre());
                producto.setPrecio(datosNuevos.getPrecio());
                producto.setCantidad(datosNuevos.getCantidad());
                producto.setIdCategoria(datosNuevos.getIdCategoria());
                modelo.actualizar(producto);
                vista.mostrarMensaje("Producto actualizado correctamente.");
            } else {
                vista.mostrarMensaje("No existe producto con ese ID.");
            }
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al actualizar producto: " + e.getMessage());
        }
    }

    private void eliminarProducto() {
        int id = vista.pedirId();
        try {
            modelo.eliminar(id);
            vista.mostrarMensaje("Producto eliminado (si existía).");
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al eliminar producto: " + e.getMessage());
        }
    }
}