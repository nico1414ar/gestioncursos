package nico.gestion.gestioncursos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/gestioncursos";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error en la conexión: " + e.getMessage());
        }
    }
}
