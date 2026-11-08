# Banco de preguntas

## Quizizz: repaso de Introducción a los árboles (inicio de clase)

| # | Pregunta | Opciones | Correcta |
|---|---|---|---|
| 1 | Una estructura de carpetas contiene «Documentos» como carpeta principal; dentro de ella están «Universidad» y «Fotos», y dentro de «Universidad» están «Datos» y «Cálculo». ¿Qué ventaja representa esta organización frente a una lista lineal? | 1. Permite visualizar las relaciones jerárquicas entre carpetas · 2. Obliga a guardar todos los archivos en una carpeta única · 3. Permite ordenar las carpetas únicamente por tamaño · 4. Elimina la necesidad de establecer relaciones entre carpetas | **1. Permite visualizar las relaciones jerárquicas entre carpetas** |
| 2 | En el árbol con raíz A, hijos B y C, y hojas D, E y F, ¿qué valor tiene el grado de la raíz A? | 1. 0, porque A no tiene padre · 2. 1, porque A tiene un padre · 3. 2, porque A tiene dos hijos · 4. 3, porque A tiene tres descendientes | **3. 2, porque A tiene dos hijos** |
| 3 | Considere un árbol con las conexiones A–B, A–C, B–D, B–E, E–G y C–F. ¿Cuál es el nivel del nudo G y cuál es la altura total del árbol? | 1. Nivel 2 y altura 2 · 2. Nivel 3 y altura 3 · 3. Nivel 3 y altura 4 · 4. Nivel 4 y altura 3 | **2. Nivel 3 y altura 3** |
| 4 | Un grafo tiene los nodos A, B, C y D, con las conexiones A–B, A–C, B–D y B–C. ¿Por qué no cumple la definición de árbol? | 1. Porque la raíz A tiene dos hijos · 2. Porque el nodo D es una hoja · 3. Porque existe más de un camino entre A y C · 4. Porque todos los nudos tienen un padre | **3. Porque existe más de un camino entre A y C** |
| 5 | ¿Cuál es la diferencia fundamental entre un árbol general y un árbol binario? | 1. El árbol general admite cualquier cantidad de hijos y el binario como máximo dos · 2. El árbol general admite dos hijos y el binario cualquier cantidad de hijos · 3. El árbol general solo admite hijos izquierdos y el binario solo derechos · 4. El árbol general no admite hojas y el binario sí admite hojas. | **1. El árbol general admite cualquier cantidad de hijos y el binario como máximo dos** |
| 6 | En una instancia de Nodo, el enlace izquierdo apunta a otro nodo y el enlace derecho tiene el valor null. ¿Qué valores deben devolver esHoja() y grado(), respectivamente? | 1. falso y 1 · 2. verdadero y 0 · 3. falso y 2 · 4. verdadero y 1 | **1. falso y 1** |
| 7 | Se ejecuta grado() sobre un nodo cuyos enlaces izquierdo y derecho apuntan a otros nodos. ¿Qué secuencia de acciones permite obtener correctamente el resultado? | 1. Iniciar hijos en 0, incrementar por cada enlace no nulo y devolver hijos · 2. Iniciar hijos en 2, disminuir por cada enlace no nulo y devolver hijos · 3. Iniciar hijos en 0, incrementar por cada enlace nulo y devolver hijos · 4. Iniciar hijos en 1, comprobar solo el enlace izquierdo y devolver hijos | **1. Iniciar hijos en 0, incrementar por cada enlace no nulo y devolver hijos** |
| 8 | Un árbol binario está vacío y se desea insertar primero el dato «A» como raíz y después el dato «B» como hijo izquierdo de esa raíz. ¿Qué secuencia de operaciones respeta las validaciones del negocio? | 1. Usar crearRaiz("A") y después agregarIzquierdo(raiz, "B"). · 2. Usar agregarIzquierdo(null, "A") y después crearRaiz("B"). · 3. Usar crearRaiz("A") dos veces para crear ambos nodos. · 4. Usar agregarDerecho(raiz, "A") y después agregarIzquierdo(null, "B"). | **1. Usar crearRaiz("A") y después agregarIzquierdo(raiz, "B").** |
| 9 | En una implementación recursiva de contarHojas, ¿qué debe devolver la función cuando recibe un nodo que no es nulo y sí es una hoja? | 1. 0, porque no tiene hijos · 2. 1, porque representa una hoja · 3. 2, porque tiene dos enlaces nulos · 4. -1, porque no tiene descendientes | **2. 1, porque representa una hoja** |
| 10 | Un árbol binario tiene una raíz cuya altura del subárbol izquierdo es 1 y cuya altura del subárbol derecho es 0. Si la altura se mide contando aristas, ¿qué altura tiene la raíz? | 1. 0, porque solo cuenta las hojas · 2. 1, porque toma la altura menor · 3. 2, porque suma uno al máximo · 4. 3, porque suma ambas alturas | **3. 2, porque suma uno al máximo** |

## Preguntas guía del design challenge

1. ¿Por qué la organización **no** puede modelarse con un árbol binario directamente?
2. ¿Qué atributos lleva el nodo del árbol general y cómo guarda a sus hijos?
3. ¿Qué atributos lleva el nodo del ABB y por qué la clave es la matrícula y no el nombre?
4. En su ABB: raíz, hojas, altura y nivel del nodo indicado en la ficha.
5. ¿Cómo se conecta un PARALELO con su ABB de estudiantes?
6. Con el diagrama de clases del Grupo 1: ¿qué clase es el dato, cuál el nodo y cuál el árbol?

Las respuestas modelo se publican después de la clase.
