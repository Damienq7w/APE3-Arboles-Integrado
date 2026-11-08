# Misión 5 — Recorridos y estadísticas comparadas

> **Responsable:** Darwin Tisalema · **Archivos:** `ArbolEstudiantes.java`, `RetoMision5.java`

## `contarAprobados(double notaMinima)`

Es recursivo y recorre todo el ABB, porque el árbol está ordenado por matrícula y no por promedio:

- **Caso base:** un nodo `null` aporta 0.
- **Caso recursivo:** suma 1 si `promedio >= notaMinima`, más lo que devuelvan el subárbol izquierdo y el derecho.

Complejidad: O(n) en tiempo y O(h) de pila. Rechaza una nota mínima fuera de 0–10 o no finita.

La opción 3 del menú ahora también muestra los aprobados con nota mínima 8.00.

## Comparación final (después de los 4 traslados)

| Dato | EB-N1-A | EB-N1-B |
|---|---|---|
| Inorden | 15 20 35 50 55 | 10 30 40 45 |
| Cantidad | 5 | 4 |
| Altura (aristas) | 2 | 2 |
| Matrícula menor | 15 | 10 |
| Matrícula mayor | 55 | 45 |
| Promedio general | 8.36 | 8.00 |
| Aprobados (≥ 8.00) | 5 | 4 |
| Aprobados (≥ 9.00) | 1 | 0 |

- **Promedio de EB-N1-A:** (8 + 8 + 9.80 + 8 + 8) / 5 = 41.80 / 5 = **8.36**. La matrícula 35, con 9.80, se queda en el origen.
- **EB-N1-B** recibe 10, 40, 45 y 30 en ese orden. Su forma es 10 → 40 → (30, 45), con altura 2.

## ¿Por qué el inorden conserva el orden?

En un ABB, todo el subárbol izquierdo de un nodo tiene matrículas menores y todo el derecho, mayores. El inorden visita **izquierdo → nodo → derecho**, así que cada matrícula sale después de todas las menores y antes de todas las mayores.

Insertar en el destino y eliminar del origen (con el sucesor inorden en el caso de dos hijos) mantienen esa propiedad. Por eso el inorden de ambos paralelos sigue ordenado después de los traslados.
