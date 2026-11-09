package pruebas;

import modelo.Estudiante;
import negocio.ArbolEstudiantes;

// Pruebas de insercion y busqueda en el ABB y validaciones de Estudiante.
public final class PruebasInsercionBusqueda {

    private PruebasInsercionBusqueda() {
    }

    public static void ejecutar(Verificador r) {
        r.seccion("INSERCION, BUSQUEDA Y VALIDACIONES (B1, B2) - Kenneth Chalco");
        ArbolEstudiantes abb = new ArbolEstudiantes();

        r.linea("Casos normales:");
        r.verificar("Un ABB nuevo esta vacio", true, abb.estaVacio());
        r.verificar("Insertar 50", true, abb.insertar(est(50)));
        r.verificar("Insertar 30", true, abb.insertar(est(30)));
        r.verificar("Insertar 70", true, abb.insertar(est(70)));
        r.verificar("La primera matricula queda como raiz", 50, abb.getRaiz().getDato().getMatricula());
        r.verificar("30 queda a la izquierda de la raiz", 30, abb.getRaiz().getIzquierdo().getDato().getMatricula());
        r.verificar("70 queda a la derecha de la raiz", 70, abb.getRaiz().getDerecho().getDato().getMatricula());
        r.verificar("Buscar 70 encuentra al estudiante", 70, abb.buscar(70).getMatricula());
        r.verificar("Cantidad despues de 3 inserciones", 3, abb.contar());

        r.linea("Casos limite:");
        r.verificar("Buscar en un ABB vacio devuelve null", null, new ArbolEstudiantes().buscar(10));
        r.verificar("Buscar una matricula inexistente devuelve null", null, abb.buscar(99));
        r.verificar("Insertar una matricula repetida (30) se rechaza", false, abb.insertar(est(30)));
        r.verificar("La repetida no cambia la cantidad", 3, abb.contar());
        r.verificar("Insertar null lanza excepcion", true, rechaza(() -> abb.insertar(null)));
        r.verificar("Matricula 0 rechazada", true, rechaza(() -> new Estudiante(0, "1800000000", "Ana", 8)));
        r.verificar("Matricula negativa rechazada", true, rechaza(() -> new Estudiante(-5, "1800000000", "Ana", 8)));
        r.verificar("Cedula de 3 digitos rechazada", true, rechaza(() -> new Estudiante(1, "123", "Ana", 8)));
        r.verificar("Nombres en blanco rechazados", true, rechaza(() -> new Estudiante(1, "1800000000", "  ", 8)));
        r.verificar("Promedio 10.5 rechazado", true, rechaza(() -> new Estudiante(1, "1800000000", "Ana", 10.5)));
        r.verificar("Promedio NaN rechazado", true, rechaza(() -> new Estudiante(1, "1800000000", "Ana", Double.NaN)));
        r.verificar("Promedio Infinity rechazado", true,
                rechaza(() -> new Estudiante(1, "1800000000", "Ana", Double.POSITIVE_INFINITY)));
        r.verificar("Promedios limite 0 y 10 aceptados", true,
                !rechaza(() -> { new Estudiante(1, "1800000000", "Ana", 0); new Estudiante(2, "1800000000", "Ana", 10); }));

        r.verificar("Buscar despues de insertar varias claves", true,
                abb.buscar(50) != null && abb.buscar(30) != null && abb.buscar(70) != null);
    }

    private static Estudiante est(int matricula) {
        return new Estudiante(matricula, "1800000000", "Estudiante " + matricula, 8.0);
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
