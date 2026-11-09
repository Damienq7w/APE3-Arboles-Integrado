# Plan de pruebas del SJA-UTA

**Responsable de documentación:** Josue Jampier Camacho.  
**Equipo:** Grupo 2.

## Objetivo

Comprobar las operaciones del árbol organizacional y del árbol binario de búsqueda de estudiantes mediante casos normales y casos límite.

Las pruebas comparan el resultado esperado con el obtenido. Cada clase utiliza datos nuevos para evitar que sus cambios afecten a las demás.

## Distribución de pruebas

La distribución prevista en el material de integración es:

| Clase                              | Operaciones                                                 | Responsable     | Verificaciones previstas |
| ---------------------------------- | ----------------------------------------------------------- | --------------- | ------------------------ |
| `PruebasArbolGeneral`              | Agregar, buscar, mostrar jerarquía y consultar propiedades. | Damian Cunalata | 26                       |
| `PruebasInsercionBusqueda`         | Insertar, buscar y validar estudiantes.                     | Kenneth Chalco  | 23                       |
| `PruebasRecorridosEstadisticas`    | Recorridos y estadísticas del ABB.                          | Darwin Tisalema | 24                       |
| `PruebasModificacionEliminacion`   | Modificar y eliminar estudiantes.                           | Luis Silva      | 19                       |
| `PruebasEliminacionTransformacion` | Eliminar unidades y transformar a binario.                  | Mónica Tacuri   | 21                       |
| **Total previsto**                 |                                                             |                 | **113**                  |

El total y los resultados deben comprobarse con las clases finalmente integradas en el repositorio.

## Datos iniciales

### Árbol organizacional

La estructura utilizada en las pruebas incluye:

- Universidad: UTA.
- Facultad: FCHE.
- Carrera: EB.
- Nivel: EB-N1.
- Paralelos: EB-N1-A y EB-N1-B.

### Árbol de estudiantes

En EB-N1-A se insertan las matrículas en este orden:

```text
30, 15, 45, 10, 20, 40, 50, 35, 55
```

El promedio inicial de cada estudiante es 8.00.

Los casos que requieren árboles vacíos, un solo nodo u otras estructuras preparan sus propios datos.

## Casos normales

| Caso                                                  | Resultado esperado                             |
| ----------------------------------------------------- | ---------------------------------------------- |
| Consultar la altura del árbol organizacional inicial. | 4 aristas.                                     |
| Contar las hojas del árbol organizacional inicial.    | 2 hojas.                                       |
| Consultar el nivel de EB-N1-A.                        | Nivel 4.                                       |
| Agregar la carrera SW bajo FCHE.                      | Operación aceptada; quedan 3 hojas.            |
| Insertar 50, 30 y 70 en un ABB vacío.                 | Raíz 50, hijo izquierdo 30 e hijo derecho 70.  |
| Consultar el preorden del ABB inicial.                | 30 15 10 20 45 40 35 50 55                     |
| Consultar el inorden del ABB inicial.                 | 10 15 20 30 35 40 45 50 55                     |
| Consultar el posorden del ABB inicial.                | 10 20 15 35 40 55 50 45 30                     |
| Consultar cantidad y altura del ABB inicial.          | 9 estudiantes y altura 3.                      |
| Consultar matrícula menor y mayor.                    | 10 y 55.                                       |
| Consultar el promedio general inicial.                | 8.00.                                          |
| Modificar el promedio del estudiante 35 a 9.80.       | Operación aceptada y valor actualizado.        |
| Eliminar, en orden, 10, 40, 45 y 30 del ABB inicial.  | Inorden final: 15 20 35 50 55; nueva raíz: 35. |
| Transformar la organización a representación binaria. | EB-N1-B es hermano derecho de EB-N1-A.         |
| Eliminar el paralelo vacío EB-N1-B.                   | Operación aceptada.                            |

## Casos límite

| Caso                                                         | Resultado esperado                                                   |
| ------------------------------------------------------------ | -------------------------------------------------------------------- |
| Agregar una unidad con código repetido.                      | Operación rechazada.                                                 |
| Agregar una unidad bajo un padre inexistente.                | Operación rechazada.                                                 |
| Agregar un NIVEL directamente bajo una FACULTAD.             | Operación rechazada por jerarquía inválida.                          |
| Buscar una unidad inexistente.                               | `null`.                                                              |
| Consultar grado o nivel de una unidad inexistente.           | −1.                                                                  |
| Consultar un árbol organizacional con solo la raíz.          | Altura 0 y una hoja.                                                 |
| Insertar una matrícula repetida.                             | Operación rechazada y cantidad sin cambios.                          |
| Crear un estudiante con matrícula cero o negativa.           | Excepción de validación.                                             |
| Crear un estudiante con cédula inválida o nombres en blanco. | Excepción de validación.                                             |
| Usar promedio 10.5, NaN o Infinity.                          | Excepción de validación.                                             |
| Usar promedios 0 y 10.                                       | Valores aceptados.                                                   |
| Consultar un ABB vacío.                                      | Recorrido vacío, altura −1, cantidad 0, menor `null` y promedio 0.0. |
| Consultar la altura de un ABB con un solo nodo.              | 0.                                                                   |
| Insertar 10, 20, 30, 40 y 50 en ese orden.                   | ABB degenerado con altura 4.                                         |
| Modificar con cédula inválida o promedio 15.                 | Excepción y registro sin cambios.                                    |
| Eliminar una matrícula inexistente.                          | Operación rechazada.                                                 |
| Eliminar en un ABB vacío.                                    | Operación rechazada.                                                 |
| Eliminar un paralelo con estudiantes.                        | Operación rechazada.                                                 |
| Eliminar una unidad con subunidades.                         | Operación rechazada.                                                 |
| Eliminar la raíz cuando es la única unidad y está vacía.     | Operación aceptada; árbol vacío.                                     |
| Solicitar un recorrido o una traza con tipo nulo.            | Excepción de validación.                                             |

## Procedimiento de ejecución

Se requiere JDK 21. Desde la raíz del repositorio, en PowerShell:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
```

Si no aparecen errores de compilación:

```powershell
java -cp out pruebas.PruebasSJA
```

El ejecutor muestra las comprobaciones y el resumen final. Si una clase todavía no se encuentra integrada, aparece un aviso `[PENDIENTE]`.

## Criterios de aceptación

- El código integrado compila sin errores.
- Se ejecutan las cinco clases de pruebas.
- No aparecen clases pendientes.
- Todas las verificaciones ejecutadas resultan correctas.
- El total coincide con las verificaciones definidas en las clases integradas.
- El registro de salida corresponde a esa misma ejecución.

Un resumen sin fallos no demuestra que la ejecución esté completa si también aparecen clases pendientes.

## Registro de resultados

La salida de la comprobación final se guarda en
[salida_pruebas.txt](salida_pruebas.txt).

**Estado de la verificación final:** pendiente de ejecutar con todos los aportes integrados.

El resultado previsto es de 113 verificaciones correctas. Esta cifra es una referencia del plan y no sustituye la comprobación real.

Después de la ejecución final se debe actualizar esta sección con el total ejecutado, las verificaciones correctas y las fallidas.

## Evidencias de ejecución

1. [Inicio de las pruebas](Evidencia/01-inicio-pruebas.png)
2. [Ejecución de los casos de prueba](Evidencia/02-ejecucion-pruebas.png)
3. [Resumen final de las pruebas](Evidencia/03-resumen-pruebas.png)
