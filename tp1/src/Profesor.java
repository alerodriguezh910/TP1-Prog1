public class Profesor extends Persona implements MiembroUniversidad {
    private String especialidad;
    private int aniosExperiencia;
    private String[] materiasAsignadas;
    private int cantidadMaterias;
    private static final int MAX_MATERIAS = 10;

    public Profesor(String nombre, String apellido, int edad, String documento,
                    String especialidad, int aniosExperiencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
        this.materiasAsignadas = new String[MAX_MATERIAS];
        this.cantidadMaterias = 0;
    }

    public void asignarMateria(String materia) {
        if (cantidadMaterias < MAX_MATERIAS) {
            materiasAsignadas[cantidadMaterias++] = materia;
        }
    }

    @Override
    public String obtenerRol() {
        return "Profesor";
    }

    @Override
    public String obtenerInformacionCompleta() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" | Especialidad: ").append(especialidad)
          .append(" | Experiencia: ").append(aniosExperiencia).append(" años")
          .append(" | Materias asignadas: ");
        for (int i = 0; i < cantidadMaterias; i++) sb.append(materiasAsignadas[i]).append(" ");
        return sb.toString();
    }
}
