package nico.gestion.gestioncursos;

public class Alumno extends Persona {
    public Alumno(int id, String nombre, String apellido, String dni) {
        super(id, nombre, apellido, dni);
    }

    public Alumno(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Alumno: " + nombre + " " + apellido + " - DNI: " + dni);
    }
}
