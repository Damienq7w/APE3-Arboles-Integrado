# APE 3 — Árboles: caso SJA-UTA (Fases 1 a 4 integradas)

| | |
|---|---|
| **Universidad** | Universidad Técnica de Ambato · Facultad de Ingeniería en Sistemas, Electrónica e Industrial |
| **Carrera y asignatura** | Software · Estructura de Datos · Tercero «B» |
| **Período** | Julio 2026 – Diciembre 2026 |
| **Docente** | Ing. José Rubén Caiza Caizabuano, PhD |
| **Grupo 2** | Cunalata Mendoza Damian Alexander, Camacho Monta Josue Jampier, Chalco Tasna Kenneth Mateo, Silva Camuendo Luis Alexander, Tacuri Santillan Mónica Sara, Tisalema Guashco Darwin Joel |

## Qué es este repositorio

El Sistema Jerárquico Académico UTA (SJA-UTA) es el caso de la APE 3: una aplicación de consola en Java con dos estructuras.

- Un **árbol general** para la organización: UTA → Facultad → Carrera → Nivel → Paralelo.
- Un **árbol binario de búsqueda (ABB)** por paralelo, que guarda a los estudiantes ordenados por matrícula.

Según la planificación de la asignatura, la APE 3 se desarrolló en **4 fases**, cada una facilitada por un grupo del curso. Este repositorio las **integra**:

- Cada fase está en su carpeta, importada **con su historial de commits original**, así que se conserva quién hizo cada cambio.
- En `src/` está el SJA-UTA terminado al cierre de la Fase 4, con las operaciones de las cuatro fases.
- En [COLABORACION.md](COLABORACION.md) se detalla el trabajo colaborativo: grupos, integrantes, ramas, pull requests y commits.

## Fases de la APE 3

| Carpeta | Fase (cronograma) | Facilita | Contenido |
|---|---|---|---|
| [`fase-1-modelado/`](fase-1-modelado/README.md) | 1 · Análisis del caso, modelado y estructura base | Grupo 1 | Caso SJA-UTA, diagramas de clases, objetos y paquetes, fichas por facultad, datos de prueba y esqueleto Java |
| [`fase-2-recursividad/`](fase-2-recursividad/README.md) | 2 · Inserción y recorridos recursivos | Grupo 2 | Inserción, búsqueda, recorridos y trazas del ABB; consultas del árbol general; diagramas de flujo y de secuencia; estaciones |
| [`fase-3-actualizacion/`](fase-3-actualizacion/README.md) | 3 · Modificación, eliminación y transformación | Grupo 3 | Eliminación de unidades, transformación a binario, estadísticas del ABB, casos límite y clínica de errores |
| [`fase-4-integracion/`](fase-4-integracion/grupo4-integracion-y-pruebas/README.md) | 4 · Integración, pruebas e informe | Grupo 4 | Integración del sistema, menú final, reinicio de datos y pruebas |
| [`src/`](src/) | 1 a 4 | Integración | SJA-UTA terminado: todas las operaciones del caso |

## Operaciones del caso

| # | Operación | Fase | Clase en `src/` |
|---|---|---|---|
| A1 · A2 | Agregar y buscar una unidad | 2 | `negocio/ArbolOrganizacional` |
| A3 | Mostrar la jerarquía con sangría | 2 | `negocio/ArbolOrganizacional` |
| A4 | Altura, grado, nivel y hojas | 2 | `negocio/ArbolOrganizacional` |
| A5 | Eliminar una unidad (solo si no tiene subunidades ni estudiantes) | 3 | `negocio/ArbolOrganizacional` |
| A6 | Transformar a binario (hijo izquierdo / hermano derecho) | 3 | `negocio/ArbolOrganizacional` |
| B1 · B2 | Insertar sin duplicados y buscar por matrícula | 2 | `negocio/ArbolEstudiantes` |
| B3 | Recorridos preorden, inorden y posorden con traza | 2 | `negocio/ArbolEstudiantes` |
| B4 · B5 | Modificar y eliminar (hoja, un hijo, dos hijos) | 3 | `negocio/ArbolEstudiantes` |
| B6 | Estadísticas: total, altura, menor, mayor y promedio | 3 | `negocio/ArbolEstudiantes` |
| Integración | Menú, estado general y reinicio de datos | 4 | `app/Main`, `app/Contexto` |

## Compilar y ejecutar

Se requiere JDK 21. Desde la raíz del repositorio, en PowerShell:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out app.Main
```

Cada carpeta de fase conserva su propio código tal como quedó en esa fase. Se compila por separado desde su carpeta, porque las clases tienen los mismos nombres.

## Repositorios originales

| Fase | Repositorio |
|---|---|
| 1 y 2 | https://github.com/Damienq7w/APE3-Arboles-Grupo2 |
| 3 | https://github.com/ElJoss09/APE3_ArbolGeneral_ABB_Grupo3 |
| 4 | https://github.com/shirleymikaela2/APE3-Grupo4-Integracion-y-pruebas- |

## Restricciones respetadas

- Árboles con nodos propios: no se usan `TreeMap` ni `TreeSet`. `ArrayList` solo guarda los hijos del árbol general.
- Recorridos, altura y consultas recursivos.
- Capas: `enums` → `modelo` → `negocio` → `app`.
- Validaciones en el modelo y en la capa de negocio.
