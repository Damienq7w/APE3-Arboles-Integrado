package pruebas;

import app.Contexto;
import enums.TipoUnidad;
import modelo.UnidadAcademica;
import negocio.ArbolOrganizacional;

// Responsable: Damian Cunalata
// Pruebas del arbol general: agregar, buscar, jerarquia, altura, grado, nivel y hojas.
public final class PruebasArbolGeneral {

    private PruebasArbolGeneral() {
    }

    public static void ejecutar(Verificador r) {
        r.seccion("ARBOL GENERAL (A1 a A4) - Damian Cunalata");
        ArbolOrganizacional org = new Contexto().organizacion;

        r.linea("Casos normales:");
        r.verificar("Altura inicial UTA -> FCHE -> EB -> EB-N1 -> paralelo", 4, org.altura());
        r.verificar("Hojas iniciales: EB-N1-A y EB-N1-B", 2, org.contarHojas());
        r.verificar("Grado de EB-N1 (dos paralelos)", 2, org.grado("EB-N1"));
        r.verificar("Nivel de la raiz UTA", 0, org.nivel("UTA"));
        r.verificar("Nivel de EB-N1-A", 4, org.nivel("EB-N1-A"));
        r.verificar("Buscar sin distinguir mayusculas (eb-n1-a)", true, org.buscar("eb-n1-a") != null);
        r.verificar("Buscar con espacios exteriores", true, org.buscar("  EB  ") != null);
        r.verificar("Agregar la carrera SW bajo FCHE", true,
                org.agregar("FCHE", new UnidadAcademica("SW", "Software", TipoUnidad.CARRERA)));
        r.verificar("SW es una hoja nueva: ahora hay 3 hojas", 3, org.contarHojas());
        r.verificar("Grado de FCHE despues de agregar SW", 2, org.grado("FCHE"));
        r.verificar("La jerarquia empieza por la raiz", true, org.mostrarJerarquia().startsWith("UTA"));
        r.verificar("La jerarquia usa 2 espacios por nivel (EB en nivel 2)", true,
                org.mostrarJerarquia().contains(System.lineSeparator() + "    EB - "));
        r.verificar("Nivel de la carrera SW recien agregada", 2, org.nivel("sw"));

        r.linea("Casos limite:");
        r.verificar("Agregar un codigo repetido (SW)", false,
                org.agregar("FCHE", new UnidadAcademica("SW", "Otra", TipoUnidad.CARRERA)));
        r.verificar("Agregar bajo un padre inexistente", false,
                org.agregar("XYZ", new UnidadAcademica("N9", "Nivel 9", TipoUnidad.NIVEL)));
        r.verificar("Agregar saltando la jerarquia (NIVEL bajo FACULTAD)", false,
                org.agregar("FCHE", new UnidadAcademica("N1", "Nivel 1", TipoUnidad.NIVEL)));
        r.verificar("Agregar una unidad nula", false, org.agregar("FCHE", null));
        r.verificar("Buscar un codigo inexistente", null, org.buscar("XYZ"));
        r.verificar("Buscar con codigo nulo", null, org.buscar(null));
        r.verificar("Grado de un codigo inexistente", -1, org.grado("XYZ"));
        r.verificar("Nivel de un codigo inexistente", -1, org.nivel("XYZ"));
        r.verificar("Agregar con codigo de padre nulo", false,
                org.agregar(null, new UnidadAcademica("N8", "Nivel 8", TipoUnidad.NIVEL)));
        r.verificar("Nivel con codigo nulo", -1, org.nivel(null));

        ArbolOrganizacional soloRaiz = new ArbolOrganizacional(
                new UnidadAcademica("UTA", "Universidad Tecnica de Ambato", TipoUnidad.UNIVERSIDAD));
        r.verificar("Arbol con solo la raiz: altura 0", 0, soloRaiz.altura());
        r.verificar("Arbol con solo la raiz: 1 hoja", 1, soloRaiz.contarHojas());
        r.verificar("La raiz debe ser UNIVERSIDAD", true, rechaza(() -> new ArbolOrganizacional(
                new UnidadAcademica("FX", "Facultad", TipoUnidad.FACULTAD))));
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
