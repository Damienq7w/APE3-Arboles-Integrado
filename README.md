# SJA-UTA - Grupo 2

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

APE 3 - Estructura de Datos - Universidad Tecnica de Ambato

## Que hace el Grupo 2

El Grupo 2 continua el proyecto del [Grupo 1](../Grupo1/README.md).

La exposicion del 15/10/2026 aborda insercion, modificacion, eliminacion y recorridos recursivos del arbol binario de busqueda de estudiantes. La Fase 2 esta planificada para el 19/10/2026.

El sistema utiliza dos estructuras:

- Un arbol general para la organizacion: universidad, facultad, carrera, nivel y paralelo.
- Un arbol binario de busqueda por cada paralelo para organizar estudiantes mediante su matricula.

## Estructura del proyecto

| Carpeta          | Contenido                                                   |
| ---------------- | ----------------------------------------------------------- |
| `src/app/`       | Menu principal y datos de prueba.                           |
| `src/enums/`     | Tipos de unidad y de recorrido.                             |
| `src/modelo/`    | Clases Estudiante y UnidadAcademica.                        |
| `src/negocio/`   | Nodos, arbol organizacional y ABB de estudiantes.           |
| `reto/`          | Plantilla y enunciado del ejercicio para el curso.          |
| `reto/solucion/` | Solucion del reto y sus pruebas.                            |
| `docs/`          | Diagramas, trazas, casos de prueba, preguntas y decisiones. |
| `presentacion/`  | Material de la exposicion.                                  |

## Como compilar y ejecutar

Requiere JDK 17 o posterior.

