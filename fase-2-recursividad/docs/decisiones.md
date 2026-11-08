# Decisiones de implementación

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Organización del sistema

Se conserva la arquitectura del Grupo 1: un árbol general para las unidades académicas y un ABB de estudiantes por cada paralelo.

El árbol general representa relaciones de dependencia: UTA → Facultad → Carrera → Nivel → Paralelo. El ABB organiza a los estudiantes por matrícula.

Se mantienen las firmas originales y la separación en los paquetes enums, modelo, negocio y app.

## Árbol general

| Decisión                                                      | Justificación                                                                                          |
| ------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| Normalizar los códigos de búsqueda con trim().toUpperCase()   | Permite consultar usando minúsculas o espacios alrededor del código.                                   |
| Devolver null cuando buscar recibe un código nulo o en blanco | Evita iniciar una búsqueda sin un código válido.                                                       |
| Comprobar códigos repetidos en todo el árbol antes de agregar | Mantiene códigos únicos, aunque se intente insertar bajo otro padre.                                   |
| Delegar la validación jerárquica en NodoUnidad.agregarHijo()  | Reutiliza la regla de TipoUnidad: el hijo debe pertenecer al tipo inmediatamente inferior.             |
| Mostrar la jerarquía mediante un preorden recursivo           | Presenta primero la unidad actual y después sus hijos.                                                 |
| Utilizar dos espacios de sangría por nivel                    | Permite reconocer visualmente la profundidad de cada unidad.                                           |
| Construir la salida con StringBuilder                         | Permite acumular el texto de las llamadas recursivas.                                                  |
| Medir la altura en aristas                                    | Una hoja tiene altura 0; el camino completo desde UTA hasta un paralelo tiene cuatro aristas.          |
| Asignar nivel 0 a UTA                                         | El nivel cuenta las aristas desde la raíz hasta la unidad consultada.                                  |
| Definir el grado como la cantidad de hijos directos           | No incluye nietos ni otros descendientes.                                                              |
| Devolver -1 en grado() y nivel() si el código no existe       | Distingue una unidad inexistente de una unidad válida con grado o nivel 0.                             |
| Contar hojas mediante recursividad                            | Un nodo sin hijos aporta 1; los demás suman las hojas de sus subárboles.                               |
| Separar las hojas organizacionales de los estudiantes         | El ABB del paralelo es una estructura asociada y no forma parte de la lista de hijos organizacionales. |

La regla de devolver -1 ante un código inexistente corresponde a grado() y nivel(). buscar() devuelve null y las operaciones de inserción informan su resultado mediante boolean.

Con los datos iniciales se esperan 88 unidades, 57 hojas y altura 4. La altura sigue pendiente de implementación en la versión revisada.

## ABB de estudiantes

| Decisión                                                       | Justificación                                                                                          |
| -------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------ |
| Ordenar el ABB por matrícula                                   | Proporciona una clave estable para decidir si se continúa por la izquierda o por la derecha.           |
| Lanzar IllegalArgumentException al insertar un estudiante null | La inserción necesita un estudiante válido para crear el nodo.                                         |
| Devolver false ante una matrícula repetida                     | Impide duplicados dentro del paralelo sin reemplazar al estudiante existente.                          |
| Implementar la inserción y la búsqueda mediante recursividad   | Permite resolver la operación sobre el subárbol correspondiente y detenerla en su caso base.           |
| Devolver una lista vacía al recorrer un ABB vacío              | Permite procesar el resultado sin recibir una referencia null.                                         |
| Rechazar un tipo de recorrido null                             | Evita ejecutar un recorrido sin conocer el orden solicitado.                                           |
| Validar todos los datos antes de modificar                     | Se construye un Estudiante temporal antes de aplicar los setters para evitar modificaciones parciales. |
| Conservar la matrícula durante una modificación                | La matrícula es final y determina la posición del estudiante en el ABB.                                |
| Incluir modificar y eliminar como adelantos de la Fase 3       | Se conserva el trabajo implementado por el Grupo 2 y se informa su alcance al siguiente grupo.         |
| Utilizar el sucesor inorden al eliminar un nodo con dos hijos  | El menor del subárbol derecho permite reemplazar el dato y conservar el orden del ABB.                 |
| Devolver false al eliminar una matrícula inexistente           | Informa que no hubo eliminación y conserva la estructura.                                              |
| Agregar trazaRecorrido() y la opción 14                        | Permite mostrar las llamadas recursivas, los casos base y el momento de visita de cada nodo.           |
| Mantener recorrer() separado de trazaRecorrido()               | recorrer() entrega una lista de estudiantes y trazaRecorrido() entrega una explicación textual.        |
| Insertar 45 durante la demostración                            | Permite observar su camino hasta quedar como hijo derecho de 40. No pertenece a la carga inicial.      |

