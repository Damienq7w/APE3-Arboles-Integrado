# Reto de recorridos recursivos con traza

> **Responsable de la documentacion:** Jampier (Josue)
> **Rama:** `rama---Josue`
>
> **Responsable del codigo del reto:** Monica
> **Rama:** `Sara-Tacuri`

## Enunciado

El paralelo SW-N3-A empieza vacio. Se matriculan estudiantes en este orden:

```text
45, 25, 70, 10, 30, 60, 90, 27, 65
```

Las matriculas se organizan en un arbol binario de busqueda: menores a la izquierda y mayores a la derecha. Las matriculas repetidas se ignoran.

## Actividades

1. Dibujar el ABB que resulta del orden de insercion.
2. Predecir en papel los recorridos preorden, inorden y posorden.
3. Completar los tres metodos recursivos de RetoRecorridos.java.
4. Ejecutar el programa y comparar las secuencias con la prediccion.
5. Revisar los casos limite incluidos en main.
6. Como actividad extra, implementar la altura en aristas.

Tiempo sugerido: cinco minutos para dibujar y predecir, diez para completar los metodos y cinco para comparar resultados.

## Archivo que completa el curso

[Plantilla RetoRecorridos.java](RetoRecorridos.java)

La insercion, la construccion de los arboles y las llamadas desde main ya estan preparadas.

Se deben completar estos metodos, conservando sus firmas:

```java
static void preorden(NodoEstudiante nodo, String sangria, StringBuilder salida)
static void inorden(NodoEstudiante nodo, String sangria, StringBuilder salida)
static void posorden(NodoEstudiante nodo, String sangria, StringBuilder salida)
```

Como extra:

```java
static int altura(NodoEstudiante nodo)
```

## Reglas de los recorridos

- Utilizar recursion.
- Detener la llamada cuando nodo sea null.
- Realizar una llamada recursiva por cada hijo.
- No ordenar listas ni sustituir los recorridos por bucles.
- Aumentar la sangria en dos espacios por nivel.
- Agregar la matricula a salida cuando se visita el nodo.

Cada recorrido debe imprimir:

```text
entra <matricula>
VISITA <matricula>
null -> regresa
```

entra se imprime al llegar a un nodo existente.

null -> regresa se imprime en el caso base.

El momento de VISITA depende del recorrido:

| Recorrido | Orden                                               |
| --------- | --------------------------------------------------- |
| Preorden  | Visitar nodo, recorrer izquierdo, recorrer derecho. |
| Inorden   | Recorrer izquierdo, visitar nodo, recorrer derecho. |
| Posorden  | Recorrer izquierdo, recorrer derecho, visitar nodo. |

Al visitar se agrega la matricula mediante:

```java
salida.append(m).append(' ');
```

## Compilacion y ejecucion

Abrir PowerShell dentro de Grupo2 y compilar:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src,reto -Filter *.java).FullName
```

Ejecutar la plantilla:

```powershell
java -cp out reto.RetoRecorridos
```

La plantilla tiene recorridos vacios y una altura provisional que devuelve 0. Debe completarse antes de interpretar sus resultados como una solucion.

## Resultados esperados del reto

Consultar estos resultados despues de realizar la prediccion.

| Recorrido | Secuencia esperada         |
| --------- | -------------------------- |
| Preorden  | 45 25 10 30 27 70 60 65 90 |
| Inorden   | 10 25 27 30 45 60 65 70 90 |
| Posorden  | 10 27 30 25 65 60 90 70 45 |

La raiz es 45.

La altura es 3 aristas. Por ejemplo, el camino 45, 25, 30, 27 tiene esa longitud.

## Casos limite

| Caso                     | Preorden     | Inorden      | Posorden     | Altura |
| ------------------------ | ------------ | ------------ | ------------ | ------ |
| Arbol vacio              | Cadena vacia | Cadena vacia | Cadena vacia | -1     |
| Un nodo: 50              | 50           | 50           | 50           | 0      |
| Cadena: 10, 20, 30, 40   | 10 20 30 40  | 10 20 30 40  | 40 30 20 10  | 3      |
| Repetido: 20, 30, 30, 10 | 20 10 30     | 10 20 30     | 10 30 20     | 1      |

En el ultimo caso, el segundo 30 no crea otro nodo.

## Solucion de referencia

[Archivo RetoSolucion.java](solucion/RetoSolucion.java)

Ejecutar despues de resolver el ejercicio:

```powershell
java -cp out reto.solucion.RetoSolucion
```

La solucion imprime una traza de inorden del conjunto SW-N3-A. Despues comprueba preorden, inorden, posorden y altura en cinco conjuntos independientes.

Salida final verificada:

```text
Resultado: 20/20 pruebas OK
```

## Diagramas relacionados

- [Diagrama de secuencia del reto](../docs/diagramas-secuencia/secuencia_reto.md)
- [Diagramas de flujo del reto](../docs/diagramas-flujo/flujo_reto.md)

[Volver al README del Grupo 2](../README.md)
