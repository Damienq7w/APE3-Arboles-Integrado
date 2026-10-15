package reto;

import modelo.Estudiante;
import negocio.NodoEstudiante;

/**
 * Responsable: Monica - Rama: Sara-Tacuri
 * Para que: plantilla del reto que el curso completa en parejas (se sube a
 * Moodle).
 *
 * RETO: Recursividad en un ABB (paralelo ENF-N2-A, Enfermeria, FCS)
 *
 * Enunciado:
 * El paralelo ENF-N2-A esta vacio. Se matriculan, en este orden, los
 * estudiantes con matricula 40, 20, 60, 10, 30, 50, 70, 25.
 *
 * 1. Dibuja el arbol binario de busqueda que resulta.
 * 2. Predice en papel: cuantos nodos tiene, cuantas hojas y su altura.
 * 3. Completa los tres metodos de abajo (// TODO) de forma recursiva.
 * Cada uno imprime una traza: "entra <matricula>" al llegar a un nodo,
 * "null -> <valor>" en el caso base y "nodo <matricula> -> <resultado>"
 * cuando el nodo ya tiene su respuesta.
 * 4. Prueba tu codigo con: arbol vacio, un solo nodo y la cadena
 * 10, 20, 30, 40.
 *
 * Pista: la altura se mide en aristas (como en el Grupo 1): una hoja
 * tiene altura 0 y un arbol vacio, -1.
 */
public class RetoRecorridos {

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

    // TODO: cuenta todos los nodos (1 + nodos de la izquierda + nodos de la
    // derecha)
    static int contarNodos(NodoEstudiante nodo, String sangria) {
        return 0;
    }

    // TODO: cuenta las hojas (nodos sin hijos)
    static int contarHojas(NodoEstudiante nodo, String sangria) {
        return 0;
    }

    // TODO: altura en aristas (1 + la mayor altura de sus dos lados)
    static int altura(NodoEstudiante nodo, String sangria) {
        return 0;
    }

    public static void main(String[] args) {
        int[] matriculas = { 40, 20, 60, 10, 30, 50, 70, 25 };
        NodoEstudiante raiz = null;
        for (int m : matriculas) {
            raiz = insertar(raiz, m);
        }
        System.out.println("Nodos: " + contarNodos(raiz, ""));
        System.out.println("Hojas: " + contarHojas(raiz, ""));
        System.out.println("Altura: " + altura(raiz, ""));
    }
}