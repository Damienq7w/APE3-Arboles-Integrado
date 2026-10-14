# Diagramas de flujo: insertar y buscar (ABB)

> **Responsable:** Kenneth · **Rama:** `Mateo-Chalco`
>
> **Para que:** mostrar como insertar decide izquierda o derecha hasta llegar al lugar libre.
>
> Esqueleto: reemplazar cada `TODO` y borrar solo esta linea al terminar (dejar Responsable y Rama).

Convencion de formas (igual que el Grupo 1): inicio y fin en rectangulo redondeado, proceso en rectangulo, decision en rombo, error en rectangulo rojo. La llamada recursiva es un paso explicito, no un ciclo de regreso al inicio.

## Metodo insertar(estudiante)
Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `public boolean insertar(Estudiante estudiante)`

```mermaid
flowchart TD
    A([Inicio: insertar]) --> B{TODO: estudiante null?}
    B -- Si --> ERR[IllegalArgumentException]:::error
    B -- No --> C{TODO: matricula repetida?}
    C -- Si --> X([Devuelve false])
    C -- No --> D{TODO: nodo null?}
    D -- Si --> E[TODO: crear nodo: caso base]
    D -- No --> F{TODO: menor que el nodo?}
    F -- Si --> G[TODO: llamada recursiva por la izquierda]
    F -- No --> H[TODO: llamada recursiva por la derecha]
    E --> Z([Devuelve true])
    G --> Z
    H --> Z
    classDef error fill:#f8d7da,stroke:#c0392b,color:#7b1d1d
```

TODO: parrafo que recorra el diagrama con el ejemplo (insertar 45 en SW-N3-B): que decide primero, cual es el caso base, donde esta la llamada recursiva y que devuelve.

## Metodo buscar(matricula)
Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `public Estudiante buscar(int matricula)`

```mermaid
flowchart TD
    A([Inicio: buscar matricula]) --> B{TODO: nodo null?}
    B -- Si --> C([Devuelve null])
    B -- No --> D{TODO: coincide?}
    D -- Si --> E([Devuelve el estudiante])
    D -- No --> F[TODO: llamada recursiva por el lado correcto]
```

TODO: parrafo que recorra el diagrama con el ejemplo (buscar 99): que decide primero, cual es el caso base, donde esta la llamada recursiva y que devuelve.

