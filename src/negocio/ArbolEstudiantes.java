package negocio;

import enums.TipoRecorrido;
import java.util.List;
import modelo.Estudiante;
import java.util.ArrayList;

public class ArbolEstudiantes {

    private NodoEstudiante raiz;

    public ArbolEstudiantes() {
        this.raiz = null;
    }

    public NodoEstudiante getRaiz() {
        return raiz;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public boolean insertar(Estudiante estudiante) {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (insertar)");
    }

    public Estudiante buscar(int matricula) {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (buscar)");
    }

        // recorridos recursivos (O(n))
    public List<Estudiante> recorrer(TipoRecorrido tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de recorrido es obligatorio");
        }
        List<Estudiante> lista = new ArrayList<>();
        switch (tipo) {
            case PREORDEN -> preorden(raiz, lista);
            case INORDEN -> inorden(raiz, lista);
            case POSORDEN -> posorden(raiz, lista);
        }
        return lista; // vacia si el arbol esta vacio
    }

    // Preorden: raiz, izquierdo, derecho
    private void preorden(NodoEstudiante nodo, List<Estudiante> lista) {
        if (nodo == null) return; // caso base
        lista.add(nodo.getDato());
        preorden(nodo.getIzquierdo(), lista);
        preorden(nodo.getDerecho(), lista);
    }

    // Inorden: izquierdo, raiz, derecho (queda ordenado por matricula)
    private void inorden(NodoEstudiante nodo, List<Estudiante> lista) {
        if (nodo == null) return;
        inorden(nodo.getIzquierdo(), lista);
        lista.add(nodo.getDato());
        inorden(nodo.getDerecho(), lista);
    }

    // Posorden: izquierdo, derecho, raiz
    private void posorden(NodoEstudiante nodo, List<Estudiante> lista) {
        if (nodo == null) return;
        posorden(nodo.getIzquierdo(), lista);
        posorden(nodo.getDerecho(), lista);
        lista.add(nodo.getDato());
    }

    public boolean modificar(int matricula, String cedula, String nombres, double promedio) {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (modificar)");
    }

    public boolean eliminar(int matricula) {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (eliminar)");
    }

    public int altura() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (altura)");
    }

    public int contar() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (contar)");
    }

    public Estudiante menor() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (menor)");
    }

    public Estudiante mayor() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (mayor)");
    }

    public double promedioGeneral() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (promedioGeneral)");
    }
}
