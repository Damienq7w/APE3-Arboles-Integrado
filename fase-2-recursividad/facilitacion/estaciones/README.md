# Reto de trazas de la Fase 2 (APE 3)

El lunes 19/10/2026 cada grupo trabaja **en su puesto** y resuelve las cuatro partes del reto (E1 a E4). No hay rotación. En todas las partes se usa la misma lista de matrículas.

## Lista de matrículas

Se insertan en este orden en un árbol binario de búsqueda (ABB):

```
38, 18, 55, 8, 28, 48, 75, 23, 33, 68
```

## Partes del reto

| Parte | Tema | Archivo | Ayuda |
| --- | --- | --- | --- |
| E1 | Inserción del 45 en el ABB | E1-insercion.md | Kenneth |
| E2 | Recorrido preorden con traza | E2-preorden.md | Darwin |
| E3 | Inorden y posorden | E3-inorden-posorden.md | Luis |
| E4 | Caza el error | E4-caza-el-error.md y ErrorRecursivo.java | Monica |

Kenneth, Darwin, Luis y Monica pasan por los puestos ayudando, cada uno con su parte.

Para E4, cada grupo descarga `ErrorRecursivo.java` de esta carpeta y lo ejecuta:

```
javac ErrorRecursivo.java
java ErrorRecursivo
```

## Cómo se publica en el Padlet

El Padlet tiene una columna de ejemplo (Grupo 2), una columna por grupo y una columna **Preguntas**.

1. **En la columna del grupo**, dos diagramas hechos en Mermaid (no a mano):
   - **Diagrama 1:** el ABB con el 45 insertado y su camino resaltado.
   - **Diagrama 2:** el ABB después de eliminar el 18 (nodo con dos hijos), indicando qué nodo sube.
2. **En la columna Preguntas**, una sola nota con el número del grupo, que contiene:
   - las respuestas de E1, E2, E3 y E4;
   - las 6 preguntas guía de la Fase 2.

Las respuestas de esa nota se copian después al Word de la Fase 2 (Tabla 2 y preguntas guía), y la captura de la columna del grupo va en los anexos.

## Las 6 preguntas guía

1. ¿Cuál es el caso base de insertar y qué ocurre en él?
2. ¿Por qué el recorrido inorden de un ABB sale ordenado?
3. ¿En qué momento se visita el nodo en preorden y en posorden?
4. ¿Por qué buscar en el árbol general recorre los hijos uno por uno y en el ABB no?
5. Al eliminar un nodo con dos hijos, ¿por qué se usa el sucesor inorden?
6. ¿Qué pasa con la altura y la velocidad del ABB si las matrículas llegan ya ordenadas?
