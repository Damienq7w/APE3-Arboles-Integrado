# SJA-UTA — APE 3 (Fase 3: Grupo 3)

Este directorio contiene la integración de la **Fase 3** del Sistema Jerárquico Académico de la UTA. 

El Grupo 3 es responsable de implementar las operaciones avanzadas de transformación, eliminación segura y cálculo de estadísticas usando recursividad sobre árboles generales y binarios.

## 👥 Equipo de Trabajo (Grupo 3)
* **Justin:** Teoría y Transformación de Árbol General a Binario (A6).
* **Jose:** Eliminación en Árbol General (A5) y Árbol Binario de Búsqueda (B5).
* **Fernando:** Estadísticas del ABB (B6) y Casos Límite.
* **Edwin:** Dinámica de facilitación y Clínica de Errores.
* **Leo:** Integración de repositorio, `Main.java` y evaluación en Quizizz.

## 🚀 Operaciones Implementadas
1. **Transformación (A6):** Algoritmo visual para convertir el árbol n-ario en binario mediante la regla de *hijo izquierdo / hermano derecho*.
2. **Eliminación Segura (A5 y B5):** 
   - Árbol General: Bloqueo de eliminación si la unidad tiene subunidades.
   - ABB: Manejo de los 3 casos (hoja, un hijo, dos hijos mediante sucesor inorden).
3. **Estadísticas (B6):** Recursividad para altura, conteo total, promedios y búsqueda de extremos (mayor/menor).

## 🛠️ Ejecución
Para probar esta fase de manera aislada, compila y ejecuta el `Main` desde esta carpeta:
```bash
javac -d out $(find src -name "*.java")
java -cp out app.Main