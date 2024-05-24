
package ProblemaJava;

public class Problema03_Departamento {
   private String nombre;
    private int numeroEmpleados;
    private double produccionAnual;
    private String categoria;

    public Problema03_Departamento(String nombre, int numeroEmpleados, double produccionAnual) {
        this.nombre = nombre;
        this.numeroEmpleados = numeroEmpleados;
        this.produccionAnual = produccionAnual;
        this.categoria = determinarCategoria();
    }

    private String determinarCategoria() {
        if (numeroEmpleados > 20 && produccionAnual > 1000000) {
            return "A";
        } else if (numeroEmpleados >= 20 && produccionAnual >= 1000000) {
            return "B";
        } else if (numeroEmpleados >= 10 && produccionAnual >= 500000) {
            return "C";
        } else {
            return "No Categoría";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public double getProduccionAnual() {
        return produccionAnual;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre + ", Empleados: " + numeroEmpleados +
               ", Producción Anual: $" + produccionAnual + ", Categoría: " + categoria;
    }
}
