# Clínica de Errores - Snippets para Padlet 

###  Reto 1: El contador infinito (Estadísticas ABB)
El problema:Este método para contar estudiantes nunca termina o da resultados incorrectos. ¿Qué le falta?
```java
private int contar(NodoEstudiante nodo) {
    // Falta el caso base aquí...
    return 1 + contar(nodo.getIzquierdo()) + contar(nodo.getDerecho());
}
Reto 2: Eliminación destructiva (Árbol General)
El problema: Este código permite borrar cualquier facultad, incluso si tiene carreras adentro, violando la regla A5. ¿Cómo lo arreglamos?

Java
if (hijo.getDato().getCodigo().equals(codigo)) {
    padre.getHijos().remove(i); 
    return true;
}

Reto 3: El hijo perdido (Eliminación ABB - Caso 2)
El problema: Al eliminar un nodo que solo tiene hijo derecho, este método borra el nodo pero no reconecta al hijo con el resto del árbol.

Java
if (nodo.getIzquierdo() == null) {
    return null; // ¡Error lógico! 
}