# Aporte de Luis Silva

**Cuenta de GitHub:** `luuissilva`

| Fase | Aporte |
|---|---|
| 2 | A4 grado y nivel; B4 y B5: modificar y eliminar en el ABB (adelanto de la Fase 3); estación E3 de inorden y posorden. |
| 3 | Respondió con el grupo las preguntas guía del Grupo 3. |
| 4 | Pruebas de modificación y de los casos de eliminación del ABB en el sistema terminado. |

## Pruebas a mi cargo

`src/pruebas/PruebasModificacionEliminacion.java`: modificación válida e inválida y los cuatro casos de eliminación (hoja, un hijo, dos hijos y raíz), comprobando que el inorden siga ordenado después de cada uno.

## Lo que aprendí

Al eliminar un nodo con dos hijos, el sucesor inorden es el único reemplazo que mantiene el orden del ABB. Validar antes de modificar evita dejar un registro a medio cambiar.
