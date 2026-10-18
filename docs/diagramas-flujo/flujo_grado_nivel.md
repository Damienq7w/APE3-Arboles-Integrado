# Diagramas de flujo: grado y nivel (árbol general)

> **Responsable:** Luis · **Rama:** `Rama-Luis-Silva`
>
> **Para qué:** mostrar cómo se obtiene el grado (cantidad de hijos) y el nivel (distancia a la raíz) de una unidad.

Cada diagrama sigue el código de `src/negocio/ArbolOrganizacional.java`: las mismas condiciones y los mismos resultados.

Convención de formas (igual que el Grupo 1): inicio y fin en rectángulo redondeado, proceso en rectángulo, decisión en rombo, error en rectángulo rojo. La llamada recursiva es un paso explícito, no un ciclo de regreso al inicio. Aquí el rojo es el resultado `-1`, porque estos métodos no lanzan excepciones: si el código no existe, devuelven `-1`.

## Índice

| Método | Clase | Capa | Archivo fuente |
|---|---|---|---|
| [grado(codigo)](#grado) | `ArbolOrganizacional` | negocio | `src/negocio/ArbolOrganizacional.java` |
| [nivel(codigo)](#nivel) | `ArbolOrganizacional` | negocio | `src/negocio/ArbolOrganizacional.java` |
| [nivel(nodo, codigo, profundidad)](#nivelNodo) | `ArbolOrganizacional` | negocio | `src/negocio/ArbolOrganizacional.java` |

## Capa negocio, clase ArbolOrganizacional

<a id="grado"></a>

### Método grado(codigo)
Paquete principal: SJA-UTA | Capa: negocio | Paquete: negocio | Clase: ArbolOrganizacional | Archivo: src/negocio/ArbolOrganizacional.java

Firma: `public int grado(String codigo)`

```mermaid
flowchart TD
    classDef fallo fill:#fde8e8,stroke:#b42318,color:#7a1212
    A(["ArbolOrganizacional.grado(codigo)"]) --> B["nodo = buscar(codigo)"]
    B --> C{"nodo == null"}
    C -- Sí --> X(["devuelve -1: no existe"])
    C -- No --> D["cantidad = nodo.getHijos().size()"]
    D --> E(["devuelve cantidad"])
    class X fallo
```

El grado de una unidad es la cantidad de hijos que tiene. El método reutiliza el `buscar` recursivo de Damian: si no encuentra la unidad devuelve `-1`; si la encuentra, devuelve el tamaño de su lista de hijos. Complejidad O(n) por la búsqueda.

Ejemplo: `FISEI` tiene grado 5, `UTA` tiene grado 10 y `SW-N3-B`, que es una hoja, tiene grado 0.

<a id="nivel"></a>

### Método nivel(codigo)
Paquete principal: SJA-UTA | Capa: negocio | Paquete: negocio | Clase: ArbolOrganizacional | Archivo: src/negocio/ArbolOrganizacional.java

Firma: `public int nivel(String codigo)`

```mermaid
flowchart TD
    classDef fallo fill:#fde8e8,stroke:#b42318,color:#7a1212
    A(["ArbolOrganizacional.nivel(codigo)"]) --> B{"codigo == null o codigo.isBlank()"}
    B -- Sí --> X(["devuelve -1"])
    B -- No --> C["codigo = codigo.trim().toUpperCase()"]
    C --> D["llamar a nivel(raiz, codigo, 0)"]
    D --> E(["devuelve el resultado"])
    class X fallo
```

El método público solo valida y normaliza el código, igual que `buscar`, y delega en el método privado recursivo empezando en la raíz con profundidad 0.

<a id="nivelNodo"></a>

### Método nivel(nodo, codigo, profundidad)
Paquete principal: SJA-UTA | Capa: negocio | Paquete: negocio | Clase: ArbolOrganizacional | Archivo: src/negocio/ArbolOrganizacional.java

Firma: `private int nivel(NodoUnidad nodo, String codigo, int profundidad)`

```mermaid
flowchart TD
    classDef fallo fill:#fde8e8,stroke:#b42318,color:#7a1212
    A(["nivel(nodo, codigo, profundidad)"]) --> B{"nodo.getDato().getCodigo().equals(codigo)"}
    B -- Sí --> C(["devuelve profundidad: caso base"])
    B -- No --> D{"quedan hijos en nodo.getHijos()"}
    D -- No --> X(["devuelve -1: no está en este subárbol"])
    D -- Sí --> F["hijo = siguiente hijo"]
    F --> G["n = nivel(hijo, codigo, profundidad + 1)"]
    G --> H{"n != -1"}
    H -- Sí --> I(["devuelve n"])
    H -- No --> D
    class X fallo
```

Cada llamada pregunta si el nodo actual es el buscado; si coincide, devuelve la profundidad acumulada (**caso base**). Si no, se llama a sí misma con cada hijo sumando 1 a la profundidad (**caso recursivo**), y devuelve el primer resultado distinto de `-1`. Si ningún hijo lo contiene, devuelve `-1` y la llamada anterior sigue con el siguiente hermano. Complejidad O(n).

Ejemplo: para `SW-N3-B` la profundidad sube así: UTA 0, FISEI 1, SW 2, SW-N3 3 y SW-N3-B 4.