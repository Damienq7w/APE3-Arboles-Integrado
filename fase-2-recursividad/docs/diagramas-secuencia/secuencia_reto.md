# Diagrama de secuencia: reto de recorridos (SW-N3-A)

> **Responsable:** Monica · **Rama:** `Sara-Tacuri`
>
> **Para que:** explicar como el reto construye el ABB del paralelo SW-N3-A, lo recorre con traza y comprueba los resultados con [OK] o [FALLA].

Un diagrama de secuencia muestra el orden de las llamadas entre objetos durante una operacion. La flecha continua es una llamada. La flecha punteada es una respuesta. El bloque `alt` separa los casos posibles. Los nombres de metodos, condiciones y mensajes son los mismos del codigo.

## Paquete reto.solucion

### Construir el ABB de SW-N3-A

`RetoSolucion` inserta las matriculas 45, 25, 70, 10, 30, 60, 90, 27, 65 con su propio `insertar`, sin usar `ArbolEstudiantes`.

```mermaid
sequenceDiagram
    participant Reto as RetoSolucion
    participant Nodo as NodoEstudiante

    Reto->>Reto: construir([45, 25, 70, 10, 30, 60, 90, 27, 65])
    Reto->>Reto: insertar(raiz = null, 45)
    Reto->>Nodo: new NodoEstudiante(Estudiante 45)
    Nodo-->>Reto: nodo 45 (raiz)
    Reto->>Reto: insertar(raiz, 25)
    Reto->>Nodo: getDato().getMatricula()
    Nodo-->>Reto: 45
    alt 25 < 45
        Reto->>Reto: insertar(izquierdo = null, 25)
        Reto->>Nodo: new NodoEstudiante(Estudiante 25)
        Nodo-->>Reto: nodo 25
        Reto->>Nodo: setIzquierdo(nodo 25)
    else 25 > 45
        Reto->>Nodo: setDerecho(...)
    else 25 == 45 (repetido)
        Note over Reto: se ignora, no se crea nodo
    end
    Note over Reto: igual con 70, 10, 30, 60, 90, 27 y 65
    Reto-->>Reto: raiz 45
```

`insertar` es recursivo. Si el nodo es `null` crea el `NodoEstudiante` (**caso base**: lugar libre). Si la matricula es menor, baja por la izquierda; si es mayor, por la derecha (**caso recursivo**), y engancha el resultado con `setIzquierdo` o `setDerecho`. Si la matricula ya existe no hace nada, por eso en el caso repetido (20, 30, 30, 10) el segundo 30 se ignora. Con el orden del reto el 45 queda de raiz, el 25 y el 70 son sus hijos, el 10 y el 30 cuelgan del 25, el 27 del 30, el 60 y el 90 del 70, y el 65 del 60.

### Traza del inorden (la que se muestra en la expo)

`main` activa `conTraza`, ejecuta el inorden del arbol del reto y la desactiva.

```mermaid
sequenceDiagram
    participant Main as main
    participant Reto as RetoSolucion
    participant Nodo as NodoEstudiante

    Main->>Reto: conTraza = true
    Main->>Reto: inorden(raiz 45, "", demo)
    alt nodo == null
        Reto-->>Main: traza "null -> regresa"
    else nodo existe
        Reto->>Nodo: getDato().getMatricula()
        Nodo-->>Reto: 45
        Note over Reto: traza "entra 45"
        Reto->>Nodo: getIzquierdo()
        Nodo-->>Reto: nodo 25
        Reto->>Reto: inorden(25, "  ", demo)
        Note right of Reto: baja por 10, sus dos null, y vuelve
        Note over Reto: traza "VISITA 45" y demo.append(45)
        Reto->>Nodo: getDerecho()
        Nodo-->>Reto: nodo 70
        Reto->>Reto: inorden(70, "  ", demo)
    end
    Main->>Reto: conTraza = false
    Note over Reto: demo = 10 25 27 30 45 60 65 70 90
```

`inorden` primero baja por el hijo izquierdo, despues visita el nodo y al final baja por el derecho. La `sangria` crece 2 espacios por nivel, asi la traza se lee como la pila de llamadas. Cuando llega a un `null` escribe `null -> regresa` y vuelve al nodo anterior (**caso base**). `preorden` y `posorden` son iguales y solo cambian el lugar de la visita. Con el arbol del reto las secuencias son: preorden 45 25 10 30 27 70 60 65 90, inorden 10 25 27 30 45 60 65 70 90 (ordenado por matricula) y posorden 10 27 30 25 65 60 90 70 45. Cada nodo se visita una vez: **O(n)**.

### Pruebas

```mermaid
sequenceDiagram
    participant Main as main
    participant Reto as RetoSolucion

    Main->>Reto: probar("Reto SW-N3-A", matriculas, pre, in, pos, 3)
    Reto->>Reto: construir(matriculas)
    Reto->>Reto: preorden, inorden y posorden (con salida)
    Reto->>Reto: altura(raiz)
    loop preorden, inorden, posorden y altura
        Reto->>Reto: comprobar(nombre, obtenido, esperado)
        alt obtenido.equals(esperado)
            Reto-->>Main: [OK] y pasadas++
        else son distintos
            Reto-->>Main: [FALLA] con obtuvo y esperaba
        end
    end
    Note over Main: igual con Vacio, Un nodo, Cadena y Repetido
    Main->>Main: imprime "Resultado: 20/20 pruebas OK"
```

`probar` arma el arbol, corre los tres recorridos y la altura, y por cada resultado llama a `comprobar`, que suma al `total` y marca `[OK]` o `[FALLA]`. Los casos limite son: arbol vacio (secuencias vacias y altura -1), un solo nodo (50, altura 0), la cadena 10, 20, 30, 40 (todo hacia la derecha: preorden e inorden iguales, posorden al reves, 40 30 20 10, altura 3) y el repetido 20, 30, 30, 10 (el segundo 30 se ignora: preorden 20 10 30 y altura 1). Son 5 casos con 4 comprobaciones cada uno y todas pasan: `Resultado: 20/20 pruebas OK`.
