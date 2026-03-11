package dao;

import entidades.Producto;
import database.ConexionMySQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void insertar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (nombre, precio, cantidad, id_categoria) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getCantidad());
            pstmt.setInt(4, producto.getIdCategoria());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    producto.setId(rs.getInt(1));
                }
            }
        }
    }

    public List<Producto> listarTodos() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, cantidad, id_categoria FROM productos";
        try (Connection conn = ConexionMySQL.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                lista.add(p);
            }
        }
        return lista;
    }

    public Producto buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nombre, precio, cantidad, id_categoria FROM productos WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Producto p = new Producto();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setCantidad(rs.getInt("cantidad"));
                    p.setIdCategoria(rs.getInt("id_categoria"));
                    return p;
                }
            }
        }
        return null;
    }

    public void actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ?, id_categoria = ? WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getCantidad());
            pstmt.setInt(4, producto.getIdCategoria());
            pstmt.setInt(5, producto.getId());
            pstmt.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}