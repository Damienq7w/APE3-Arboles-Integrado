# Trabajo colaborativo de la APE 3

## Organización de las fases

La APE 3 se desarrolló en cuatro fases. En cada una, un grupo facilitó las actividades y los demás equipos trabajaron sobre el caso del Sistema Jerárquico Académico UTA.

| Fase             | Grupo facilitador | Trabajo principal                                      |
| ---------------- | ----------------- | ------------------------------------------------------ |
| 1. Modelado      | Grupo 1           | Análisis del caso, diagramas y estructura inicial.     |
| 2. Recursividad  | Grupo 2           | Inserción, búsqueda, consultas y recorridos.           |
| 3. Actualización | Grupo 3           | Modificación, eliminación y transformación de árboles. |
| 4. Integración   | Grupo 4           | Integración del sistema, pruebas e informe.            |

Las carpetas de las fases permiten consultar los materiales y el código de cada etapa. El directorio `src/` contiene el sistema integrado.

## Integrantes del Grupo 2

- Cunalata Mendoza Damian Alexander.
- Chalco Tasna Kenneth Mateo.
- Camacho Monta Josue Jampier.
- Tisalema Guashco Darwin Joel.
- Tacuri Santillan Mónica Sara.
- Silva Camuendo Luis Alexander.

## Participación en las fases anteriores

### Fase 2: recursividad

| Integrante            | Responsabilidad                                                          |
| --------------------- | ------------------------------------------------------------------------ |
| Damian Cunalata       | Agregar y buscar unidades académicas; integración de las ramas.          |
| Kenneth Chalco        | Altura del árbol general; inserción y búsqueda en el ABB; estación E1.   |
| Darwin Tisalema       | Mostrar la jerarquía; recorridos y trazas del ABB; estación E2.          |
| Luis Silva            | Grado y nivel; modificación y eliminación de estudiantes; estación E3.   |
| Mónica Tacuri         | Conteo de hojas; estación E4 de identificación de errores y Padlet.      |
| Josue Jampier Camacho | README, índices, casos de prueba, decisiones y material de facilitación. |

### Fase 3: actualización

El Grupo 2 trabajó conjuntamente en las preguntas guía sobre modificación, eliminación, trazas y casos límite planteadas por el grupo facilitador.

## Distribución del trabajo en la integración

| Integrante            | Rama prevista     | Archivos a su cargo                                                           |
| --------------------- | ----------------- | ----------------------------------------------------------------------------- |
| Damian Cunalata       | `Damian_Cunalata` | `PruebasSJA.java`, `Verificador.java` y `PruebasArbolGeneral.java`.           |
| Kenneth Chalco        | `Mateo-Chalco`    | `PruebasInsercionBusqueda.java`.                                              |
| Darwin Tisalema       | `Rama-Joel`       | `PruebasRecorridosEstadisticas.java`.                                         |
| Luis Silva            | `Luis-Silva`      | `PruebasModificacionEliminacion.java`.                                        |
| Mónica Tacuri         | `Monica_Tacuri`   | `PruebasEliminacionTransformacion.java`.                                      |
| Josue Jampier Camacho | `rama-Josue`      | README, documentación colaborativa, plan de pruebas y registro de resultados. |

Las clases de pruebas se ubican en `src/pruebas/`. Cada integrante también prepara su aporte y reflexión en `docs/aportes/`.

La tabla describe las responsabilidades asignadas. La incorporación efectiva de cada aporte se comprueba en el historial y en los pull requests del repositorio.

## Forma de trabajo

1. Cada integrante actualiza su copia del repositorio y trabaja en su propia rama.
2. Agrega o modifica los archivos correspondientes a su responsabilidad.
3. Comprueba los cambios y registra un commit con un mensaje descriptivo.
4. Sube su rama y abre un pull request hacia `main`.
5. Damian revisa e integra los aportes.
6. Con todas las clases incorporadas, se ejecutan las pruebas completas y se actualiza la documentación.

La documentación puede prepararse antes de que termine la integración. Los resultados definitivos se registran después de ejecutar el sistema con todos los aportes.

## Comprobación del proyecto integrado

Desde la raíz del repositorio, en PowerShell:

```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
```

Si la compilación termina sin errores:

```powershell
java -cp out pruebas.PruebasSJA
```

Antes de cerrar la entrega se debe comprobar que:

- Estén incorporadas las cinco clases de pruebas.
- No aparezcan clases pendientes ni verificaciones fallidas.
- El total ejecutado coincida con los casos del plan de pruebas.
- `docs/salida_pruebas.txt` corresponda a la ejecución real del proyecto integrado.
- Las instrucciones y los enlaces de la documentación funcionen.

## Consulta del historial

Para consultar autores y cantidad de commits:

```bash
git shortlog -sn --all
```

Para revisar ramas, commits y fusiones:

```bash
git log --all --oneline --graph --decorate
```

Estos registros permiten consultar la participación y la integración de los cambios.

## Documentación relacionada

- [Presentación e instrucciones del proyecto](README.md)
- [Plan de pruebas](docs/PLAN_DE_PRUEBAS.md)
- [Registro de ejecución](docs/salida_pruebas.txt)
- [Aportes individuales](docs/aportes/)
- [Aporte de Josue Jampier Camacho](docs/aportes/josue-jampier-camacho.md)

## Repositorios de referencia

| Fases | Repositorio                                                           |
| ----- | --------------------------------------------------------------------- |
| 1     | https://github.com/juanchicoyunda1234/APE3-Arboles                    |
| 2     | https://github.com/Damienq7w/APE3-Arboles-Grupo2                      |
| 3     | https://github.com/ElJoss09/APE3_ArbolGeneral_ABB_Grupo3              |
| 4     | https://github.com/shirleymikaela2/APE3-Grupo4-Integracion-y-pruebas- |
