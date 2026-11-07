package app;

import modelo.Estudiante;
import negocio.ArbolEstudiantes;
import negocio.NodoEstudiante;

// Mision 4: modificacion segura y casos de eliminacion del ABB
// Responsable: Luis Silva
final class RetoMision4 {

    private RetoMision4() {
    }

    static void ejecutar(Contexto c, Reporte r) {
        r.seccion("MISION 4 - Modificacion segura y casos de eliminacion del ABB");

        modificar(c.estudiantes(c.paralelo), r);
        trasladar(c, r);
    }

    private static void modificar(ArbolEstudiantes abb, Reporte r) {
        Estudiante e = abb.buscar(35);
        String cedula = e.getCedula();
        String nombres = e.getNombres();

        r.verificar("Modificar promedio de 35 a 9.80", true, abb.modificar(35, cedula, nombres, 9.80));
        r.verificar("Promedio de 35 actualizado", 9.80, abb.buscar(35).getPromedio());

        String valido = abb.buscar(35).toString();

        r.verificar("Actualizar 35 con cedula invalida '123' es rechazado",
                rechaza(() -> abb.modificar(35, "123", "Cambio rechazado", 9.80)));
        r.verificar("Actualizar 35 con promedio 15 es rechazado",
                rechaza(() -> abb.modificar(35, cedula, "Cambio rechazado", 15)));
        r.verificar("El registro valido de 35 no cambio", valido, abb.buscar(35).toString());
        r.verificar("Modificar una matricula inexistente (99)", false, abb.modificar(99, cedula, nombres, 9));
    }

    private static void trasladar(Contexto c, Reporte r) {
        ArbolEstudiantes origen = c.estudiantes(c.paralelo);
        ArbolEstudiantes destino = c.estudiantes(c.paraleloDestino);

        int[] matriculas = {10, 40, 45, 30};
        String[] casosEsperados = {"nodo hoja", "nodo con un hijo", "nodo con dos hijos", "raiz"};

        for (int i = 0; i < matriculas.length; i++) {
            int m = matriculas[i];
            String caso = clasificar(origen, m);
            String antes = RetoIntegrador.inorden(origen);

            r.linea("");
            r.linea("Traslado de " + m + " (" + caso + " en el origen)");
            r.linea("  Inorden origen antes:   " + antes);

            boolean ok = c.organizacion.trasladarEstudiante(c.paralelo, c.paraleloDestino, m);

            r.linea("  Inorden origen despues: " + RetoIntegrador.inorden(origen));
            r.linea("  Inorden destino:        " + RetoIntegrador.inorden(destino));
            r.verificar("Traslado de " + m, true, ok);
            r.verificar("Caso de eliminacion de " + m, casosEsperados[i], caso);
            r.verificar("El origen conserva el orden", true, estaOrdenado(origen));
        }

        r.linea("");
        r.verificar("EB-N1-A final", "15 20 35 50 55", RetoIntegrador.inorden(origen));
        r.verificar("EB-N1-B final", "10 30 40 45", RetoIntegrador.inorden(destino));
        r.verificar("Repetir el traslado de 10 (ya esta en destino)", false,
                c.organizacion.trasladarEstudiante(c.paralelo, c.paraleloDestino, 10));
    }

    // Clasifica el nodo antes de eliminarlo del ABB de origen
    private static String clasificar(ArbolEstudiantes abb, int matricula) {
        NodoEstudiante nodo = buscarNodo(abb.getRaiz(), matricula);
        if (nodo == null) {
            return "no existe";
        }
        if (nodo == abb.getRaiz()) {
            return "raiz";
        }
        if (nodo.esHoja()) {
            return "nodo hoja";
        }
        if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {
            return "nodo con un hijo";
        }
        return "nodo con dos hijos";
    }

    private static NodoEstudiante buscarNodo(NodoEstudiante nodo, int matricula) {
        if (nodo == null || nodo.getDato().getMatricula() == matricula) {
            return nodo;
        }
        return matricula < nodo.getDato().getMatricula()
                ? buscarNodo(nodo.getIzquierdo(), matricula)
                : buscarNodo(nodo.getDerecho(), matricula);
    }

    // El inorden de un ABB valido es estrictamente creciente
    private static boolean estaOrdenado(ArbolEstudiantes abb) {
        String[] partes = RetoIntegrador.inorden(abb).split(" ");
        for (int i = 1; i < partes.length; i++) {
            if (Integer.parseInt(partes[i - 1]) >= Integer.parseInt(partes[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean rechaza(Runnable accion) {
        try {
            accion.run();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
