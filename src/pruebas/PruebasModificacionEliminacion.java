package pruebas;

import app.Contexto;
import enums.TipoRecorrido;
import java.util.StringJoiner;
import modelo.Estudiante;
import negocio.ArbolEstudiantes;

// Responsable: Luis Silva
// Pruebas de modificacion segura y de los casos de eliminacion del ABB.
public final class PruebasModificacionEliminacion {

    private PruebasModificacionEliminacion() {
    }

    public static void ejecutar(Verificador r) {
        r.seccion("MODIFICACION Y ELIMINACION (B4, B5) - Luis Silva");
        // EB-N1-A: raiz 30; 15 (10, 20); 45 (40 con hijo 35, 50 con hijo 55)
        ArbolEstudiantes abb = new Contexto().estudiantes();
        Estudiante e35 = abb.buscar(35);

        r.linea("Modificacion:");
        r.verificar("Modificar el promedio de 35 a 9.80", true,
                abb.modificar(35, e35.getCedula(), e35.getNombres(), 9.80));
        r.verificar("El promedio de 35 quedo en 9.80", 9.80, abb.buscar(35).getPromedio());
        String valido = abb.buscar(35).toString();
        r.verificar("Modificar con cedula invalida lanza excepcion", true,
                rechaza(() -> abb.modificar(35, "123", "Cambio", 9.0)));
        r.verificar("Modificar con promedio 15 lanza excepcion", true,
                rechaza(() -> abb.modificar(35, e35.getCedula(), "Cambio", 15)));
        r.verificar("Los intentos invalidos no alteran el registro", valido, abb.buscar(35).toString());
        r.verificar("Modificar una matricula inexistente", false, abb.modificar(99, "1800000000", "X", 8));

        r.linea("Eliminacion (cada caso sobre el arbol que deja el anterior):");
        r.verificar("Eliminar 10: nodo hoja", true, abb.eliminar(10));
        r.verificar("Inorden despues de eliminar 10", "15 20 30 35 40 45 50 55", inorden(abb));
        r.verificar("Eliminar 40: nodo con un hijo (35)", true, abb.eliminar(40));
        r.verificar("Inorden despues de eliminar 40", "15 20 30 35 45 50 55", inorden(abb));
        r.verificar("Eliminar 45: dos hijos, lo reemplaza el sucesor 50", true, abb.eliminar(45));
        r.verificar("Inorden despues de eliminar 45", "15 20 30 35 50 55", inorden(abb));
        r.verificar("Eliminar 30: la raiz con dos hijos", true, abb.eliminar(30));
        r.verificar("La nueva raiz es el sucesor inorden 35", 35, abb.getRaiz().getDato().getMatricula());
        r.verificar("Inorden despues de eliminar la raiz", "15 20 35 50 55", inorden(abb));
        r.verificar("Cantidad despues de 4 eliminaciones", 5, abb.contar());

        r.linea("Casos limite:");
        r.verificar("Eliminar una matricula inexistente", false, abb.eliminar(99));
        r.verificar("Eliminar en un ABB vacio", false, new ArbolEstudiantes().eliminar(1));
        for (int m : new int[]{15, 20, 35, 50, 55}) {
            abb.eliminar(m);
        }
        r.verificar("Eliminar todos los estudiantes deja el ABB vacio", true, abb.estaVacio());
    }

    private static String inorden(ArbolEstudiantes abb) {
        StringJoiner sj = new StringJoiner(" ");
        for (Estudiante e : abb.recorrer(TipoRecorrido.INORDEN)) {
            sj.add(String.valueOf(e.getMatricula()));
        }
        return sj.toString();
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
