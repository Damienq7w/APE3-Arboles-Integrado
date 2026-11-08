# Diagrama de secuencia: contarHojas

Ejemplo con una unidad que tiene dos hijos: el primero es una hoja y el segundo tiene un hijo hoja.

```mermaid
sequenceDiagram
    participant M as Menú (opción 4)
    participant A as ArbolOrganizacional
    participant R as contarHojas(nodo)

    M->>A: contarHojas()
    A->>R: contarHojas(raíz)
    Note over R: La raíz tiene hijos, total = 0
    R->>R: contarHojas(hijo 1)
    Note over R: hijo 1 no tiene hijos
    R-->>R: devuelve 1
    R->>R: contarHojas(hijo 2)
    R->>R: contarHojas(nieto)
    Note over R: nieto no tiene hijos
    R-->>R: devuelve 1
    R-->>R: devuelve 1 (hojas de hijo 2)
    R-->>A: devuelve 2 (total)
    A-->>M: Hojas: 2
```

Con los datos de prueba del repo, el mismo proceso recorre las 88 unidades y el menú muestra el total de hojas.