public class Materia {
    private String nombre;
    private String codigo;
    private Profesor profesor;

    public Materia(String nombre, String codigo, Profesor profesor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.profesor = profesor;
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public Profesor getProfesor() { return profesor; }

    @Override
    public String toString() {
        return "Materia: " + nombre + " (" + codigo + ") | Profesor: " +
               (profesor != null ? profesor.getNombre() + " " + profesor.getApellido() : "No asignado");
    }
}