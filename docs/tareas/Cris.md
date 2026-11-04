# Cris: Jerarquía académica

Rama: `feat/cris`.

Archivo principal: `src/negocio/ArbolOrganizacional.java`.

## Trabajo realizado

Se revisaron y validaron las funciones A1–A4 del árbol organizacional:

- `agregar`: registro de unidades bajo un padre existente, respetando la jerarquía y evitando códigos duplicados.
- `buscar`: búsqueda por código, incluyendo códigos inexistentes, espacios exteriores y minúsculas.
- `mostrarJerarquia`: presentación de las unidades en preorden, con sangría según su nivel.
- `altura`: cálculo de la mayor distancia desde la raíz hasta una hoja.
- `grado`: consulta de la cantidad de hijos directos de una unidad.
- `nivel`: cálculo de la distancia de una unidad respecto de la raíz.
- `contarHojas`: conteo de unidades sin hijos.

Se completó, en coordinación con Shirley, el acceso al registro de unidades y a la consulta explícita por código desde el menú.

## Pruebas realizadas

- Registro de unidades válidas.
- Rechazo de códigos duplicados.
- Rechazo de padres inexistentes.
- Rechazo de relaciones jerárquicas inválidas.
- Búsqueda de unidades existentes e inexistentes.
- Verificación de jerarquía, altura, grado, nivel y hojas.
- Consultas sobre un árbol con una sola raíz.
- Consultas sobre un árbol vacío.
- Compilación y ejecución del proyecto después de los cambios.

Los resultados coincidieron con los valores esperados y las operaciones probadas no produjeron excepciones no controladas.

## Documentación y entrega

Se completó `docs/informe/Cris.md` con el objetivo, la descripción del aporte, los casos de prueba, los resultados y dos preguntas con sus respuestas.

El aporte se desarrolló en `feat/cris`, respetando las funciones asignadas a los demás integrantes y conservando los créditos del código heredado.

## Coordinación

Se mantuvo la separación de responsabilidades dentro de `ArbolOrganizacional.java`: Cris trabajó las funciones A1–A4 y Héctor las funciones de eliminación y transformación a binario. Los cambios del menú se coordinaron con Shirley.

## Estado

Trabajo de implementación, validación y documentación completado.
