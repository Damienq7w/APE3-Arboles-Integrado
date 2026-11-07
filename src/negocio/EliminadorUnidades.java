package negocio;

// Responsable: Monica Tacuri
public final class EliminadorUnidades {

    private EliminadorUnidades() {
    }

    // Mision 2: elimina una unidad solo si es una hoja vacia.
    // Se rechaza: codigo inexistente, la raiz, unidades con subunidades
    // y paralelos que todavia tienen estudiantes.
    public static boolean eliminar(NodoUnidad raiz, String codigo) {

        if (raiz == null || codigo == null || codigo.isBlank()) {
            return false;
        }

        String clave = codigo.trim().toUpperCase();

        if (raiz.getDato().getCodigo().equals(clave)) {
            return false; // la universidad sostiene todo el sistema
        }

        return eliminarDesde(raiz, clave);
    }

    // Busca al padre de la unidad y la quita de su lista de hijos (recursivo)
    private static boolean eliminarDesde(NodoUnidad padre, String codigo) {

        for (NodoUnidad hijo : padre.getHijos()) {

            if (hijo.getDato().getCodigo().equals(codigo)) {
                // los codigos son unicos: se decide aqui y no se sigue buscando
                return puedeEliminar(hijo) && padre.eliminarHijo(hijo);
            }

            if (eliminarDesde(hijo, codigo)) {
                return true;
            }
        }

        return false;
    }

    // Regla de negocio: sin subunidades y sin estudiantes matriculados
    private static boolean puedeEliminar(NodoUnidad nodo) {

        if (!nodo.esHoja()) {
            return false;
        }

        ArbolEstudiantes estudiantes = nodo.getEstudiantes();

        return estudiantes == null || estudiantes.estaVacio();
    }
}
