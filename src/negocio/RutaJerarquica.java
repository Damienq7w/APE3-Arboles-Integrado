package negocio;

// Responsable: Damian Cunalata
public final class RutaJerarquica {

    private RutaJerarquica() {
    }

    // Mision 1: ruta desde la raiz hasta la unidad, separada por " -> ".
    // Devuelve "No existe" si el codigo no esta en el arbol.
    public static String obtener(NodoUnidad raiz, String codigo) {

        if (raiz == null || codigo == null || codigo.isBlank()) {
            return "No existe";
        }

        String ruta = buscarRuta(raiz, codigo.trim().toUpperCase());

        return ruta == null ? "No existe" : ruta;
    }

    // Devuelve la ruta desde este nodo hasta el codigo, o null si no esta en el subarbol
    private static String buscarRuta(NodoUnidad nodo, String codigo) {

        String actual = nodo.getDato().getCodigo();

        if (actual.equals(codigo)) {
            return actual; // caso base: se encontro la unidad
        }

        for (NodoUnidad hijo : nodo.getHijos()) {
            String resto = buscarRuta(hijo, codigo); // caso recursivo

            if (resto != null) {
                return actual + " -> " + resto; // se antepone el codigo del padre
            }
        }

        return null; // no esta en este subarbol
    }
}
