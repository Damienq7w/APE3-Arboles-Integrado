# Casos de prueba

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Condiciones de las pruebas

El código integrado se compiló y ejecutó con Java 17.

Las pruebas del programa principal utilizan el paralelo SW-N3-B. Primero se cargan los datos iniciales y se inserta la matrícula 45. Los recorridos se consultan antes de eliminar estudiantes.

Las eliminaciones se realizan en este orden: 20, 60 y 50.

Las pruebas de las consultas del árbol general utilizan una ejecución independiente, con los datos iniciales y sin agregar ni eliminar unidades.

Los mensajes corresponden a la versión en la que se realizó cada comprobación; pueden variar en sus tildes o presentación. Se omiten los prefijos del menú cuando no afectan la interpretación del resultado.

## Árbol organizacional

| Método  | Entrada                                                       | Resultado esperado              | Resultado obtenido              | Estado |
| ------- | ------------------------------------------------------------- | ------------------------------- | ------------------------------- | ------ |
| buscar  | sw-n3-b                                                       | SW-N3-B - Paralelo B (PARALELO) | SW-N3-B - Paralelo B (PARALELO) | OK     |
| buscar  | XX                                                            | No existe                       | No existe                       | OK     |
| agregar | Padre SW-N3; código SW-N3-C; nombre Paralelo C; tipo PARALELO | Unidad agregada                 | Unidad agregada                 | OK     |
| agregar | Repetir el código SW-N3-C                                     | No se pudo agregar              | No se pudo agregar              | OK     |
| agregar | Padre SW; código FX; nombre Prueba; tipo FACULTAD             | No se pudo agregar              | No se pudo agregar              | OK     |

La búsqueda admite minúsculas porque normaliza el código.

La inserción de FX se rechaza porque una CARRERA no puede tener como hija una FACULTAD.

## Inserción y búsqueda de estudiantes

| Método   | Entrada                                                               | Resultado esperado   | Resultado obtenido   | Estado |
| -------- | --------------------------------------------------------------------- | -------------------- | -------------------- | ------ |
| insertar | Matrícula 45; cédula 1800000045; nombres Estudiante Nuevo; promedio 9 | Estudiante insertado | Estudiante insertado | OK     |
| insertar | Repetir el estudiante con matrícula 45                                | Matrícula repetida   | Matrícula repetida   | OK     |
| buscar   | Matrícula 99 en SW-N3-B                                               | No existe            | No existe            | OK     |

La inserción repetida no reemplaza al estudiante ni agrega un segundo nodo con la misma matrícula.

## Recorridos

Secuencias finales obtenidas con la opción 14, después de insertar 45:

| Tipo     | Secuencia esperada            | Secuencia obtenida            | Estado |
| -------- | ----------------------------- | ----------------------------- | ------ |
| PREORDEN | 50 30 20 40 35 45 70 60 65 80 | 50 30 20 40 35 45 70 60 65 80 | OK     |
| INORDEN  | 20 30 35 40 45 50 60 65 70 80 | 20 30 35 40 45 50 60 65 70 80 | OK     |
| POSORDEN | 20 35 45 40 30 65 60 80 70 50 | 20 35 45 40 30 65 60 80 70 50 | OK     |

Las trazas completas están en [trazas_recorridos.md](trazas_recorridos.md).

## Modificación

| Método    | Entrada                                                                 | Resultado esperado                                 | Resultado obtenido                             | Estado |
| --------- | ----------------------------------------------------------------------- | -------------------------------------------------- | ---------------------------------------------- | ------ |
| modificar | Matrícula 45; cédula 1800000045; nombres Estudiante Nuevo; promedio 9.5 | Estudiante modificado                              | Estudiante modificado                          | OK     |
| modificar | Matrícula 45; cédula 123; nombres Cambio rechazado; promedio 9.5        | Error de cédula sin modificar los datos anteriores | La cédula debe tener 10 dígitos                | OK     |
| buscar    | Matrícula 45 después del intento inválido                               | Conservar cédula, nombres y promedio anteriores    | CI 1800000045; Estudiante Nuevo; promedio 9.50 | OK     |
| modificar | Matrícula 99; cédula 1800000099; nombres No existe; promedio 8          | No existe                                          | No existe                                      | OK     |

La consulta posterior al intento inválido confirmó que el nombre no cambió a Cambio rechazado. La validación se realiza antes de aplicar los setters.

La matrícula permanece igual porque es la clave del ABB.

## Eliminación

| Método   | Entrada | Caso        | Resultado esperado   | Resultado obtenido   | Estado |
| -------- | ------- | ----------- | -------------------- | -------------------- | ------ |
| eliminar | 20      | Hoja        | Estudiante eliminado | Estudiante eliminado | OK     |
| eliminar | 60      | Un hijo     | Estudiante eliminado | Estudiante eliminado | OK     |
| eliminar | 50      | Dos hijos   | Estudiante eliminado | Estudiante eliminado | OK     |
| eliminar | 99      | Inexistente | No existe            | No existe            | OK     |

Después de eliminar 20, 60 y 50:

