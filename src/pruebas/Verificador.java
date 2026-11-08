package pruebas;

import java.util.Objects;

// Responsable: Damian Cunalata
// Compara el valor esperado con el obtenido y cuenta las pruebas correctas y fallidas.
public final class Verificador {

    private static final String NL = System.lineSeparator();

    private final StringBuilder texto = new StringBuilder();
    private int correctas;
    private int fallidas;

    public void seccion(String titulo) {
        linea("");
        linea("==================================================");
        linea(titulo);
        linea("==================================================");
    }

    public void linea(String mensaje) {
        texto.append(mensaje).append(NL);
    }

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
            correctas++;
        } else {
            fallidas++;
        }
        linea((ok ? "  [OK]    " : "  [FALLO] ") + detalle);
    }

    public int getFallidas() {
        return fallidas;
    }

    public String resumen() {
        int total = correctas + fallidas;
        return "Resultado: " + correctas + "/" + total + " pruebas OK"
                + (fallidas == 0 ? "" : " (" + fallidas + " fallidas)");
    }

    @Override
    public String toString() {
        return texto.toString();
    }
}
