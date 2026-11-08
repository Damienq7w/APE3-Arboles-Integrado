# Decisiones de implementación

Responsable de documentación — Jampier Camacho.

## Organización del sistema

Se mantuvieron los paquetes `app`, `modelo`, `enums` y `negocio`.

La organización académica utiliza un árbol general. Cada paralelo mantiene un ABB de estudiantes ordenado por matrícula.

## Decisiones principales

| Decisión                                                        | Justificación                                                               |
| --------------------------------------------------------------- | --------------------------------------------------------------------------- |
| Mantener un ABB por paralelo                                    | Permite administrar los estudiantes de cada paralelo de forma independiente |
| Ordenar por matrícula                                           | Facilita la búsqueda y evita registros con matrículas repetidas             |
| Buscar la ruta mediante recursión                               | Permite recorrer la jerarquía desde la raíz hasta la unidad solicitada      |
| Devolver `No existe` cuando no se encuentra una ruta            | Proporciona una respuesta clara para códigos inexistentes                   |
| Proteger la raíz UTA                                            | Conserva la base de la organización académica                               |
| Rechazar la eliminación de unidades con hijos                   | Evita eliminar subestructuras completas accidentalmente                     |
| Rechazar la eliminación de paralelos con estudiantes            | Conserva los registros vinculados al paralelo                               |
| Crear nodos nuevos para la transformación binaria               | Conserva la estructura del árbol general                                    |
| Representar el primer hijo mediante el enlace izquierdo         | Permite convertir la jerarquía general en una representación binaria        |
| Representar el siguiente hermano mediante el enlace derecho     | Mantiene la relación entre unidades del mismo nivel                         |
| Copiar al estudiante antes de trasladarlo                       | Evita compartir el mismo objeto entre los dos ABB                           |
| Insertar en el destino antes de eliminar del origen             | Permite comprobar la inserción antes de retirar el registro original        |
| Retirar la copia del destino si falla la eliminación del origen | Permite recuperar el estado anterior del traslado                           |
| Validar una modificación antes de aplicarla                     | Evita modificar parcialmente un registro cuando existen datos inválidos     |
| Recorrer todo el ABB para contar aprobados                      | La posición de los estudiantes depende de su matrícula                      |
| Reiniciar los datos al comenzar el reto                         | Permite repetir las pruebas desde las mismas condiciones                    |
| Separar las pruebas en clases por misión                        | Facilita la organización del trabajo y la revisión de resultados            |

## Validaciones

| Elemento                 | Validaciones aplicadas                                                       |
| ------------------------ | ---------------------------------------------------------------------------- |
| Matrícula                | Debe ser mayor que cero y no repetirse dentro del ABB                        |
| Cédula                   | Debe contener diez dígitos                                                   |
| Nombre del estudiante    | Debe contener texto                                                          |
| Promedio                 | Debe ser un número finito entre 0 y 10                                       |
| Unidad académica         | Debe tener código, nombre y tipo                                             |
| Código de unidad         | Debe ser único dentro de la organización                                     |
| Unidad padre             | Debe existir antes de agregar una unidad hija                                |
| Relación entre unidades  | El hijo debe pertenecer al tipo inmediatamente inferior                      |
| Eliminación de unidades  | La unidad debe existir, tener permiso de eliminación y estar vacía           |
| Traslado                 | Origen y destino deben existir, ser paralelos y ser diferentes               |
| Estudiante trasladado    | Debe existir en el origen y su matrícula debe estar disponible en el destino |
| Nota mínima para aprobar | Debe ser un número finito entre 0 y 10                                       |

## Casos de eliminación del ABB

Se probaron los siguientes casos mediante traslados entre paralelos.

| Matrícula | Caso               |
| --------- | ------------------ |
| 10        | Nodo hoja          |
| 40        | Nodo con un hijo   |
| 45        | Nodo con dos hijos |
| 30        | Raíz del árbol     |

Después de cada traslado se comprobó el recorrido inorden para verificar que las matrículas conservaran su orden.

## Criterio de altura

La altura se mide en aristas.

- Un árbol vacío tiene altura -1.
- Un árbol con un solo nodo tiene altura 0.
- Cada enlace adicional en el camino más largo aumenta la altura en una unidad.

## Repetición y reinicio

La opción 8 reinicia los datos antes de ejecutar las misiones. Esto permite repetir el reto y obtener el mismo estado final.

La opción 7 crea nuevamente la organización inicial, recupera los nueve estudiantes de EB-N1-A y deja vacío EB-N1-B.
