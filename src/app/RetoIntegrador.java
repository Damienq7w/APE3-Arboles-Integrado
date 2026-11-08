package app;

import enums.TipoRecorrido;
import java.util.StringJoiner;
import modelo.Estudiante;
import negocio.ArbolEstudiantes;

// Mision 6: ejecuta en secuencia las misiones del reto (opcion 8 del menu).
// Tambien se puede correr sin menu: java -cp out app.RetoIntegrador
// Responsable: Damian Cunalata
public final class RetoIntegrador {

    private RetoIntegrador() {
    }

    public static void main(String[] args) {
        Reporte reporte = ejecutar(new Contexto());
        System.out.println(reporte);
        if (reporte.getFallidas() > 0) {
            System.exit(1);
        }
    }

    // Punto de entrada de la opcion 8
    public static Reporte ejecutar(Contexto c) {
        Reporte r = new Reporte(false);

        r.seccion("RETO INTEGRADOR SJA-UTA - GRUPO 2");
        r.linea("Se parte siempre de los datos iniciales (reinicio automatico).");
        r.linea("Asi, repetir la opcion 8 no duplica unidades ni estudiantes.");

        correrMisiones(c, r);
        mision6(r);

        r.seccion("RESUMEN");
        r.linea(r.resumen());
        r.linea("El estado final del reto queda cargado. Use la opcion 7 para volver a los datos iniciales.");
        return r;
    }

    // Reinicia y corre las misiones 1 a 5 sobre el contexto recibido
    static void correrMisiones(Contexto c, Reporte r) {
        c.reiniciar();
        RetoMision1.ejecutar(c, r);
        RetoMision2.ejecutar(c, r);
        RetoMision3.ejecutar(c, r);
        RetoMision4.ejecutar(c, r);
        RetoMision5.ejecutar(c, r);
    }

    // Mision 6: repeticion sin duplicados y reinicio completo.
    // Se usa un contexto auxiliar para no tocar el estado que ve el usuario.
    private static void mision6(Reporte r) {
        r.seccion("MISION 6 - Integracion y reinicio");

        Contexto aux = new Contexto();

        correrMisiones(aux, new Reporte(true));
        String primeraEjecucion = huella(aux);

        correrMisiones(aux, new Reporte(true));
        String segundaEjecucion = huella(aux);

        r.verificar("Ejecutar el reto dos veces deja exactamente el mismo estado",
                primeraEjecucion.equals(segundaEjecucion));

        aux.reiniciar();
        String original = new Contexto().organizacion.mostrarJerarquia();
        ArbolEstudiantes a = aux.estudiantes(aux.paralelo);
        ArbolEstudiantes b = aux.estudiantes(aux.paraleloDestino);

        r.linea("Despues de reiniciar (opcion 7):");
        r.verificar("Jerarquia igual a la inicial (sin SW ni sus subunidades)",
                original.equals(aux.organizacion.mostrarJerarquia()));
        r.verificar("Unidad SW eliminada por el reinicio", null, aux.organizacion.buscar("SW"));
        r.verificar("Unidad SW-N3-A eliminada por el reinicio", null, aux.organizacion.buscar("SW-N3-A"));
        r.verificar("Inorden de EB-N1-A con las 9 matriculas",
                "10 15 20 30 35 40 45 50 55", inorden(a));
        r.verificar("EB-N1-B vacio", true, b.estaVacio());
        r.verificar("Matricula 35 vuelve a promedio 8.00", 8.0, a.buscar(35).getPromedio());
    }

    // Resumen del estado completo para comparar dos ejecuciones
    private static String huella(Contexto c) {
        StringBuilder sb = new StringBuilder(c.organizacion.mostrarJerarquia());
        for (String codigo : new String[]{c.paralelo, c.paraleloDestino}) {
            sb.append('|').append(codigo).append(':');
            for (Estudiante e : c.estudiantes(codigo).recorrer(TipoRecorrido.PREORDEN)) {
                sb.append(e).append(';');
            }
        }
        return sb.toString();
    }

    // Matriculas del inorden separadas por espacios, por ejemplo "10 15 20"
    static String inorden(ArbolEstudiantes abb) {
        return matriculas(abb, TipoRecorrido.INORDEN);
    }

    static String matriculas(ArbolEstudiantes abb, TipoRecorrido tipo) {
        StringJoiner sj = new StringJoiner(" ");
        for (Estudiante e : abb.recorrer(tipo)) {
            sj.add(String.valueOf(e.getMatricula()));
        }
        return sj.toString();
    }
}
