public class Estudiante {
    private String cedula;
    private String apellidos;
    private String nombres;
    private double notaFinal;
    private String carrera;
    private int nivel;

    public Estudiante(String cedula, String apellidos, String nombres, double notaFinal, String carrera, int nivel) {
        this.cedula = cedula;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.notaFinal = notaFinal;
        this.carrera = carrera;
        this.nivel = nivel;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return String.format("Cédula: %s | Nombre: %s %s | Nota: %.2f | Carrera: %s | Nivel: %d", 
                cedula, nombres, apellidos, notaFinal, carrera, nivel);
    }
}
