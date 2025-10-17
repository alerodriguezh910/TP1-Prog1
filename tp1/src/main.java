import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad Nacional de Villa Mercedes");

        Estudiante est1 = new Estudiante("Lucas", "Rodriguez", 20, "12345", "Ingenieria en Sistemas", 8.5);
        est1.agregarMateria("Matematica");
        est1.agregarMateria("Programacion");

        Profesor prof1 = new Profesor("Ana", "Garcia", 45, "67890", "Informatica", 15);
        prof1.asignarMateria("Programacion");

        Personal pers1 = new Personal("Carlos", "Lopez", 38, "11223", "Administracion", "Secretario",
                LocalDate.of(2015, 3, 10));

        universidad.agregarMiembro(est1);
        universidad.agregarMiembro(prof1);
        universidad.agregarMiembro(pers1);

        universidad.listarMiembros();

        universidad.listarPorRol("Personal");
    }
}
