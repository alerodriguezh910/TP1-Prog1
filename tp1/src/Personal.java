import java.time.LocalDate;

public class Personal extends Persona implements MiembroUniversidad {
    private String departamento;
    private String puesto;
    private LocalDate fechaIngreso;

    public Personal(String nombre, String apellido, int edad, String documento,
                    String departamento, String puesto, LocalDate fechaIngreso) {
        super(nombre, apellido, edad, documento);
        this.departamento = departamento;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String obtenerRol() {
        return "Personal";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return super.toString() + " | Departamento: " + departamento +
               " | Puesto: " + puesto + " | Fecha de ingreso: " + fechaIngreso;
    }
}