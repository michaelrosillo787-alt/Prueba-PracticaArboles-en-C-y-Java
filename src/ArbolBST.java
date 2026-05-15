import java.util.LinkedList;
import java.util.Queue;

public class ArbolBST {
    private Nodo raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    // 1. Insertar estudiante
    public void insertarEstudiante(Estudiante estudiante) {
        raiz = insertarRecursivo(raiz, estudiante);
    }

    private Nodo insertarRecursivo(Nodo actual, Estudiante estudiante) {
        if (actual == null) {
            return new Nodo(estudiante);
        }

        // Comparamos por cédula para mantener el orden del BST
        if (estudiante.getCedula().compareTo(actual.estudiante.getCedula()) < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, estudiante);
        } else if (estudiante.getCedula().compareTo(actual.estudiante.getCedula()) > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, estudiante);
        } else {
            System.out.println("Error: Ya existe un estudiante con la cédula " + estudiante.getCedula());
        }

        return actual;
    }

    // 2. Buscar estudiante por cédula
    public Estudiante buscarEstudiante(String cedula) {
        Nodo resultado = buscarRecursivo(raiz, cedula);
        return resultado != null ? resultado.estudiante : null;
    }

    private Nodo buscarRecursivo(Nodo actual, String cedula) {
        if (actual == null || actual.estudiante.getCedula().equals(cedula)) {
            return actual;
        }

        if (cedula.compareTo(actual.estudiante.getCedula()) < 0) {
            return buscarRecursivo(actual.izquierdo, cedula);
        } else {
            return buscarRecursivo(actual.derecho, cedula);
        }
    }

    // 3. Eliminar estudiante
    public void eliminarEstudiante(String cedula) {
        if (buscarEstudiante(cedula) != null) {
            raiz = eliminarRecursivo(raiz, cedula);
            System.out.println("Estudiante con cédula " + cedula + " eliminado correctamente.");
        } else {
            System.out.println("Error: No se encontró al estudiante con cédula " + cedula);
        }
    }

    private Nodo eliminarRecursivo(Nodo actual, String cedula) {
        if (actual == null) {
            return null;
        }

        if (cedula.compareTo(actual.estudiante.getCedula()) < 0) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, cedula);
        } else if (cedula.compareTo(actual.estudiante.getCedula()) > 0) {
            actual.derecho = eliminarRecursivo(actual.derecho, cedula);
        } else {
            // Nodo a eliminar encontrado
            
            // Caso 1 y 2: Un solo hijo o sin hijos
            if (actual.izquierdo == null) {
                return actual.derecho;
            } else if (actual.derecho == null) {
                return actual.izquierdo;
            }

            // Caso 3: Dos hijos
            // Obtener el sucesor inorden (el menor del subárbol derecho)
            actual.estudiante = encontrarMinimo(actual.derecho).estudiante;
            // Eliminar el sucesor inorden
            actual.derecho = eliminarRecursivo(actual.derecho, actual.estudiante.getCedula());
        }

        return actual;
    }

    private Nodo encontrarMinimo(Nodo actual) {
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }

    // 4. Recorrido Inorden
    public void recorridoInorden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Nodo actual) {
        if (actual != null) {
            inordenRecursivo(actual.izquierdo);
            System.out.println(actual.estudiante);
            inordenRecursivo(actual.derecho);
        }
    }

    // 5. Recorrido Preorden
    public void recorridoPreorden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        preordenRecursivo(raiz);
    }

    private void preordenRecursivo(Nodo actual) {
        if (actual != null) {
            System.out.println(actual.estudiante);
            preordenRecursivo(actual.izquierdo);
            preordenRecursivo(actual.derecho);
        }
    }

    // 6. Recorrido Postorden
    public void recorridoPostorden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        postordenRecursivo(raiz);
    }

    private void postordenRecursivo(Nodo actual) {
        if (actual != null) {
            postordenRecursivo(actual.izquierdo);
            postordenRecursivo(actual.derecho);
            System.out.println(actual.estudiante);
        }
    }

    // 7. Recorrido por niveles (BFS)
    public void recorridoPorNiveles() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.println(actual.estudiante);

            if (actual.izquierdo != null) {
                cola.add(actual.izquierdo);
            }
            if (actual.derecho != null) {
                cola.add(actual.derecho);
            }
        }
    }

    // 8. Contar estudiantes (nodos)
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    private int contarNodosRecursivo(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        return 1 + contarNodosRecursivo(actual.izquierdo) + contarNodosRecursivo(actual.derecho);
    }

    // 9. Calcular altura del árbol
    public int calcularAltura() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        int alturaIzquierda = calcularAlturaRecursivo(actual.izquierdo);
        int alturaDerecha = calcularAlturaRecursivo(actual.derecho);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // 10. Mostrar estudiante con mayor nota
    public void buscarNotaMayor() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        Estudiante mejor = buscarNotaMayorRecursivo(raiz, raiz.estudiante);
        System.out.println("Estudiante con la mayor nota:");
        System.out.println(mejor);
    }

    private Estudiante buscarNotaMayorRecursivo(Nodo actual, Estudiante mejorHastaAhora) {
        if (actual == null) {
            return mejorHastaAhora;
        }
        if (actual.estudiante.getNotaFinal() > mejorHastaAhora.getNotaFinal()) {
            mejorHastaAhora = actual.estudiante;
        }
        mejorHastaAhora = buscarNotaMayorRecursivo(actual.izquierdo, mejorHastaAhora);
        mejorHastaAhora = buscarNotaMayorRecursivo(actual.derecho, mejorHastaAhora);
        return mejorHastaAhora;
    }

    // 11. Mostrar estudiante con menor nota
    public void buscarNotaMenor() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        Estudiante peor = buscarNotaMenorRecursivo(raiz, raiz.estudiante);
        System.out.println("Estudiante con la menor nota:");
        System.out.println(peor);
    }

    private Estudiante buscarNotaMenorRecursivo(Nodo actual, Estudiante peorHastaAhora) {
        if (actual == null) {
            return peorHastaAhora;
        }
        if (actual.estudiante.getNotaFinal() < peorHastaAhora.getNotaFinal()) {
            peorHastaAhora = actual.estudiante;
        }
        peorHastaAhora = buscarNotaMenorRecursivo(actual.izquierdo, peorHastaAhora);
        peorHastaAhora = buscarNotaMenorRecursivo(actual.derecho, peorHastaAhora);
        return peorHastaAhora;
    }

    // 12. Mostrar estudiantes aprobados
    public void mostrarAprobados() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        System.out.println("--- Estudiantes Aprobados (Nota >= 7.0) ---");
        boolean[] encontro = {false};
        mostrarAprobadosRecursivo(raiz, encontro);
        if (!encontro[0]) {
            System.out.println("No hay estudiantes aprobados.");
        }
    }

    private void mostrarAprobadosRecursivo(Nodo actual, boolean[] encontro) {
        if (actual != null) {
            mostrarAprobadosRecursivo(actual.izquierdo, encontro);
            if (actual.estudiante.getNotaFinal() >= 7.0) {
                System.out.println(actual.estudiante);
                encontro[0] = true;
            }
            mostrarAprobadosRecursivo(actual.derecho, encontro);
        }
    }

    // 13. Mostrar estudiantes reprobados
    public void mostrarReprobados() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        System.out.println("--- Estudiantes Reprobados (Nota < 7.0) ---");
        boolean[] encontro = {false};
        mostrarReprobadosRecursivo(raiz, encontro);
        if (!encontro[0]) {
            System.out.println("No hay estudiantes reprobados.");
        }
    }

    private void mostrarReprobadosRecursivo(Nodo actual, boolean[] encontro) {
        if (actual != null) {
            mostrarReprobadosRecursivo(actual.izquierdo, encontro);
            if (actual.estudiante.getNotaFinal() < 7.0) {
                System.out.println(actual.estudiante);
                encontro[0] = true;
            }
            mostrarReprobadosRecursivo(actual.derecho, encontro);
        }
    }
}
