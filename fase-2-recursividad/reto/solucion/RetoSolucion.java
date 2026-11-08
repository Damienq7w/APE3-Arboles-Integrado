package reto.solucion;

import modelo.Estudiante;
import negocio.NodoEstudiante;

/**
 * Responsable: Monica - Rama: Sara-Tacuri
 * Para que: solucion del reto de recorridos (SW-N3-A) con pruebas [OK]/[FALLA].
 * Solo se muestra en los minutos 57-60 de la expo.
 */
public class RetoSolucion {

    static NodoEstudiante insertar(NodoEstudiante nodo, int matricula) {
        if (nodo == null) {
            return new NodoEstudiante(new Estudiante(matricula,
                    String.format("18%08d", matricula),
                    "Estudiante " + matricula, 8));
        }
        int actual = nodo.getDato().getMatricula();
        if (matricula < actual) {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), matricula));
        } else if (matricula > actual) {
            nodo.setDerecho(insertar(nodo.getDerecho(), matricula));
        }
        return nodo;
    }

    static boolean conTraza = false;

    static void traza(String linea) {
        if (conTraza) {
            System.out.println(linea);
        }
    }

    // PREORDEN: nodo, izquierda, derecha. O(n)
    static void preorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) { // caso base
            traza(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        traza(sangria + "entra " + m);
        traza(sangria + "VISITA " + m);
        salida.append(m).append(' ');
        preorden(nodo.getIzquierdo(), sangria + "  ", salida);
        preorden(nodo.getDerecho(), sangria + "  ", salida);
    }

    // INORDEN: izquierda, nodo, derecha. O(n)
    static void inorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            traza(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        traza(sangria + "entra " + m);
        inorden(nodo.getIzquierdo(), sangria + "  ", salida);
        traza(sangria + "VISITA " + m);
        salida.append(m).append(' ');
        inorden(nodo.getDerecho(), sangria + "  ", salida);
    }

    // POSORDEN: izquierda, derecha, nodo. O(n)
    static void posorden(NodoEstudiante nodo, String sangria, StringBuilder salida) {
        if (nodo == null) {
            traza(sangria + "null -> regresa");
            return;
        }
        int m = nodo.getDato().getMatricula();
        traza(sangria + "entra " + m);
        posorden(nodo.getIzquierdo(), sangria + "  ", salida);
        posorden(nodo.getDerecho(), sangria + "  ", salida);
        traza(sangria + "VISITA " + m);
        salida.append(m).append(' ');
    }

    // EXTRA: altura en aristas. Hoja 0, vacio -1
    static int altura(NodoEstudiante nodo) {
        if (nodo == null) {
            return -1;
        }
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }

    static NodoEstudiante construir(int[] matriculas) {
        NodoEstudiante raiz = null;
        for (int m : matriculas) {
            raiz = insertar(raiz, m);
        }
        return raiz;
    }

    static int pasadas = 0;
    static int total = 0;

    static void comprobar(String nombre, String obtenido, String esperado) {
        total++;
        if (obtenido.equals(esperado)) {
            pasadas++;
            System.out.println("[OK]    " + nombre + ": " + obtenido);
        } else {
            System.out.println("[FALLA] " + nombre + ": obtuvo '" + obtenido
                    + "' y esperaba '" + esperado + "'");
        }
    }

    static void probar(String caso, int[] matriculas, String pre, String in, String pos, int alt) {
        NodoEstudiante raiz = construir(matriculas);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        StringBuilder c = new StringBuilder();
        preorden(raiz, "", a);
        inorden(raiz, "", b);
        posorden(raiz, "", c);
        comprobar(caso + " preorden", a.toString().trim(), pre);
        comprobar(caso + " inorden", b.toString().trim(), in);
        comprobar(caso + " posorden", c.toString().trim(), pos);
        comprobar(caso + " altura", String.valueOf(altura(raiz)), String.valueOf(alt));
    }

    public static void main(String[] args) {
        System.out.println("=== Traza INORDEN del reto SW-N3-A ===");
        conTraza = true;
        StringBuilder demo = new StringBuilder();
        inorden(construir(new int[] { 45, 25, 70, 10, 30, 60, 90, 27, 65 }), "", demo);
        conTraza = false;
        System.out.println();

        probar("Reto SW-N3-A", new int[] { 45, 25, 70, 10, 30, 60, 90, 27, 65 },
                "45 25 10 30 27 70 60 65 90",
                "10 25 27 30 45 60 65 70 90",
                "10 27 30 25 65 60 90 70 45", 3);
        probar("Vacio", new int[] {}, "", "", "", -1);
        probar("Un nodo", new int[] { 50 }, "50", "50", "50", 0);
        probar("Cadena", new int[] { 10, 20, 30, 40 },
                "10 20 30 40", "10 20 30 40", "40 30 20 10", 3);
        probar("Repetido", new int[] { 20, 30, 30, 10 },
                "20 10 30", "10 20 30", "10 30 20", 1);

        System.out.println();
        System.out.println("Resultado: " + pasadas + "/" + total + " pruebas OK");
    }
}