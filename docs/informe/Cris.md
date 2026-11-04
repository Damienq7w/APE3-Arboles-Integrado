# Aporte de Cris

## Objetivo

Validar las funcionalidades A1–A4 del árbol organizacional: agregar unidades, buscar por código, mostrar la jerarquía y consultar altura, grado, nivel y cantidad de hojas. Comprobar el cumplimiento de las relaciones entre unidades académicas y el comportamiento del sistema ante códigos duplicados, padres inexistentes y árboles vacíos.

## Cambios realizados

Se revisaron los métodos `agregar`, `buscar`, `mostrarJerarquia`, `altura`, `grado`, `nivel` y `contarHojas` de `ArbolOrganizacional.java`, incluidos sus auxiliares recursivos.

Se verificó que el registro de unidades compruebe la existencia del padre, la unicidad del código y la relación jerárquica permitida. También se comprobó que las búsquedas admitan espacios exteriores y minúsculas, y que las consultas devuelvan los valores establecidos cuando una unidad no existe.

Se validó la presentación de la jerarquía en preorden, con dos espacios de sangría por nivel, y se contrastaron los cálculos de altura, grado, nivel y hojas con la estructura de los datos de ejemplo.

En coordinación con Shirley, se completó el registro de unidades y la búsqueda explícita por código desde el menú, utilizando la lógica compartida de negocio.

El aporte se realizó sobre la base existente, conservando los créditos de los grupos anteriores y sin atribuir como nuevos los algoritmos heredados. No se modificaron las funcionalidades de eliminación y transformación a binario asignadas a Héctor.

## Pruebas

Las pruebas de registro se ejecutaron sobre los datos iniciales de `Contexto`. Después de agregar el paralelo C, se conservaron esos datos para comprobar el rechazo de duplicados y padres inexistentes. Los casos de raíz sola y árbol vacío se probaron en una instancia independiente.

| Prueba | Entrada o procedimiento | Resultado esperado | Resultado obtenido |
|---|---|---|---|
| Estructura inicial | Consultar altura, hojas, nivel y grado de `EB-N1` | Altura `4`, hojas `2`, nivel `3` y grado `2` | Se obtuvieron los cuatro valores esperados. |
| Unidad válida | Agregar `EB-N1-C`, de tipo `PARALELO`, bajo `EB-N1` | Inserción `true`, nivel `4`, grado del padre `3`, hojas `3` y altura `4` | La unidad se registró y las consultas coincidieron con los valores esperados. |
| Código duplicado | Intentar agregar `" eb-n1-c "` después del registro válido | Inserción `false`, sin reemplazar la unidad existente ni aumentar hijos u hojas | El duplicado fue rechazado y se conservó el nombre original, `Paralelo C`. |
| Padre inexistente | Agregar `EB-N1-D` bajo `NO-EXISTE` | Inserción `false` y búsqueda de `EB-N1-D` igual a `null` | La operación fue rechazada y la unidad no quedó registrada. |
| Jerarquía inválida | Agregar un `PARALELO` directamente bajo `UTA` | Inserción `false` | Se rechazó la relación entre universidad y paralelo. |
| Búsqueda normalizada | Buscar `" eb-n1-a "` | Encontrar `EB-N1-A` | Se encontró la unidad pese a los espacios exteriores y las minúsculas. |
| Código inexistente | Consultar búsqueda, nivel y grado de `NO-EXISTE` | Búsqueda `null`, nivel `-1` y grado `-1` | Se obtuvieron los valores esperados, sin excepciones. |
| Jerarquía visual | Ejecutar `mostrarJerarquia()` | Padres antes que hijos, dos espacios por nivel y paralelos al mismo nivel | Se comprobó el orden y la sangría de la estructura. |
| Raíz sin hijos | Crear un árbol que contenga únicamente `UTA` | Altura `0`, grado `0`, nivel `0` y hojas `1` | Se obtuvieron los cuatro valores esperados. |
| Árbol vacío | Eliminar la raíz sin hijos del árbol independiente y ejecutar las consultas | Raíz y búsqueda `null`; altura, grado y nivel `-1`; hojas `0` | Las consultas devolvieron los valores esperados y no produjeron excepciones. |
| Registro sobre árbol vacío | Intentar agregar una facultad bajo `UTA` después de eliminar la raíz | Inserción `false` | La operación fue rechazada porque el padre ya no existía. |

### Evidencias

Las capturas de las ejecuciones se incorporan como respaldo de los casos documentados. Cada evidencia debe mostrar la entrada utilizada y la salida correspondiente.

### Observaciones

La altura y el nivel se calculan contando aristas. Por ello, una raíz sin hijos tiene altura cero y nivel cero. Además, cuenta como una hoja.

Para preparar el árbol vacío se utilizó la eliminación existente sobre una raíz sin hijos, sin modificar el método asignado a Héctor.

En la base revisada, `mostrarJerarquia()` devuelve un salto de línea cuando el árbol está vacío. Se comprobó que esta consulta no produce excepciones.

## Dos preguntas y respuestas

### 1. ¿Cuál es la diferencia entre altura, nivel y grado?

La altura del árbol es la mayor cantidad de aristas entre la raíz y una hoja. El nivel de una unidad es la cantidad de aristas que la separan de la raíz. El grado es la cantidad de hijos directos que tiene esa unidad.

En los datos iniciales, el árbol tiene altura `4`. La unidad `EB-N1` tiene nivel `3` y grado `2`, porque contiene los paralelos A y B.

### 2. ¿Cómo se impiden los códigos duplicados y las relaciones jerárquicas inválidas?

El método `agregar` busca primero el código de la nueva unidad. Si ya está registrado, devuelve `false`. Después comprueba que exista el padre indicado.

Si ambas validaciones se cumplen, llama a `NodoUnidad.agregarHijo`, que verifica la relación entre tipos mediante `TipoUnidad.puedeTenerHijo`.

La secuencia permitida es:

`UNIVERSIDAD → FACULTAD → CARRERA → NIVEL → PARALELO`.

De esta manera, se evita tanto repetir códigos como insertar unidades en una posición incompatible con su tipo.

## Conclusión de esta parte

Se validaron las funcionalidades A1–A4 del árbol organizacional mediante casos normales, entradas inválidas y situaciones límite. Los resultados obtenidos coincidieron con los esperados: las unidades válidas se registraron correctamente, las inserciones inválidas fueron rechazadas y las consultas estructurales reflejaron la organización del árbol.

También se comprobó el comportamiento de una raíz sin hijos y de un árbol vacío. El trabajo permitió verificar la lógica del módulo y completar su acceso desde el menú, manteniendo la separación de responsabilidades del equipo.