## Interpretación de las trazas

- entra indica una llamada con un nodo existente.
- null -> regresa identifica el caso base.
- VISITA indica cuándo se agrega la matrícula a la secuencia.

La sangría aumenta dos espacios por nivel y permite seguir la profundidad de las llamadas.

El momento de VISITA cambia según el recorrido:

- Preorden: antes de recorrer ambos hijos.
- Inorden: después del hijo izquierdo y antes del derecho.
- Posorden: después de recorrer ambos hijos.

## Orden de las eliminaciones

La demostración elimina 20, 60 y 50, en ese orden.

1. Al eliminar 20 se aplica el caso hoja.
2. Al eliminar 60 se aplica el caso de un hijo y 65 ocupa su posición.
3. Al eliminar 50 se aplica el caso de dos hijos y su sucesor es 65, porque 60 ya fue eliminado.

Si se eliminara 50 antes que 60, su sucesor sería 60. Las explicaciones y los resultados deben indicar el orden utilizado.

## Reto anterior y estaciones de la Fase 2

Se conserva el reto anterior como material de apoyo:

- RetoRecorridos contiene la plantilla que debe resolver el curso.
- RetoSolucion contiene la implementación completa y sus verificaciones.
- La solución realiza 20 comprobaciones: tres recorridos y la altura en cinco conjuntos independientes.
- La inserción y la altura del reto son implementaciones propias; no completan los métodos pendientes de las clases del sistema.

Para la clase del 19 de octubre se utiliza una lista común de matrículas en cuatro estaciones:

1. E1: inserción.
2. E2: preorden.
3. E3: inorden y posorden.
4. E4: caza el error.

La lista común y la rotación se consultan en [la organización de las estaciones](../facilitacion/estaciones/README.md).

Los grupos publican sus respuestas en el Padlet de la Fase 2. El enlace debe registrarse en facilitacion/enlaces.md cuando esté disponible.

El banco de preguntas y el quiz anterior se conservan como material de repaso. La actividad participativa prevista para esta clase son las estaciones y el Padlet.

## Alcance del código revisado

### Implementado

En el árbol general:

- agregar().
- buscar().
- mostrarJerarquia().
- grado().
- nivel().
- contarHojas().

En el ABB:

- insertar().
- buscar().
- recorrer() con preorden, inorden y posorden.
- trazaRecorrido().
- modificar().
- eliminar() con los casos de hoja, un hijo y dos hijos.

### Pendiente de la Fase 2

- altura() del árbol general.

Aunque el valor esperado es 4, el método todavía lanza UnsupportedOperationException en la versión revisada.

La opción 4 evalúa altura() antes de contarHojas(). Mientras altura() esté pendiente, esa opción no alcanza a mostrar las hojas. contarHojas() se comprobó de forma independiente.

### Pendiente para la Fase 3

En el árbol general:

- eliminar().
- transformarABinario().

En el ABB:

- altura().
- contar().
- menor().
- mayor().
- promedioGeneral().

Los métodos pendientes no se presentan como implementados ni como pruebas aprobadas.

## Documentación y evidencias

La documentación, el informe y las diapositivas se escriben con tildes y ñ.

Los diagramas se guardan en archivos Markdown con Mermaid dentro de docs/diagramas-flujo y docs/diagramas-secuencia.

En el informe Word se incorporan capturas de los diagramas renderizados y de los métodos correspondientes.

Los resultados esperados se distinguen de los resultados obtenidos. Cuando se integre un método pendiente, se ejecuta nuevamente su prueba antes de cambiar su estado a OK.

## Trabajo con ramas

Cada integrante trabaja en su rama y abre un pull request hacia main. Damián revisa e integra los cambios.

El orden previsto para integrar los aportes de esta fase es:

1. Kenneth.
2. Mónica.
3. Luis.
4. Darwin.
5. Jampier.

Antes de continuar las ediciones, cada integrante incorpora la versión actualizada de main a su rama.

Se conservan las firmas de los métodos y cada responsable modifica únicamente la parte que tiene asignada.

Los commits describen cambios concretos. La documentación debe reflejar el estado del código revisado.

[Volver al README del Grupo 2](../README.md)
