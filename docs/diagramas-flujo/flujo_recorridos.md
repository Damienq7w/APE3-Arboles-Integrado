# Diagramas de flujo: recorridos y traza (ABB de estudiantes)

> **Responsable:** Darwin · **Rama:** `Rama-Joel`
>
> **Para que:** mostrar las decisiones de recorrer (preorden, inorden y posorden recursivos) y de trazaRecorrido (traza con sangria por nivel).

Un diagrama de flujo recorre las decisiones de un metodo, de la entrada hasta el valor que devuelve. Cada diagrama sigue el codigo de `src/negocio/ArbolEstudiantes.java`: las mismas condiciones y los mismos resultados.

Convencion de formas (igual que el Grupo 1): inicio y fin en rectangulo redondeado, proceso en rectangulo, decision en rombo, error en rectangulo rojo. La llamada recursiva es un paso explicito, no un ciclo de regreso al inicio. En `recorrer` y `trazaRecorrido` el rectangulo rojo es la `IllegalArgumentException` cuando el tipo es null.

## Indice

| Metodo | Clase | Capa | Archivo fuente |
|---|---|---|---|
| [recorrer(tipo)](#recorrer) | `ArbolEstudiantes` | negocio | `src/negocio/ArbolEstudiantes.java` |
| [preorden(nodo, lista)](#preorden) | `ArbolEstudiantes` | negocio | `src/negocio/ArbolEstudiantes.java` |
| [trazaRecorrido(tipo)](#traza) | `ArbolEstudiantes` | negocio | `src/negocio/ArbolEstudiantes.java` |

## Capa negocio, clase ArbolEstudiantes

<a id="recorrer"></a>

### Metodo recorrer(tipo)
Paquete principal: SJA-UTA | Capa: negocio | Paquete: negocio | Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `public List<Estudiante> recorrer(TipoRecorrido tipo)`

```mermaid
flowchart TD
    classDef fallo fill:#fde8e8,stroke:#b42318,color:#7a1212
    A(["ArbolEstudiantes.recorrer(tipo)"]) --> B{"tipo == null"}
    B -- Si --> C["lanza IllegalArgumentException"]:::fallo
    B -- No --> D["lista = new ArrayList()"]
    D --> E{"que tipo es"}
    E -- PREORDEN --> F["llamar a preorden(raiz, lista)"]
    E -- INORDEN --> G["llamar a inorden(raiz, lista)"]
    E -- POSORDEN --> H["llamar a posorden(raiz, lista)"]
    F --> I(["devuelve lista"])
    G --> I
    H --> I
```

El metodo publico valida el tipo: si es null lanza `IllegalArgumentException`. Si no, crea una lista vacia y delega en el metodo recursivo que corresponde, empezando desde la raiz. Si el arbol esta vacio, la raiz es null, el recorrido no agrega nada y devuelve la lista vacia, nunca null. Cada nodo se visita una sola vez: O(n).

Ejemplo: `recorrer(INORDEN)` en el paralelo `SW-N3-B` devuelve los estudiantes ordenados por matricula.

<a id="preorden"></a>

### Metodo preorden(nodo, lista)
Paquete principal: SJA-UTA | Capa: negocio | Paquete: negocio | Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `private void preorden(NodoEstudiante nodo, List<Estudiante> lista)`

```mermaid
flowchart TD
    A(["preorden(nodo, lista)"]) --> B{"nodo == null"}
    B -- Si --> C(["regresa: caso base"])
    B -- No --> D["lista.add(nodo.getDato()): visita"]
    D --> E["llamar a preorden(nodo.getIzquierdo(), lista)"]
    E --> F["llamar a preorden(nodo.getDerecho(), lista)"]
    F --> G(["regresa"])
```

Cada llamada pregunta si el nodo es null; si lo es, ese es el **caso base** y regresa sin hacer nada. Si no, visita el nodo (lo agrega a la lista) y se llama a si misma con el hijo izquierdo y luego con el derecho (**caso recursivo**). En `inorden` la visita va entre las dos llamadas y en `posorden` despues de ambas; el resto del diagrama es igual.

Ejemplo: con raiz 50, preorden visita 50, baja por la izquierda (30, 20, 40, 35, 45) y despues por la derecha (70, 60, 65, 80).

<a id="traza"></a>

### Metodo trazaRecorrido(tipo)
Paquete principal: SJA-UTA | Capa: negocio | Paquete: negocio | Clase: ArbolEstudiantes | Archivo: src/negocio/ArbolEstudiantes.java

Firma: `public String trazaRecorrido(TipoRecorrido tipo)`

```mermaid
flowchart TD
    classDef fallo fill:#fde8e8,stroke:#b42318,color:#7a1212
    A(["ArbolEstudiantes.trazaRecorrido(tipo)"]) --> B{"tipo == null"}
    B -- Si --> C["lanza IllegalArgumentException"]:::fallo
    B -- No --> D["crear traza y secuencia vacias"]
    D --> E["llamar a traza(raiz, tipo, 0, traza, secuencia)"]
    E --> F{"nodo == null"}
    F -- Si --> G["agrega 'null -> regresa' y regresa: caso base"]
    F -- No --> H["agrega 'entra matricula'"]
    H --> I{"tipo es PREORDEN"}
    I -- Si --> J["VISITA matricula"]
    I -- No --> K["llamar a traza(izquierdo, nivel + 1)"]
    J --> K
    K --> L{"tipo es INORDEN"}
    L -- Si --> M["VISITA matricula"]
    L -- No --> N["llamar a traza(derecho, nivel + 1)"]
    M --> N
    N --> O{"tipo es POSORDEN"}
    O -- Si --> P["VISITA matricula"]
    O -- No --> Q["agrega 'Secuencia TIPO: matriculas'"]
    P --> Q
    G --> Q
    Q --> R(["devuelve el texto de la traza"])
```

`trazaRecorrido` valida el tipo y arma el texto con un `StringBuilder`. El metodo privado `traza` hace el mismo recorrido recursivo, pero escribe una linea por paso con dos espacios de sangria por cada nivel: `entra`, `null -> regresa` en el caso base y `VISITA` en el momento que corresponde al tipo (antes de los hijos en preorden, entre ellos en inorden, despues en posorden). Al final agrega la linea `Secuencia <TIPO>: ...` solo con matriculas. Es la evidencia de los recorridos. Complejidad O(n).

Ejemplo: `SW-N3-B` con `PREORDEN` termina en `Secuencia PREORDEN: 50 30 20 40 35 45 70 60 65 80`.