package negocio;

import enums.TipoUnidad;
import modelo.UnidadAcademica;

// Responsable: Damian Cunalata
public class ArbolOrganizacional {

    private NodoUnidad raiz;

    public ArbolOrganizacional(UnidadAcademica universidad) {
        if (universidad == null
                || universidad.getTipo() != TipoUnidad.UNIVERSIDAD) {
            throw new IllegalArgumentException(
                "La raiz debe ser una UNIVERSIDAD"
            );
        }

        this.raiz = new NodoUnidad(universidad);
    }

    public NodoUnidad getRaiz() {
        return raiz;
    }

    // A1: Agregar unidad academica
    public boolean agregar(String codigoPadre, UnidadAcademica unidad) {

        if (codigoPadre == null || unidad == null) {
            return false;
        }

        if (buscar(unidad.getCodigo()) != null) {
            return false;
        }

        NodoUnidad padre = buscar(codigoPadre);

        if (padre == null) {
            return false;
        }

        return padre.agregarHijo(new NodoUnidad(unidad));
    }

    // A2: Buscar unidad recursivamente
    public NodoUnidad buscar(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            return null;
        }

        return buscar(raiz, codigo.trim().toUpperCase());
    }

    private NodoUnidad buscar(NodoUnidad nodo, String codigo) {

        if (nodo == null) {
            return null;
        }

        if (nodo.getDato().getCodigo().equals(codigo)) {
            return nodo;
        }

        for (NodoUnidad hijo : nodo.getHijos()) {
            NodoUnidad encontrado = buscar(hijo, codigo);

            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    // A3: Mostrar jerarquia
    public String mostrarJerarquia() {

        if (raiz == null) {
            return "Arbol organizacional vacio.";
        }

        StringBuilder sb = new StringBuilder();

        mostrarJerarquia(raiz, 0, sb);

        return sb.toString().stripTrailing();
    }

    private void mostrarJerarquia(
            NodoUnidad nodo,
            int nivel,
            StringBuilder sb) {

        if (nodo == null) {
            return;
        }

        sb.append("  ".repeat(nivel))
          .append(nodo.getDato())
          .append(System.lineSeparator());

        for (NodoUnidad hijo : nodo.getHijos()) {
            mostrarJerarquia(hijo, nivel + 1, sb);
        }
    }

    // A4: Calcular altura organizacional
    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoUnidad nodo) {

        if (nodo == null) {
            return -1;
        }

        int mayor = -1;

        for (NodoUnidad hijo : nodo.getHijos()) {
            mayor = Math.max(mayor, altura(hijo));
        }

        return 1 + mayor;
    }

    // A4: Consultar grado de una unidad
    public int grado(String codigo) {

        NodoUnidad nodo = buscar(codigo);

        if (nodo == null) {
            return -1;
        }

        return nodo.getHijos().size();
    }

    // A4: Consultar nivel de una unidad
    public int nivel(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            return -1;
        }

        return nivel(
            raiz,
            codigo.trim().toUpperCase(),
            0
        );
    }

    private int nivel(
            NodoUnidad nodo,
            String codigo,
            int profundidad) {

        if (nodo == null) {
            return -1;
        }

        if (nodo.getDato().getCodigo().equals(codigo)) {
            return profundidad;
        }

        for (NodoUnidad hijo : nodo.getHijos()) {

            int resultado = nivel(
                hijo,
                codigo,
                profundidad + 1
            );

            if (resultado != -1) {
                return resultado;
            }
        }

        return -1;
    }

    // A4: Contar hojas del arbol general
    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(NodoUnidad nodo) {

        if (nodo == null) {
            return 0;
        }

        if (nodo.esHoja()) {
            return 1;
        }

        int total = 0;

        for (NodoUnidad hijo : nodo.getHijos()) {
            total += contarHojas(hijo);
        }

        return total;
    }

    // ===== Operaciones del reto =====
    // ArbolOrganizacional conserva las firmas que pide el enunciado y delega
    // cada operacion en la clase auxiliar de su responsable.

    // Mision 1: ruta desde UTA hasta la unidad (RutaJerarquica)
    public String obtenerRutaJerarquica(String codigo) {
        return RutaJerarquica.obtener(raiz, codigo);
    }

    // Mision 2: elimina solo hojas vacias (EliminadorUnidades)
    public boolean eliminar(String codigo) {
        return EliminadorUnidades.eliminar(raiz, codigo);
    }

    // Mision 2: arbol binario hijo izquierdo / hermano derecho (TransformadorBinario)
    public NodoBinario construirBinario() {
        return TransformadorBinario.construir(raiz);
    }

    public String transformarABinario() {
        return TransformadorBinario.mostrar(construirBinario());
    }

    public String relacionBinaria(String codigo) {
        return TransformadorBinario.relacion(construirBinario(), codigo);
    }

    // Mision 3: traslado seguro entre paralelos (TrasladoEstudiantes)
    public boolean trasladarEstudiante(String codOrigen, String codDestino, int matricula) {
        return TrasladoEstudiantes.trasladar(buscar(codOrigen), buscar(codDestino), matricula);
    }
}
