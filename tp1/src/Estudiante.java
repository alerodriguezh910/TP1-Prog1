public class Estudiante extends Persona implements MiembroUniversidad {
    private String carrera;
    private double promedio;
    private String[] materias;
    private int cantidadMaterias;
    private static final int MAX_MATERIAS = 10;

    public Estudiante(String nombre, String apellido, int edad, String documento,
                      String carrera, double promedio) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.promedio = promedio;
        this.materias = new String[MAX_MATERIAS];
        this.cantidadMaterias = 0;
    }

    public void agregarMateria(String materia) {
        if (cantidadMaterias < MAX_MATERIAS) {
            materias[cantidadMaterias++] = materia;
        }
    }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" | Carrera: ").append(carrera)
          .append(" | Promedio: ").append(promedio)
          .append(" | Materias: ");
        for (int i = 0; i < cantidadMaterias; i++) sb.append(materias[i]).append(" ");
        return sb.toString();
    }
}