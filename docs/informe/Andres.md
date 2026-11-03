# Aporte de Andres

## Objetivo
Validar y garantizar la integridad del registro y la búsqueda de estudiantes dentro del Árbol Binario de Búsqueda (ABB) correspondiente al paralelo activo, asegurando el rechazo de matrículas duplicadas, el control de claves inválidas y la validación estricta de los datos en la entidad `Estudiante` (incluyendo el blindaje contra valores no finitos como `NaN`).

## Cambios realizados
1. **`src/modelo/Estudiante.java`:** Se actualizó el método `setPromedio(double promedio)` incorporando la validación `!Double.isFinite(promedio)` para impedir el registro de valores `NaN` o infinitos, los cuales el operador relacional tradicional dejaba pasar por el estándar IEEE 754.
2. **`src/negocio/ArbolEstudiantes.java`:** Se optimizó el método `buscar(int matricula)` añadiendo una guarda inicial para retornar `null` de inmediato si se consultan matrículas negativas o cero, manteniendo la eficiencia $O(h)$ en las operaciones recursivas.

## Pruebas
| Entrada | Esperado | Obtenido | Evidencia |
|---|---|---|---|
| Inserción válida: Matrícula `25`, CI `1801234567`, Nombre `Andres Moyota`, Prom `9.5` | Inserción aceptada en el ABB del paralelo | `true` (Estudiante registrado correctamente) | Captura local |
| Búsqueda de estudiante existente: Matrícula `35` | Retorna los datos completos del estudiante registrado | Objeto Estudiante con sus datos y promedio | Captura local |
| Inserción de matrícula duplicada: Matrícula `30` | Rechazo de la inserción sin alterar ni duplicar el nodo | `false` (Matrícula duplicada rechazada) | Captura local |
| Búsqueda de matrícula inexistente: Matrícula `99` | Retorno de `null` de forma controlada | `null` (Estudiante no encontrado) | Captura local |
| Inserción con promedio inválido: Promedio `NaN` | Excepción controlada por el modelo `Estudiante` | `IllegalArgumentException` (Promedio no válido) | Captura local |

## Dos preguntas y respuestas

**1. ¿Por qué la validación `promedio < 0 || promedio > 10` no era suficiente en `Estudiante` y permitía el ingreso de `NaN`?**  
Porque en el estándar de punto flotante IEEE 754 utilizado por Java, cualquier comparación relacional (`<`, `>`, `<=`, `>=`) que involucre a `Double.NaN` evalúa siempre a `false`. Al comprobar `NaN < 0` (`false`) y `NaN > 10` (`false`), el flujo ignoraba el error y permitía almacenar el estado `NaN`, corrompiendo posteriormente el cálculo del promedio general. La función `Double.isFinite(promedio)` soluciona este problema al detectar correctamente cualquier valor no numérico o infinito.

**2. ¿Cómo se comporta la complejidad temporal en las operaciones de inserción y búsqueda del ABB a tu cargo?**  
Ambas operaciones se implementaron de forma recursiva con una complejidad de tiempo de $O(h)$, donde $h$ es la altura del árbol binario de búsqueda. En el peor de los casos (si el árbol se desbalancea como una lista enlazada), la altura equivale a $n - 1$ ($O(n)$); sin embargo, con una distribución equilibrada de las claves, la altura se reduce logarítmicamente a $O(\log n)$, descartando la mitad de las ramas en cada paso recursivo.

## Conclusion de esta parte
Las modificaciones implementadas aseguran que la estructura de datos del ABB procese de manera robusta las inserciones y búsquedas de estudiantes. El control estricto de duplicados y la validación matemática de los atributos en la entidad `Estudiante` evitan la propagación de datos corruptos hacia las capas estadísticas y de reportes del sistema.