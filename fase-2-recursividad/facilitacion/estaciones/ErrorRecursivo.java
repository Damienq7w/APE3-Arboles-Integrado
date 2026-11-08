/**
 * Estación E4 · Caza el error (APE 3 · Fase 2 · Grupo 2).
 *
 * Construye un ABB con la lista de matrículas de las estaciones y muestra
 * el inorden y el posorden. El programa tiene DOS errores a propósito:
 * uno en el método inorden y otro en el método posorden.
 *
 * Compilar:  javac ErrorRecursivo.java
 * Ejecutar:  java ErrorRecursivo
 */
public class ErrorRecursivo {

    static class Nodo {
        int matricula;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(int matricula) {
            this.matricula = matricula;
        }
    }

    // Inserta una matrícula en el ABB (este método está bien).
    static Nodo insertar(Nodo nodo, int matricula) {
        if (nodo == null) {
            return new Nodo(matricula);
        }
        if (matricula < nodo.matricula) {
            nodo.izquierdo = insertar(nodo.izquierdo, matricula);
        } else if (matricula > nodo.matricula) {
            nodo.derecho = insertar(nodo.derecho, matricula);
        }
        return nodo;
    }

    // Recorrido inorden: izquierdo -> nodo -> derecho
    static void inorden(Nodo nodo, StringBuilder salida) {
        inorden(nodo.izquierdo, salida);
        salida.append(nodo.matricula).append(' ');
        inorden(nodo.derecho, salida);
    }

    // Recorrido posorden: izquierdo -> derecho -> nodo
    static void posorden(Nodo nodo, StringBuilder salida) {
        if (nodo == null) {
            return;
        }
        salida.append(nodo.matricula).append(' ');
        posorden(nodo.izquierdo, salida);
        posorden(nodo.derecho, salida);
    }

    public static void main(String[] args) {
        int[] matriculas = {38, 18, 55, 8, 28, 48, 75, 23, 33, 68};
        Nodo raiz = null;
        for (int m : matriculas) {
            raiz = insertar(raiz, m);
        }

        StringBuilder in = new StringBuilder();
        try {
            inorden(raiz, in);
            System.out.println("Inorden:  " + in.toString().trim());
        } catch (RuntimeException e) {
            System.out.println("Inorden:  ERROR -> " + e.getClass().getSimpleName());
        }

        StringBuilder pos = new StringBuilder();
        posorden(raiz, pos);
        System.out.println("Posorden: " + pos.toString().trim());
    }
}
