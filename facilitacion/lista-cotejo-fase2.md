# Lista de cotejo de la Fase 2

## Datos de la revisión

- Fecha:
- Responsable de la revisión:
- Rama o commit revisado:

## Código y ejecución

- [ ] El proyecto compila sin errores.
- [ ] El programa carga los datos iniciales.
- [ ] Se mantiene la separación en enums, modelo, negocio y app.
- [ ] Los árboles utilizan nodos propios, sin TreeMap ni TreeSet.
- [ ] Se conservan las firmas acordadas.

## Árbol general

### Agregar y buscar — A1 y A2

- [ ] Se agrega una unidad bajo un padre existente y del tipo permitido.
- [ ] Se rechaza un código de unidad repetido.
- [ ] Se rechaza una relación jerárquica incorrecta.
- [ ] Se rechaza la inserción cuando el padre no existe.
- [ ] La búsqueda encuentra códigos existentes.
- [ ] La búsqueda admite minúsculas y espacios alrededor del código.
- [ ] La búsqueda devuelve null si la unidad no existe.

### Mostrar jerarquía — A3

- [ ] La opción 1 muestra las 88 unidades iniciales.
- [ ] UTA aparece como raíz.
- [ ] Cada nivel agrega dos espacios de sangría.
- [ ] El método recorre los hijos de forma recursiva.

### Altura, grado, nivel y hojas — A4

- [ ] altura() está implementado mediante recursividad.
- [ ] La altura se mide en aristas.
- [ ] La altura del árbol inicial es 4.
- [ ] contarHojas() está implementado mediante recursividad.
- [ ] El árbol inicial tiene 57 hojas.
- [ ] La opción 4 muestra Altura: 4 y Hojas: 57.
- [ ] UTA tiene grado 10 y nivel 0.
- [ ] FISEI tiene grado 5 y nivel 1.
- [ ] SW-N3-B tiene grado 0 y nivel 4.
- [ ] Un código inexistente devuelve -1 en grado() y nivel().
- [ ] Los estudiantes no se cuentan como hijos organizacionales del paralelo.

Estas comprobaciones se realizan con los datos iniciales, sin agregar ni eliminar unidades.

## ABB de estudiantes

### Inserción y búsqueda — B1 y B2

- [ ] La inserción utiliza recursividad.
- [ ] La matrícula 45 se inserta como hijo derecho de 40.
- [ ] Una segunda inserción de 45 se rechaza.
- [ ] La búsqueda encuentra una matrícula existente.
- [ ] La búsqueda devuelve null para una matrícula inexistente.
- [ ] La búsqueda sigue el subárbol correspondiente según la matrícula.

### Recorridos y trazas — B3

- [ ] Preorden visita antes de recorrer los hijos.
- [ ] Inorden visita entre el subárbol izquierdo y el derecho.
- [ ] Posorden visita después de recorrer ambos hijos.
- [ ] El inorden entrega las matrículas en orden ascendente.
- [ ] Un ABB vacío devuelve una lista vacía al recorrerlo.
- [ ] La opción 14 muestra entra, VISITA y null -> regresa.
- [ ] La traza utiliza sangría para representar la profundidad.

Con 45 insertado y antes de eliminar estudiantes:

| Recorrido | Secuencia esperada            |
| --------- | ----------------------------- |
| Preorden  | 50 30 20 40 35 45 70 60 65 80 |
| Inorden   | 20 30 35 40 45 50 60 65 70 80 |
| Posorden  | 20 35 45 40 30 65 60 80 70 50 |

## Adelantos de la Fase 3 — B4 y B5

- [ ] La modificación conserva la matrícula.
- [ ] Los datos inválidos se rechazan sin modificar parcialmente al estudiante.
- [ ] Se comprueba la eliminación de una hoja.
- [ ] Se comprueba la eliminación de un nodo con un hijo.
- [ ] Se comprueba la eliminación de un nodo con dos hijos.
- [ ] La eliminación conserva el orden del ABB.
- [ ] Se informa al Grupo 3 que estas operaciones ya están implementadas.

Al eliminar 20, 60 y 50, en ese orden, después de insertar 45:

- [ ] El inorden final es 30 35 40 45 65 70 80.
- [ ] La nueva raíz es 65.

## Diagramas y documentación

- [ ] Los diagramas están guardados en Markdown con Mermaid.
- [ ] Los diagramas se visualizan correctamente en GitHub.
- [ ] Están los diagramas de flujo y secuencia de mostrarJerarquia.
- [ ] Están los diagramas de flujo y secuencia de altura.
- [ ] Están los diagramas de flujo y secuencia de grado y nivel.
- [ ] Están los diagramas de flujo y secuencia de contarHojas.
- [ ] Los índices contienen los enlaces a los diagramas incorporados.
- [ ] casos_prueba.md distingue resultados esperados y obtenidos.
- [ ] decisiones.md refleja los acuerdos de la Fase 2.
- [ ] El README del Grupo 2 refleja el estado del código.
- [ ] El README principal permite acceder al material de la Fase 2.
- [ ] La documentación utiliza tildes y ñ.
- [ ] No se presentan métodos pendientes como terminados.

## Estaciones y Padlet

- [ ] Está publicada la lista común de matrículas.
- [ ] Está definido el orden de rotación de los grupos.
- [ ] Cada estación tiene previstos siete minutos.
- [ ] E1 incluye el ejercicio de inserción y su solución.
- [ ] E2 incluye el ejercicio de preorden y su solución.
- [ ] E3 incluye los ejercicios de inorden y posorden y sus soluciones.
- [ ] E4 incluye el error recursivo y su corrección.
- [ ] Los ejercicios y las soluciones están diferenciados.
- [ ] El Padlet tiene columnas para los grupos 1, 3, 4 y 5.
- [ ] Se comprobó que los compañeros pueden publicar.
- [ ] El enlace del Padlet está registrado en enlaces.md.
- [ ] El QR permite acceder al Padlet correcto.
- [ ] Los grupos conocen cómo titular y publicar sus respuestas.

## Informe y presentación

- [ ] El informe conserva el contenido del Grupo 1.
- [ ] Está completo el bloque correspondiente a la Fase 2.
- [ ] Los espacios que llenará el curso están resaltados en amarillo.
- [ ] Las figuras tienen número y título.
- [ ] Las capturas corresponden al código y a los diagramas del repositorio.
- [ ] Las referencias nuevas continúan la numeración existente.
- [ ] Los anexos incluyen los enlaces y espacios para evidencias.
- [ ] Las diapositivas están completas.
- [ ] El guion de la clase indica tiempos y responsables.
- [ ] El deber preparado por Damián está disponible.
- [ ] Se comprobó el acceso de solo lectura al documento compartido.

## Repositorio y preparación de la clase

- [ ] Cada integrante trabajó en su rama.
- [ ] Los commits describen cambios concretos.
- [ ] Damián revisó e integró los pull requests.
- [ ] Se ejecutaron las comprobaciones después de integrar.
- [ ] El proyecto está abierto y compilado antes de la clase.
- [ ] El proyector y la conexión funcionan.
- [ ] El Padlet está abierto para proyectarse.
- [ ] El cronómetro está preparado.
- [ ] Se acordó avisar cuando falten dos minutos de cada bloque.

## Observaciones

Registrar los elementos pendientes, el responsable y la acción necesaria:

| Elemento | Observación | Responsable | Acción pendiente |
| -------- | ----------- | ----------- | ---------------- |
|          |             |             |                  |

[Volver al README del Grupo 2](../README.md)
