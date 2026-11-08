# SJA-UTA: Sistema Jerárquico Académico UTA

**APE 3 · Árboles** · Estructura de Datos · Tercero "B" · Ing. José Rubén Caiza Caizabuano
Universidad Técnica de Ambato · FISEI · Software · Julio a diciembre 2026

Aplicación de consola en Java que representa la **estructura organizacional de la UTA** con un **árbol general**
y gestiona a los **estudiantes de cada paralelo** con un **árbol binario de búsqueda (ABB)** ordenado por matrícula.

## Fases de la APE 3

| Fase | Fecha | Facilita | Qué se construye |
|---|---|---|---|
| **1** | Lun 12/10 | **Grupo 1** | Caso, diagramas, esqueleto Java y modelado de los árboles con el curso |
| 2 | Lun 19/10 | Grupo 2 | Inserción y recorridos recursivos (métodos `Pendiente: Fase 2`) |
| 3 | Jue 22/10 | Grupo 3 | Modificación, eliminación y transformación general → binario (`Pendiente: Fase 3`) |
| 4 | Jue 05/11 | Grupo 4 | Integración, pruebas, demostración e informe |

## Cómo está organizado

```
src/
├── enums/     TipoUnidad y TipoRecorrido (completo)
├── modelo/    datos puros: UnidadAcademica y Estudiante (completo)
├── negocio/   nodos completos + árboles con firmas (la lógica la hacen las fases 2 y 3)
└── app/       menú y datos de prueba (completo)

Dependencias en un solo sentido: app → negocio → modelo → enums
```

Cada método sin lógica lanza `UnsupportedOperationException("Pendiente: Fase X")`.
**Para encontrar lo que te toca, busca en el proyecto el texto `Pendiente: Fase 2` o `Pendiente: Fase 3`.**

## Cómo ejecutar

```bash
javac -d out $(find src -name "*.java")
java -cp out app.Main
```

En Windows (PowerShell):
```powershell
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out app.Main
```
O ábrelo en IntelliJ / VS Code marcando `src` como carpeta de fuentes y ejecuta `app.Main`.

Mientras la Fase 2 no esté hecha, cada opción del menú muestra `[PENDIENTE] Pendiente: Fase 2 (...)`. Eso es lo esperado.

## Documentación

| Documento | Contenido |
|---|---|
| [docs/caso.md](docs/caso.md) | Enunciado completo, operaciones (requisitos) y restricciones |
| [docs/datos-prueba.md](docs/datos-prueba.md) | Facultades y carreras de la UTA, datos del ABB de ejemplo |
| [docs/equipos.md](docs/equipos.md) | Equipos del design challenge y su facultad |
| [docs/fichas/](docs/fichas/) | Ficha de trabajo de cada facultad |
| [docs/diagramas/paquetes.md](docs/diagramas/paquetes.md) | Diagrama de paquetes |
| [docs/diagramas/clases.md](docs/diagramas/clases.md) | **Diagrama de clases completo** |
| [docs/diagramas/objetos.md](docs/diagramas/objetos.md) | Cómo se une un PARALELO con su ABB |
| [docs/diagramas/ejemplo-fisei.md](docs/diagramas/ejemplo-fisei.md) | Ejemplo resuelto: FISEI |
| [facilitacion/](facilitacion/) | Guion, banco de preguntas, lista de cotejo y enlaces de la Fase 1 |

## Grupo 1 (Fase 1)

- Altamirano Segovia Jullisa Brigitte
- Chico Yunda Juan Carlos (líder)
- Llamuca Abrajan Andrés Joel
- Romo Núñez Joseph Alejandro
- Torosina Armendariz Jeremy Alejandro
- Tuza Quinatoa Edith Noemi
