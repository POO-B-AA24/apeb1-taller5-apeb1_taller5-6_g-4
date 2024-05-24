
package ProblemaJava;

import java.util.Scanner;

public class Problema02_Ejecutor {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar datos del estudiante
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        System.out.print("Ingrese la edad del estudiante: ");
        int edadEstudiante = scanner.nextInt();

        Problema02_Estudiante estudiante = new Problema02_Estudiante(nombreEstudiante, edadEstudiante);

        // Ingresar datos de la materia
        boolean agregarOtraMateria = true;
        while (agregarOtraMateria) {
            System.out.print("Ingrese el nombre de la materia: ");
            scanner.nextLine();  // Consumir el newline
            String nombreMateria = scanner.nextLine();
            System.out.print("Ingrese la calificación ACD (sobre 3.5): ");
            double acd = scanner.nextDouble();
            System.out.print("Ingrese la calificación APE (sobre 3.5): ");
            double ape = scanner.nextDouble();
            System.out.print("Ingrese la calificación AA (sobre 3.0): ");
            double aa = scanner.nextDouble();

            Problema02_Materia materia = new Problema02_Materia(nombreMateria, acd, ape, aa);

            // Asignar la materia al estudiante
            estudiante.agregarMateria(materia);

            // Preguntar si desea agregar otra materia
            System.out.print("¿Desea agregar otra materia? (si/no): ");
            scanner.nextLine(); // Consumir el newline
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                agregarOtraMateria = false;
            }
        }

        // Mostrar detalle de las materias
        System.out.println(estudiante.getNombre() + " está cursando las siguientes materias:");
        for (Problema02_Materia materia : estudiante.getMaterias()) {
            System.out.println(materia.toString());
        }

        // Verificar aprobación
        estudiante.verificarAprobacion();
    }
}