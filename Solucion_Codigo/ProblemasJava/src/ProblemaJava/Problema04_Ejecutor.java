package ProblemaJava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Problema04_Ejecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Ingresar datos del caso de corrupción
        System.out.print("Ingrese el nombre del caso: ");
        String nombreCaso = scanner.nextLine();
        System.out.print("Ingrese la fecha de inicio del caso (AAAA-MM-DD): ");
        String fechaInicioStr = scanner.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatter);
        System.out.print("Ingrese los detalles del caso: ");
        String detalles = scanner.nextLine();

        Problema04_CasoCorrupcion caso = new Problema04_CasoCorrupcion(nombreCaso, fechaInicio, detalles);

        // Ingresar datos de las personas implicadas
        boolean agregarOtraPersona = true;
        while (agregarOtraPersona) {
            System.out.print("Ingrese el nombre de la persona: ");
            String nombrePersona = scanner.nextLine();
            System.out.print("Ingrese la edad de la persona: ");
            int edadPersona = scanner.nextInt();
            System.out.print("Ingrese la ocupación de la persona: ");
            scanner.nextLine();  // Consumir el newline
            String ocupacionPersona = scanner.nextLine();
            System.out.print("Ingrese el nivel de implicación (acusado, testigo, víctima, etc.): ");
            String nivelImplicacion = scanner.nextLine();

            Problema04_Persona persona = new Problema04_Persona(nombrePersona, edadPersona, ocupacionPersona, nivelImplicacion);

            // Asignar la persona al caso
            caso.agregarPersona(persona);

            // Preguntar si desea agregar otra persona
            System.out.print("¿Desea agregar otra persona? (si/no): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                agregarOtraPersona = false;
            }
        }

        // Actualizar y mostrar el estado del caso
        caso.actualizarEstado();
        System.out.println(caso.toString());
    }
}
