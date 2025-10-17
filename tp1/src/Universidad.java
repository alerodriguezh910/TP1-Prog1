public class Universidad {
    private String nombre;
    private MiembroUniversidad[] miembros;
    private int cantidadMiembros;
    private static final int MAX_MIEMBROS = 50;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.miembros = new MiembroUniversidad[MAX_MIEMBROS];
        this.cantidadMiembros = 0;
    }

    public void agregarMiembro(MiembroUniversidad miembro) {
        if (cantidadMiembros < MAX_MIEMBROS) {
            miembros[cantidadMiembros++] = miembro;
        } else {
            System.out.println("No se pueden agregar más miembros.");
        }
    }

    public void listarMiembros() {
        System.out.println("Miembros de la " + nombre );
        for (int i = 0; i < cantidadMiembros; i++) {
            MiembroUniversidad m = miembros[i];
            System.out.println(m.obtenerRol() + " → " + m.obtenerInformacionCompleta());
        }
    }

    public void listarPorRol(String rol) {
        System.out.println("Miembros con rol: " + rol);
        for (int i = 0; i < cantidadMiembros; i++) {
            MiembroUniversidad m = miembros[i];
            if (m.obtenerRol().equalsIgnoreCase(rol)) {
                System.out.println(m.obtenerInformacionCompleta());
            }
        }
    }
}