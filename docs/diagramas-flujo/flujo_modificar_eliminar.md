# Diagramas de flujo: modificar y eliminar (ABB)

> **Responsable:** Luis · **Rama:** `Rama-Luis-Silva`
>
> **Para que:** mostrar las decisiones de modificar y los 3 casos de eliminar.
>
> Esqueleto: reemplazar cada `TODO` y borrar solo esta linea al terminar (dejar Responsable y Rama).

Convencion de formas (igual que el Grupo 1): inicio y fin en rectangulo redondeado, proceso en rectangulo, decision en rombo, error en rectangulo rojo. La llamada recursiva es un paso explicito, no un ciclo de regreso al inicio.

## Metodo modificar(matricula, cedula, nombres, promedio)
Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `public boolean modificar(int matricula, String cedula, String nombres, double promedio)`

```mermaid
flowchart TD
    A([Inicio: modificar]) --> B{TODO: existe la matricula?}
    B -- No --> X([Devuelve false])
    B -- Si --> C{TODO: datos validos?}
    C -- No --> ERR[IllegalArgumentException]:::error
    C -- Si --> D[TODO: cambiar cedula, nombres y promedio]
    D --> Z([Devuelve true])
    classDef error fill:#f8d7da,stroke:#c0392b,color:#7b1d1d
```

TODO: parrafo que recorra el diagrama con el ejemplo (modificar el 45): que decide primero, cual es el caso base, donde esta la llamada recursiva y que devuelve.

## Metodo eliminar(matricula)
Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `public boolean eliminar(int matricula)`

```mermaid
flowchart TD
    A([Inicio: eliminar]) --> B{TODO: existe la matricula?}
    B -- No --> X([Devuelve false])
    B -- Si --> C{TODO: es hoja?}
    C -- Si --> D[TODO: caso 1]
    C -- No --> E{TODO: tiene un solo hijo?}
    E -- Si --> F[TODO: caso 2]
    E -- No --> G[TODO: caso 3: sucesor inorden]
    D --> Z([Devuelve true])
    F --> Z
    G --> Z
```

TODO: parrafo que recorra el diagrama con el ejemplo (eliminar 20, 60 y 50): que decide primero, cual es el caso base, donde esta la llamada recursiva y que devuelve.

