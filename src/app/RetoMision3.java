package app;

import modelo.Estudiante;
import negocio.ArbolEstudiantes;
import negocio.ArbolOrganizacional;

// Mision 3: validacion de datos y traslado entre paralelos
// Responsable: Kenneth Chalco
final class RetoMision3 {

    private RetoMision3() {
    }

    static void ejecutar(Contexto c, Reporte r) {
        r.seccion("MISION 3 - Validacion de datos y traslado entre paralelos");

        validarEstudiante(r);
        validarTraslado(c, r);
    }

    private static void validarEstudiante(Reporte r) {
        r.linea("Validaciones de Estudiante:");
        r.verificar("Matricula 0 rechazada", rechaza(() -> crear(0, 8)));
        r.verificar("Matricula negativa rechazada", rechaza(() -> crear(-5, 8)));
        r.verificar("Promedio -0.5 rechazado", rechaza(() -> crear(99, -0.5)));
        r.verificar("Promedio 10.5 rechazado", rechaza(() -> crear(99, 10.5)));
        r.verificar("Promedio NaN rechazado", rechaza(() -> crear(99, Double.NaN)));
        r.verificar("Promedio Infinity rechazado", rechaza(() -> crear(99, Double.POSITIVE_INFINITY)));
        r.verificar("Promedio -Infinity rechazado", rechaza(() -> crear(99, Double.NEGATIVE_INFINITY)));
        r.verificar("Promedio 0 aceptado (limite)", !rechaza(() -> crear(99, 0)));
        r.verificar("Promedio 10 aceptado (limite)", !rechaza(() -> crear(99, 10)));

        Estudiante e = crear(99, 7.5);
        boolean rechazoNaN = rechaza(() -> e.setPromedio(Double.NaN));
        r.verificar("setPromedio(NaN) rechazado y conserva 7.5",
                rechazoNaN && e.getPromedio() == 7.5);
    }

    private static void validarTraslado(Contexto c, Reporte r) {
        ArbolOrganizacional org = c.organizacion;
        String a = c.paralelo;
        String b = c.paraleloDestino;

        r.linea("");
        r.linea("Traslados que deben rechazarse (no cambian ningun arbol):");
        r.verificar("Origen inexistente", false, org.trasladarEstudiante("XYZ", b, 30));
        r.verificar("Destino inexistente", false, org.trasladarEstudiante(a, "XYZ", 30));
        r.verificar("Destino que no es PARALELO (EB-N1)", false, org.trasladarEstudiante(a, "EB-N1", 30));
        r.verificar("Origen que no es PARALELO (FCHE)", false, org.trasladarEstudiante("FCHE", b, 30));
        r.verificar("Origen igual al destino", false, org.trasladarEstudiante(a, a, 30));
        r.verificar("Matricula 99 no existe en el origen", false, org.trasladarEstudiante(a, b, 99));
        r.verificar("EB-N1-A conserva sus 9 estudiantes",
                "10 15 20 30 35 40 45 50 55", RetoIntegrador.inorden(c.estudiantes(a)));
        r.verificar("EB-N1-B sigue vacio", true, c.estudiantes(b).estaVacio());

        // Duplicado en destino: se prueba en un contexto aparte para no alterar el reto
        Contexto aux = new Contexto();
        ArbolEstudiantes auxA = aux.estudiantes(a);
        ArbolEstudiantes auxB = aux.estudiantes(b);
        auxB.insertar(crear(55, 6));
        r.verificar("Matricula 55 ya existe en el destino (contexto auxiliar)", false,
                aux.organizacion.trasladarEstudiante(a, b, 55));
        r.verificar("El 55 sigue en el origen y el destino no se duplica",
                auxA.buscar(55) != null && auxB.contar() == 1 && auxB.buscar(55).getPromedio() == 6);

        // Traslado valido en el contexto auxiliar: los datos llegan completos
        Estudiante antes = auxA.buscar(20);
        String datosAntes = antes.toString();
        r.verificar("Traslado valido de 20 (contexto auxiliar)", true,
                aux.organizacion.trasladarEstudiante(a, b, 20));
        r.verificar("El 20 ya no esta en el origen", null, auxA.buscar(20));
        r.verificar("El 20 llega al destino con los mismos datos", datosAntes, String.valueOf(auxB.buscar(20)));
    }

    private static Estudiante crear(int matricula, double promedio) {
        return new Estudiante(matricula, "1800000000", "Prueba " + matricula, promedio);
    }

    // true si la accion lanza IllegalArgumentException
    private static boolean rechaza(Runnable accion) {
        try {
            accion.run();
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }
}
