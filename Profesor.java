package nico.gestion.gestioncursos;

public class Profesor extends Persona {
    public Profesor(int id, String nombre, String apellido, String dni) {
        super(id, nombre, apellido, dni);
    }

    public Profesor(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre + " " + apellido + " - DNI: " + dni);
    }
}
