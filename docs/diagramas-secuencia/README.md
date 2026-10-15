# Diagramas de secuencia

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Que representan

Los diagramas de secuencia muestran el orden de las llamadas entre los participantes durante una operacion del sistema.

Permiten seguir como Main solicita una operacion, como los arboles procesan la solicitud y como los nodos proporcionan o actualizan sus datos.

## Como leerlos

- Los participantes aparecen en la parte superior.
- El tiempo avanza de arriba hacia abajo.
- La flecha continua `->>` representa una llamada.
- La flecha punteada `-->>` representa una respuesta.
- Una llamada de un participante hacia si mismo representa una llamada interna; puede ser recursiva.
- El bloque `alt` separa casos posibles y `else` introduce una alternativa.
- El bloque `loop` representa una repeticion.
- Las notas explican condiciones o resultados relevantes.

Un resultado null o false no siempre representa un error: puede indicar que un elemento no existe o que una insercion fue rechazada por duplicado.

## Indice de diagramas

| Operacion                                   | Responsable | Archivo                                                 |
| ------------------------------------------- | ----------- | ------------------------------------------------------- |
| Agregar y buscar unidades del arbol general | Damian      | [Agregar y buscar](secuencia_agregar_buscar.md)         |
| Insertar y buscar estudiantes en el ABB     | Kenneth     | [Insertar y buscar](secuencia_insertar_buscar.md)       |
| Recorridos recursivos y trazas              | Darwin      | [Recorridos](secuencia_recorridos.md)                   |
| Modificar y eliminar estudiantes            | Luis        | [Modificar y eliminar](secuencia_modificar_eliminar.md) |
| Construccion, recorridos y pruebas del reto | Monica      | [Reto](secuencia_reto.md)                               |

## Datos utilizados

Las operaciones del programa principal utilizan el paralelo SW-N3-B, con las matriculas iniciales:

50, 30, 70, 20, 40, 60, 80, 35, 65.

La matricula 45 se agrega durante la demostracion.

El reto utiliza otro conjunto independiente, correspondiente a SW-N3-A:

45, 25, 70, 10, 30, 60, 90, 27, 65.

## Visualizacion

Los archivos contienen diagramas Mermaid de tipo sequenceDiagram. Abrirlos en GitHub para visualizar su representacion grafica.

Cada diagrama incluye una explicacion de las llamadas y los resultados del ejemplo.

[Volver al README del Grupo 2](../../README.md)
