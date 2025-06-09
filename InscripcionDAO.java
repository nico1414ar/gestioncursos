package nico.gestion.gestioncursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscripcionDAO {
    private Connection conn;

    public InscripcionDAO(Connection conn) {
        this.conn = conn;
    }

    public void inscribirAlumno(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripciones (id_alumno, id_curso) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, inscripcion.getIdAlumno());
            stmt.setInt(2, inscripcion.getIdCurso());
            stmt.executeUpdate();
            System.out.println("Inscripción realizada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }
    }
}
