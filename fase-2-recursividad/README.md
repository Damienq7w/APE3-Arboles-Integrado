# SJA-UTA — Grupo 2

> **Responsable de documentación:** Jampier (Josue)
> **Rama:** `rama---Josue`

APE 3 — Estructura de Datos — Universidad Técnica de Ambato.

## Propósito

El Grupo 2 continúa el proyecto del [Grupo 1](../Grupo1/README.md) e implementa las operaciones recursivas correspondientes a la Fase 2.

El sistema combina dos estructuras:

- Un árbol general para la organización: UTA → Facultad → Carrera → Nivel → Paralelo.
- Un árbol binario de búsqueda por cada paralelo para organizar estudiantes mediante su matrícula.

El material preparado para la exposición del 15 de octubre se conserva como apoyo. La clase de la Fase 2 del 19 de octubre incorpora las consultas del árbol general y cuatro estaciones de trabajo con publicación de respuestas en Padlet.

## Estructura del proyecto

| Carpeta                    | Contenido                                                   |
| -------------------------- | ----------------------------------------------------------- |
| `src/app/`                 | Menú principal y datos de prueba.                           |
| `src/enums/`               | Tipos de unidad y de recorrido.                             |
| `src/modelo/`              | Clases Estudiante y UnidadAcademica.                        |
| `src/negocio/`             | Nodos, árbol organizacional y ABB de estudiantes.           |
| `docs/`                    | Diagramas, trazas, casos de prueba, preguntas y decisiones. |
| `facilitacion/`            | Material de organización de la Fase 2.                      |
| `facilitacion/estaciones/` | Secuencia común, rotación y ejercicios de las estaciones.   |
| `reto/`                    | Enunciado y plantilla del reto anterior.                    |
| `reto/solucion/`           | Solución del reto y sus pruebas.                            |
| `presentacion/`            | Material de exposición.                                     |

## Compilación y ejecución

La guía de la actividad solicita JDK 21. El código revisado también compiló y se ejecutó con Java 17.

