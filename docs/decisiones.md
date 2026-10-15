# Decisiones de implementacion

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Organizacion del sistema

Se conserva la estructura del Grupo 1: un arbol general para las unidades academicas y un ABB de estudiantes por cada paralelo.

El arbol general representa relaciones de dependencia. El ABB organiza estudiantes mediante una clave: la matricula.

Se mantienen las firmas originales y las clases modelo, enums, NodoUnidad, NodoEstudiante y DatosPrueba.

## Decisiones y justificacion

| Decision                                                                  | Justificacion                                                                                                                                |
| ------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| Normalizar el codigo en buscar del arbol general con trim().toUpperCase() | Permite buscar una unidad usando minusculas o espacios alrededor del codigo.                                                                 |
| Devolver null cuando el codigo de busqueda es null o esta en blanco       | Evita iniciar una busqueda sin un codigo util.                                                                                               |
| Comprobar codigos repetidos en todo el arbol antes de agregar             | Mantiene la unicidad de los codigos, aunque se intente insertar bajo otro padre.                                                             |
| Delegar la validacion jerarquica en NodoUnidad.agregarHijo                | Reutiliza la regla definida mediante TipoUnidad y evita relaciones de tipos incorrectas.                                                     |
| Ordenar el ABB por matricula                                              | Proporciona una clave estable para decidir si la busqueda continua a la izquierda o a la derecha.                                            |
| Lanzar IllegalArgumentException al insertar un estudiante null            | La insercion necesita un estudiante valido para crear el nodo.                                                                               |
| Devolver false ante una matricula repetida                                | Impide duplicados dentro del ABB del paralelo sin reemplazar al estudiante existente.                                                        |
| Implementar busquedas y operaciones del ABB mediante recursion            | Permite resolver cada operacion sobre el subarbol correspondiente y detenerla en su caso base.                                               |
| Devolver una lista vacia al recorrer un ABB vacio                         | Permite procesar el resultado sin recibir una referencia null.                                                                               |
| Rechazar un tipo de recorrido null                                        | Evita ejecutar un recorrido sin conocer el orden solicitado.                                                                                 |
| Validar todos los datos antes de modificar                                | Se construye un Estudiante temporal y solo despues se aplican los setters, evitando modificaciones parciales por datos invalidos.            |
| Conservar la matricula durante una modificacion                           | La matricula es final y determina la posicion del estudiante en el ABB.                                                                      |
| Incluir modificar y eliminar del ABB en el Grupo 2                        | El reparto asigna estas operaciones al grupo aunque el esqueleto original las identifique como Fase 3.                                       |
| Utilizar el sucesor inorden al eliminar un nodo con dos hijos             | El menor del subarbol derecho permite reemplazar el dato y conservar el orden del ABB.                                                       |
| Devolver false al eliminar una matricula inexistente                      | Informa que no hubo eliminacion y conserva la estructura.                                                                                    |
| Agregar trazaRecorrido y la opcion 14                                     | Permite mostrar las llamadas recursivas, los casos base y el momento de visita de cada nodo.                                                 |
| Mantener recorrer separado de trazaRecorrido                              | recorrer entrega una lista de estudiantes; trazaRecorrido entrega el texto explicativo de la ejecucion.                                      |
| Insertar 45 durante la demostracion                                       | Permite observar su camino hasta quedar como hijo derecho de 40. No pertenece a la carga inicial.                                            |
| Utilizar una insercion propia en el reto                                  | Permite trabajar con Estudiante y NodoEstudiante sin depender de la implementacion de ArbolEstudiantes.                                      |
| Conservar metodos incompletos en RetoRecorridos                           | Es la plantilla que debe resolver el curso; la implementacion completa esta en RetoSolucion.                                                 |
| Documentar 20 comprobaciones del reto                                     | La solucion integrada verifica tres recorridos y la altura en cinco conjuntos: 20 resultados en total.                                       |
| Utilizar Wayground con 10 preguntas para la apertura                      | Se ajusto el plan inicial de ocho preguntas en Kahoot para repasar los fundamentos del Grupo 1 antes de explicar los algoritmos del Grupo 2. |

## Interpretacion de las trazas

entra indica una llamada con nodo existente.

null -> regresa identifica el caso base.

VISITA indica cuando se agrega la matricula a la secuencia.

La sangria aumenta dos espacios por nivel y permite seguir la profundidad de las llamadas.

El momento de VISITA cambia segun el recorrido:

- Preorden: antes de ambos hijos.
- Inorden: entre el hijo izquierdo y el derecho.
- Posorden: despues de ambos hijos.

## Orden de las eliminaciones

La demostracion elimina 20, 60 y 50, en ese orden.

Al eliminar 20 se aplica el caso hoja.

Al eliminar 60 se aplica el caso de un hijo y 65 ocupa su posicion.

Al eliminar 50 se aplica el caso de dos hijos y su sucesor es 65, porque 60 ya fue eliminado.

Si se eliminara 50 antes que 60, su sucesor seria 60. Las explicaciones y resultados deben indicar el orden utilizado.

## Alcance del codigo integrado

La implementacion revisada incluye agregar y buscar unidades, insertar y buscar estudiantes, los tres recorridos, trazas, modificacion y eliminacion del ABB.

Todavia existen operaciones pendientes del arbol general y de las estadisticas del ABB. No se presentan como terminadas en la documentacion.

La altura implementada en RetoSolucion pertenece al reto y no completa el metodo altura de ArbolEstudiantes.

Los textos nuevos se escriben sin tildes. Los mensajes heredados del Grupo 1 se conservan.

## Trabajo con ramas

Cada integrante trabaja en su rama y abre un pull request hacia main. Damian revisa e integra.

Orden de integracion acordado:

1. Damian.
2. Kenneth.
3. Darwin.
4. Luis.
5. Monica.
6. Jampier.

Antes de abrir el pull request, se incorpora la version mas reciente de main a la rama de trabajo.

Los commits deben describir los cambios realizados. Los resultados documentados deben corresponder a ejecuciones del codigo integrado.

[Volver al README del Grupo 2](../README.md)
