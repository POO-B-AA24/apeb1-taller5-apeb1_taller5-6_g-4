package ProblemaJava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problema05_Ejecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Ingresar datos del conflicto
        System.out.print("Ingrese el nombre del conflicto: ");
        String nombreConflicto = scanner.nextLine();
        System.out.print("Ingrese la fecha de inicio del conflicto (AAAA-MM-DD): ");
        String fechaInicioStr = scanner.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatter);
        System.out.print("Ingrese los detalles del conflicto: ");
        String detalles = scanner.nextLine();

        List<String> paisesInvolucrados = new ArrayList<>();
        boolean agregarOtroPais = true;
        while (agregarOtroPais) {
            System.out.print("Ingrese un país involucrado: ");
            String pais = scanner.nextLine();
            paisesInvolucrados.add(pais);

            System.out.print("¿Desea agregar otro país? (si/no): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                agregarOtroPais = false;
            }
        }

        Problema05_Conflicto conflicto = new Problema05_Conflicto(nombreConflicto, paisesInvolucrados, fechaInicio, detalles);

        // Ingresar datos de los eventos
        boolean agregarOtroEvento = true;
        while (agregarOtroEvento) {
            System.out.print("Ingrese el nombre del evento: ");
            String nombreEvento = scanner.nextLine();
            System.out.print("Ingrese la fecha del evento (AAAA-MM-DD): ");
            String fechaEventoStr = scanner.nextLine();
            LocalDate fechaEvento = LocalDate.parse(fechaEventoStr, formatter);
            System.out.print("Ingrese la ubicación del evento: ");
            String ubicacion = scanner.nextLine();
            System.out.print("Ingrese la descripción del evento: ");
            String descripcion = scanner.nextLine();
            System.out.print("¿Se usaron armas nucleares? (si/no): ");
            boolean usoArmasNucleares = scanner.nextLine().equalsIgnoreCase("si");
            System.out.print("Ingrese el número de bajas: ");
            int bajas = scanner.nextInt();
            scanner.nextLine();  // Consumir el newline

            Problema05_Evento evento = new Problema05_Evento(nombreEvento, fechaEvento, ubicacion, descripcion, usoArmasNucleares, bajas);

            // Asignar el evento al conflicto
            conflicto.agregarEvento(evento);

            // Preguntar si desea agregar otro evento
            System.out.print("¿Desea agregar otro evento? (si/no): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                agregarOtroEvento = false;
            }
        }

        // Mostrar detalles del conflicto
        System.out.println(conflicto.toString());
    }
}


