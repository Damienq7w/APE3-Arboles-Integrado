package pruebas;

import app.Contexto;
import enums.TipoRecorrido;
import java.util.StringJoiner;
import modelo.Estudiante;
import negocio.ArbolEstudiantes;


// Pruebas de los recorridos recursivos, la traza y las estadisticas del ABB.
public final class PruebasRecorridosEstadisticas {

    private PruebasRecorridosEstadisticas() {
    }

    public static void ejecutar(Verificador r) {
        r.seccion("RECORRIDOS Y ESTADISTICAS (B3, B6) - Darwin Tisalema");
        // EB-N1-A: insercion 30, 15, 45, 10, 20, 40, 50, 35, 55 con promedio 8.00
        ArbolEstudiantes abb = new Contexto().estudiantes();

        r.linea("Casos normales:");
        r.verificar("Preorden (raiz, izquierdo, derecho)", "30 15 10 20 45 40 35 50 55",
                matriculas(abb, TipoRecorrido.PREORDEN));
        r.verificar("Inorden (sale ordenado)", "10 15 20 30 35 40 45 50 55",
                matriculas(abb, TipoRecorrido.INORDEN));
        r.verificar("Posorden (izquierdo, derecho, raiz)", "10 20 15 35 40 55 50 45 30",
                matriculas(abb, TipoRecorrido.POSORDEN));
        String traza = abb.trazaRecorrido(TipoRecorrido.PREORDEN);
        r.verificar("La traza termina con la secuencia del preorden", true,
                traza.trim().endsWith("Secuencia PREORDEN: 30 15 10 20 45 40 35 50 55"));
        r.verificar("La traza visita los 9 nodos", 9, contar(traza, "VISITA "));
        r.verificar("La traza regresa en 10 hijos null (n + 1)", 10, contar(traza, "null -> regresa"));
        r.verificar("Cantidad de estudiantes", 9, abb.contar());
        r.verificar("Altura en aristas", 3, abb.altura());
        r.verificar("Menor matricula", 10, abb.menor().getMatricula());
        r.verificar("Mayor matricula", 55, abb.mayor().getMatricula());
        r.verificar("Promedio general", 8.0, abb.promedioGeneral());
        r.verificar("Traza en inorden: secuencia ordenada", true,
                abb.trazaRecorrido(TipoRecorrido.INORDEN).trim().endsWith("Secuencia INORDEN: 10 15 20 30 35 40 45 50 55"));

        r.linea("Casos limite:");
        ArbolEstudiantes vacio = new ArbolEstudiantes();
        r.verificar("Recorrido de un ABB vacio", "", matriculas(vacio, TipoRecorrido.INORDEN));
        r.verificar("Altura de un ABB vacio", -1, vacio.altura());
        r.verificar("Cantidad de un ABB vacio", 0, vacio.contar());
        r.verificar("Menor de un ABB vacio", null, vacio.menor());
        r.verificar("Promedio de un ABB vacio", 0.0, vacio.promedioGeneral());
        r.verificar("Mayor de un ABB vacio", null, vacio.mayor());
        ArbolEstudiantes uno = new ArbolEstudiantes();
        uno.insertar(est(7, 9.5));
        r.verificar("Altura de un ABB con un solo nodo", 0, uno.altura());
        ArbolEstudiantes cadena = new ArbolEstudiantes();
        for (int m : new int[]{10, 20, 30, 40, 50}) {
            cadena.insertar(est(m, 7.0));
        }
        r.verificar("Insercion ordenada: el ABB degenera en cadena (altura n - 1)", 4, cadena.altura());
        r.verificar("En la cadena el preorden coincide con el inorden", matriculas(cadena, TipoRecorrido.INORDEN),
                matriculas(cadena, TipoRecorrido.PREORDEN));
        r.verificar("Recorrido con tipo null lanza excepcion", true, rechaza(() -> abb.recorrer(null)));
        r.verificar("Traza con tipo null lanza excepcion", true, rechaza(() -> abb.trazaRecorrido(null)));
        r.verificar("Promedio con un solo estudiante", 9.5, uno.promedioGeneral());
    }

    private static Estudiante est(int matricula, double promedio) {
        return new Estudiante(matricula, "1800000000", "Estudiante " + matricula, promedio);
    }

    private static String matriculas(ArbolEstudiantes abb, TipoRecorrido tipo) {
        StringJoiner sj = new StringJoiner(" ");
        for (Estudiante e : abb.recorrer(tipo)) {
            sj.add(String.valueOf(e.getMatricula()));
        }
        return sj.toString();
    }

    private static int contar(String texto, String patron) {
        int n = 0;
        for (int i = texto.indexOf(patron); i >= 0; i = texto.indexOf(patron, i + 1)) {
            n++;
        }
        return n;
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
