# Trazas de recorridos

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Datos utilizados

Salidas verificadas de la opcion 14 de Main sobre el paralelo SW-N3-B.

Se cargaron las matriculas iniciales:

50, 30, 70, 20, 40, 60, 80, 35, 65.

Despues se inserto la matricula 45. No se realizaron eliminaciones entre los tres recorridos.

Para reproducir cada traza, seleccionar la opcion 14, ingresar SW-N3-B y escribir PREORDEN, INORDEN o POSORDEN.

## Preorden

Orden: nodo, subarbol izquierdo y subarbol derecho.

```text
entra 50
VISITA 50
  entra 30
  VISITA 30
    entra 20
    VISITA 20
      null -> regresa
      null -> regresa
    entra 40
    VISITA 40
      entra 35
      VISITA 35
        null -> regresa
        null -> regresa
      entra 45
      VISITA 45
        null -> regresa
        null -> regresa
  entra 70
  VISITA 70
    entra 60
    VISITA 60
      null -> regresa
      entra 65
      VISITA 65
        null -> regresa
        null -> regresa
    entra 80
    VISITA 80
      null -> regresa
      null -> regresa
Secuencia PREORDEN: 50 30 20 40 35 45 70 60 65 80
```

## Inorden

Orden: subarbol izquierdo, nodo y subarbol derecho.

```text
entra 50
  entra 30
    entra 20
      null -> regresa
    VISITA 20
      null -> regresa
  VISITA 30
    entra 40
      entra 35
        null -> regresa
      VISITA 35
        null -> regresa
    VISITA 40
      entra 45
        null -> regresa
      VISITA 45
        null -> regresa
VISITA 50
  entra 70
    entra 60
      null -> regresa
    VISITA 60
      entra 65
        null -> regresa
      VISITA 65
        null -> regresa
  VISITA 70
    entra 80
      null -> regresa
    VISITA 80
      null -> regresa
Secuencia INORDEN: 20 30 35 40 45 50 60 65 70 80
```

## Posorden

Orden: subarbol izquierdo, subarbol derecho y nodo.

```text
entra 50
  entra 30
    entra 20
      null -> regresa
      null -> regresa
    VISITA 20
    entra 40
      entra 35
        null -> regresa
        null -> regresa
      VISITA 35
      entra 45
        null -> regresa
        null -> regresa
      VISITA 45
    VISITA 40
  VISITA 30
  entra 70
    entra 60
      null -> regresa
      entra 65
        null -> regresa
        null -> regresa
      VISITA 65
    VISITA 60
    entra 80
      null -> regresa
      null -> regresa
    VISITA 80
  VISITA 70
VISITA 50
Secuencia POSORDEN: 20 35 45 40 30 65 60 80 70 50
```

## Interpretacion de las trazas

- entra: comienza una llamada con un nodo existente.
- null -> regresa: se alcanza el caso base y la llamada termina.
- VISITA: se agrega la matricula a la secuencia.
- Sangria: aumenta dos espacios por nivel y permite seguir la profundidad de las llamadas.

Lo que cambia entre los recorridos es el momento de VISITA: antes de los hijos en preorden, entre ambos en inorden y despues de ambos en posorden.

El inorden produce matriculas ascendentes porque se trabaja con un arbol binario de busqueda ordenado por matricula. Un arbol binario sin ese criterio de orden no garantiza este resultado.

La opcion 10 muestra los estudiantes completos en el orden elegido; la opcion 14 muestra las llamadas y la secuencia final de matriculas.

[Volver al README del Grupo 2](../README.md)
