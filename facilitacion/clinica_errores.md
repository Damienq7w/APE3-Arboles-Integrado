# Clínica de Errores - Snippets para Padlet 

### ❌ Reto 1: El contador infinito (Estadísticas ABB)
**El problema:** Este método para contar estudiantes nunca termina o da resultados incorrectos. ¿Qué le falta?
```java

private int contar(NodoEstudiante nodo) {
    // Falta el caso base aquí...
    return 1 + contar(nodo.getIzquierdo()) + contar(nodo.getDerecho());
}
if (hijo.getDato().getCodigo().equals(codigo)) {
    padre.getHijos().remove(i); 
    return true;
}
if (nodo.getIzquierdo() == null) {
    return null; // ¡Error lógico! 
}