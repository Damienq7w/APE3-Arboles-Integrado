package negocio;

import java.util.List;

// Responsable: Monica Tacuri
public final class TransformadorBinario {

    private TransformadorBinario() {
    }

    // Mision 2: construye un arbol binario NUEVO (hijo izquierdo / hermano derecho).
    // El arbol general original no se modifica.
    public static NodoBinario construir(NodoUnidad raiz) {

        if (raiz == null) {
            return null;
        }

        return convertir(raiz);
    }

    // El primer hijo pasa a ser el hijo izquierdo
    private static NodoBinario convertir(NodoUnidad nodo) {

        NodoBinario binario = new NodoBinario(nodo.getDato());

        binario.setHijoIzquierdo(convertirHermanos(nodo.getHijos(), 0));

        return binario;
    }

    // Cada hijo apunta al siguiente como hermano derecho
    private static NodoBinario convertirHermanos(List<NodoUnidad> hermanos, int indice) {

        if (indice >= hermanos.size()) {
            return null; // caso base: no quedan hermanos
        }

        NodoBinario actual = convertir(hermanos.get(indice));

        actual.setHermanoDerecho(convertirHermanos(hermanos, indice + 1));

        return actual;
    }

    // Muestra el arbol binario con HI y HD por nodo
    public static String mostrar(NodoBinario raiz) {

        if (raiz == null) {
            return "Arbol vacio.";
        }

        StringBuilder sb = new StringBuilder();

        mostrar(raiz, 0, "Raiz", sb);

        return sb.toString().stripTrailing();
    }

    private static void mostrar(
            NodoBinario nodo,
            int profundidad,
            String relacion,
            StringBuilder sb) {

        if (nodo == null) {
            return;
        }

        String codigo = nodo.getDato().getCodigo();

        sb.append("  ".repeat(profundidad))
          .append(relacion)
          .append(": ")
          .append(codigo)
          .append(System.lineSeparator());

        mostrar(nodo.getHijoIzquierdo(), profundidad + 1, "HI de " + codigo, sb);
        mostrar(nodo.getHermanoDerecho(), profundidad + 1, "HD de " + codigo, sb);
    }

    // Describe los enlaces binarios de una unidad, por ejemplo:
    // "EB: HI = EB-N1 | HD = SW"
    public static String relacion(NodoBinario raiz, String codigo) {

        if (codigo == null || codigo.isBlank()) {
            return "No existe";
        }

        NodoBinario nodo = buscar(raiz, codigo.trim().toUpperCase());

        if (nodo == null) {
            return "No existe";
        }

        return nodo.getDato().getCodigo()
                + ": HI = " + codigoONulo(nodo.getHijoIzquierdo())
                + " | HD = " + codigoONulo(nodo.getHermanoDerecho());
    }

    private static NodoBinario buscar(NodoBinario nodo, String codigo) {

        if (nodo == null) {
            return null;
        }

        if (nodo.getDato().getCodigo().equals(codigo)) {
            return nodo;
        }

        NodoBinario izquierdo = buscar(nodo.getHijoIzquierdo(), codigo);

        return izquierdo != null
                ? izquierdo
                : buscar(nodo.getHermanoDerecho(), codigo);
    }

    private static String codigoONulo(NodoBinario nodo) {
        return nodo == null ? "null" : nodo.getDato().getCodigo();
    }
}
