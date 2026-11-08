package negocio;

import modelo.UnidadAcademica;

// Nodo de la representacion binaria del arbol general:
// hijoIzquierdo = primer hijo, hermanoDerecho = siguiente hermano.
// Responsable: Monica Tacuri
public class NodoBinario {

    private final UnidadAcademica dato;
    private NodoBinario hijoIzquierdo;
    private NodoBinario hermanoDerecho;

    public NodoBinario(UnidadAcademica dato) {
        if (dato == null) {
            throw new IllegalArgumentException("El nodo binario necesita una unidad academica");
        }
        this.dato = dato;
    }

    public UnidadAcademica getDato() {
        return dato;
    }

    public NodoBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoBinario getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setHermanoDerecho(NodoBinario hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }
}
