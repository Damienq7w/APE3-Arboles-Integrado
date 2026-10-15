# Diagramas de flujo

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Que representan

Los diagramas de flujo muestran las acciones y decisiones de los metodos implementados por el Grupo 2.

Permiten identificar las validaciones, los casos base, las llamadas recursivas y los resultados de cada operacion.

## Como leerlos

- Inicio y fin: formas redondeadas.
- Proceso: rectangulo.
- Decision: rombo con sus alternativas.
- Error o prueba fallida: rectangulo rojo.
- Flechas: orden de ejecucion.
- Llamada recursiva: paso explicito que invoca el metodo con un subproblema.

Una llamada recursiva regresa al punto desde donde fue invocada. No debe interpretarse como reiniciar todo el programa.

El caso base detiene la recursion. El caso recursivo continua con un hijo o subarbol.

## Indice de diagramas

| Operacion                                   | Responsable | Archivo                                             |
| ------------------------------------------- | ----------- | --------------------------------------------------- |
| Agregar y buscar unidades del arbol general | Damian      | [Agregar y buscar](flujo_agregar_buscar.md)         |
| Insertar y buscar estudiantes en el ABB     | Kenneth     | [Insertar y buscar](flujo_insertar_buscar.md)       |
| Recorridos recursivos y trazas              | Darwin      | [Recorridos](flujo_recorridos.md)                   |
| Modificar y eliminar estudiantes            | Luis        | [Modificar y eliminar](flujo_modificar_eliminar.md) |
| Recorridos y pruebas del reto               | Monica      | [Reto](flujo_reto.md)                               |

## Casos representados

Los diagramas permiten seguir operaciones como:

- Buscar una unidad y comprobar si existe.
- Rechazar codigos o matriculas repetidas.
- Insertar un estudiante en una posicion libre.
- Recorrer los subarboles hasta llegar al caso base.
- Validar los datos antes de modificar un estudiante.
- Eliminar un nodo hoja, con un hijo o con dos hijos.
- Comparar resultados del reto y mostrar OK o FALLA.

## Visualizacion

Los archivos contienen diagramas Mermaid de tipo flowchart. Abrirlos en GitHub para visualizar su representacion grafica.

Cada archivo incluye las firmas de los metodos y una explicacion relacionada con los datos de la exposicion.

[Volver al README del Grupo 2](../../README.md)
