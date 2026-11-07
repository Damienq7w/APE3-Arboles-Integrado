package app;

import enums.TipoUnidad;
import modelo.UnidadAcademica;
import negocio.ArbolOrganizacional;

// Mision 1: jerarquia y ruta institucional
// Responsable: Damian Cunalata
final class RetoMision1 {

    private RetoMision1() {
    }

    static void ejecutar(Contexto c, Reporte r) {
        ArbolOrganizacional org = c.organizacion;

        r.seccion("MISION 1 - Jerarquia y ruta institucional");
        r.linea("Antes: altura " + org.altura() + " | hojas " + org.contarHojas());

        r.verificar("Agregar carrera SW bajo FCHE", true,
                org.agregar("FCHE", new UnidadAcademica("SW", "Software", TipoUnidad.CARRERA)));
        r.verificar("Agregar nivel SW-N3 bajo SW", true,
                org.agregar("SW", new UnidadAcademica("SW-N3", "Nivel 3", TipoUnidad.NIVEL)));
        r.verificar("Agregar paralelo SW-N3-A bajo SW-N3", true,
                org.agregar("SW-N3", new UnidadAcademica("SW-N3-A", "Paralelo A", TipoUnidad.PARALELO)));

        // Reglas que impiden duplicados o saltos de jerarquia
        r.verificar("Agregar SW otra vez (codigo repetido)", false,
                org.agregar("FCHE", new UnidadAcademica("SW", "Software", TipoUnidad.CARRERA)));
        r.verificar("Agregar un PARALELO directo bajo FCHE (salta niveles)", false,
                org.agregar("FCHE", new UnidadAcademica("SW-X", "Invalido", TipoUnidad.PARALELO)));
        r.verificar("Agregar bajo un padre inexistente", false,
                org.agregar("XYZ", new UnidadAcademica("SW-N9", "Nivel 9", TipoUnidad.NIVEL)));

        r.linea("");
        r.linea(org.mostrarJerarquia());
        r.linea("");

        r.verificar("Nivel de SW", 2, org.nivel("SW"));
        r.verificar("Nivel de SW-N3", 3, org.nivel("SW-N3"));
        r.verificar("Nivel de SW-N3-A", 4, org.nivel("SW-N3-A"));
        r.verificar("Altura del arbol (aristas)", 4, org.altura());
        r.verificar("Hojas: EB-N1-A, EB-N1-B y SW-N3-A", 3, org.contarHojas());

        r.verificar("Ruta de EB-N1-A",
                "UTA -> FCHE -> EB -> EB-N1 -> EB-N1-A", org.obtenerRutaJerarquica("EB-N1-A"));
        r.verificar("Ruta de SW-N3-A (en minusculas)",
                "UTA -> FCHE -> SW -> SW-N3 -> SW-N3-A", org.obtenerRutaJerarquica("sw-n3-a"));
        r.verificar("Ruta de la raiz", "UTA", org.obtenerRutaJerarquica("UTA"));
        r.verificar("Ruta de un codigo inexistente", "No existe", org.obtenerRutaJerarquica("XYZ"));
    }
}
