package nico.gestion.gestioncursos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class GestionCursos {
    private static final String URL = "jdbc:mysql://localhost:3306/gestioncursos";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            AlumnoDAO alumnoDAO = new AlumnoDAO(conn);
            ProfesorDAO profesorDAO = new ProfesorDAO(conn);
            CursoDAO cursoDAO = new CursoDAO(conn);
            InscripcionDAO inscripcionDAO = new InscripcionDAO(conn);

            boolean salir = false;

            while (!salir) {
                System.out.println("\n===== SISTEMA DE GESTIÓN DE CURSOS =====");
                System.out.println("1. Alta de alumno");
                System.out.println("2. Alta de profesor");
                System.out.println("3. Alta de curso");
                System.out.println("4. Inscripción de alumno a curso");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del alumno: ");
                        String nombreA = scanner.nextLine();
                        System.out.print("Apellido del alumno: ");
                        String apellidoA = scanner.nextLine();
                        System.out.print("DNI del alumno: ");
                        String dniA = scanner.nextLine();

                        Alumno alumno = new Alumno(nombreA, apellidoA, dniA);
                        alumnoDAO.agregarAlumno(alumno);
                        break;

                    case 2:
                        System.out.print("Nombre del profesor: ");
                        String nombreP = scanner.nextLine();
                        System.out.print("Apellido del profesor: ");
                        String apellidoP = scanner.nextLine();
                        System.out.print("DNI del profesor: ");
                        String dniP = scanner.nextLine();

                        Profesor profesor = new Profesor(nombreP, apellidoP, dniP);
                        profesorDAO.agregarProfesor(profesor);
                        break;

                    case 3:
                        System.out.print("Nombre del curso: ");
                        String nombreC = scanner.nextLine();
                        System.out.print("Descripción del curso: ");
                        String descripcion = scanner.nextLine();

                        Curso curso = new Curso(nombreC, descripcion);
                        cursoDAO.agregarCurso(curso);
                        break;

                    case 4:
                        System.out.print("ID del alumno: ");
                        int idAlumno = Integer.parseInt(scanner.nextLine());
                        System.out.print("ID del curso: ");
                        int idCurso = Integer.parseInt(scanner.nextLine());

                        Inscripcion inscripcion = new Inscripcion(idAlumno, idCurso);
                        inscripcionDAO.inscribirAlumno(inscripcion);
                        break;

                    case 5:
                        salir = true;
                        System.out.println("¡Gracias por usar el sistema!");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error en la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
