package app;

import enums.TipoRecorrido;
import negocio.ArbolEstudiantes;

// Mision 5: recorridos y estadisticas comparadas de EB-N1-A y EB-N1-B

final class RetoMision5 {

    private static final double NOTA_MINIMA = 8.00;

    private RetoMision5() {
    }

    static void ejecutar(Contexto c, Reporte r) {
        r.seccion("MISION 5 - Recorridos y estadisticas comparadas");

        ArbolEstudiantes a = c.estudiantes(c.paralelo);
        ArbolEstudiantes b = c.estudiantes(c.paraleloDestino);

        r.linea(String.format("%-22s | %-16s | %-16s", "Dato", c.paralelo, c.paraleloDestino));
        r.linea("-".repeat(60));
        fila(r, "Preorden", RetoIntegrador.matriculas(a, TipoRecorrido.PREORDEN),
                RetoIntegrador.matriculas(b, TipoRecorrido.PREORDEN));
        fila(r, "Inorden", RetoIntegrador.inorden(a), RetoIntegrador.inorden(b));
        fila(r, "Posorden", RetoIntegrador.matriculas(a, TipoRecorrido.POSORDEN),
                RetoIntegrador.matriculas(b, TipoRecorrido.POSORDEN));
        fila(r, "Cantidad", a.contar(), b.contar());
        fila(r, "Altura (aristas)", a.altura(), b.altura());
        fila(r, "Matricula menor", a.menor().getMatricula(), b.menor().getMatricula());
        fila(r, "Matricula mayor", a.mayor().getMatricula(), b.mayor().getMatricula());
        fila(r, "Promedio general", dosDecimales(a.promedioGeneral()), dosDecimales(b.promedioGeneral()));
        fila(r, "Aprobados (>= 8.00)", a.contarAprobados(NOTA_MINIMA), b.contarAprobados(NOTA_MINIMA));
        fila(r, "Aprobados (>= 9.00)", a.contarAprobados(9.0), b.contarAprobados(9.0));
        r.linea("");

        r.verificar("Inorden EB-N1-A", "15 20 35 50 55", RetoIntegrador.inorden(a));
        r.verificar("Inorden EB-N1-B", "10 30 40 45", RetoIntegrador.inorden(b));
        r.verificar("Cantidad EB-N1-A", 5, a.contar());
        r.verificar("Cantidad EB-N1-B", 4, b.contar());
        r.verificar("Altura EB-N1-A", 2, a.altura());
        r.verificar("Altura EB-N1-B", 2, b.altura());
        r.verificar("Menor y mayor EB-N1-A", "15-55", a.menor().getMatricula() + "-" + a.mayor().getMatricula());
        r.verificar("Menor y mayor EB-N1-B", "10-45", b.menor().getMatricula() + "-" + b.mayor().getMatricula());
        r.verificar("Promedio EB-N1-A", "8.36", dosDecimales(a.promedioGeneral()));
        r.verificar("Promedio EB-N1-B", "8.00", dosDecimales(b.promedioGeneral()));
        r.verificar("Aprobados EB-N1-A con 8.00", 5, a.contarAprobados(NOTA_MINIMA));
        r.verificar("Aprobados EB-N1-B con 8.00", 4, b.contarAprobados(NOTA_MINIMA));
        r.verificar("Aprobados EB-N1-A con 9.00 (solo el 35)", 1, a.contarAprobados(9.0));
        r.verificar("Aprobados en un ABB vacio", 0, new ArbolEstudiantes().contarAprobados(NOTA_MINIMA));
        r.verificar("Nota minima 11 rechazada", rechaza(() -> a.contarAprobados(11)));
        r.verificar("Nota minima NaN rechazada", rechaza(() -> a.contarAprobados(Double.NaN)));

        r.linea("");
        r.linea("Comparacion: EB-N1-A queda con 5 estudiantes y promedio 8.36 porque conserva");
        r.linea("al 35 (9.80); EB-N1-B recibe 4 estudiantes con 8.00. Ambos tienen altura 2.");
        r.linea("Por que el inorden sale ordenado: en un ABB todo el subarbol izquierdo es menor");
        r.linea("que el nodo y todo el derecho es mayor. El inorden visita izquierdo -> nodo ->");
        r.linea("derecho, asi que cada matricula aparece despues de todas las menores y antes de");
        r.linea("todas las mayores. Por eso los traslados no rompen el orden de ninguno de los dos.");
    }

    private static void fila(Reporte r, String dato, Object a, Object b) {
        r.linea(String.format("%-22s | %-16s | %-16s", dato, a, b));
    }

    // Siempre con punto decimal, sin depender del idioma del sistema
    private static String dosDecimales(double valor) {
        return String.format(java.util.Locale.ROOT, "%.2f", valor);
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
