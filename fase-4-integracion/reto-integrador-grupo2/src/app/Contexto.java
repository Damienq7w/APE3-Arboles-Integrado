package app;

import enums.TipoUnidad;
import modelo.Estudiante;
import modelo.UnidadAcademica;
import negocio.ArbolEstudiantes;
import negocio.ArbolOrganizacional;
import negocio.NodoUnidad;

// Estado del sistema: arbol organizacional con los datos iniciales del reto.
// Responsable: Damian Cunalata
public class Contexto {

    public static final int[] MATRICULAS_INICIALES = {30, 15, 45, 10, 20, 40, 50, 35, 55};
    public static final double PROMEDIO_INICIAL = 8.0;

    public ArbolOrganizacional organizacion;
    public final String paralelo = "EB-N1-A";
    public final String paraleloDestino = "EB-N1-B";

    public Contexto() {
        reiniciar();
    }

    // Opcion 7: crea un arbol NUEVO, asi no queda nada del estado anterior
    public void reiniciar() {
        organizacion = new ArbolOrganizacional(
            new UnidadAcademica("UTA", "Universidad Tecnica de Ambato", TipoUnidad.UNIVERSIDAD));
        organizacion.agregar("UTA",
            new UnidadAcademica("FCHE", "Ciencias Humanas y de la Educacion", TipoUnidad.FACULTAD));
        organizacion.agregar("FCHE",
            new UnidadAcademica("EB", "Educacion Basica", TipoUnidad.CARRERA));
        organizacion.agregar("EB",
            new UnidadAcademica("EB-N1", "Nivel 1", TipoUnidad.NIVEL));
        organizacion.agregar("EB-N1",
            new UnidadAcademica(paralelo, "Paralelo A", TipoUnidad.PARALELO));
        organizacion.agregar("EB-N1",
            new UnidadAcademica(paraleloDestino, "Paralelo B vacio", TipoUnidad.PARALELO));

        ArbolEstudiantes abb = estudiantes();
        for (int matricula : MATRICULAS_INICIALES) {
            abb.insertar(new Estudiante(
                matricula,
                String.format("%010d", matricula),
                "Estudiante " + matricula,
                PROMEDIO_INICIAL));
        }
    }

    // ABB del paralelo activo (EB-N1-A)
    public ArbolEstudiantes estudiantes() {
        return estudiantes(paralelo);
    }

    // ABB de cualquier paralelo por codigo
    public ArbolEstudiantes estudiantes(String codigoParalelo) {
        NodoUnidad nodo = organizacion.buscar(codigoParalelo);
        if (nodo == null || nodo.getEstudiantes() == null) {
            throw new IllegalStateException(
                "El paralelo " + codigoParalelo + " no existe. Reinicie los datos con 7.");
        }
        return nodo.getEstudiantes();
    }
}
