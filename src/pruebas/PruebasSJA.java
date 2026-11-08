package pruebas;


// Responsable: Damian Cunalata
// Ejecuta todas las pruebas del SJA-UTA (casos normales y limite) y muestra el resumen.
// Uso: java -cp out pruebas.PruebasSJA
public final class PruebasSJA {

    // Cada integrante agrega su clase de pruebas; si todavia no esta, se marca como pendiente
    private static final String[] CLASES = {
        "pruebas.PruebasArbolGeneral",           // A1 a A4 y ruta: Damian Cunalata
        "pruebas.PruebasInsercionBusqueda",      // B1, B2, validaciones y traslado: Kenneth Chalco
        "pruebas.PruebasRecorridosEstadisticas", // B3, B6 y aprobados: Darwin Tisalema
        "pruebas.PruebasModificacionEliminacion",// B4 y B5: Luis Silva
        "pruebas.PruebasEliminacionTransformacion" // A5 y A6: Monica Tacuri
    };

    private PruebasSJA() {
    }

    public static void main(String[] args) {
        Verificador r = new Verificador();
        r.seccion("PRUEBAS DEL SJA-UTA - APE 3 - GRUPO 2");

        for (String nombre : CLASES) {
            try {
                Class.forName(nombre)
                        .getMethod("ejecutar", Verificador.class)
                        .invoke(null, r);
            } catch (ClassNotFoundException e) {
                r.linea("");
                r.linea("[PENDIENTE] " + nombre + " todavia no fue agregada.");
            } catch (ReflectiveOperationException e) {
                Throwable causa = e.getCause() != null ? e.getCause() : e;
                r.verificar(nombre + " termino sin errores inesperados (" + causa + ")", false);
            }
        }

        r.seccion("RESUMEN DE PRUEBAS");
        r.linea(r.resumen());
        System.out.println(r);
        if (r.getFallidas() > 0) {
            System.exit(1);
        }
    }
}
