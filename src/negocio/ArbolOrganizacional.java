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

    public boolean agregar(String codigoPadre, UnidadAcademica unidad) {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (agregar)");
    }

    public NodoUnidad buscar(String codigo) {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (buscar)");
    }

    public String mostrarJerarquia() {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (mostrarJerarquia)");
    }

    public int altura() {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (altura)");
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
