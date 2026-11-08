# APE 3 — Árboles: caso SJA-UTA (Fases 1 a 4 integradas)

**Universidad Técnica de Ambato · Facultad de Ingeniería en Sistemas, Electrónica e Industrial**
**Carrera de Software · Estructura de Datos · Tercero «B» · Julio 2026 – Diciembre 2026**
**Docente:** Ing. José Rubén Caiza Caizabuano, PhD

**Grupo 2:** Cunalata Mendoza Damian Alexander · Camacho Monta Josue Jampier · Chalco Tasna Kenneth Mateo · Silva Camuendo Luis Alexander · Tacuri Santillan Mónica Sara · Tisalema Guashco Darwin Joel

## Qué es este repositorio

El Sistema Jerárquico Académico UTA (SJA-UTA) es una aplicación de consola en Java con dos estructuras:

- Un **árbol general** para la organización: UTA → Facultad → Carrera → Nivel → Paralelo.
- Un **árbol binario de búsqueda (ABB)** por paralelo, que guarda a los estudiantes ordenados por matrícula.

La APE 3 se desarrolló en **4 fases**, cada una facilitada por un grupo del curso. Este repositorio las **integra en un solo lugar**:

- Cada fase está en su carpeta, importada **con su historial de commits original**, así que se conserva quién hizo cada cambio.
- En `src/` está el código final, que reúne las operaciones de las 4 fases.
- En [COLABORACION.md](COLABORACION.md) se detalla el trabajo colaborativo: grupos, integrantes, ramas, pull requests y commits.

## Estructura

| Carpeta | Fase | Facilita | Contenido |
|---|---|---|---|
| [`fase-1-modelado/`](fase-1-modelado/README.md) | 1 · Lun 12/10 | Grupo 1 | Caso SJA-UTA, diagramas de clases, objetos y paquetes, fichas por facultad, datos de prueba y esqueleto Java |
| [`fase-2-recursividad/`](fase-2-recursividad/README.md) | 2 · Lun 19/10 | Grupo 2 | Inserción, búsqueda y recorridos recursivos del ABB; consultas del árbol general; trazas, diagramas de flujo y de secuencia, estaciones y reto |
| [`fase-3-actualizacion/`](fase-3-actualizacion/README.md) | 3 · Jue 22/10 | Grupo 3 | Eliminación de unidades, transformación a binario, modificación y eliminación en el ABB, estadísticas, casos límite y clínica de errores |
| [`fase-4-integracion/grupo4-integracion-y-pruebas/`](fase-4-integracion/grupo4-integracion-y-pruebas/README.md) | 4 · Jue 05/11 | Grupo 4 | Integración del sistema, menú final, pruebas funcionales y reinicio de datos |
| [`fase-4-integracion/reto-integrador-grupo2/`](fase-4-integracion/reto-integrador-grupo2/README.md) | 4 | Grupo 2 (resuelve) | Reto práctico integrador propuesto por el Grupo 4: 6 misiones, 97 verificaciones |
| [`src/`](src/) | 1 a 4 | Integración | Versión final del SJA-UTA con todas las operaciones |
| [`docs/`](docs/) | — | Grupo 2 | Informe final de la APE 3 |

## Operaciones del caso y dónde quedaron

| # | Operación | Fase | Clase en `src/` |
|---|---|---|---|
| A1 · A2 | Agregar y buscar una unidad | 2 | `negocio/ArbolOrganizacional` |
| A3 | Mostrar la jerarquía con sangría | 2 | `negocio/ArbolOrganizacional` |
| A4 | Altura, grado, nivel y hojas | 2 | `negocio/ArbolOrganizacional` |
| A5 | Eliminar una unidad (solo hojas vacías) | 3 · 4 | `negocio/EliminadorUnidades` |
| A6 | Transformar a binario (hijo izquierdo / hermano derecho) | 3 · 4 | `negocio/TransformadorBinario`, `negocio/NodoBinario` |
| B1 · B2 | Insertar sin duplicados y buscar por matrícula | 2 | `negocio/ArbolEstudiantes` |
| B3 | Recorridos preorden, inorden y posorden con traza | 2 | `negocio/ArbolEstudiantes` |
| B4 · B5 | Modificar y eliminar (hoja, un hijo, dos hijos) | 2 · 3 | `negocio/ArbolEstudiantes` |
| B6 | Estadísticas: total, altura, menor, mayor y promedio | 3 | `negocio/ArbolEstudiantes` |
| Reto | Ruta jerárquica, traslado entre paralelos, aprobados, opción 8 | 4 | `RutaJerarquica`, `TrasladoEstudiantes`, `app/RetoIntegrador` |

## Compilar y ejecutar

Se requiere JDK 21. Desde la raíz del repositorio, en PowerShell:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out app.Main
```

Para ejecutar directamente el reto integrador (97 verificaciones):

```powershell
java -cp out app.RetoIntegrador
```

Cada carpeta de fase conserva su propio código tal como quedó en esa fase. Se compila por separado desde su carpeta, porque las clases tienen los mismos nombres.

## Repositorios originales

| Fase | Repositorio |
|---|---|
| 1 y 2 | https://github.com/Damienq7w/APE3-Arboles-Grupo2 |
| 3 | https://github.com/ElJoss09/APE3_ArbolGeneral_ABB_Grupo3 |
| 4 (Grupo 4) | https://github.com/shirleymikaela2/APE3-Grupo4-Integracion-y-pruebas- |
| 4 (reto del Grupo 2) | https://github.com/Damienq7w/Estructura_Datos_Reto_Grupo4 |

## Restricciones respetadas

- Árboles con nodos propios: no se usan `TreeMap` ni `TreeSet`. `ArrayList` solo guarda los hijos del árbol general.
- Recorridos, altura y consultas recursivos.
- Capas: `enums` → `modelo` → `negocio` → `app`.
- Validaciones en el modelo y en la capa de negocio.
