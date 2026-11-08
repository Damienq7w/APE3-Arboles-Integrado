package app;

import java.util.Objects;

// Acumula la salida del reto y cuenta verificaciones aprobadas y fallidas.
// En modo silencioso solo cuenta (se usa para repetir el reto sin imprimir).
// Responsable: Luis Silva
public class Reporte {

    private static final String NL = System.lineSeparator();

    private final StringBuilder texto = new StringBuilder();
    private final boolean silencioso;
    private int aprobadas;
    private int fallidas;

    public Reporte(boolean silencioso) {
        this.silencioso = silencioso;
    }

    public void seccion(String titulo) {
        linea("");
        linea("==================================================");
        linea(titulo);
        linea("==================================================");
    }

    public void linea(String mensaje) {
        if (!silencioso) {
            texto.append(mensaje).append(NL);
        }
    }

    // Compara el valor esperado con el obtenido en la ejecucion real
    public boolean verificar(String descripcion, Object esperado, Object obtenido) {
        boolean ok = Objects.equals(esperado, obtenido);
        registrar(ok, descripcion + " | esperado: " + esperado + " | obtenido: " + obtenido);
        return ok;
    }

    public boolean verificar(String descripcion, boolean condicion) {
        registrar(condicion, descripcion);
        return condicion;
    }

    private void registrar(boolean ok, String detalle) {
        if (ok) {
            aprobadas++;
        } else {
            fallidas++;
        }
        linea((ok ? "  [OK]    " : "  [FALLO] ") + detalle);
    }

    public int getAprobadas() {
        return aprobadas;
    }

    public int getFallidas() {
        return fallidas;
    }

    public String resumen() {
        int total = aprobadas + fallidas;
        return "Resultado: " + aprobadas + "/" + total + " verificaciones OK"
                + (fallidas == 0 ? "" : " (" + fallidas + " fallidas)");
    }

    @Override
    public String toString() {
        return texto.toString();
    }
}
