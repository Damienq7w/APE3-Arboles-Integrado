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

    public String mostrarJerarquia() {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (mostrarJerarquia)");
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
        throw new UnsupportedOperationException("Pendiente: Fase 2 (grado)");
    }

    public int nivel(String codigo) {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (nivel)");
    }

    public int contarHojas() {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (contarHojas)");
    }

    public boolean eliminar(String codigo) {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (eliminar)");
    }

    public String transformarABinario() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (transformarABinario)");
    }
}