Abrir PowerShell dentro de la carpeta `Grupo2` y ejecutar:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src,reto -Filter *.java).FullName
java -cp out app.Main
```

Para ejecutar la solución del reto anterior:

```powershell
java -cp out reto.solucion.RetoSolucion
```

Para ejecutar la plantilla del curso:

```powershell
java -cp out reto.RetoRecorridos
```

La plantilla contiene métodos intencionalmente incompletos. La implementación completa del reto está en RetoSolucion.

## Operaciones y responsables

| Requisito     | Operación                                           | Clase               | Responsable | Rama            |
| ------------- | --------------------------------------------------- | ------------------- | ----------- | --------------- |
| A1            | agregar                                             | ArbolOrganizacional | Damián      | Damian_Cunalata |
| A2            | buscar                                              | ArbolOrganizacional | Damián      | Damian_Cunalata |
| A3            | mostrarJerarquia                                    | ArbolOrganizacional | Darwin      | Rama-Joel       |
| A4            | altura                                              | ArbolOrganizacional | Kenneth     | Mateo-Chalco    |
| A4            | grado y nivel                                       | ArbolOrganizacional | Luis        | Rama-Luis-Silva |
| A4            | contarHojas                                         | ArbolOrganizacional | Mónica      | Sara-Tacuri     |
| B1            | insertar                                            | ArbolEstudiantes    | Kenneth     | Mateo-Chalco    |
| B2            | buscar                                              | ArbolEstudiantes    | Kenneth     | Mateo-Chalco    |
| B3            | recorrer y trazaRecorrido                           | ArbolEstudiantes    | Darwin      | Rama-Joel       |
| B3            | Opción 14 de trazas                                 | Main                | Darwin      | Rama-Joel       |
| B4            | modificar                                           | ArbolEstudiantes    | Luis        | Rama-Luis-Silva |
| B5            | eliminar                                            | ArbolEstudiantes    | Luis        | Rama-Luis-Silva |
| Documentación | README, índices, pruebas, decisiones y facilitación | Archivos Markdown   | Jampier     | rama---Josue    |

Modificar y eliminar estudiantes son adelantos de operaciones asignadas originalmente a la Fase 3.

Cada responsable elabora los diagramas de sus métodos. Jampier actualiza los índices y la documentación general.

## Datos iniciales

El árbol organizacional contiene 88 unidades académicas.

Al iniciar el programa, el paralelo `SW-N3-B` recibe estas matrículas, en este orden:

```text
50, 30, 70, 20, 40, 60, 80, 35, 65
```

La matrícula 45 se agrega durante la demostración y no pertenece a la carga inicial.

Para insertarla, utilizar la opción 8:

| Campo     | Valor de prueba  |
| --------- | ---------------- |
| Paralelo  | SW-N3-B          |
| Matrícula | 45               |
| Cédula    | 1800000045       |
| Nombres   | Estudiante Nuevo |
| Promedio  | 9                |

Una segunda inserción de la matrícula 45 se rechaza.

## Consultas del árbol general

Estas comprobaciones utilizan los datos iniciales, sin agregar ni eliminar unidades.

| Consulta                 | Resultado                                                               | Estado                                    |
| ------------------------ | ----------------------------------------------------------------------- | ----------------------------------------- |
| Mostrar jerarquía        | 88 unidades, comenzando por UTA y con sangría de dos espacios por nivel | Verificado                                |
| Contar hojas             | 57                                                                      | Verificado mediante llamada independiente |
| Altura                   | Se esperan 4 aristas                                                    | Método pendiente en la versión revisada   |
| Grado y nivel de UTA     | Grado 10, nivel 0                                                       | Verificado                                |
| Grado y nivel de FISEI   | Grado 5, nivel 1                                                        | Verificado                                |
| Grado y nivel de SW-N3-B | Grado 0, nivel 4                                                        | Verificado                                |
| Grado y nivel de XYZ     | -1 y -1                                                                 | Verificado                                |

La raíz se encuentra en el nivel 0 y la altura se mide en aristas.

Las hojas del árbol organizacional son unidades sin hijos. Los estudiantes pertenecen al ABB asociado al paralelo y no se cuentan como hijos organizacionales.

La opción 4 evalúa altura() antes de contarHojas(). Mientras altura() siga pendiente, esta opción no alcanza a mostrar ninguno de los dos resultados.

Cuando se implemente altura(), se debe verificar la salida:

```text
[Altura y hojas] Altura: 4 | Hojas: 57
```

## Resultados del ABB

Con la matrícula 45 insertada y antes de eliminar estudiantes:

| Recorrido | Secuencia                     |
| --------- | ----------------------------- |
| Preorden  | 50 30 20 40 35 45 70 60 65 80 |
| Inorden   | 20 30 35 40 45 50 60 65 70 80 |
| Posorden  | 20 35 45 40 30 65 60 80 70 50 |

La opción 10 muestra los estudiantes completos en el orden elegido. La opción 14 muestra la traza de llamadas y la secuencia de matrículas.

Después de eliminar 20, 60 y 50, en ese orden:

```text
Inorden: 30 35 40 45 65 70 80
```

La nueva raíz del ABB es 65.

La solución del reto independiente termina con:

```text
Resultado: 20/20 pruebas OK
```

Estas pruebas del reto no completan los métodos pendientes del sistema.

## Estaciones de la Fase 2

Los grupos trabajan con una lista común de matrículas y pasan por cuatro estaciones.

| Estación | Actividad                                                    | Responsable |
| -------- | ------------------------------------------------------------ | ----------- |
| E1       | Construir el ABB y analizar una inserción adicional          | Kenneth     |
| E2       | Elaborar una traza de preorden                               | Darwin      |
| E3       | Obtener inorden y posorden y justificar el orden del inorden | Luis        |
| E4       | Identificar y corregir un error recursivo                    | Mónica      |

Cada estación tiene una duración prevista de siete minutos. La lista común y la rotación se consultan en [la organización de las estaciones](facilitacion/estaciones/README.md).

Al terminar cada estación, un integrante publica la respuesta en la columna de su grupo en el Padlet de la Fase 2.

En la copia revisada están la organización común y la estación E4. Las estaciones E1, E2 y E3 siguen pendientes de incorporación.

Jampier proyecta el Padlet, controla el tiempo de los bloques y avisa cuando faltan dos minutos.

## Complejidad

N representa la cantidad de unidades del árbol general; n, la cantidad de estudiantes; H, la altura del árbol general; y h, la altura del ABB.

| Operación                      | Tiempo                                              |
| ------------------------------ | --------------------------------------------------- |
| Buscar unidad                  | O(N)                                                |
| Agregar unidad                 | O(N) amortizado                                     |
| Consultar grado                | O(N), por la búsqueda de la unidad                  |
| Consultar nivel                | O(N)                                                |
| Contar hojas organizacionales  | O(N)                                                |
| Mostrar jerarquía              | O(N + L), donde L es la longitud del texto generado |
| Buscar estudiante              | O(h + 1)                                            |
| Insertar estudiante            | O(h + 1)                                            |
| Modificar estudiante           | O(h + 1), más la validación de los textos           |
| Eliminar estudiante            | O(h + 1)                                            |
| Preorden, inorden y posorden   | O(n)                                                |
| Generar traza                  | O(n + L), donde L es la longitud del texto generado |
| Altura en la solución del reto | O(n)                                                |

Las operaciones que siguen un camino del ABB suelen expresarse como O(h). En un árbol equilibrado ese camino es logarítmico; en uno degenerado puede llegar a O(n).

Los recorridos del ABB utilizan O(h + 1) de pila y O(n) para la lista de resultados. Las consultas recursivas del árbol general utilizan hasta O(H + 1) de pila.

La jerarquía y las trazas requieren espacio adicional para su texto. Como la sangría aumenta con la profundidad, la longitud de la salida depende también de la forma del árbol.

## Restricciones

- Las estructuras se implementan con nodos propios.
- No se utilizan TreeMap ni TreeSet.
- La inserción del ABB, las búsquedas y los recorridos utilizan recursividad.
- Las consultas de nivel y hojas del árbol general utilizan recursividad.
- Se conservan las firmas originales y la separación por capas.
- La documentación se escribe con tildes y ñ.
- Los diagramas se mantienen como archivos Markdown con Mermaid.
- Los resultados esperados se distinguen de los resultados obtenidos.

## Operaciones pendientes

### Fase 2

- altura() de ArbolOrganizacional.
- Incorporación de los diagramas de altura.
- Incorporación de las estaciones E1, E2 y E3.

### Fase 3

En ArbolOrganizacional:

- eliminar().
- transformarABinario().

En ArbolEstudiantes:

- altura().
- contar().
- menor().
- mayor().
- promedioGeneral().

En la versión revisada, las opciones 4, 6, 7 y 13 del menú encuentran métodos pendientes. Las opciones 1 y 5 ya están implementadas.

El estado debe actualizarse después de integrar y comprobar los aportes correspondientes.

## Documentación

- [Diagramas de secuencia](docs/diagramas-secuencia/README.md)
- [Diagramas de flujo](docs/diagramas-flujo/README.md)
- [Trazas de recorridos](docs/trazas_recorridos.md)
- [Trazas de inserción y eliminación](docs/trazas_insercion_eliminacion.md)
- [Casos de prueba](docs/casos_prueba.md)
- [Decisiones de implementación](docs/decisiones.md)
- [Organización de las estaciones](facilitacion/estaciones/README.md)
- [Banco de preguntas](docs/banco_preguntas.md)
- [Excel del cuestionario](docs/Quiz_Arboles_Grupo2.xlsx)
- [Enunciado del reto anterior](reto/RETO.md)
- [Presentación](presentacion/)

## Material de repaso anterior

Se conserva el cuestionario de Wayground con diez preguntas sobre fundamentos de árboles.

El banco incluye opciones, respuestas correctas y explicaciones. Las preguntas se importaron mediante una plantilla de Excel.

El código o QR de participación se comparte al abrir la sesión correspondiente. No se registra un código temporal como enlace permanente del proyecto.

Para la clase de la Fase 2 del 19 de octubre, la actividad participativa prevista son las estaciones y el Padlet.

[Volver al README principal](../README.md)
