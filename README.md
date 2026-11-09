# APE 3 — Árboles: Sistema Jerárquico Académico UTA

## Datos generales

| Dato        | Descripción                                      |
| ----------- | ------------------------------------------------ |
| Universidad | Universidad Técnica de Ambato                    |
| Facultad    | Ingeniería en Sistemas, Electrónica e Industrial |
| Carrera     | Software                                         |
| Asignatura  | Estructura de Datos                              |
| Curso       | Tercero B                                        |
| Período     | Julio 2026 – Diciembre 2026                      |
| Docente     | Ing. José Rubén Caiza Caizabuano, PhD            |
| Equipo      | Grupo 2                                          |

## Descripción del proyecto

El Sistema Jerárquico Académico UTA (SJA-UTA) es una aplicación de consola desarrollada en Java. Utiliza dos estructuras:

- Un árbol general para representar la organización académica: universidad, facultad, carrera, nivel y paralelo.
- Un árbol binario de búsqueda (ABB) por paralelo para almacenar estudiantes ordenados por matrícula.

Este repositorio reúne el trabajo de las cuatro fases de la APE 3. Las carpetas de cada fase conservan sus materiales y código, mientras que `src/` contiene el sistema integrado.

## Organización del repositorio

| Carpeta o archivo       | Contenido                                               |
| ----------------------- | ------------------------------------------------------- |
| `fase-1-modelado/`      | Análisis del caso, modelado y estructura inicial.       |
| `fase-2-recursividad/`  | Inserción, búsqueda, consultas y recorridos recursivos. |
| `fase-3-actualizacion/` | Modificación, eliminación y transformación de árboles.  |
| `fase-4-integracion/`   | Integración del sistema y actividades de comprobación.  |
| `src/`                  | Código fuente del sistema integrado.                    |
| `src/pruebas/`          | Ejecutor y clases de pruebas del Grupo 2.               |
| `docs/`                 | Plan de pruebas, registro de resultados y aportes.      |
| `COLABORACION.md`       | Organización del equipo y distribución del trabajo.     |

## Funcionalidades

### Árbol organizacional

- Agregar y buscar unidades académicas.
- Mostrar la jerarquía con sangría.
- Consultar altura, grado, nivel y cantidad de hojas.
- Eliminar unidades respetando las restricciones del sistema.
- Representar el árbol como binario mediante hijo izquierdo y hermano derecho.

### Árbol de estudiantes

- Insertar estudiantes sin repetir matrículas.
- Buscar estudiantes por matrícula.
- Mostrar recorridos preorden, inorden y posorden.
- Modificar los datos de un estudiante.
- Eliminar nodos considerando los casos de hoja, un hijo y dos hijos.
- Consultar cantidad, altura, matrícula menor, matrícula mayor y promedio.

### Integración

- Acceder a las operaciones mediante un menú de consola.
- Consultar el estado general del sistema.
- Reiniciar los datos de ejemplo.

## Requisitos

- JDK 21.
- Una terminal para compilar y ejecutar el proyecto.
- Git para trabajar con las ramas y registrar los cambios.

## Compilar y ejecutar

Desde la raíz del repositorio, abre una terminal PowerShell.

Compila únicamente el código del sistema integrado:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
```

Si la compilación termina sin errores, inicia el menú:

```powershell
java -cp out app.Main
```

Las carpetas de las fases contienen otras versiones de las clases. Por eso se compila `src/` y no todos los archivos Java del repositorio juntos.

## Ejecutar las pruebas

Después de compilar:

```powershell
java -cp out pruebas.PruebasSJA
```

El ejecutor muestra las comprobaciones y un resumen de resultados. Si falta alguna clase de pruebas, la identifica como pendiente.

La comprobación final debe realizarse cuando estén integradas las clases de todos los responsables. El total esperado según el plan suministrado es de 113 verificaciones; el resultado definitivo debe coincidir con la ejecución real.

- [Plan de pruebas](docs/PLAN_DE_PRUEBAS.md)
- [Registro de salida](docs/salida_pruebas.txt)

## Distribución de responsabilidades

| Integrante            | Responsabilidad en la integración                                    |
| --------------------- | -------------------------------------------------------------------- |
| Damian Cunalata       | Ejecutor de pruebas, verificador y pruebas del árbol general.        |
| Kenneth Chalco        | Pruebas de inserción, búsqueda y validaciones.                       |
| Darwin Tisalema       | Pruebas de recorridos y estadísticas.                                |
| Luis Silva            | Pruebas de modificación y eliminación de estudiantes.                |
| Mónica Tacuri         | Pruebas de eliminación de unidades y transformación binaria.         |
| Josue Jampier Camacho | README, documentación colaborativa, plan de pruebas e informe final. |

Los aportes individuales se encuentran en [docs/aportes/](docs/aportes/).

## Trabajo colaborativo

Cada integrante trabaja en su rama y registra sus cambios mediante commits. La integración se realiza mediante pull requests hacia `main`.

Antes de cerrar la entrega se debe:

1. Integrar los aportes del equipo.
2. Compilar el sistema.
3. Ejecutar todas las pruebas y revisar los casos pendientes o fallidos.
4. Actualizar el registro de salida y los resultados documentados.
5. Comprobar los enlaces y las instrucciones de ejecución.

Consulta [COLABORACION.md](COLABORACION.md) para revisar la organización del trabajo.

## Repositorios de las fases

- Fase 1: https://github.com/juanchicoyunda1234/APE3-Arboles
- Fase 2: https://github.com/Damienq7w/APE3-Arboles-Grupo2
- Fase 3: https://github.com/ElJoss09/APE3_ArbolGeneral_ABB_Grupo3
- Fase 4: https://github.com/shirleymikaela2/APE3-Grupo4-Integracion-y-pruebas-
