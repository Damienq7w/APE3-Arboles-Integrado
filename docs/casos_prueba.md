# Casos de prueba

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Condiciones de las pruebas

El codigo integrado se compilo y ejecuto con Java 17.

Las pruebas del programa principal utilizan el paralelo SW-N3-B. Primero se cargan los datos iniciales y se inserta 45. Los recorridos se consultan antes de eliminar estudiantes.

Las eliminaciones se realizan en este orden: 20, 60 y 50.

Los mensajes heredados se transcriben sin tildes. Se omiten los prefijos del menu cuando no afectan la interpretacion del resultado.

## Arbol organizacional

| Metodo  | Entrada                                                       | Resultado esperado              | Resultado obtenido              | Estado |
| ------- | ------------------------------------------------------------- | ------------------------------- | ------------------------------- | ------ |
| buscar  | sw-n3-b                                                       | SW-N3-B - Paralelo B (PARALELO) | SW-N3-B - Paralelo B (PARALELO) | OK     |
| buscar  | XX                                                            | No existe                       | No existe                       | OK     |
| agregar | Padre SW-N3; codigo SW-N3-C; nombre Paralelo C; tipo PARALELO | Unidad agregada                 | Unidad agregada                 | OK     |
| agregar | Repetir el codigo SW-N3-C                                     | No se pudo agregar              | No se pudo agregar              | OK     |
| agregar | Padre SW; codigo FX; nombre Prueba; tipo FACULTAD             | No se pudo agregar              | No se pudo agregar              | OK     |

La busqueda admite minusculas porque normaliza el codigo.

La insercion de FX se rechaza porque una CARRERA no puede tener como hija una FACULTAD.

## Insercion y busqueda de estudiantes

| Metodo   | Entrada                                                               | Resultado esperado   | Resultado obtenido   | Estado |
| -------- | --------------------------------------------------------------------- | -------------------- | -------------------- | ------ |
| insertar | Matricula 45; cedula 1800000045; nombres Estudiante Nuevo; promedio 9 | Estudiante insertado | Estudiante insertado | OK     |
| insertar | Repetir el estudiante con matricula 45                                | Matricula repetida   | Matricula repetida   | OK     |
| buscar   | Matricula 99 en SW-N3-B                                               | No existe            | No existe            | OK     |

La insercion repetida no reemplaza al estudiante ni agrega un segundo nodo con la misma matricula.

## Recorridos

Secuencias finales obtenidas con la opcion 14, despues de insertar 45:

| Tipo     | Secuencia esperada            | Secuencia obtenida            | Estado |
| -------- | ----------------------------- | ----------------------------- | ------ |
| PREORDEN | 50 30 20 40 35 45 70 60 65 80 | 50 30 20 40 35 45 70 60 65 80 | OK     |
| INORDEN  | 20 30 35 40 45 50 60 65 70 80 | 20 30 35 40 45 50 60 65 70 80 | OK     |
| POSORDEN | 20 35 45 40 30 65 60 80 70 50 | 20 35 45 40 30 65 60 80 70 50 | OK     |

Las trazas completas estan en [trazas_recorridos.md](trazas_recorridos.md).

## Modificacion

| Metodo    | Entrada                                                                 | Resultado esperado                                 | Resultado obtenido                             | Estado |
| --------- | ----------------------------------------------------------------------- | -------------------------------------------------- | ---------------------------------------------- | ------ |
| modificar | Matricula 45; cedula 1800000045; nombres Estudiante Nuevo; promedio 9.5 | Estudiante modificado                              | Estudiante modificado                          | OK     |
| modificar | Matricula 45; cedula 123; nombres Cambio rechazado; promedio 9.5        | Error de cedula sin modificar los datos anteriores | La cedula debe tener 10 digitos                | OK     |
| buscar    | Matricula 45 despues del intento invalido                               | Conservar cedula, nombres y promedio anteriores    | CI 1800000045; Estudiante Nuevo; promedio 9.50 | OK     |
| modificar | Matricula 99; cedula 1800000099; nombres No existe; promedio 8          | No existe                                          | No existe                                      | OK     |

La consulta posterior al intento invalido confirmo que el nombre no cambio a Cambio rechazado. La validacion se realiza antes de aplicar los setters.

La matricula permanece igual porque es la clave del ABB.

## Eliminacion

| Metodo   | Entrada | Caso        | Resultado esperado   | Resultado obtenido   | Estado |
| -------- | ------- | ----------- | -------------------- | -------------------- | ------ |
| eliminar | 20      | Hoja        | Estudiante eliminado | Estudiante eliminado | OK     |
| eliminar | 60      | Un hijo     | Estudiante eliminado | Estudiante eliminado | OK     |
| eliminar | 50      | Dos hijos   | Estudiante eliminado | Estudiante eliminado | OK     |
| eliminar | 99      | Inexistente | No existe            | No existe            | OK     |

Despues de eliminar 20, 60 y 50:

| Verificacion | Esperado             | Obtenido             | Estado |
| ------------ | -------------------- | -------------------- | ------ |
| INORDEN      | 30 35 40 45 65 70 80 | 30 35 40 45 65 70 80 | OK     |

La explicacion de cada cambio esta en [trazas_insercion_eliminacion.md](trazas_insercion_eliminacion.md).

## Pruebas de la solucion del reto

RetoSolucion comprueba preorden, inorden, posorden y altura en cinco conjuntos independientes.

Las secuencias y alturas de la siguiente tabla coincidieron con los resultados obtenidos.

| Caso                     | Preorden                   | Inorden                    | Posorden                   | Altura | Resultado |
| ------------------------ | -------------------------- | -------------------------- | -------------------------- | ------ | --------- |
| SW-N3-A                  | 45 25 10 30 27 70 60 65 90 | 10 25 27 30 45 60 65 70 90 | 10 27 30 25 65 60 90 70 45 | 3      | 4 OK      |
| Arbol vacio              | Cadena vacia               | Cadena vacia               | Cadena vacia               | -1     | 4 OK      |
| Un nodo: 50              | 50                         | 50                         | 50                         | 0      | 4 OK      |
| Cadena: 10, 20, 30, 40   | 10 20 30 40                | 10 20 30 40                | 40 30 20 10                | 3      | 4 OK      |
| Repetido: 20, 30, 30, 10 | 20 10 30                   | 10 20 30                   | 10 30 20                   | 1      | 4 OK      |

Salida final verificada:

```text
Resultado: 20/20 pruebas OK
```

La cantidad real reemplaza las nueve comprobaciones previstas inicialmente en el reparto: la solucion integrada comprueba cuatro resultados para cada uno de los cinco casos.

## Alcance de los resultados

Los metodos que todavia lanzan UnsupportedOperationException no se presentan como pruebas aprobadas.

RetoRecorridos es una plantilla para el curso. Sus metodos incompletos no deben confundirse con RetoSolucion, que contiene la implementacion y las verificaciones.

[Volver al README del Grupo 2](../README.md)
