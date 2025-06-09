package nico.gestion.gestioncursos;

public class Inscripcion {
    private int id;
    private int idAlumno;
    private int idCurso;

    public Inscripcion(int id, int idAlumno, int idCurso) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
    }

    public Inscripcion(int idAlumno, int idCurso) {
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
    }

    public int getId() { return id; }
    public int getIdAlumno() { return idAlumno; }
    public int getIdCurso() { return idCurso; }

    public void setId(int id) { this.id = id; }
    public void setIdAlumno(int idAlumno) { this.idAlumno = idAlumno; }
    public void setIdCurso(int idCurso) { this.idCurso = idCurso; }
}
