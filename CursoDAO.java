package nico.gestion.gestioncursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursoDAO {
    private Connection conn;

    public CursoDAO(Connection conn) {
        this.conn = conn;
    }

    public void agregarCurso(Curso curso) {
        String sql = "INSERT INTO cursos (nombre, descripcion) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNombre());
            stmt.setString(2, curso.getDescripcion());
            stmt.executeUpdate();
            System.out.println("Curso agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar curso: " + e.getMessage());
        }
    }
}
