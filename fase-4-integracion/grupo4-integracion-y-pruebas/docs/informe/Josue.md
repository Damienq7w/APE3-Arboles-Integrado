
# Informe individual - Josué

## 1. Objetivo

Verificar el funcionamiento de los métodos de modificación
y eliminación de estudiantes en un árbol binario de
búsqueda (ABB), comprobando que los datos se conserven
correctamente y que el árbol mantenga su estructura.

## 2. Actividades realizadas

Se revisaron los métodos modificar() y eliminar() de la
clase ArbolEstudiantes.java.

Se creó PruebasJosue.java para comprobar su funcionamiento
mediante diferentes casos de prueba.

## 3. Pruebas realizadas

| Prueba | Resultado |
|---|---|
| Modificación válida | Aprobado |
| Modificación inválida | Aprobado |
| Eliminación de hoja 10 | Aprobado |
| Eliminación con un hijo 40 | Aprobado |
| Eliminación con dos hijos 45 | Aprobado |
| Eliminación de raíz 30 | Aprobado |

## 4. Explicación de los resultados

En la modificación válida, se comprobó que los datos
del estudiante se actualizaron correctamente.

En la modificación inválida, los datos originales
se conservaron.

En las eliminaciones, se comprobó que los estudiantes
desaparecieron del árbol y que los elementos restantes
mantuvieron su orden.

## 5. Preguntas y respuestas

**¿Qué sucede al eliminar un nodo con dos hijos?**

Se busca el sucesor inorden, se reemplaza el dato del
nodo y se elimina el sucesor de su ubicación anterior.

**¿Por qué se deben validar los datos antes de modificar?**

Para evitar que una modificación incorrecta altere
la información que ya estaba almacenada.

## 6. Evidencias

Agregar capturas de la terminal con los resultados de
las pruebas ejecutadas.

## 7. Conclusión

Las pruebas permitieron comprobar que los métodos de
modificación y eliminación funcionan correctamente en
los casos evaluados. También se verificó que los datos
se conservan cuando una modificación es inválida y que
el árbol mantiene su orden después de las eliminaciones.
