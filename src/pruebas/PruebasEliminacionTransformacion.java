package pruebas;

import app.Contexto;
import enums.TipoUnidad;
import modelo.UnidadAcademica;
import negocio.ArbolOrganizacional;

// Responsable: Monica Tacuri
// Pruebas de la eliminacion de unidades y de la transformacion a binario.
public final class PruebasEliminacionTransformacion {

    private PruebasEliminacionTransformacion() {
    }

    public static void ejecutar(Verificador r) {
        r.seccion("ELIMINACION DE UNIDADES Y TRANSFORMACION (A5, A6) - Monica Tacuri");
        ArbolOrganizacional org = new Contexto().organizacion;

        r.linea("Transformacion a binario (hijo izquierdo / hermano derecho):");
        String antes = org.mostrarJerarquia();
        String binario = org.transformarABinario();
        r.verificar("La transformacion empieza por la raiz", true, binario.startsWith("Raiz: UTA"));
        r.verificar("FCHE es el hijo izquierdo de UTA", true, binario.contains("Hijo Izq de UTA: FCHE"));
        r.verificar("EB-N1-A es el hijo izquierdo de EB-N1", true, binario.contains("Hijo Izq de EB-N1: EB-N1-A"));
        r.verificar("EB-N1-B es el hermano derecho de EB-N1-A", true, binario.contains("Hermano Der de EB-N1-A: EB-N1-B"));
        r.verificar("Una linea por cada una de las 6 unidades", 6, binario.split("\\R").length);
        r.verificar("La transformacion no altera el arbol general", antes.equals(org.mostrarJerarquia()));
        ArbolOrganizacional soloRaiz = new ArbolOrganizacional(
                new UnidadAcademica("UTA", "Universidad Tecnica de Ambato", TipoUnidad.UNIVERSIDAD));
        r.verificar("Transformar un arbol con solo la raiz", "Raiz: UTA", soloRaiz.transformarABinario());

        r.linea("Eliminacion de unidades (casos limite):");
        r.verificar("Eliminar EB-N1-A: paralelo con 9 estudiantes", false, org.eliminar("EB-N1-A"));
        r.verificar("Eliminar EB-N1: tiene subunidades", false, org.eliminar("EB-N1"));
        r.verificar("Eliminar UTA: la raiz tiene subunidades", false, org.eliminar("UTA"));
        r.verificar("Eliminar un codigo inexistente", false, org.eliminar("XYZ"));
        r.verificar("Eliminar con codigo nulo", false, org.eliminar(null));
        r.verificar("Las unidades protegidas siguen existiendo", true,
                org.buscar("EB-N1-A") != null && org.buscar("EB-N1") != null);

        r.linea("Eliminacion de unidades (casos normales):");
        r.verificar("Eliminar EB-N1-B: paralelo vacio y sin hijos", true, org.eliminar("eb-n1-b"));
        r.verificar("EB-N1-B ya no existe", null, org.buscar("EB-N1-B"));
        r.verificar("EB-N1 queda con un solo hijo", 1, org.grado("EB-N1"));
        r.verificar("Ahora queda una sola hoja", 1, org.contarHojas());
        r.verificar("Eliminar EB-N1-B por segunda vez", false, org.eliminar("EB-N1-B"));
        r.verificar("EB-N1-A ya no tiene hermano derecho", false,
                org.transformarABinario().contains("Hermano Der de EB-N1-A"));
        r.verificar("Eliminar la raiz cuando es la unica unidad", true, soloRaiz.eliminar("UTA"));
        r.verificar("El arbol queda vacio", "Arbol organizacional vacio.", soloRaiz.mostrarJerarquia());
    }
}
