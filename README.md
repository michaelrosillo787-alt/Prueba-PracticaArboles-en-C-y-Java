# Sistema Académico UTA - Árboles Binarios de Búsqueda (Java)

Este repositorio contiene la implementación de un sistema de gestión académica para la Universidad Técnica de Ambato. Permite administrar estudiantes utilizando una estructura de datos basada en **Árboles Binarios de Búsqueda (BST)**.

El proyecto está íntegramente desarrollado en Java usando Programación Orientada a Objetos.

---

## Arquitectura del Proyecto (Explicación de Clases)

Para mantener un código limpio, modular y escalable, el proyecto se ha dividido en 4 clases principales. Cada una cumple con el **Principio de Responsabilidad Única**:

### 1. Clase `Estudiante`
* **¿Por qué existe?** Porque necesitamos un molde (plantilla) para representar la entidad principal del sistema, que es el estudiante en el mundo real, encapsulando sus propiedades y evitando tener variables sueltas.
* **¿Para qué sirve?** Sirve para almacenar los datos personales y académicos de una persona (Cédula, Nombres, Apellidos, Nota Final, Carrera, Nivel). Contiene sus constructores, sus métodos *getters* y *setters* para acceder a la información de forma segura (encapsulamiento), y un método `toString()` formateado para imprimir fácilmente al estudiante en la pantalla.

### 2. Clase `Nodo`
* **¿Por qué existe?** La estructura de datos de un "Árbol Binario" requiere elementos que se enlacen entre sí en la memoria. No podemos enlazar estudiantes directamente porque ensuciaría la lógica de negocio del estudiante con la lógica de la estructura de datos.
* **¿Para qué sirve?** Es el contenedor ("la caja") que se coloca dentro del árbol. Cada `Nodo` guarda adentro un objeto `Estudiante`, y además tiene dos punteros (referencias en Java): `izquierdo` y `derecho`. Estos enlaces permiten conectar a un nodo con sus hijos, formando así las ramas del árbol.

### 3. Clase `ArbolBST` (Binary Search Tree)
* **¿Por qué existe?** Se necesita un gestor centralizado que se encargue de organizar a los estudiantes en la memoria usando las reglas matemáticas de un árbol de búsqueda binaria (menores a la izquierda, mayores a la derecha). 
* **¿Para qué sirve?** Es el "cerebro" lógico de la estructura. Contiene todas las operaciones (generalmente implementadas de manera recursiva) sobre el árbol:
  - **Inserción y Búsqueda:** Mantiene el árbol balanceado lógicamente ordenando por la **Cédula**.
  - **Eliminación:** Cubre los 3 casos (nodo sin hijos, con 1 hijo, o con 2 hijos usando el sucesor inorden).
  - **Recorridos:** Permite viajar por los nodos en distintas formas (Inorden para verlos ordenados alfabéticamente/numéricamente, Preorden, Postorden y BFS / Niveles usando una Cola o `Queue`).
  - **Operaciones Analíticas:** Tiene métodos para calcular la altura, contar la cantidad total de nodos, y aplicar filtros de negocio (buscar el mejor/peor estudiante, o filtrar aprobados/reprobados según su `notaFinal`).

### 4. Clase `Main`
* **¿Por qué existe?** Todo programa escrito en Java requiere un punto de entrada (método `public static void main`).
* **¿Para qué sirve?** Actúa como la **Interfaz de Usuario (Consola)** y como **Controlador**. 
  - Muestra el menú interactivo con las 14 opciones al usuario.
  - Recibe las entradas del teclado mediante `Scanner`.
  - **Valida los datos:** Asegura que la cédula sea de exactamente 10 dígitos numéricos y previene cierres inesperados si el usuario escribe letras donde van números (`try-catch`).
  - Tras validar la entrada, se comunica con la clase `ArbolBST` para ejecutar la acción solicitada.

---

## Características y Operaciones del Menú

1. **Inserción de estudiantes**
2. **Búsqueda por cédula**
3. **Eliminación por cédula**
4. **Recorridos:**
   - Inorden (Muestra los datos ordenados por cédula)
   - Preorden
   - Postorden
   - Por Niveles (BFS - Utilizando `Queue` para procesar nivel a nivel)
5. **Estadísticas del árbol:**
   - Conteo de estudiantes (nodos totales)
   - Cálculo de altura del árbol
6. **Filtros de Negocio:**
   - Estudiante con mayor nota
   - Estudiante con menor nota
   - Mostrar aprobados (Nota >= 7.0)
   - Mostrar reprobados (Nota < 7.0)

---

## Compilación y Ejecución (Java)

1. Abrir una terminal o CMD en la carpeta principal del proyecto (donde se encuentra la carpeta `src`).
2. Compilar todos los archivos Java ejecutando:
   ```bash
   javac src/*.java
   ```
3. Ejecutar la clase principal para levantar el menú:
   ```bash
   java -cp src Main
   ```
## Evidencias de funcionamiento
### Menú
### Opción 1 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion1.png)
### Opción 2
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion2.png)
### Opción 3 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion3.png)
### Opción 4
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion4.png)
### Opción 5
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion5.png)
### Opción 6
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion6.png)
### Opción 7 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion7.png)
### Opción 8 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion8.png)
### Opción 9 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion9.png)
### Opción 10 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion10.png)
### Opción 11 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion11.png)
### Opción 12 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion12.png)
### Opción 13 
![opcion1](https://github.com/michaelrosillo787-alt/Prueba-PracticaArboles-en-C-y-Java/blob/5ac758fc068c75968123e30687d7a1ddcd9f7429/Evidencias/opcion13.png)
