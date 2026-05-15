public class Nodo {
    public Estudiante estudiante;
    public Nodo izquierdo;
    public Nodo derecho;

    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.izquierdo = null;
        this.derecho = null;
    }
}
