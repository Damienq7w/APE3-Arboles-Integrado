package negocio;

import enums.TipoUnidad;
import modelo.UnidadAcademica;

public class ArbolOrganizacional {

    private NodoUnidad raiz;

    public ArbolOrganizacional(UnidadAcademica universidad) {
        if (universidad == null || universidad.getTipo() != TipoUnidad.UNIVERSIDAD) {
            throw new IllegalArgumentException("La raíz debe ser una UNIVERSIDAD");
        }
        this.raiz = new NodoUnidad(universidad);
    }

    public NodoUnidad getRaiz() {
        return raiz;
    }

    // A1: agrega una unidad bajo su padre (codigo unico y regla jerarquica)
    public boolean agregar(String codigoPadre, UnidadAcademica unidad) {
        if (codigoPadre == null || unidad == null) {
            return false;
        }
        if (buscar(unidad.getCodigo()) != null) {
            return false; // el codigo ya existe en el arbol
        }
        NodoUnidad padre = buscar(codigoPadre);
        if (padre == null) {
            return false; // el padre no existe
        }
        return padre.agregarHijo(new NodoUnidad(unidad)); // valida la jerarquia
    }

    // A2: busca una unidad por codigo (recursivo, O(n))
    public NodoUnidad buscar(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return null;
        }
        return buscar(raiz, codigo.trim().toUpperCase());
    }

    private NodoUnidad buscar(NodoUnidad nodo, String codigo) {
        if (nodo.getDato().getCodigo().equals(codigo)) {
            return nodo; // caso base: lo encontro
        }
        for (NodoUnidad hijo : nodo.getHijos()) {
            NodoUnidad encontrado = buscar(hijo, codigo); // caso recursivo
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null; // no esta en este subarbol
    }

    //muestra la jerarquia en preorden, 2 espacios por nivel. O(n)
    public String mostrarJerarquia() {
        StringBuilder sb = new StringBuilder();
        mostrarJerarquia(raiz, 0, sb);
        return System.lineSeparator() + sb.toString().stripTrailing();
    }

    // Escribe el nodo con su sangria y llama a cada hijo con un nivel mas
    private void mostrarJerarquia(NodoUnidad nodo, int nivel, StringBuilder sb) {
        if (nodo == null) {
            return;
        }

        sb.append("  ".repeat(nivel))
          .append(nodo.getDato())
          .append(System.lineSeparator());

        for (NodoUnidad hijo : nodo.getHijos()) {
            mostrarJerarquia(hijo, nivel + 1, sb);
        }
    }

    // A4: calcula la altura del arbol general de forma recursiva
    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoUnidad nodo) {
        if (nodo == null) {
            return -1;
        }

        int mayorAltura = -1;

        for (NodoUnidad hijo : nodo.getHijos()) {
            int alturaHijo = altura(hijo);

            if (alturaHijo > mayorAltura) {
                mayorAltura = alturaHijo;
            }
        }

        return 1 + mayorAltura;
    }

    public int grado(String codigo) {
        NodoUnidad nodo = buscar(codigo);
        if (nodo == null) {
            return -1; // el codigo no existe
        }
        return nodo.getHijos().size();
    }

    // A4: nivel = distancia desde la raiz, UTA = 0 (-1 si el codigo no existe)
    public int nivel(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return -1;
        }
        return nivel(raiz, codigo.trim().toUpperCase(), 0);
    }

    private int nivel(NodoUnidad nodo, String codigo, int profundidad) {
        if (nodo.getDato().getCodigo().equals(codigo)) {
            return profundidad; // caso base: lo encontro
        }
        for (NodoUnidad hijo : nodo.getHijos()) {
            int n = nivel(hijo, codigo, profundidad + 1); // caso recursivo
            if (n != -1) {
                return n;
            }
        }
        return -1; // no esta en este subarbol
    }

        // A4: cuenta las hojas del arbol (recursivo, O(n))
    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(NodoUnidad nodo) {
        if (nodo.esHoja()) {
            return 1; // caso base: no tiene hijos
        }
        int total = 0;
        for (NodoUnidad hijo : nodo.getHijos()) {
            total += contarHojas(hijo); // caso recursivo
        }
        return total;
    }

    public boolean eliminar(String codigo) {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (eliminar)");
    }

    public String transformarABinario() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (transformarABinario)");
    }
}