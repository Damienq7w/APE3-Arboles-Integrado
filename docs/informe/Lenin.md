# Aporte de Lenin

## Objetivo

Revisar y comprobar los recorridos preorden, inorden y posorden del árbol binario de búsqueda de estudiantes, sus trazas y sus estadísticas. Comparar los resultados del programa con cálculos manuales en tres casos: árbol inicial, árbol vacío y árbol formado por inserciones ascendentes.

## Cambios realizados

- Se restauraron desde el ZIP base las cuatro clases incompletas que impedían compilar el proyecto: `TipoRecorrido.java`, `UnidadAcademica.java`, `NodoEstudiante.java` y `NodoUnidad.java`. Esta recuperación permitió ejecutar las pruebas; los algoritmos de recorridos y estadísticas ya estaban implementados en la base.
- Se añadió `src/pruebas/PruebasLenin.java`, un ejecutable de pruebas sin JUnit. Compara los recorridos con secuencias esperadas, revisa el orden de las líneas `VISITA`, la secuencia final, las entradas y los retornos desde `null`, y comprueba las estadísticas del árbol vacío y del árbol en cadena.
- Se actualizó únicamente `Main.mostrarRecorridosYEstadisticas(Contexto c, Scanner in)` para presentar un submenú: preorden, inorden, posorden, trazas, estadísticas y regreso al menú principal. Las consultas utilizan el árbol del mismo contexto y conservan los datos actuales.
- Se reunieron las nueve capturas de las ejecuciones realizadas por Lenin y se registraron los resultados de esta parte.

## Pruebas

### Resultados calculados manualmente

**Árbol inicial.** Orden de inserción: `30, 15, 45, 10, 20, 40, 50, 35, 55`. Los nueve estudiantes tienen promedio `8`.

- Preorden: `30, 15, 10, 20, 45, 40, 35, 50, 55`.
- Inorden: `10, 15, 20, 30, 35, 40, 45, 50, 55`.
- Posorden: `10, 20, 15, 35, 40, 55, 50, 45, 30`.
- Cantidad: `9`; altura en aristas: `3`; menor matrícula: `10`; mayor matrícula: `55`; promedio general: `8`.

**Árbol vacío.** Los tres recorridos deben devolver `[]`; la traza no debe registrar visitas. Cantidad `0`, altura `-1`, menor y mayor `null`, promedio general `0`.

**Árbol en cadena.** Orden de inserción: `10, 15, 20, 30, 35, 40, 45, 50, 55`. Los promedios respectivos son `5, 6, 7, 8, 9, 10, 6, 8, 8.5`.

- Preorden e inorden: `10, 15, 20, 30, 35, 40, 45, 50, 55`.
- Posorden: `55, 50, 45, 40, 35, 30, 20, 15, 10`.
- Cantidad: `9`; altura en aristas: `8`; menor matrícula: `10`; mayor matrícula: `55`.
- Suma de promedios: `67.5`; promedio general: `67.5 / 9 = 7.5`.

### Comparación y evidencias de ejecución

