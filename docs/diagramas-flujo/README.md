# Diagramas de flujo

> **Responsable del índice:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Propósito

Los diagramas muestran las acciones, decisiones, validaciones y llamadas recursivas de las operaciones del Grupo 2.

Permiten identificar el caso base, el procesamiento del nodo actual y la continuación sobre los hijos o subárboles.

## Cómo leerlos

- Inicio y fin: indican los límites de la operación.
- Proceso: representa una acción o cálculo.
- Decisión: presenta una condición y sus alternativas.
- Flechas: indican el orden de ejecución.
- Llamada recursiva: invoca el método sobre un hijo o subárbol.

Una llamada recursiva regresa al punto desde donde fue invocada. El caso base detiene esa llamada; después, la ejecución continúa en la llamada anterior.

## Índice de diagramas

| Requisito o actividad | Operación                        | Responsable | Archivo                                             |
| --------------------- | -------------------------------- | ----------- | --------------------------------------------------- |
| A1 y A2               | Agregar y buscar unidades        | Damián      | [Agregar y buscar](flujo_agregar_buscar.md)         |
| A3                    | Mostrar la jerarquía             | Darwin      | [Mostrar jerarquía](flujo_mostrarJerarquia.md)      |
| A4                    | Consultar grado y nivel          | Luis        | [Grado y nivel](flujo_grado_nivel.md)               |
| A4                    | Contar hojas                     | Mónica      | [Contar hojas](flujo_contarHojas.md)                |
| B1 y B2               | Insertar y buscar estudiantes    | Kenneth     | [Insertar y buscar](flujo_insertar_buscar.md)       |
| B3                    | Recorridos recursivos y trazas   | Darwin      | [Recorridos](flujo_recorridos.md)                   |
| B4 y B5               | Modificar y eliminar estudiantes | Luis        | [Modificar y eliminar](flujo_modificar_eliminar.md) |
| Reto anterior         | Recorridos y comprobaciones      | Mónica      | [Reto](flujo_reto.md)                               |

## Diagrama pendiente de incorporación

| Requisito | Operación                            | Responsable | Archivo previsto |
| --------- | ------------------------------------ | ----------- | ---------------- |
| A4        | Calcular la altura del árbol general | Kenneth     | flujo_altura.md  |

En la copia revisada, flujo_altura.md todavía no está incorporado. Cuando se integre, se debe agregar su enlace al índice y retirar esta indicación.

## Operaciones del árbol general

Los diagramas permiten seguir:

- La búsqueda recursiva de una unidad por código.
- La comprobación de códigos repetidos antes de agregar.
- La validación del tipo de hijo permitido.
- La presentación de la jerarquía con sangría por nivel.
- La consulta del grado como cantidad de hijos directos.
- La búsqueda del nivel contando desde UTA en el nivel 0.
- El conteo recursivo de las unidades sin hijos.

El diagrama de altura deberá representar el cálculo de una altura de 0 para una hoja y de 1 más la mayor altura de los hijos para un nodo interno.

## Operaciones del ABB

Los diagramas permiten seguir:

- La comparación de matrículas para elegir un subárbol.
- El rechazo de matrículas repetidas.
- La inserción de un estudiante en una posición libre.
- Los recorridos preorden, inorden y posorden.
- La generación de trazas recursivas.
- La validación de los datos antes de modificar.
- La eliminación de un nodo hoja, con un hijo o con dos hijos.

La modificación y la eliminación del ABB son adelantos de operaciones asignadas originalmente a la Fase 3.

## Visualización

Los archivos contienen diagramas Mermaid de tipo flowchart.

Para visualizarlos, abrir el archivo correspondiente en GitHub y consultar su representación gráfica.

En el repositorio se conserva el código Mermaid. Para el informe Word se utilizan capturas de los diagramas renderizados, con su número de figura y título.

## Verificación

Antes de incorporar una figura al informe:

1. Comprobar que el diagrama se visualiza correctamente.
2. Comparar sus condiciones y resultados con el método Java.
3. Revisar el caso base y las llamadas recursivas.
4. Confirmar que las ramas de decisión conducen al resultado correspondiente.
5. Evitar presentar una operación pendiente como implementada.

[Volver al README del Grupo 2](../../README.md)
