package dao;

import entidades.Categoria;
import database.ConexionMySQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    // CREATE
    public void insertar(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, categoria.getNombre());
            pstmt.setString(2, categoria.getDescripcion());
            pstmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    categoria.setId(rs.getInt(1));
                }
            }
        }
    }

    // READ (todos)
    public List<Categoria> listarTodos() throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, descripcion FROM categorias";
        try (Connection conn = ConexionMySQL.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDescripcion(rs.getString("descripcion"));
                lista.add(c);
            }
        }
        return lista;
    }

    // READ (por ID)
    public Categoria buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nombre, descripcion FROM categorias WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Categoria c = new Categoria();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setDescripcion(rs.getString("descripcion"));
                    return c;
                }
            }
        }
        return null;
    }

    // UPDATE
    public void actualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categorias SET nombre = ?, descripcion = ? WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getNombre());
            pstmt.setString(2, categoria.getDescripcion());
            pstmt.setInt(3, categoria.getId());
            pstmt.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}