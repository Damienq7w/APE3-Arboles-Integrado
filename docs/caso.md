# Caso de estudio: Sistema Jerárquico Académico UTA (SJA-UTA)

## 1. Contexto

La Universidad Técnica de Ambato necesita una aplicación de consola en Java que represente su **estructura organizacional**
y que permita **gestionar a los estudiantes de cada paralelo** de forma eficiente.

La información tiene dos naturalezas distintas:

- La **organización** es jerárquica y cada unidad puede tener cualquier cantidad de subunidades: la universidad tiene facultades,
  una facultad tiene carreras, una carrera tiene niveles y un nivel tiene paralelos. → **Árbol general (n-ario).**
- Los **estudiantes de un paralelo** se identifican por un número de matrícula único y se consultan constantemente por ese número.
  → **Árbol binario de búsqueda (ABB)** ordenado por matrícula.

## 2. Parte A: estructura organizacional (árbol general)

| Atributo | Tipo | Regla |
|---|---|---|
| código | String | único en todo el árbol (`UTA`, `FISEI`, `SW`, `SW-N3`, `SW-N3-B`) |
| nombre | String | no vacío |
| tipo | `TipoUnidad` | `UNIVERSIDAD`, `FACULTAD`, `CARRERA`, `NIVEL`, `PARALELO` |

**Regla jerárquica:** un hijo siempre es del tipo inmediatamente inferior a su padre. La raíz es la única UNIVERSIDAD.

| # | Operación | Fase |
|---|---|---|
| A1 | Agregar una unidad bajo un padre (código único y regla jerárquica) | 2 |
| A2 | Buscar una unidad por código | 2 |
| A3 | Mostrar la jerarquía completa con sangría por nivel | 2 |
| A4 | Altura del árbol, grado y nivel de un nodo, cantidad de hojas | 2 |
| A5 | Eliminar una unidad (solo si no tiene subunidades) | 3 |
| A6 | Transformar a árbol binario (hijo izquierdo / hermano derecho) | 3 |

## 3. Parte B: estudiantes por paralelo (ABB)

Cada unidad de tipo **PARALELO** administra su propio ABB.

| Atributo | Tipo | Regla |
|---|---|---|
| matrícula | int | **clave del ABB**, única en el paralelo, positiva |
| cédula | String | 10 dígitos |
| nombres | String | no vacío |
| promedio | double | entre 0 y 10 |

| # | Operación | Fase |
|---|---|---|
| B1 | Insertar estudiante (sin matrículas repetidas) | 2 |
| B2 | Buscar por matrícula | 2 |
| B3 | Recorridos recursivos: preorden, inorden, posorden | 2 |
| B4 | Modificar datos (todo excepto la matrícula) | 3 |
| B5 | Eliminar: nodo hoja, con un hijo, con dos hijos | 3 |
| B6 | Estadísticas: total, menor y mayor matrícula, altura, promedio general | 3 |

## 4. Restricciones

- Java, aplicación de consola con menú.
- Árboles implementados por el curso: **no** se permite `TreeMap`, `TreeSet` ni colecciones que ya resuelvan el árbol.
  (`ArrayList` solo para guardar los hijos de un nodo del árbol general.)
- Recorridos y altura **recursivos**.
- Capas: `enums` (tipos), `modelo` (datos), `negocio` (nodos y árboles), `app` (menú).
- Validaciones con mensajes claros.
- Trabajo colaborativo evidenciado con commits de todos los integrantes.

## 5. Fases

| Fase | Fecha | Facilita | Entregable |
|---|---|---|---|
| 1 | Lun 12/10 | Grupo 1 | Caso, diagramas, esqueleto Java; el curso modela los árboles (Padlet) |
| 2 | Lun 19/10 | Grupo 2 | A1 a A4 y B1 a B3, con trazas de recorridos |
| 3 | Jue 22/10 | Grupo 3 | A5, A6 y B4 a B6, con pruebas de casos límite |
| 4 | Jue 05/11 | Grupo 4 | Integración, pruebas, demostración e informe en Moodle |

Criterios de la Matriz APE: modelación · recursividad · recorridos · actualización · transformación · pruebas · claridad del informe.
