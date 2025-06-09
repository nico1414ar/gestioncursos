package nico.gestion.gestioncursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDAO {
    private Connection conn;

    public ProfesorDAO(Connection conn) {
        this.conn = conn;
    }

    public void agregarProfesor(Profesor profesor) {
        String sql = "INSERT INTO profesores (nombre, apellido, dni) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellido());
            stmt.setString(3, profesor.getDni());
            stmt.executeUpdate();
            System.out.println("Profesor agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar profesor: " + e.getMessage());
        }
    }
}
