package app;

import java.util.Scanner;

/** Menu unico de la base colaborativa del Grupo 4. */
public class Main {
    public static void main(String[] args) {
        Contexto c = new Contexto();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nSJA-UTA - APE3 GRUPO 4");
                System.out.println("1. Jerarquia academica");
                System.out.println("2. Insercion y busqueda de estudiantes");
                System.out.println("3. Recorridos y estadisticas");
                System.out.println("4. Modificacion y eliminacion de estudiantes");
                System.out.println("5. Unidades y transformacion");
                System.out.println("6. Estado del sistema");
                System.out.println("7. Reiniciar datos de ejemplo / 0. Salir");
                if (!in.hasNextLine()) return;
                String opcion = in.nextLine();
                try {
                    switch (opcion) {
                        case "1": consultarJerarquia(c, in); break;
                        case "2": registrarOBuscarEstudiante(c, in); break;
                        case "3": mostrarRecorridosYEstadisticas(c, in); break;
                        case "4": modificarOEliminarEstudiante(c, in); break;
                        case "5": gestionarUnidadesYTransformacion(c, in); break;
                        case "6": mostrarEstadoSistema(c, in); break;
                        case "7": c.reiniciar(); System.out.println("Datos reiniciados"); break;
                        case "0": return;
                        default: System.out.println("Opcion invalida");
                    }
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Aviso: " + e.getMessage());
                }
            }
        }
    }

    private static void consultarJerarquia(Contexto c, Scanner in) {
        // TODO G4 Cris: Agregar registro de unidades y consulta explicita por codigo. Probar codigo duplicado, padre inexistente y arbol vacio.
         System.out.println(c.organizacion.mostrarJerarquia());
         System.out.println("Altura="+c.organizacion.altura()+" Hojas="+c.organizacion.contarHojas());
         System.out.print("Codigo para consultar nivel y grado: ");String cod=in.nextLine();
         System.out.println("Nivel="+c.organizacion.nivel(cod)+" Grado="+c.organizacion.grado(cod));
    }

    private static void registrarOBuscarEstudiante(Contexto c, Scanner in) {
        // TODO G4 Andres: Mejorar mensaje de busqueda inexistente. Verificar ABB vinculado al paralelo, duplicados y datos invalidos; validar tambien promedios no finitos.
         System.out.print("1 Insertar / 2 Buscar: ");String op=in.nextLine();
         System.out.print("Matricula: ");int m=Integer.parseInt(in.nextLine());
         if(op.equals("2")){System.out.println(c.estudiantes().buscar(m));return;}
         if(!op.equals("1"))throw new IllegalArgumentException("Opcion invalida");
         System.out.print("Cedula: ");String ci=in.nextLine();System.out.print("Nombre: ");String nombre=in.nextLine();
         System.out.print("Promedio (punto decimal): ");double prom=Double.parseDouble(in.nextLine());
         System.out.println("Insertado="+c.estudiantes().insertar(new modelo.Estudiante(m,ci,nombre,prom)));
    }

    // Aporte de Lenin: submenu para consultar recorridos,
    // trazas y estadisticas del arbol de estudiantes.
    // Reutiliza los metodos de negocio existentes.
    private static void mostrarRecorridosYEstadisticas(Contexto c, Scanner in) {
        negocio.ArbolEstudiantes arbol = c.estudiantes();

        // Mantiene el submenu abierto hasta elegir volver.
        while (true) {
            System.out.println("\nRECORRIDOS Y ESTADISTICAS");
            System.out.println("1. Preorden");
            System.out.println("2. Inorden");
            System.out.println("3. Posorden");
            System.out.println("4. Traza de un recorrido");
            System.out.println("5. Estadisticas");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            if (!in.hasNextLine())
                return;
            String opcion = in.nextLine().trim();

            switch (opcion) {
                // Consulta el recorrido y muestra las matriculas.
                case "1", "2", "3" -> {
                    enums.TipoRecorrido tipo = switch (opcion) {
                        case "1" -> enums.TipoRecorrido.PREORDEN;
                        case "2" -> enums.TipoRecorrido.INORDEN;
                        default -> enums.TipoRecorrido.POSORDEN;
                    };

                    java.util.List<Integer> matriculas = new java.util.ArrayList<>();

                    for (modelo.Estudiante estudiante : arbol.recorrer(tipo)) {
                        matriculas.add(estudiante.getMatricula());
                    }

                    System.out.println(tipo + ": " + matriculas);
                }

                // Permite elegir la traza que se desea consultar.
                case "4" -> {
                    System.out.println(
                            "1. Preorden / 2. Inorden / 3. Posorden / 0. Volver");
                    System.out.print("Seleccione la traza: ");

                    if (!in.hasNextLine())
                        return;
                    String opcionTraza = in.nextLine().trim();

                    if (opcionTraza.equals("0"))
                        continue;

                    enums.TipoRecorrido tipo = switch (opcionTraza) {
                        case "1" -> enums.TipoRecorrido.PREORDEN;
                        case "2" -> enums.TipoRecorrido.INORDEN;
                        case "3" -> enums.TipoRecorrido.POSORDEN;
                        default -> null;
                    };

                    if (tipo == null) {
                        System.out.println("Opcion de traza invalida");
                    } else {
                        System.out.println(arbol.trazaRecorrido(tipo));
                    }
                }

                // Consulta las estadisticas y contempla el arbol vacio.
                case "5" -> {
                    modelo.Estudiante menor = arbol.menor();
                    modelo.Estudiante mayor = arbol.mayor();

                    System.out.println("Cantidad=" + arbol.contar());
                    System.out.println("Altura (aristas)=" + arbol.altura());

                    System.out.println("Menor matricula="
                            + (menor == null
                                    ? "Sin estudiantes"
                                    : menor.getMatricula()));

                    System.out.println("Mayor matricula="
                            + (mayor == null
                                    ? "Sin estudiantes"
                                    : mayor.getMatricula()));

                    System.out.println(
                            "Promedio general=" + arbol.promedioGeneral());
                }

                // Regresa al menu principal.
                case "0" -> {
                    return;
                }

                // Informa cuando la opcion ingresada no existe.
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    private static void modificarOEliminarEstudiante(Contexto c, Scanner in) {
        // TODO G4 Josue: Mostrar inorden antes/despues de eliminar. Probar hoja 10, un hijo 40, dos hijos 45 y raiz 30, reiniciando entre pruebas; comprobar modificacion invalida sin cambios parciales.
         System.out.print("1 Modificar / 2 Eliminar: ");String op=in.nextLine();
         System.out.print("Matricula: ");int m=Integer.parseInt(in.nextLine());
         if(op.equals("2")){System.out.println("Eliminado="+c.estudiantes().eliminar(m));return;}
         if(!op.equals("1"))throw new IllegalArgumentException("Opcion invalida");
         System.out.print("Nueva cedula: ");String ci=in.nextLine();System.out.print("Nuevo nombre: ");String nombre=in.nextLine();
         System.out.print("Nuevo promedio: ");double prom=Double.parseDouble(in.nextLine());
         System.out.println("Modificado="+c.estudiantes().modificar(m,ci,nombre,prom));
    }

    private static void gestionarUnidadesYTransformacion(Contexto c, Scanner in) {
        // TODO G4 Hector: Validar representacion hijo izquierdo/hermano derecho con varios hermanos. Probar unidad hoja vacia, unidad con hijos y paralelo ocupado. Acordar regla de eliminacion y aplicarla en negocio si corresponde.
         System.out.print("1 Transformar / 2 Eliminar unidad: ");String op=in.nextLine();
         if(op.equals("1")){System.out.println(c.organizacion.transformarABinario());return;}
         if(!op.equals("2"))throw new IllegalArgumentException("Opcion invalida");
         System.out.print("Codigo de unidad: ");String cod=in.nextLine();
         negocio.NodoUnidad n=c.organizacion.buscar(cod);
         if(n!=null && n.getEstudiantes()!=null && !n.getEstudiantes().estaVacio())throw new IllegalArgumentException("No eliminar un paralelo con estudiantes");
         System.out.println("Eliminado="+c.organizacion.eliminar(cod));
    }

    private static void mostrarEstadoSistema(Contexto c, Scanner in) {
        // TODO G4 Shirley: Coordinar menu y Contexto; probar flujo completo y reinicio; integrar Pull Requests. Cada companero mantiene sus propias pruebas y evidencias, no delegarlas a Shirley.
         System.out.println("Paralelo activo="+c.paralelo);
         System.out.println("ABB vinculado="+(c.organizacion.buscar(c.paralelo).getEstudiantes()==c.estudiantes()));
         System.out.println("Estudiantes actuales="+c.estudiantes().contar());
         System.out.println("Validar flujo completo: insertar, buscar, recorrer, modificar y eliminar.");
    }

}