Abrir PowerShell dentro de la carpeta `Grupo2` y ejecutar:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src,reto -Filter *.java).FullName
java -cp out app.Main
```

Para ejecutar la solucion del reto:

```powershell
java -cp out reto.solucion.RetoSolucion
```

Para ejecutar la plantilla del curso:

```powershell
java -cp out reto.RetoRecorridos
```

La plantilla tiene metodos intencionalmente incompletos para que el curso los resuelva. La solucion completa esta en RetoSolucion.

## Metodos y responsables

| Requisito     | Metodo                                                   | Clase                         | Responsable | Rama            |
| ------------- | -------------------------------------------------------- | ----------------------------- | ----------- | --------------- |
| A1            | agregar                                                  | ArbolOrganizacional           | Damian      | Damian_Cunalata |
| A2            | buscar                                                   | ArbolOrganizacional           | Damian      | Damian_Cunalata |
| B1            | insertar                                                 | ArbolEstudiantes              | Kenneth     | Mateo-Chalco    |
| B2            | buscar                                                   | ArbolEstudiantes              | Kenneth     | Mateo-Chalco    |
| B3            | recorrer y trazaRecorrido                                | ArbolEstudiantes              | Darwin      | Rama-Joel       |
| B3            | Opcion 14 de trazas                                      | Main                          | Darwin      | Rama-Joel       |
| B4            | modificar                                                | ArbolEstudiantes              | Luis        | Rama-Luis-Silva |
| B5            | eliminar                                                 | ArbolEstudiantes              | Luis        | Rama-Luis-Silva |
| Reto          | Plantilla y solucion                                     | RetoRecorridos y RetoSolucion | Monica      | Sara-Tacuri     |
| Documentacion | README, indices, trazas, pruebas, preguntas y decisiones | Archivos Markdown             | Jampier     | rama---Josue    |

Cada integrante elabora los diagramas de sus operaciones. Jampier prepara los indices y la documentacion general.

## Datos de prueba

Al iniciar el programa, el paralelo `SW-N3-B` contiene estas matriculas, insertadas en este orden:

```text
50, 30, 70, 20, 40, 60, 80, 35, 65
```

La matricula 45 se agrega durante la demostracion; no forma parte de la carga inicial.

Para insertarla, usar la opcion 8:

| Campo     | Valor de prueba  |
| --------- | ---------------- |
| Paralelo  | SW-N3-B          |
| Matricula | 45               |
| Cedula    | 1800000045       |
| Nombres   | Estudiante Nuevo |
| Promedio  | 9                |

Una segunda insercion de la matricula 45 se rechaza como matricula repetida.

## Resultados verificados

Con el 45 insertado y antes de eliminar estudiantes:

| Recorrido | Secuencia                     |
| --------- | ----------------------------- |
| Preorden  | 50 30 20 40 35 45 70 60 65 80 |
| Inorden   | 20 30 35 40 45 50 60 65 70 80 |
| Posorden  | 20 35 45 40 30 65 60 80 70 50 |

La opcion 10 muestra los estudiantes completos en el orden elegido. La opcion 14 muestra la traza de llamadas y la secuencia de matriculas.

Despues de eliminar 20, 60 y 50, en ese orden:

```text
Inorden: 30 35 40 45 65 70 80
```

La nueva raiz del ABB es 65.

La solucion del reto independiente termina con:

```text
Resultado: 20/20 pruebas OK
```

## Complejidad

N representa la cantidad de unidades del arbol general; n, la cantidad de estudiantes; h, la altura del ABB.

| Operacion                      | Tiempo                                              |
| ------------------------------ | --------------------------------------------------- |
| Buscar unidad                  | O(N)                                                |
| Agregar unidad                 | O(N) amortizado                                     |
| Buscar estudiante              | O(h + 1)                                            |
| Insertar estudiante            | O(h + 1)                                            |
| Modificar estudiante           | O(h + 1), mas la validacion de los textos           |
| Eliminar estudiante            | O(h + 1)                                            |
| Preorden, inorden y posorden   | O(n)                                                |
| Generar traza                  | O(n + L), donde L es la longitud del texto generado |
| Altura en la solucion del reto | O(n)                                                |

Las operaciones que siguen un camino del ABB suelen expresarse como O(h). En un arbol balanceado ese camino es logaritmico; en uno degenerado puede llegar a O(n).

Los recorridos utilizan O(h + 1) de pila y O(n) para la lista de resultados. Las trazas necesitan espacio adicional para su texto. Como la sangria aumenta con la profundidad, el texto puede alcanzar longitud cuadratica en un arbol degenerado.

## Restricciones y estado

- Las estructuras se implementan con nodos propios.
- No se utilizan TreeMap ni TreeSet.
- Las busquedas, inserciones, eliminaciones y recorridos implementados utilizan recursion.
- Se conservan las firmas originales y las clases modelo, enums, nodos y DatosPrueba.
- Los textos nuevos se escriben sin tildes. Los mensajes heredados del Grupo 1 se conservan.

En la version verificada siguen pendientes:

- Arbol general: mostrarJerarquia, altura, grado, nivel, contarHojas, eliminar y transformarABinario.
- ABB: altura, contar, menor, mayor y promedioGeneral.

Por ello, las opciones 1, 4, 5, 6, 7 y 13 del menu todavia muestran operaciones pendientes. La altura implementada en RetoSolucion pertenece al reto y no completa el metodo altura de ArbolEstudiantes.

## Documentacion

- [Diagramas de secuencia](docs/diagramas-secuencia/README.md)
- [Diagramas de flujo](docs/diagramas-flujo/README.md)
- [Trazas de recorridos](docs/trazas_recorridos.md)
- [Trazas de insercion y eliminacion](docs/trazas_insercion_eliminacion.md)
- [Casos de prueba](docs/casos_prueba.md)
- [Banco de preguntas](docs/banco_preguntas.md)
- [Decisiones de implementacion](docs/decisiones.md)
- [Enunciado del reto](reto/RETO.md)
- [Presentacion](presentacion/)

## Quiz de apertura

Se preparo un cuestionario en Wayground con 10 preguntas de repaso del material del Grupo 1.

El banco incluye opciones, respuestas correctas y explicaciones. Las preguntas se importaron mediante la plantilla de Excel de Wayground.

El enlace o codigo para participar se comparte al abrir la sesion en vivo. No se utiliza un codigo temporal como enlace permanente del proyecto.
