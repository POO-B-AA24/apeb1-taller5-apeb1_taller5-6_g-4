
package ProblemaJava;

import java.util.Scanner;

public class Problema03_Ejecutor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar datos de la empresa
        System.out.print("Ingrese el nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine();
        System.out.print("Ingrese el RUC de la empresa: ");
        String rucEmpresa = scanner.nextLine();
        System.out.print("Ingrese la dirección de la empresa: ");
        String direccionEmpresa = scanner.nextLine();

        Problema03_Empresa empresa = new Problema03_Empresa(nombreEmpresa, rucEmpresa, direccionEmpresa);

        // Ingresar datos de los departamentos
        boolean agregarOtroDepartamento = true;
        while (agregarOtroDepartamento) {
            System.out.print("Ingrese el nombre del departamento: ");
            String nombreDepartamento = scanner.nextLine();
            System.out.print("Ingrese el número de empleados: ");
            int numeroEmpleados = scanner.nextInt();
            System.out.print("Ingrese la producción anual: ");
            double produccionAnual = scanner.nextDouble();

            Problema03_Departamento departamento = new Problema03_Departamento(nombreDepartamento, numeroEmpleados, produccionAnual);

            // Asignar el departamento a la empresa
            empresa.agregarDepartamento(departamento);

            // Preguntar si desea agregar otro departamento
            System.out.print("¿Desea agregar otro departamento? (si/no): ");
            scanner.nextLine(); // Consumir el newline
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("si")) {
                agregarOtroDepartamento = false;
            }
        }

        // Mostrar detalle de la empresa y sus departamentos
        System.out.println(empresa.toString());
    }
}
