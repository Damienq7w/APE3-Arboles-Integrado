# Diagrama de clases

## Completo

```mermaid
classDiagram
    direction TB
    namespace enums {
        class TipoUnidad {
            <<enumeration>>
            UNIVERSIDAD
            FACULTAD
            CARRERA
            NIVEL
            PARALELO
            +puedeTenerHijo(TipoUnidad hijo) boolean
        }
        class TipoRecorrido {
            <<enumeration>>
            PREORDEN
            INORDEN
            POSORDEN
        }
    }
    namespace modelo {
        class UnidadAcademica {
            -String codigo
            -String nombre
            -TipoUnidad tipo
            +getCodigo() String
            +getNombre() String
            +setNombre(String nombre)
            +getTipo() TipoUnidad
        }
        class Estudiante {
            -int matricula
            -String cedula
            -String nombres
            -double promedio
            +getMatricula() int
            +setCedula(String cedula)
            +setNombres(String nombres)
            +setPromedio(double promedio)
        }
    }
    namespace negocio {
        class NodoUnidad {
            -UnidadAcademica dato
            -List~NodoUnidad~ hijos
            -ArbolEstudiantes estudiantes
            +agregarHijo(NodoUnidad hijo) boolean
            +getHijos() List~NodoUnidad~
            +esHoja() boolean
            +getEstudiantes() ArbolEstudiantes
        }
        class NodoEstudiante {
            -Estudiante dato
            -NodoEstudiante izquierdo
            -NodoEstudiante derecho
            +esHoja() boolean
        }
        class ArbolOrganizacional {
            -NodoUnidad raiz
            +agregar(String codigoPadre, UnidadAcademica unidad) boolean
            +buscar(String codigo) NodoUnidad
            +mostrarJerarquia() String
            +altura() int
            +grado(String codigo) int
            +nivel(String codigo) int
            +contarHojas() int
            +eliminar(String codigo) boolean
            +transformarABinario() String
        }
        class ArbolEstudiantes {
            -NodoEstudiante raiz
            +estaVacio() boolean
            +insertar(Estudiante e) boolean
            +buscar(int matricula) Estudiante
            +recorrer(TipoRecorrido tipo) List~Estudiante~
            +modificar(int matricula, String cedula, String nombres, double promedio) boolean
            +eliminar(int matricula) boolean
            +altura() int
            +contar() int
            +menor() Estudiante
            +mayor() Estudiante
            +promedioGeneral() double
        }
    }
    namespace app {
        class Main {
            +main(String[] args)$
        }
        class DatosPrueba {
            +cargar(ArbolOrganizacional arbol)$
        }
    }
    UnidadAcademica --> TipoUnidad
    NodoUnidad *-- "1" UnidadAcademica : dato
    NodoUnidad o-- "0..*" NodoUnidad : hijos
    NodoUnidad *-- "0..1" ArbolEstudiantes : solo PARALELO
    ArbolOrganizacional o-- "0..1" NodoUnidad : raiz
    NodoEstudiante *-- "1" Estudiante : dato
    NodoEstudiante o-- "0..2" NodoEstudiante : izq / der
    ArbolEstudiantes o-- "0..1" NodoEstudiante : raiz
    ArbolEstudiantes ..> TipoRecorrido
    Main ..> ArbolOrganizacional
    Main ..> DatosPrueba
    DatosPrueba ..> ArbolOrganizacional
```


## Relaciones clave

| Relación | Significado |
|---|---|
| `NodoUnidad` → `NodoUnidad` **0..\*** | Un nodo del organigrama tiene cero o muchos hijos: **árbol general** |
| `NodoEstudiante` → `NodoEstudiante` **0..2** | Un nodo del ABB tiene como máximo izquierdo y derecho: **binario** |
| `NodoUnidad` → `ArbolEstudiantes` **0..1** | **Aquí se unen los dos árboles**: solo un PARALELO tiene ABB |
| Nodo ◆ Dato | El nodo contiene al dato (composición) y le agrega los enlaces |
| Árbol ◇ raíz | El árbol solo guarda la raíz; lo demás se alcanza siguiendo enlaces |

## Qué está hecho y qué falta

| Clase | Estado |
|---|---|
| `enums.TipoUnidad`, `enums.TipoRecorrido` | Completos |
| `modelo.UnidadAcademica`, `modelo.Estudiante` | Completas |
| `NodoUnidad`, `NodoEstudiante` | Completas |
| `ArbolOrganizacional`, `ArbolEstudiantes` | Firmas listas, lógica de las Fases 2 y 3 |
| `Main`, `DatosPrueba` | Completas |