| Verificación | Esperado             | Obtenido             | Estado |
| ------------ | -------------------- | -------------------- | ------ |
| INORDEN      | 30 35 40 45 65 70 80 | 30 35 40 45 65 70 80 | OK     |

La explicación de cada cambio está en [trazas_insercion_eliminacion.md](trazas_insercion_eliminacion.md).

## Pruebas de la solución del reto

RetoSolucion comprueba preorden, inorden, posorden y altura en cinco conjuntos independientes.

Las secuencias y alturas de la siguiente tabla coincidieron con los resultados obtenidos.

| Caso                     | Preorden                   | Inorden                    | Posorden                   | Altura | Resultado |
| ------------------------ | -------------------------- | -------------------------- | -------------------------- | ------ | --------- |
| SW-N3-A                  | 45 25 10 30 27 70 60 65 90 | 10 25 27 30 45 60 65 70 90 | 10 27 30 25 65 60 90 70 45 | 3      | 4 OK      |
| Árbol vacío              | Cadena vacía               | Cadena vacía               | Cadena vacía               | -1     | 4 OK      |
| Un nodo: 50              | 50                         | 50                         | 50                         | 0      | 4 OK      |
| Cadena: 10, 20, 30, 40   | 10 20 30 40                | 10 20 30 40                | 40 30 20 10                | 3      | 4 OK      |
| Repetido: 20, 30, 30, 10 | 20 10 30                   | 10 20 30                   | 10 30 20                   | 1      | 4 OK      |

Salida final verificada:

```text
Resultado: 20/20 pruebas OK
```

La cantidad real reemplaza las nueve comprobaciones previstas inicialmente en el reparto: la solución integrada comprueba cuatro resultados para cada uno de los cinco casos.

## Consultas del árbol general de la Fase 2

Estas pruebas utilizan los datos iniciales del programa, sin agregar ni eliminar unidades académicas. El árbol contiene 88 unidades.

Si antes se agregó SW-N3-C, se debe reiniciar el programa para recuperar los datos iniciales.

### Mostrar la jerarquía — opción 1

| Verificación                   | Resultado esperado                 | Resultado obtenido                 | Estado |
| ------------------------------ | ---------------------------------- | ---------------------------------- | ------ |
| Cantidad de unidades mostradas | 88                                 | 88                                 | OK     |
| Raíz de la jerarquía           | UTA                                | UTA                                | OK     |
| Sangría por nivel              | Dos espacios adicionales por nivel | Dos espacios adicionales por nivel | OK     |

La jerarquía se muestra en preorden: primero la unidad actual y después sus hijos. La sangría permite reconocer las relaciones entre universidad, facultades, carreras, niveles y paralelos.

### Altura y hojas — opción 4

| Método        | Resultado esperado | Resultado obtenido                                              | Estado    |
| ------------- | ------------------ | --------------------------------------------------------------- | --------- |
| altura()      | 4 aristas          | Lanza UnsupportedOperationException: Pendiente: Fase 2 (altura) | PENDIENTE |
| contarHojas() | 57                 | 57 mediante comprobación directa del método                     | OK        |

La altura esperada es 4 porque el camino UTA → Facultad → Carrera → Nivel → Paralelo contiene cuatro aristas.

Las 57 hojas corresponden a las unidades sin hijos del árbol organizacional. Los estudiantes pertenecen a los ABB asociados a los paralelos y no se cuentan como hojas del árbol general.

En la versión revisada, la opción 4 se interrumpe al ejecutar altura(), por lo que tampoco alcanza a mostrar las hojas. El resultado de contarHojas() se verificó mediante una llamada independiente.

Cuando se integre altura(), se debe repetir la opción 4 y comprobar esta salida:

```text
[Altura y hojas] Altura: 4 | Hojas: 57
```

### Grado y nivel — opción 5

| Código  | Grado esperado | Grado obtenido | Nivel esperado | Nivel obtenido | Estado |
| ------- | -------------- | -------------- | -------------- | -------------- | ------ |
| UTA     | 10             | 10             | 0              | 0              | OK     |
| FISEI   | 5              | 5              | 1              | 1              | OK     |
| SW-N3-B | 0              | 0              | 4              | 4              | OK     |
| XYZ     | -1             | -1             | -1             | -1             | OK     |

El grado representa la cantidad de hijos directos de una unidad. El nivel corresponde a su distancia desde la raíz, medida en aristas.

UTA tiene grado 10 por sus diez facultades. FISEI tiene grado 5 por sus cinco carreras. SW-N3-B tiene grado 0 porque no tiene hijos organizacionales; su ABB de estudiantes es una estructura asociada.

Cuando el código no existe, grado() y nivel() devuelven -1 para distinguir esa situación de una unidad válida con grado o nivel 0.

## Alcance de los resultados

Los métodos que todavía lanzan UnsupportedOperationException no se presentan como pruebas aprobadas.

La comprobación de altura incluida en RetoSolucion corresponde a su implementación independiente. No demuestra que altura() esté implementado en ArbolOrganizacional ni en ArbolEstudiantes.

RetoRecorridos es una plantilla para el curso. Sus métodos incompletos no deben confundirse con RetoSolucion, que contiene la implementación y las verificaciones.

[Volver al README del Grupo 2](../README.md)
