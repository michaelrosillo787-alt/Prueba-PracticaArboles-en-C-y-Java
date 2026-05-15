import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArbolBST arbol = new ArbolBST();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA ACADÉMICO UTA ---");
            System.out.println("1. Insertar estudiante");
            System.out.println("2. Buscar estudiante por cédula");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Recorrido Inorden");
            System.out.println("5. Recorrido Preorden");
            System.out.println("6. Recorrido Postorden");
            System.out.println("7. Recorrido por niveles BFS");
            System.out.println("8. Contar estudiantes");
            System.out.println("9. Calcular altura del árbol");
            System.out.println("10. Mostrar estudiante con mayor nota");
            System.out.println("11. Mostrar estudiante con menor nota");
            System.out.println("12. Mostrar estudiantes aprobados");
            System.out.println("13. Mostrar estudiantes reprobados");
            System.out.println("14. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                ejecutarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
            }
        } while (opcion != 14);
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                insertarNuevoEstudiante();
                break;
            case 2:
                buscarEstudiante();
                break;
            case 3:
                eliminarEstudiante();
                break;
            case 4:
                System.out.println("\n--- Recorrido Inorden ---");
                arbol.recorridoInorden();
                break;
            case 5:
                System.out.println("\n--- Recorrido Preorden ---");
                arbol.recorridoPreorden();
                break;
            case 6:
                System.out.println("\n--- Recorrido Postorden ---");
                arbol.recorridoPostorden();
                break;
            case 7:
                System.out.println("\n--- Recorrido por niveles (BFS) ---");
                arbol.recorridoPorNiveles();
                break;
            case 8:
                System.out.println("Total de estudiantes en el sistema: " + arbol.contarNodos());
                break;
            case 9:
                System.out.println("Altura actual del árbol: " + arbol.calcularAltura());
                break;
            case 10:
                arbol.buscarNotaMayor();
                break;
            case 11:
                arbol.buscarNotaMenor();
                break;
            case 12:
                arbol.mostrarAprobados();
                break;
            case 13:
                arbol.mostrarReprobados();
                break;
            case 14:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }
    }

    private static void insertarNuevoEstudiante() {
        System.out.println("\n--- Insertar Nuevo Estudiante ---");
        
        String cedula = leerCedula();
        
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        
        double notaFinal = leerNota();
        
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();
        
        int nivel = leerNivel();

        Estudiante nuevo = new Estudiante(cedula, apellidos, nombres, notaFinal, carrera, nivel);
        arbol.insertarEstudiante(nuevo);
        System.out.println("Estudiante registrado con éxito.");
    }

    private static void buscarEstudiante() {
        System.out.println("\n--- Buscar Estudiante ---");
        String cedula = leerCedula();
        Estudiante est = arbol.buscarEstudiante(cedula);
        if (est != null) {
            System.out.println("Estudiante encontrado:");
            System.out.println(est);
        } else {
            System.out.println("No se encontró ningún estudiante con esa cédula.");
        }
    }

    private static void eliminarEstudiante() {
        System.out.println("\n--- Eliminar Estudiante ---");
        String cedula = leerCedula();
        arbol.eliminarEstudiante(cedula);
    }

    private static String leerCedula() {
        String cedula = "";
        boolean valido = false;
        while (!valido) {
            System.out.print("Cédula (10 dígitos): ");
            cedula = scanner.nextLine();
            if (cedula.matches("\\d{10}")) {
                valido = true;
            } else {
                System.out.println("Error: La cédula debe contener exactamente 10 dígitos numéricos.");
            }
        }
        return cedula;
    }

    private static double leerNota() {
        double nota = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print("Nota final (0.0 - 10.0): ");
            try {
                nota = Double.parseDouble(scanner.nextLine());
                if (nota >= 0.0 && nota <= 10.0) {
                    valido = true;
                } else {
                    System.out.println("Error: La nota debe estar entre 0.0 y 10.0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor numérico válido para la nota.");
            }
        }
        return nota;
    }

    private static int leerNivel() {
        int nivel = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print("Nivel (Ej. 1, 2, 3...): ");
            try {
                nivel = Integer.parseInt(scanner.nextLine());
                if (nivel > 0) {
                    valido = true;
                } else {
                    System.out.println("Error: El nivel debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor numérico entero para el nivel.");
            }
        }
        return nivel;
    }
}
