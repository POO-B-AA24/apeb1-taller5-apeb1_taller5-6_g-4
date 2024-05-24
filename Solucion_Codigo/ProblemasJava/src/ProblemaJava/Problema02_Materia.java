
package ProblemaJava;

public class Problema02_Materia {
  private String nombre;
    private double acd;
    private double ape;
    private double aa;

    public Problema02_Materia(String nombre, double acd, double ape, double aa) {
        this.nombre = nombre;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAcumulado() {
        return acd + ape + aa;
    }

    public double getNotaRecuperacion(double notaRecuperacion) {
        return (getAcumulado() * 0.6) + notaRecuperacion;
    }

    @Override
    public String toString() {
        return "Materia: " + nombre + ", ACD: " + acd + "/3.5, APE: " + ape + "/3.5, AA: " + aa + "/3.0";
    }
}
