package reto.solucion;

import modelo.Estudiante;
import negocio.NodoEstudiante;

/**
 * Responsable: Monica - Rama: Sara-Tacuri
 * Para que: solucion del reto con traza y casos de prueba [OK] / [FALLA].
 *
 * Solucion del reto: recursividad en un ABB (paralelo ENF-N2-A).
 * Cuenta nodos, cuenta hojas y calcula la altura (en aristas).
 */
public class RetoSolucion {

    private static boolean mostrarTraza = true;
    private static int ok = 0;
    private static int fallas = 0;

    // Inserta una matricula en el ABB (ignora repetidos)
    static NodoEstudiante insertar(NodoEstudiante nodo, int matricula) {
        if (nodo == null) { // caso base: lugar libre
            return new NodoEstudiante(new Estudiante(matricula,
                    String.format("18%08d", matricula),
                    "Estudiante " + matricula, 8));
        }
        int actual = nodo.getDato().getMatricula();
        if (matricula < actual) { // caso recursivo: izquierda
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), matricula));
        } else if (matricula > actual) { // caso recursivo: derecha
            nodo.setDerecho(insertar(nodo.getDerecho(), matricula));
        }
        return nodo;
    }

    // Imprime una linea de la traza (solo si esta activada)
    private static void traza(String sangria, String texto) {
        if (mostrarTraza) {
            System.out.println(sangria + texto);
        }
    }

    // 1 + nodos de la izquierda + nodos de la derecha
    static int contarNodos(NodoEstudiante nodo, String sangria) {
        if (nodo == null) { // caso base
            traza(sangria, "null -> 0");
            return 0;
        }
        int m = nodo.getDato().getMatricula();
        traza(sangria, "entra " + m);
        int izq = contarNodos(nodo.getIzquierdo(), sangria + "  "); // caso recursivo
        int der = contarNodos(nodo.getDerecho(), sangria + "  ");
        int total = 1 + izq + der;
        traza(sangria, "nodo " + m + " -> " + total);
        return total;
    }

    // una hoja vale 1; si no, suma las hojas de sus dos lados
    static int contarHojas(NodoEstudiante nodo, String sangria) {
        if (nodo == null) { // caso base: no hay nodo
            traza(sangria, "null -> 0");
            return 0;
        }
        int m = nodo.getDato().getMatricula();
        traza(sangria, "entra " + m);
        if (nodo.esHoja()) { // caso base: hoja
            traza(sangria, "nodo " + m + " -> 1 (hoja)");
            return 1;
        }
        int izq = contarHojas(nodo.getIzquierdo(), sangria + "  "); // caso recursivo
        int der = contarHojas(nodo.getDerecho(), sangria + "  ");
        traza(sangria, "nodo " + m + " -> " + (izq + der));
        return izq + der;
    }

    // altura en aristas: arbol vacio = -1, hoja = 0
    static int altura(NodoEstudiante nodo, String sangria) {
        if (nodo == null) { // caso base
            traza(sangria, "null -> -1");
            return -1;
        }
        int m = nodo.getDato().getMatricula();
        traza(sangria, "entra " + m);
        int izq = altura(nodo.getIzquierdo(), sangria + "  "); // caso recursivo
        int der = altura(nodo.getDerecho(), sangria + "  ");
        int h = 1 + Math.max(izq, der);
        traza(sangria, "nodo " + m + " -> " + h);
        return h;
    }

    // Construye un ABB a partir de una lista de matriculas
    private static NodoEstudiante construir(int... matriculas) {
        NodoEstudiante raiz = null;
        for (int m : matriculas) {
            raiz = insertar(raiz, m);
        }
        return raiz;
    }

    // Compara y marca [OK] o [FALLA]
    private static void probar(String nombre, int esperado, int obtenido) {
        boolean paso = esperado == obtenido;
        if (paso) {
            ok++;
        } else {
            fallas++;
        }
        System.out.println((paso ? "[OK] " : "[FALLA] ") + nombre
                + " | esperado: " + esperado + " | obtenido: " + obtenido);
    }

    public static void main(String[] args) {
        // Arbol del enunciado (paralelo ENF-N2-A) con traza completa
        NodoEstudiante raiz = construir(40, 20, 60, 10, 30, 50, 70, 25);
        System.out.println("=== CONTAR NODOS ===");
        int nodos = contarNodos(raiz, "");
        System.out.println("Nodos: " + nodos);
        System.out.println("=== CONTAR HOJAS ===");
        int hojas = contarHojas(raiz, "");
        System.out.println("Hojas: " + hojas);
        System.out.println("=== ALTURA ===");
        int alt = altura(raiz, "");
        System.out.println("Altura: " + alt);

        // Casos de prueba (sin traza para no llenar la pantalla)
        System.out.println();
        System.out.println("=== PRUEBAS ===");
        mostrarTraza = false;
        probar("ENF-N2-A nodos", 8, nodos);
        probar("ENF-N2-A hojas", 4, hojas);
        probar("ENF-N2-A altura", 3, alt);

        probar("Arbol vacio nodos", 0, contarNodos(null, ""));
        probar("Arbol vacio hojas", 0, contarHojas(null, ""));
        probar("Arbol vacio altura", -1, altura(null, ""));

        NodoEstudiante uno = construir(50);
        probar("Un solo nodo nodos", 1, contarNodos(uno, ""));
        probar("Un solo nodo hojas", 1, contarHojas(uno, ""));
        probar("Un solo nodo altura", 0, altura(uno, ""));

        NodoEstudiante cadena = construir(10, 20, 30, 40);
        probar("Cadena 10-20-30-40 nodos", 4, contarNodos(cadena, ""));
        probar("Cadena 10-20-30-40 hojas", 1, contarHojas(cadena, ""));
        probar("Cadena 10-20-30-40 altura", 3, altura(cadena, ""));

        NodoEstudiante repetido = construir(30, 30);
        probar("Repetido 30 dos veces nodos", 1, contarNodos(repetido, ""));

        System.out.println();
        System.out.println("Resultado: " + ok + " OK, " + fallas + " fallas");
    }
}