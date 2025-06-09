package nico.gestion.gestioncursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlumnoDAO {
    private Connection conn;

    public AlumnoDAO(Connection conn) {
        this.conn = conn;
    }

    public void agregarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (nombre, apellido, dni) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellido());
            stmt.setString(3, alumno.getDni());
            stmt.executeUpdate();
            System.out.println("Alumno agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar alumno: " + e.getMessage());
        }
    }
}
