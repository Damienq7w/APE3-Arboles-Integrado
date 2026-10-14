# Diagrama de secuencia: agregar y buscar (arbol general)

> **Responsable:** Damian · **Rama:** `Damian_Cunalata`
>
> **Para que:** explicar como se busca recursivamente una unidad entre las 88 y como se agrega respetando codigo unico y jerarquia.
>
> Esqueleto: reemplazar cada `TODO` y borrar solo esta linea al terminar (dejar Responsable y Rama).

La flecha continua es una llamada. La flecha punteada es una respuesta. El bloque `alt` separa el camino normal de los errores. Los nombres de metodos, condiciones y mensajes deben ser los mismos del codigo.

## agregar y buscar (arbol general)

TODO: una linea que diga que operacion se muestra y con que datos (buscar "sw-n3-b" y agregar SW-N3-C bajo SW-N3).

```mermaid
sequenceDiagram
    participant Main
    participant Org as ArbolOrganizacional
    participant Nodo as NodoUnidad
    %% TODO: completar con las llamadas reales del codigo
    Main->>Org: buscar("sw-n3-b")
    alt TODO: codigo null o vacio
        Org-->>Main: null
    else TODO: codigo valido
        Org->>Org: buscar(raiz, "SW-N3-B")
        %% TODO: caso base (coincide) y llamada recursiva por cada hijo
        Org-->>Main: nodo SW-N3-B
    end

    Main->>Org: agregar("SW-N3", SW-N3-C)
    alt TODO: datos null
        Org-->>Main: false
    else TODO: codigo repetido
        Org-->>Main: false
    else TODO: padre no existe
        Org-->>Main: false
    else TODO: datos validos
        Org->>Nodo: agregarHijo(new NodoUnidad(SW-N3-C))
        alt TODO: jerarquia invalida
            Nodo-->>Org: false
            Org-->>Main: false
        else TODO: agregado
            Nodo-->>Org: true
            Org-->>Main: true
        end
    end
```

TODO: parrafo que explique el diagrama paso a paso con el ejemplo (buscar "sw-n3-b" y agregar SW-N3-C bajo SW-N3): que revisa primero, cual es el caso base, cual es la llamada recursiva, que devuelve y su complejidad.
