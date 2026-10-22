package app;

import enums.TipoUnidad;
import modelo.Estudiante;
import modelo.UnidadAcademica;
import negocio.ArbolEstudiantes;
import negocio.ArbolOrganizacional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Inicializar datos de prueba básicos para el árbol general
        ArbolOrganizacional arbolUTA = new ArbolOrganizacional(
                new UnidadAcademica("UTA", "Universidad Técnica de Ambato", TipoUnidad.UNIVERSIDAD));
        arbolUTA.agregar("UTA", new UnidadAcademica("FISEI", "Facultad de Ing. en Sistemas", TipoUnidad.FACULTAD));
        arbolUTA.agregar("FISEI", new UnidadAcademica("SW", "Software", TipoUnidad.CARRERA));
        arbolUTA.agregar("SW", new UnidadAcademica("SW-N3", "Tercer Nivel", TipoUnidad.NIVEL));
        arbolUTA.agregar("SW-N3", new UnidadAcademica("SW-N3-B", "Paralelo B", TipoUnidad.PARALELO));

        // Unidad extra para probar la eliminación (hoja)
        arbolUTA.agregar("UTA",
                new UnidadAcademica("FCA", "Facultad de Ciencias Administrativas", TipoUnidad.FACULTAD));

        // 2. Inicializar el ABB de estudiantes para el paralelo B
        ArbolEstudiantes paraleloB = new ArbolEstudiantes();
        paraleloB.insertar(new Estudiante(1005, "1800000005", "Jose", 8.5));
        paraleloB.insertar(new Estudiante(1002, "1800000002", "Fernando", 9.2));
        paraleloB.insertar(new Estudiante(1008, "1800000008", "Edwin", 7.8));
        paraleloB.insertar(new Estudiante(1001, "1800000001", "Leo", 9.5));
        paraleloB.insertar(new Estudiante(1009, "1800000009", "Justin", 8.9));

        int opcion = 0;
        do {
            try {
                System.out.println("\n=== SJA-UTA: FASE 3 (GRUPO 3) ===");
                System.out.println("1. Ver jerarquía general actual");
                System.out.println("2. Eliminar una unidad del árbol general (A5 - ej. FCA)");
                System.out.println("3. Transformar árbol general a Binario (A6)");
                System.out.println("4. Ver estadísticas del ABB de Estudiantes (B6)");
                System.out.println("5. Modificar estudiante en el ABB");
                System.out.println("6. Eliminar estudiante del ABB");
                System.out.println("7. Salir");
                System.out.print("Elige una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println(arbolUTA.mostrarJerarquia());
                        break;
                    case 2:
                        System.out.print("Ingresa el código de la unidad a eliminar (ej. FCA): ");
                        String codEliminar = scanner.nextLine();
                        if (arbolUTA.eliminar(codEliminar)) {
                            System.out.println("Unidad " + codEliminar + " eliminada correctamente.");
                        } else {
                            System.out.println("No se pudo eliminar. Verifica que exista y no tenga subunidades.");
                        }
                        break;
                    case 3:
                        System.out.println("\n--- Transformación a Binario (Hijo Izq / Hermano Der) ---");
                        System.out.println(arbolUTA.transformarABinario());
                        break;
                    case 4:
                        System.out.println("\n--- Estadísticas del Paralelo B ---");
                        if (paraleloB.estaVacio()) {
                            System.out.println("El paralelo no tiene estudiantes registrados.");
                        } else {
                            System.out.println("Total de estudiantes: " + paraleloB.contar());
                            System.out.println("Altura del árbol (ABB): " + paraleloB.altura());
                            System.out
                                    .println("Promedio general: " + String.format("%.2f", paraleloB.promedioGeneral()));
                            System.out.println("Menor matrícula: " + paraleloB.menor().getMatricula() + " ("
                                    + paraleloB.menor().getNombres() + ")");
                            System.out.println("Mayor matrícula: " + paraleloB.mayor().getMatricula() + " ("
                                    + paraleloB.mayor().getNombres() + ")");
                        }
                        break;
                    case 5:
                        System.out.print("Matrícula del estudiante a modificar: ");
                        int matMod = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nueva Cédula: ");
                        String nuevaCedula = scanner.nextLine();
                        System.out.print("Nuevos Nombres: ");
                        String nuevosNombres = scanner.nextLine();
                        System.out.print("Nuevo Promedio: ");
                        double nuevoPromedio = scanner.nextDouble();

                        if (paraleloB.modificar(matMod, nuevaCedula, nuevosNombres, nuevoPromedio)) {
                            System.out.println("Estudiante modificado exitosamente.");
                        } else {
                            System.out.println("No se encontró un estudiante con esa matrícula.");
                        }
                        break;
                    case 6:
                        System.out.print("Matrícula del estudiante a eliminar: ");
                        int matEliminar = scanner.nextInt();
                        if (paraleloB.eliminar(matEliminar)) {
                            System.out.println("Estudiante eliminado del ABB correctamente.");
                        } else {
                            System.out.println("No se encontró la matrícula.");
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Debes ingresar el tipo de dato correcto (número/texto).");
                scanner.nextLine(); // Limpiar el teclado
            } catch (IllegalArgumentException e) {
                System.out.println("Error de validación: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getClass().getSimpleName());
                e.printStackTrace();
            }
        } while (opcion != 7);

        scanner.close();
    }
}