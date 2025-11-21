import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<MiembroUniversidad> miembros;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    public void agregarMiembro(MiembroUniversidad miembro) {
        this.miembros.add(miembro);
    }

    public void listarTodosLosMiembros() {
        System.out.println("\n--- LISTADO DE MIEMBROS DE LA " + this.nombre.toUpperCase() + " ---");
        for (MiembroUniversidad miembro : this.miembros) {
            System.out.println(miembro.obtenerInformacionCompleta());
        }
    }
    
    // Métodos de Conteo Recursivo/Iterativo
    
    // 1. Versión Iterativa
    public static int contarEstudiantesIterativo(Estudiante[] estudiantes, String carrera) {
        int contador = 0;
        if (estudiantes != null) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getCarrera().equalsIgnoreCase(carrera)) {
                    contador++;
                }
            }
        }
        return contador;
    }
    
    // 2. Versión Recursiva
    public static int contarEstudiantesRecursivo(Estudiante[] estudiantes, String carrera, int indice) {
        if (estudiantes == null || indice < 0 || indice >= estudiantes.length) {
            return 0;
        }

        int conteoRestante = contarEstudiantesRecursivo(estudiantes, carrera, indice + 1);

        if (estudiantes[indice].getCarrera().equalsIgnoreCase(carrera)) {
            return 1 + conteoRestante;
        } else {
            return conteoRestante;
        }
    }

    // Métodos de Búsqueda de Estudiante por Documento

    // 1. Versión Iterativa
    public static Estudiante buscarEstudianteIterativo(Estudiante[] estudiantes, String documento) {
        if (estudiantes != null) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getDocumento().equals(documento)) {
                    return estudiante;
                }
            }
        }
        return null;
    }

    // 2. Versión Recursiva
    public static Estudiante buscarEstudianteRecursivo(Estudiante[] estudiantes, String documento, int indice) {
        if (estudiantes == null || indice < 0 || indice >= estudiantes.length) {
            return null;
        }

        if (estudiantes[indice].getDocumento().equals(documento)) {
            return estudiantes[indice];
        }

        return buscarEstudianteRecursivo(estudiantes, documento, indice + 1);
    }
    

    public static Estudiante[] ordenarEstudiantesPorApellido(Estudiante[] estudiantes) {
        if (estudiantes == null || estudiantes.length < 2) return estudiantes;

        int n = estudiantes.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                // Si el apellido del índice j es menor alfabéticamente
                if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            }
            
            if (indiceMinimo != i) {
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[indiceMinimo];
                estudiantes[indiceMinimo] = temp;
            }
        }
        return estudiantes;
    }

    public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
        int izquierda = 0;
        int derecha = estudiantes.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparacion = apellido.compareTo(estudiantes[medio].getApellido());

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                derecha = medio - 1;
            } else {
                izquierda = medio + 1;
            }
        }
        return -1;
    }
}
}
