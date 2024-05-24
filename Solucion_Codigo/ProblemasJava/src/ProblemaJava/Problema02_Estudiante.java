
package ProblemaJava;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Problema02_Estudiante {
    private String nombre;
    private int edad;
    private List<Problema02_Materia> materias;

    public Problema02_Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.materias = new ArrayList<>();
    }

    public void agregarMateria(Problema02_Materia materia) {
        this.materias.add(materia);
    }

    public List<Problema02_Materia> getMaterias() {
        return materias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void verificarAprobacion() {
        for (Problema02_Materia materia : materias) {
            double total = materia.getAcumulado();
            if (total >= 7.0) {
                System.out.println(nombre + " ha aprobado la materia " + materia.getNombre() + " con una calificación de " + total + "/10.");
            } else {
                System.out.println(nombre + " no ha aprobado la materia " + materia.getNombre() + " y deberá rendir un examen de recuperación.");
                // Realizar el examen de recuperación
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese la nota del examen de recuperación sobre 3.5: ");
                double notaRecuperacion = scanner.nextDouble();
                double nuevaNota = materia.getNotaRecuperacion(notaRecuperacion);
                System.out.println("Nota después de recuperación: " + nuevaNota + "/10.");
                if (nuevaNota >= 7.0) {
                    System.out.println(nombre + " ha aprobado la materia " + materia.getNombre() + " después de la recuperación.");
                } else {
                    System.out.println(nombre + " no ha aprobado la materia " + materia.getNombre() + " después de la recuperación.");
                }
            }
        }
    }
}
