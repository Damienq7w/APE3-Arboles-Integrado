package app;

import negocio.ArbolOrganizacional;

// Mision 2: proteccion de unidades y transformacion binaria
// Responsable: Monica Tacuri
final class RetoMision2 {

    private RetoMision2() {
    }

    static void ejecutar(Contexto c, Reporte r) {
        ArbolOrganizacional org = c.organizacion;

        r.seccion("MISION 2 - Proteccion de unidades y transformacion binaria");

        // Eliminaciones que deben rechazarse
        r.verificar("Eliminar EB-N1-A (paralelo con 9 estudiantes)", false, org.eliminar("EB-N1-A"));
        r.verificar("Eliminar EB-N1 (tiene subunidades)", false, org.eliminar("EB-N1"));
        r.verificar("Eliminar FCHE (tiene subunidades)", false, org.eliminar("FCHE"));
        r.verificar("Eliminar UTA (raiz del sistema)", false, org.eliminar("UTA"));
        r.verificar("Eliminar XYZ (codigo inexistente)", false, org.eliminar("XYZ"));
        r.verificar("EB-N1-A sigue existiendo", true, org.buscar("EB-N1-A") != null);

        // Transformacion: se hace antes de eliminar SW-N3-A para ver la rama SW completa
        String jerarquiaAntes = org.mostrarJerarquia();
        r.linea("");
        r.linea("Arbol binario (HI = hijo izquierdo, HD = hermano derecho):");
        r.linea(org.transformarABinario());
        r.linea("");

        r.verificar("Relacion de FCHE", "FCHE: HI = EB | HD = null", org.relacionBinaria("FCHE"));
        r.verificar("EB tiene a SW como hermano derecho", "EB: HI = EB-N1 | HD = SW", org.relacionBinaria("EB"));
        r.verificar("EB-N1-A tiene a EB-N1-B como hermano derecho",
                "EB-N1-A: HI = null | HD = EB-N1-B", org.relacionBinaria("EB-N1-A"));
        r.verificar("SW es el ultimo hermano", "SW: HI = SW-N3 | HD = null", org.relacionBinaria("SW"));
        r.verificar("La transformacion no altera el arbol general",
                jerarquiaAntes.equals(org.mostrarJerarquia()));

        // Eliminacion permitida: hoja vacia
        r.verificar("Eliminar SW-N3-A (hoja vacia)", true, org.eliminar("SW-N3-A"));
        r.verificar("SW-N3-A ya no existe", null, org.buscar("SW-N3-A"));
        r.verificar("SW-N3 queda como hoja (grado 0)", 0, org.grado("SW-N3"));
        r.verificar("Eliminar SW-N3-A por segunda vez", false, org.eliminar("SW-N3-A"));
    }
}
