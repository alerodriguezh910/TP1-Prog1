public class Persona {
    
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public String getDocumento() { return documento; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + documento + "), edad: " + edad;
    }
}
