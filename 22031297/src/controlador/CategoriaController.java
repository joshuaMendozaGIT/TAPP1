package controlador;

import dao.CategoriaDAO;
import entidades.Categoria;
import vista.CategoriaVista;
import java.sql.SQLException;
import java.util.List;

public class CategoriaController {
    private CategoriaVista vista;
    private CategoriaDAO modelo;

    public CategoriaController() {
        this.vista = new CategoriaVista();
        this.modelo = new CategoriaDAO();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    listarCategorias();
                    break;
                case 2:
                    buscarCategoria();
                    break;
                case 3:
                    insertarCategoria();
                    break;
                case 4:
                    actualizarCategoria();
                    break;
                case 5:
                    eliminarCategoria();
                    break;
                case 6:
                    vista.mostrarMensaje("Volviendo al menú principal...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void listarCategorias() {
        try {
            List<Categoria> categorias = modelo.listarTodos();
            vista.listarCategorias(categorias);
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al listar categorías: " + e.getMessage());
        }
    }

    private void buscarCategoria() {
        int id = vista.pedirId();
        try {
            Categoria categoria = modelo.buscarPorId(id);
            vista.mostrarCategoria(categoria);
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al buscar categoría: " + e.getMessage());
        }
    }

    private void insertarCategoria() {
        Categoria nueva = vista.pedirDatosCategoria();
        try {
            modelo.insertar(nueva);
            vista.mostrarMensaje("Categoría insertada con ID: " + nueva.getId());
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al insertar categoría: " + e.getMessage());
        }
    }

    private void actualizarCategoria() {
        int id = vista.pedirId();
        try {
            Categoria categoria = modelo.buscarPorId(id);
            if (categoria != null) {
                vista.mostrarCategoria(categoria);
                Categoria datosNuevos = vista.pedirDatosCategoria();
                categoria.setNombre(datosNuevos.getNombre());
                categoria.setDescripcion(datosNuevos.getDescripcion());
                modelo.actualizar(categoria);
                vista.mostrarMensaje("Categoría actualizada correctamente.");
            } else {
                vista.mostrarMensaje("No existe categoría con ese ID.");
            }
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al actualizar categoría: " + e.getMessage());
        }
    }

    private void eliminarCategoria() {
        int id = vista.pedirId();
        try {
            modelo.eliminar(id);
            vista.mostrarMensaje("Categoría eliminada (si existía).");
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al eliminar categoría: " + e.getMessage());
        }
    }
}