| Entrada | Esperado | Obtenido | Evidencia |
|---|---|---|---|
| Árbol inicial: inserciones `30, 15, 45, 10, 20, 40, 50, 35, 55`, todas con promedio `8`. Consulta desde la opción 3 del menú original. | Las tres secuencias iniciales detalladas arriba; cantidad `9`, altura `3`, menor `10`, mayor `55`, promedio `8`. | Las trazas muestran las tres secuencias esperadas. La salida de estadísticas indica cantidad `9`, altura `3`, menor `10`, mayor `55` y promedio `8.0`. | [Preorden](../evidencias/lenin/01_preorden_inicial.png), [inorden](../evidencias/lenin/02_inorden_inicial.png), [posorden](../evidencias/lenin/03_posorden_inicial.png) y [estadísticas](../evidencias/lenin/04_estadisticas_inicial.png). |
| Árbol vacío: `java -cp bin pruebas.PruebasLenin vacio`. | Recorridos `[]`, trazas sin visitas, cantidad `0`, altura `-1`, extremos `null`, promedio `0`. | Todas las comprobaciones muestran `[OK]`; resultado final `APROBADO`. | [Prueba del árbol vacío](../evidencias/lenin/05_arbol_vacio.png). |
| Árbol en cadena: `java -cp bin pruebas.PruebasLenin cadena`, con las matrículas y promedios detallados arriba. | Preorden e inorden ascendentes; posorden descendente; cantidad `9`, altura `8`, menor `10`, mayor `55`, promedio `7.5`. | Las secuencias, las trazas y todas las estadísticas coinciden. Cada comprobación muestra `[OK]`; resultado final `APROBADO`. | [Prueba del árbol en cadena](../evidencias/lenin/06_arbol_cadena.png). |
| Nuevo submenú: `java -cp bin app.Main`; opción principal `3`, después `5` para estadísticas y `0` para volver. | Mostrar el submenú; consultar cantidad `9`, altura `3`, menor `10`, mayor `55` y promedio `8`; volver al menú principal con `0`. | Lenin abrió el nuevo submenú, obtuvo las estadísticas esperadas y regresó al menú principal. Después de consultar las estadísticas, el submenú volvió a mostrarse. | [Apertura del submenú](../evidencias/lenin/07_submenu.png), [estadísticas desde el submenú](../evidencias/lenin/08_estadisticas_submenu.png) y [retorno al menú principal](../evidencias/lenin/09_retorno_menu.png). |

### Verificación del submenú

Después de guardar el submenú, se revisó una copia exacta del código fuente actual: compiló con compatibilidad para Java 17 y se comprobaron las tres opciones de recorrido, las tres trazas, las estadísticas iniciales, una opción inválida y el regreso con `0`. Al volver al menú principal, la consulta del estado confirmó que se conservaban los nueve estudiantes.

Esta verificación técnica se realizó sobre una copia de revisión. Por separado, Lenin ejecutó el programa y documentó la apertura del nuevo submenú, la consulta de estadísticas y el regreso al menú principal en las capturas 07, 08 y 09. Las capturas 01 a 06 corresponden a sus ejecuciones del menú original y de las pruebas de vacío y cadena.

## Dos preguntas y respuestas

**1. ¿Por qué el recorrido inorden entrega las matrículas ordenadas?**

Porque el árbol binario de búsqueda ubica las matrículas menores en el subárbol izquierdo y las mayores en el derecho. Inorden visita primero el subárbol izquierdo, después el nodo actual y finalmente el derecho. Al mantener esta propiedad en cada nodo y rechazar matrículas duplicadas, la secuencia queda en orden ascendente.

**2. ¿Por qué la altura de la cadena es `n - 1` y cómo afecta al rendimiento?**

La altura se mide en aristas: un árbol vacío tiene altura `-1` y una hoja tiene altura `0`. En una cadena de `n` nodos existe un único camino que une todos los nodos y contiene `n - 1` aristas. Por eso la cadena de nueve estudiantes tiene altura `8`. Las operaciones que siguen un camino del árbol, como buscar o insertar, cuestan `O(h)`, donde `h` es la altura; en una cadena su peor caso es `O(n)`. Un árbol de altura cercana a `log n` permite caminos más cortos. Los recorridos completos siguen costando `O(n)` porque visitan todos los nodos.

## Conclusión de esta parte

Los recorridos, las trazas y las estadísticas coincidieron con los resultados manuales en los tres casos de árbol documentados. Las pruebas de vacío y cadena terminaron con `APROBADO`. El submenú superó la verificación técnica descrita, y Lenin documentó su apertura, la consulta de estadísticas y el regreso al menú principal. El aporte conserva los algoritmos heredados y añade pruebas, acceso separado a las consultas y nueve evidencias de ejecución. El aporte individual queda preparado para su revisión e integración por el grupo.
