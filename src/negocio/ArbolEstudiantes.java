package negocio;

import enums.TipoRecorrido;
import java.util.List;
import modelo.Estudiante;

public class ArbolEstudiantes {

    private NodoEstudiante raiz;

    public ArbolEstudiantes() {
        this.raiz = null;
    }

    public NodoEstudiante getRaiz() {
        return raiz;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public boolean insertar(Estudiante estudiante) {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (insertar)");
    }

    public Estudiante buscar(int matricula) {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (buscar)");
    }

    public List<Estudiante> recorrer(TipoRecorrido tipo) {
        throw new UnsupportedOperationException("Pendiente: Fase 2 (recorrer " + tipo + ")");
    }

    public boolean modificar(int matricula, String cedula, String nombres, double promedio) {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (modificar)");
    }

    public boolean eliminar(int matricula) {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (eliminar)");
    }

    public int altura() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (altura)");
    }

    public int contar() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (contar)");
    }

    public Estudiante menor() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (menor)");
    }

    public Estudiante mayor() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (mayor)");
    }

    public double promedioGeneral() {
        throw new UnsupportedOperationException("Pendiente: Fase 3 (promedioGeneral)");
    }
}
