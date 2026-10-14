# Diagrama de secuencia: modificar y eliminar (ABB)

> **Responsable:** Luis · **Rama:** `Rama-Luis-Silva`
>
> **Para que:** explicar que modificar no toca la matricula y los 3 casos de eliminacion.
>
> Esqueleto: reemplazar cada `TODO` y borrar solo esta linea al terminar (dejar Responsable y Rama).

La flecha continua es una llamada. La flecha punteada es una respuesta. El bloque `alt` separa el camino normal de los errores. Los nombres de metodos, condiciones y mensajes deben ser los mismos del codigo.

## modificar y eliminar (ABB)

TODO: una linea que diga que operacion se muestra y con que datos (modificar el 45; eliminar 20, 60 y 50 en secuencia).

```mermaid
sequenceDiagram
    participant Main
    participant ABB as ArbolEstudiantes
    participant Est as Estudiante
    participant Nodo as NodoEstudiante
    %% TODO: completar con las llamadas reales del codigo
    Main->>ABB: modificar(45, cedula, nombres, promedio)
    ABB->>ABB: buscarNodo(raiz, 45)
    alt TODO: no existe
        ABB-->>Main: false
    else TODO: datos invalidos
        ABB->>Est: new Estudiante(45, cedula, nombres, promedio)
        Est-->>Main: IllegalArgumentException
    else TODO: modificado
        ABB->>Est: TODO setCedula / setNombres / setPromedio
        ABB-->>Main: true
    end

    Note over Main,ABB: m = 20 (hoja), luego 60 (un hijo), luego 50 (dos hijos)
    Main->>ABB: eliminar(m)
    ABB->>ABB: buscarNodo(raiz, m)
    alt TODO: no existe
        ABB-->>Main: false
    else TODO: existe
        ABB->>ABB: eliminar(raiz, m)
        alt TODO: hoja
            ABB-->>ABB: null
        else TODO: un hijo
            ABB-->>ABB: ese hijo
        else TODO: dos hijos (sucesor inorden)
            ABB->>ABB: menorNodo(nodo.derecho)
            ABB->>Nodo: setDato(sucesor)
            ABB->>ABB: eliminar(nodo.derecho, sucesor)
        end
        ABB-->>Main: true
    end
```

TODO: parrafo que explique el diagrama paso a paso con el ejemplo (modificar el 45; eliminar 20, 60 y 50 en secuencia): que revisa primero, cual es el caso base, cual es la llamada recursiva, que devuelve y su complejidad.
