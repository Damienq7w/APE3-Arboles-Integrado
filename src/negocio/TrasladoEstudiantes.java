package negocio;

import enums.TipoUnidad;
import modelo.Estudiante;

public final class TrasladoEstudiantes {

    private TrasladoEstudiantes() {
    }

    // Mision 3: traslada un estudiante entre dos paralelos sin perder datos.
    // Orden seguro: 1) validar, 2) insertar en destino, 3) eliminar del origen,
    // 4) si el paso 3 falla, deshacer el paso 2.
    public static boolean trasladar(NodoUnidad origen, NodoUnidad destino, int matricula) {

        if (origen == null || destino == null || origen == destino) {
            return false;
        }

        if (origen.getDato().getTipo() != TipoUnidad.PARALELO
                || destino.getDato().getTipo() != TipoUnidad.PARALELO) {
            return false;
        }

        ArbolEstudiantes abbOrigen = origen.getEstudiantes();
        ArbolEstudiantes abbDestino = destino.getEstudiantes();

        Estudiante estudiante = abbOrigen.buscar(matricula);

        if (estudiante == null || abbDestino.buscar(matricula) != null) {
            return false; // no existe en origen o ya esta en destino
        }

        // Copia independiente: el destino no comparte el objeto con el origen
        Estudiante copia = new Estudiante(
            estudiante.getMatricula(),
            estudiante.getCedula(),
            estudiante.getNombres(),
            estudiante.getPromedio()
        );

        if (!abbDestino.insertar(copia)) {
            return false; // nada cambio todavia
        }

        boolean eliminado;

        try {
            eliminado = abbOrigen.eliminar(matricula);
        } catch (RuntimeException e) {
            eliminado = false;
        }

        if (!eliminado) {
            // Recuperacion: se quita la copia del destino y el origen queda intacto
            abbDestino.eliminar(matricula);
            return false;
        }

        return true;
    }
}
