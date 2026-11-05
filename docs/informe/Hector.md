# Aporte de Hector

## Objetivo
Implementar y verificar la lógica de eliminación de unidades académicas y la transformación jerárquica de árbol organizacional a representación hijo izquierdo / hermano derecho, asegurando la protección de paralelos con estudiantes.

## Cambios realizados
- Revisión y ajuste de la eliminación de nodos en `ArbolOrganizacional.java`.
- Validación de la representación jerárquica de unidades (Hijo Izquierdo / Hermano Derecho).
- Traslado de la validación de protección de paralelos con estudiantes desde la interfaz hacia la capa de negocio.

## Pruebas
| Entrada | Esperado | Obtenido | Evidencia |
|---|---|---|---|
| Eliminar unidad vacía | Nodo eliminado correctamente sin afectar la estructura | Exitoso | Unidad sin hijos eliminada |
| Eliminar unidad con hijos | Restricción o reacomodo correcto de sub-unidades | Exitoso | Estructura preservada |
| Múltiples hermanos | Reorganización de punteros de hermanos contiguos | Exitoso | Punteros actualizados |

## Dos preguntas y respuestas
1. **¿Por qué es importante proteger la eliminación de paralelos ocupados en la capa de negocio?**  
   Porque evita la pérdida accidental de datos de estudiantes matriculados y desvincula la lógica de seguridad de la interfaz de usuario.
2. **¿Cómo beneficia la representación Hijo Izquierdo / Hermano Derecho al árbol organizacional?**  
   Permite representar árboles n-arios (con cantidad variable de hijos) utilizando una estructura binaria de punteros simples y eficientes.

## Conclusion de esta parte
La centralización de validaciones en la capa de negocio asegura la integridad referencial del árbol organizacional y previene estados inconsistentes al manipular las unidades y sus estudiantes asociados.
