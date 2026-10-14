# Diagramas de flujo: recorridos y traza (ABB)

> **Responsable:** Darwin · **Rama:** `Rama-Joel`
>
> **Para que:** mostrar que pre, in y pos tienen la misma forma y solo cambia el momento de visitar.
>
> Esqueleto: reemplazar cada `TODO` y borrar solo esta linea al terminar (dejar Responsable y Rama).

Convencion de formas (igual que el Grupo 1): inicio y fin en rectangulo redondeado, proceso en rectangulo, decision en rombo, error en rectangulo rojo. La llamada recursiva es un paso explicito, no un ciclo de regreso al inicio.

## Metodo recorrer(tipo)
Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `public List<Estudiante> recorrer(TipoRecorrido tipo)`

```mermaid
flowchart TD
    A([Inicio: recorrer]) --> B{TODO: tipo null?}
    B -- Si --> ERR[IllegalArgumentException]:::error
    B -- No --> C[TODO: crear lista]
    C --> D{TODO: que tipo?}
    D -- PREORDEN --> E[TODO: preorden raiz]
    D -- INORDEN --> F[TODO: inorden raiz]
    D -- POSORDEN --> G[TODO: posorden raiz]
    E --> Z([Devuelve la lista])
    F --> Z
    G --> Z
    classDef error fill:#f8d7da,stroke:#c0392b,color:#7b1d1d
```

TODO: parrafo que recorra el diagrama con el ejemplo (PREORDEN en SW-N3-B): que decide primero, cual es el caso base, donde esta la llamada recursiva y que devuelve.

## Metodo preorden(nodo, lista)
Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `private void preorden(NodoEstudiante nodo, List<Estudiante> lista)`

```mermaid
flowchart TD
    A([Inicio: preorden nodo]) --> B{TODO: nodo null?}
    B -- Si --> C([Regresa: caso base])
    B -- No --> D[TODO: visitar el nodo]
    D --> E[TODO: llamada recursiva izquierda]
    E --> F[TODO: llamada recursiva derecha]
    F --> G([Fin])
```

TODO: parrafo que recorra el diagrama con el ejemplo (50 30 20 40 35 45 70 60 65 80): que decide primero, cual es el caso base, donde esta la llamada recursiva y que devuelve.

## Metodo trazaRecorrido(tipo)
Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `public String trazaRecorrido(TipoRecorrido tipo)`

```mermaid
flowchart TD
    A([Inicio: trazaRecorrido]) --> B{TODO: tipo null?}
    B -- No --> C[TODO: traza raiz con nivel 0]
    C --> D([TODO: devuelve el texto con la secuencia])
```

TODO: parrafo que recorra el diagrama con el ejemplo (opcion 14 con PREORDEN): que decide primero, cual es el caso base, donde esta la llamada recursiva y que devuelve.

