# Reto práctico integrador SJA-UTA

**Materia:** Estructura de Datos  
**Carrera:** Ingeniería de Software · Universidad Técnica de Ambato  
**Responsable de documentación:** Josué Jampier Camacho

## Descripción

El Sistema Jerárquico Académico UTA es una aplicación de consola en Java. Usa un árbol general para organizar las unidades académicas y un árbol binario de búsqueda (ABB) en cada paralelo para guardar estudiantes por matrícula.

La jerarquía inicial es `UTA → FCHE → EB → EB-N1`, con los paralelos `EB-N1-A` y `EB-N1-B`. El reto comprueba la búsqueda de rutas, la eliminación protegida de unidades, los traslados de estudiantes y el reinicio de los datos.

## Estructura del proyecto

| Carpeta        | Contenido                                                                  |
| -------------- | -------------------------------------------------------------------------- |
| `src/app/`     | Menú, datos iniciales, misiones y reporte del reto                         |
| `src/modelo/`  | Clases `Estudiante` y `UnidadAcademica`                                    |
| `src/negocio/` | Árboles, nodos, búsqueda de rutas, eliminación, transformación y traslados |
| `src/enums/`   | Tipos de unidades académicas y recorridos                                  |
| `docs/`        | Decisiones, evidencias, salida de consola y descripción de las misiones    |

## Compilación y ejecución

El proyecto se probó con JDK 21. En PowerShell, desde la raíz del repositorio:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out app.Main
```

En Git Bash o Linux:

```bash
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out app.Main
```

Para ejecutar directamente el reto integrador:

```text
java -cp out app.RetoIntegrador
```

## Menú principal

| Opción | Acción                                                   |
| ------ | -------------------------------------------------------- |
| 1      | Consultar la jerarquía académica y la ruta de una unidad |
| 2      | Insertar o buscar estudiantes en un paralelo             |
| 3      | Consultar recorridos y estadísticas de un paralelo       |
| 4      | Modificar o eliminar estudiantes de un paralelo          |
| 5      | Eliminar unidades o mostrar la transformación binaria    |
| 6      | Estado general: árbol y ambos paralelos                  |
| 7      | Reiniciar los datos de ejemplo                           |
| 8      | Ejecutar el reto integrador                              |
| 0      | Salir                                                    |

En las opciones 2, 3 y 4 se escribe el código del paralelo (`EB-N1-A` o `EB-N1-B`); con Enter se usa `EB-N1-A`.

## Responsables

| Integrante            | Aporte                                                        |
| --------------------- | ------------------------------------------------------------- |
| Damian Cunalata       | Misiones 1 y 6 · Ruta institucional, integración y reinicio   |
| Mónica Tacuri         | Misión 2 · Eliminación protegida y transformación binaria     |
| Kenneth Chalco        | Misión 3 · Validaciones y traslado entre paralelos            |
| Luis Silva            | Misión 4 · Modificación segura y casos de eliminación del ABB |
| Darwin Tisalema       | Misión 5 · Recorridos y estadísticas comparadas               |
| Josué Jampier Camacho | Documentación, decisiones y evidencias de ejecución           |

### Clases por integrante

Cada clase tiene un solo responsable. `ArbolOrganizacional` conserva los métodos que pide el enunciado y delega cada operación del reto en la clase de quien la programa.

| Integrante            | Clases                                                                                          |
| --------------------- | ----------------------------------------------------------------------------------------------- |
| Damian Cunalata       | `ArbolOrganizacional`, `RutaJerarquica`, `Contexto`, `Main`, `RetoIntegrador`, `RetoMision1`    |
| Mónica Tacuri         | `NodoUnidad`, `NodoBinario`, `EliminadorUnidades`, `TransformadorBinario`, `RetoMision2`        |
| Kenneth Chalco        | `Estudiante`, `UnidadAcademica`, `TipoUnidad`, `TrasladoEstudiantes`, `RetoMision3`             |
| Luis Silva            | `NodoEstudiante`, `Reporte`, `RetoMision4`                                                      |
| Darwin Tisalema       | `TipoRecorrido`, `ArbolEstudiantes`, `RetoMision5`                                              |
| Josué Jampier Camacho | `README.md`, `docs/decisiones.md`, `docs/evidencias.md`, `docs/salida_reto.txt`                 |

Cada misión se explica en `docs/misiones/`, escrita por su responsable.

## Resultado y documentación

El reto integrado en `main` obtuvo **97/97 verificaciones correctas**.

- [Descripción de las misiones](docs/misiones/)
- [Decisiones de implementación](docs/decisiones.md)
- [Evidencias de ejecución](docs/evidencias.md)
- [Salida completa del reto](docs/salida_reto.txt)
