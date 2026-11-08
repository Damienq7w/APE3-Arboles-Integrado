# Diagramas de secuencia

> **Responsable del índice:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Propósito

Los diagramas muestran el orden de las llamadas entre los participantes durante una operación del sistema.

Permiten seguir cómo Main solicita una operación, cómo los árboles procesan la solicitud y cómo los nodos proporcionan o actualizan sus datos.

## Cómo leerlos

- Los participantes aparecen en la parte superior.
- El tiempo avanza de arriba hacia abajo.
- La flecha continua ->> representa una llamada.
- La flecha punteada -->> representa una respuesta.
- Una llamada hacia el mismo participante representa una llamada interna; puede ser recursiva.
- El bloque alt separa casos posibles y else introduce una alternativa.
- El bloque loop representa una repetición.
- Las notas explican condiciones o resultados relevantes.

Un resultado null o false no siempre representa un error: puede indicar que un elemento no existe o que una inserción fue rechazada.

## Índice de diagramas

| Requisito o actividad | Operación                                 | Responsable | Archivo                                                 |
| --------------------- | ----------------------------------------- | ----------- | ------------------------------------------------------- |
| A1 y A2               | Agregar y buscar unidades                 | Damián      | [Agregar y buscar](secuencia_agregar_buscar.md)         |
| A3                    | Mostrar la jerarquía                      | Darwin      | [Mostrar jerarquía](secuencia_mostrarJerarquia.md)      |
| A4                    | Consultar grado y nivel                   | Luis        | [Grado y nivel](secuencia_grado_nivel.md)               |
| A4                    | Contar hojas                              | Mónica      | [Contar hojas](secuencia_contarHojas.md)                |
| B1 y B2               | Insertar y buscar estudiantes             | Kenneth     | [Insertar y buscar](secuencia_insertar_buscar.md)       |
| B3                    | Recorridos recursivos y trazas            | Darwin      | [Recorridos](secuencia_recorridos.md)                   |
| B4 y B5               | Modificar y eliminar estudiantes          | Luis        | [Modificar y eliminar](secuencia_modificar_eliminar.md) |
| Reto anterior         | Construcción, recorridos y comprobaciones | Mónica      | [Reto](secuencia_reto.md)                               |

## Diagrama pendiente de incorporación

| Requisito | Operación                            | Responsable | Archivo previsto    |
| --------- | ------------------------------------ | ----------- | ------------------- |
| A4        | Calcular la altura del árbol general | Kenneth     | secuencia_altura.md |

En la copia revisada, secuencia_altura.md todavía no está incorporado. Cuando se integre, se debe agregar su enlace al índice y retirar esta indicación.

## Consultas del árbol general

Los diagramas incorporados en esta fase muestran:

- mostrarJerarquia(): construcción del texto con sangría y llamadas sobre cada hijo.
- grado(): búsqueda de la unidad y consulta de la cantidad de hijos directos.
- nivel(): búsqueda recursiva acumulando la profundidad desde UTA en el nivel 0.
- contarHojas(): retorno de 1 para una hoja y suma de los resultados de los hijos para un nodo interno.

El diagrama de altura deberá mostrar cómo cada llamada devuelve la altura del subárbol y cómo el padre selecciona la mayor.

## Datos utilizados

Las operaciones del ABB del programa principal utilizan el paralelo SW-N3-B, con las matrículas iniciales:

50, 30, 70, 20, 40, 60, 80, 35 y 65.

La matrícula 45 se agrega durante la demostración.

Las eliminaciones se realizan en este orden: 20, 60 y 50. Con ese orden, el sucesor utilizado al eliminar 50 es 65.

El reto anterior utiliza un conjunto independiente, correspondiente a SW-N3-A:

45, 25, 70, 10, 30, 60, 90, 27 y 65.

Las estaciones de la Fase 2 utilizan su propia lista común, disponible en [la organización de las estaciones](../../facilitacion/estaciones/README.md).

## Visualización

Los archivos contienen diagramas Mermaid de tipo sequenceDiagram.

Para visualizarlos, abrir el archivo correspondiente en GitHub y consultar su representación gráfica.

En el repositorio se conserva el código Mermaid. Para el informe Word se utilizan capturas de los diagramas renderizados, con su número de figura y título.

## Verificación

Antes de incorporar una figura al informe:

1. Confirmar que los participantes corresponden a las clases del proyecto.
2. Comparar las llamadas y sus parámetros con el código Java.
3. Revisar los casos base y los retornos de las llamadas recursivas.
4. Comprobar que las alternativas representan las condiciones del método.
5. Distinguir las operaciones implementadas de las pendientes.

[Volver al README del Grupo 2](../../README.md)
