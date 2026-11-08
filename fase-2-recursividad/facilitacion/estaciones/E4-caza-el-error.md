# Estación 4: Caza el error

**Archivo:** `ErrorRecursivo.java` (en esta misma carpeta). Cada grupo lo descarga del repositorio y lo ejecuta en su puesto; Monica pasa por los grupos ayudando.

## Ejercicio

El programa construye un ABB con la lista de matrículas de las estaciones (38, 18, 55, 8, 28, 48, 75, 23, 33, 68) y debe mostrar el inorden y el posorden. Pero tiene **dos errores a propósito**, uno en `inorden` y otro en `posorden`.

1. Compila y ejecuta el programa: `javac ErrorRecursivo.java` y luego `java ErrorRecursivo`.
2. Lee lo que imprime y compáralo con lo que debería salir.
3. Encuentra los dos errores. Di en qué método está cada uno y por qué ocurre.
4. Corrígelos y vuelve a ejecutar.
5. Escribe en la nota del grupo en la columna **Preguntas** del Padlet, en la parte **E4**, los dos errores que encontraron y cómo los corrigieron.

### Pistas

- Pista 1: el inorden de un ABB siempre sale ordenado de menor a mayor.
- Pista 2: en el posorden, la raíz es lo último que se visita.
- Pista 3: ¿qué pasa cuando la recursión llega a un hijo que no existe?

---

## Solución (no mostrar hasta la comprobación)

**Error 1, en `inorden`: no tiene caso base.** Cuando la recursión llega a un hijo que no existe (`null`), el método intenta leer `nodo.izquierdo` de un nodo nulo y lanza `NullPointerException`. Se corrige agregando al inicio:

```java
if (nodo == null) {
    return;
}
```

**Error 2, en `posorden`: la visita está en mal lugar.** Se agrega la matrícula antes de llamar a los hijos, así que en realidad hace un preorden (sale `38 18 8 28 ...`). En posorden la visita va al final, después de las dos llamadas recursivas:

```java
posorden(nodo.izquierdo, salida);
posorden(nodo.derecho, salida);
salida.append(nodo.matricula).append(' ');
```

**Resultado esperado con los dos errores corregidos:**

```
Inorden:  8 18 23 28 33 38 48 55 68 75
Posorden: 8 23 33 28 18 48 68 75 55 38
```