import java.util.Arrays;

public class MainCompleto {
    public static void main(String[] args) {
        Universidad miUniversidad = new Universidad("Global Tech");


        Profesor prof1 = new Profesor("Ana", "García", 45, "P123", "Matemáticas", 15);
        Estudiante est1 = new Estudiante("Luis", "Pérez", 20, "E987", "Ingeniería", 8.5);
        Estudiante est2 = new Estudiante("Sofía", "Castro", 22, "E555", "Arquitectura", 9.1);
        Estudiante est3 = new Estudiante("Carlos", "Álvarez", 19, "E111", "Ingeniería", 7.8);
        Personal pers1 = new Personal("Marta", "Rojas", 35, "A112", "Administración", "Secretaria", "2018-03-01");


        Materia algLin = new Materia("Álgebra Lineal", "AL101", 9.0);
        Materia calDiv = new Materia("Cálculo Diverso", "CD202", 7.5);
        Materia ingSoft = new Materia("Ingeniería Software", "IS303", 8.0);
        Materia hisArq = new Materia("Historia Arquitectura", "HA404", 9.5);
 
        prof1.asignarMateria(algLin);
        prof1.asignarMateria(calDiv);
        
        est1.getMaterias().add(algLin);
        est1.getMaterias().add(calDiv);
        est1.getMaterias().add(ingSoft);
        
        est2.getMaterias().add(hisArq);
        
        miUniversidad.agregarMiembro(prof1);
        miUniversidad.agregarMiembro(est1);
        miUniversidad.agregarMiembro(pers1);
        miUniversidad.agregarMiembro(est2);
        miUniversidad.agregarMiembro(est3);
        
        System.out.println("==========================================");
        miUniversidad.listarTodosLosMiembros();
        System.out.println("==========================================");

        // PRUEBA DE RECURSIÓN Y CÁLCULO DE PROMEDIO
        
        Materia[] materiasArray = est1.getMaterias().toArray(new Materia[0]);
        double promRec = Estudiante.calcularPromedioRecursivo(materiasArray);
        double promIte = est1.calcularPromedioIterativo();
        
        System.out.println("\n--- CÁLCULO DE PROMEDIO (" + est1.getNombre() + ") ---");
        System.out.println("Promedio Iterativo: " + String.format("%.2f", promIte));
        System.out.println("Promedio Recursivo: " + String.format("%.2f", promRec));
        
        Estudiante[] estudiantesArray = {est1, est2, est3};
        
        System.out.println("\n--- CONTEO POR CARRERA (Ingeniería) ---");
        int conteoIte = Universidad.contarEstudiantesIterativo(estudiantesArray, "Ingeniería");
        int conteoRec = Universidad.contarEstudiantesRecursivo(estudiantesArray, "Ingeniería", 0);
        System.out.println("Conteo Iterativo: " + conteoIte);
        System.out.println("Conteo Recursivo: " + conteoRec);

        // PRUEBA DE BÚSQUEDA LINEAL
        System.out.println("\n--- BÚSQUEDA POR DOCUMENTO (E111) ---");
        Estudiante buscadoIte = Universidad.buscarEstudianteIterativo(estudiantesArray, "E111");
        Estudiante buscadoRec = Universidad.buscarEstudianteRecursivo(estudiantesArray, "E111", 0);
        System.out.println("Estudiante encontrado (Iterativo): " + (buscadoIte != null ? buscadoIte.getApellido() : "No encontrado"));
        System.out.println("Estudiante encontrado (Recursivo): " + (buscadoRec != null ? buscadoRec.getApellido() : "No encontrado"));
        
        // -PRUEBA DE ORDENAMIENTO Y BÚSQUEDA BINARIA
        System.out.println("\n--- ORDENAMIENTO (Selection Sort) Y BÚSQUEDA BINARIA ---");
        
        System.out.println("Original: " + Arrays.toString(estudiantesArray));
        
        // 1. Ordenar
        Estudiante[] estudiantesOrdenados = Universidad.ordenarEstudiantesPorApellido(estudiantesArray);
        System.out.println("Ordenado: " + Arrays.toString(estudiantesOrdenados));
        
        // 2. Búsqueda Binaria (Requiere estar ordenado)
        String apellidoBuscado = "Pérez";
        int indice = Universidad.busquedaBinariaEstudiantes(estudiantesOrdenados, apellidoBuscado);
        
        if (indice != -1) {
            System.out.println("Búsqueda Binaria: " + apellidoBuscado + " encontrado en índice " + indice);
            System.out.println("Estudiante: " + estudiantesOrdenados[indice].getNombre());
        } else {
            System.out.println("Búsqueda Binaria: " + apellidoBuscado + " no encontrado.");
        }
    }
}
