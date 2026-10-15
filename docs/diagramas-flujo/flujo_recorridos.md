# Flujo de recorridos

Firma: `public List<Estudiante> recorrer(TipoRecorrido tipo)`

```mermaid
flowchart TD
    A([Inicio recorrer tipo]) --> B{tipo es null?}
    B -- Si --> E[/IllegalArgumentException/]
    B -- No --> C[Crear lista ArrayList vacia]
    C --> D{Que tipo es?}
    D -- PREORDEN --> P[preorden raiz, lista]
    D -- INORDEN --> I[inorden raiz, lista]
    D -- POSORDEN --> S[posorden raiz, lista]
    P --> N{nodo == null?}
    I --> N
    S --> N
    N -- Si caso base --> R[Regresa sin agregar]
    N -- No --> V[Visita: agrega nodo.getDato a la lista]
    V --> L[Llamada recursiva al hijo izquierdo]
    L --> RD[Llamada recursiva al hijo derecho]
    RD --> F([Fin: devuelve la lista])
    R --> F

    style E fill:#f8d7da,stroke:#c0392b,color:#7b1f17
```

El metodo `recorrer` valida el tipo: si es `null` lanza `IllegalArgumentException`. Luego crea una lista vacia y llama al metodo recursivo segun el tipo. Cada llamada termina en el caso base `nodo == null`. En preorden la visita va antes de las llamadas a los hijos, en inorden entre ellas y en posorden despues. Si el arbol esta vacio devuelve la lista vacia, nunca `null`. Cada nodo se visita una vez, por eso la complejidad es O(n).
