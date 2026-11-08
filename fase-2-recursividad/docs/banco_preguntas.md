# Banco de preguntas del quiz de apertura

> **Responsable:** Jampier (Josue)
> **Rama:** `rama---Josue`

## Descripcion

Cuestionario de 10 preguntas de opcion multiple en Wayground, antes Quizizz.

Su objetivo es repasar los fundamentos explicados por el Grupo 1 antes de iniciar la exposicion del Grupo 2. No evalua algoritmos que todavia no se han explicado.

Cada pregunta tiene cuatro opciones y una sola respuesta correcta.

Distribucion: tres preguntas de concepto, dos de lectura de codigo y cinco de aplicacion.

## Acceso

[Pagina del cuestionario guardado](https://wayground.com/activity/admin/quiz/6ad05fafc1f568d492e17685)

Archivo de importacion: Quiz_Repaso_Arboles_Grupo2.xlsx.

Para participar, el anfitrion abre una sesion en vivo y comparte el enlace, QR o codigo generado en ese momento. El codigo de una sesion de prueba no se utiliza como acceso permanente.

## 1. Identificacion de la raiz

Tipo: Concepto.
Tiempo: 30 segundos.

En la jerarquia UNIVERSIDAD → FCS → ENFERMERIA, ¿por que UNIVERSIDAD es la raiz?

A. Porque tiene mas descendientes que cualquier otro nodo.

B. Porque su nombre identifica a toda la institucion.

C. Porque no tiene padre dentro del arbol representado.

D. Porque se encuentra junto a los nodos hoja.

**Respuesta correcta: C.**

Explicacion: la raiz es el unico nodo que no tiene padre dentro del arbol.

## 2. Referencias y grado

Tipo: Lectura de codigo.
Tiempo: 30 segundos.

Un nodo tiene izquierdo = null y derecho apunta a otro nodo. ¿Que podemos afirmar?

A. Es una hoja porque le falta un hijo.

B. Tiene grado 1 y no es una hoja.

C. Tiene grado 2 porque dispone de dos referencias.

D. Es la raiz porque su lado izquierdo esta vacio.

**Respuesta correcta: B.**

Explicacion: el grado cuenta los hijos existentes. Tiene un hijo y, por lo tanto, no es una hoja.

## 3. Eleccion de la estructura

Tipo: Aplicacion.
Tiempo: 30 segundos.

Una facultad tiene cuatro carreras que dependen directamente de ella. ¿Que estructura permite representarlas como sus cuatro hijos?

A. Un arbol binario con dos carreras en cada referencia.

B. Una lista simple donde todas las carreras sean raices.

C. Un arbol binario con cuatro referencias de hijos.

D. Un arbol general con una referencia por cada hijo.

**Respuesta correcta: D.**

Explicacion: un arbol general permite mas de dos hijos por nodo. Un arbol binario admite como maximo dos.

## 4. Condicion de un arbol binario

Tipo: Concepto.
Tiempo: 30 segundos.

¿Cual de estas situaciones puede presentarse en un arbol binario valido?

A. Un nodo tiene unicamente hijo derecho.

B. Un nodo tiene tres hijos directos.

C. Un nodo tiene cuatro hijos directos.

D. Dos padres comparten el mismo nodo hijo.

**Respuesta correcta: A.**

Explicacion: un nodo puede tener cero, uno o dos hijos. Un hijo derecho sin hijo izquierdo es valido; un nodo no raiz tiene un solo padre.

## 5. Nivel de un nodo

Tipo: Aplicacion.
Tiempo: 45 segundos.

La raiz esta en el nivel 0. En UNIVERSIDAD → FACULTAD → CARRERA → NIVEL 3 → PARALELO B, ¿en que nivel del arbol esta PARALELO B?

A. Nivel 3.

B. Nivel 5.

C. Nivel 4.

D. Nivel 2.

**Respuesta correcta: C.**

Explicacion: cada arista aumenta el nivel en uno. Se recorren cuatro aristas hasta PARALELO B; NIVEL 3 es el nombre de una dependencia.

## 6. Altura del arbol

Tipo: Aplicacion.
Tiempo: 30 segundos.

Desde la raiz se llega a una hoja con dos aristas y a otra con cuatro. Si no hay caminos mas largos, ¿cual es la altura del arbol en aristas?

A. 2.

B. 5.

C. 6.

D. 4.

**Respuesta correcta: D.**

Explicacion: la altura en aristas es la longitud del camino mas largo desde la raiz hasta una hoja: cuatro aristas.

## 7. Identificacion de un subarbol

Tipo: Aplicacion.
Tiempo: 45 segundos.

FCS tiene como hijas a MEDICINA y ENFERMERIA. MEDICINA tiene como unico hijo a NIVEL 1. ¿Que nodos forman el subarbol con raiz MEDICINA?

A. FCS, MEDICINA y NIVEL 1.

B. MEDICINA y NIVEL 1.

C. MEDICINA y ENFERMERIA.

D. Unicamente NIVEL 1.

**Respuesta correcta: B.**

Explicacion: el subarbol incluye su propia raiz y todos sus descendientes. No incluye al padre ni a los hermanos de esa raiz.

## 8. Tipo de una referencia

Tipo: Lectura de codigo.
Tiempo: 30 segundos.

En Nodo<T>, ¿por que el atributo izquierdo se declara como Nodo<T> en lugar de String?

A. Porque debe referenciar otro nodo con su dato y sus enlaces.

B. Porque debe guardar solamente el nombre del hijo izquierdo.

C. Porque debe almacenar la cantidad de descendientes del nodo.

D. Porque debe indicar si el hijo pertenece al nivel izquierdo.

**Respuesta correcta: A.**

Explicacion: la referencia izquierdo apunta a un nodo completo, que contiene su dato y los enlaces a sus propios hijos.

## 9. Arbol con un solo nodo

Tipo: Aplicacion.
Tiempo: 30 segundos.

Un arbol contiene unicamente su raiz. Si medimos la altura en aristas, ¿cual es el resultado?

A. -1, porque no existen hijos.

B. 1, porque existe un nodo.

C. 2, porque hay dos referencias disponibles.

D. 0, porque no se recorre ninguna arista.

**Respuesta correcta: D.**

Explicacion: una raiz sin hijos tambien es una hoja. El camino desde ella hasta ella misma tiene cero aristas.

## 10. Relacion entre nodos

Tipo: Concepto.
Tiempo: 30 segundos.

Dos nodos tienen el mismo padre y cada uno posee sus propios descendientes. ¿Que relacion existe entre esos dos nodos?

A. Son antecesor y descendiente.

B. Son hermanos dentro del arbol.

C. Son necesariamente nodos hoja.

D. Son raices del arbol completo.

**Respuesta correcta: B.**

Explicacion: los nodos que comparten el mismo padre son hermanos, independientemente de que tengan descendientes.

[Volver al README del Grupo 2](../README.md)
