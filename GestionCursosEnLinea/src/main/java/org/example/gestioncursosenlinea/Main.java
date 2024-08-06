package org.example.gestioncursosenlinea;
import org.example.gestioncursosenlinea.controller.CourseController;
import org.example.gestioncursosenlinea.model.StudentModel;
import org.example.gestioncursosenlinea.persistence.ConnectionDB;

import java.sql.Connection;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println(" ##### ---------  Menú de Riwi Academy ---------- ####");
            System.out.println("1. Gestión de Estudiantes");
            System.out.println("2. Gestión de Cursos");
            System.out.println("3. Gestión de Inscripciones");
            System.out.println("4. Gestión de Calificaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    StudentManagement(scanner);
                    break;
                case 2:
                    CourseManagement(scanner);
                    break;
                case 3:
                    EnrollmentManagement(scanner);
                    break;
                case 4:
                    GradeManagement(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo. las opciones eXISTENTES SON (1. Gestión de Estudiantes - 2. Gestión de Cursos - 3. Gestión de Inscripciones -  4. Gestión de Calificaciones - 5. Salir)");
            }
        }
        scanner.close();
    }
    private static void StudentManagement(Scanner scanner) {


        boolean exit = false;
        while (!exit) {
            System.out.println("\n ###### ---- Gestión de Estudiantes ---- ####3");
            System.out.println("1.Crear Estudiante");
            System.out.println("2.Editar Estudiante");
            System.out.println("3.Listar Estudiantes Activos");
            System.out.println("4.Buscar Estudiante por ID o Email");
            System.out.println("5.Volver al Menú Principal");
            System.out.print("Seleccione una opción, por favor: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void CourseManagement(Scanner scanner) {
        boolean exit = false;
        ConnectionDB.openConnection();
        CourseController courseController = new CourseController();
        while (!exit) {
            System.out.println("\n---- Gestión de Cursos ----");
            System.out.println("1. Crear Curso");
            System.out.println("2. Editar Curso");
            System.out.println("3. Listar Cursos");
            System.out.println("4. Eliminar Curso");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    courseController.create();
                    break;
                case 2:
                    courseController.edit();
                    break;
                case 3:

                    break;
                case 4:
                    courseController.delete();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo. las opciones son ( 1. Crear Curso - 2. Editar Curso - 3. Listar Cursos -  4. Eliminar Curso - 5. Volver al Menú Principal )");
            }
        }
    }

    private static void EnrollmentManagement(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n #### ---- Gestión de Inscripciones ---- #####");
            System.out.println("1.Generar Inscripción");
            System.out.println("2.Eliminar Inscripción");
            System.out.println("3.Ver Inscripciones de un Estudiante");
            System.out.println("4.olver al Menú Principal");
            System.out.print("Seleccione una opción, por favor: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo. las opciones son (1.Generar Inscripción - 2.Eliminar Inscripción - 3.Ver Inscripciones de un Estudiante - 4.olver al Menú Principal)");
            }
        }
    }

    private static void GradeManagement(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n ##### ---- Gestión de Calificaciones ---- ####");
            System.out.println("1. Crear Calificación");
            System.out.println("2. Editar Calificación");
            System.out.println("3. Ver Calificaciones de un Estudiante");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo. las opciones son (1. Crear Calificación - 2. Editar Calificación - 3. Ver Calificaciones de un Estudiante - 4. Volver al Menú Principal )");
            }
        }
    }
}

